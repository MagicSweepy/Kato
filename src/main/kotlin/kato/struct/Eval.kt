@file:Suppress("UNCHECKED_CAST")
package kato.struct

sealed class Eval<out A>
{
    abstract val value: A

    companion object
    {
        fun <A> now(a: A): Eval<A> = Now(a)

        fun <A> later(a: () -> A): Eval<A> = Later(a)

        fun <A> always(a: () -> A): Eval<A> = Always(a)

        fun <A> defer(a: () -> Eval<A>): Eval<A> = Defer(a)

        val Empty: Eval<Unit> = Now(Unit)

        val True: Eval<Boolean> = Now(true)

        val False: Eval<Boolean> = Now(false)

        val Zero: Eval<Int> = Now(0)

        val One: Eval<Int> = Now(1)

        fun <A> semiGroup(algebra: SemiGroup<A>): SemiGroup<Eval<A>>
            = SemiGroup { lx, ly -> lx.flatMap { x -> ly.map { y -> algebra.combine(x, y) } } }

        fun <A> monoid(group: Monoid<A>): SemiGroup<Eval<A>> = EvalMonoid(group)

        fun <A> group(group: Group<A>): Group<Eval<A>> = EvalGroup(group)
    }

    fun <B> map(f: (A) -> B): Eval<B> = flatMap { a -> Now(f(a)) }

    fun <B> flatMap(f: (A) -> Eval<B>): Eval<B> = when (this)
    {
        is FlatMap<*, *> ->
        {
            val c = this as FlatMap<Any?, A>
            FlatMap(start = { c.start() }, run = { s -> FlatMap({ c.run(s) }, f) })
        }
        is Defer<*>      ->
        {
            val c = this as Defer<A>
            FlatMap(start = c.thunk, run = f)
        }
        else             -> FlatMap(start = { this }, run = f)
    }

    abstract fun memoize(): Eval<A>

    sealed class Leaf<out A> : Eval<A>()

    class Defer<out A>(val thunk: () -> Eval<A>) : Eval<A>()
    {
        override fun memoize(): Eval<A> = Memoize(this)

        override val value: A get() = evaluate(this)
    }

    class FlatMap<S, out A>(val start: () -> Eval<S>,
                            val run: (S) -> Eval<A>) : Eval<A>()
    {
        override fun memoize(): Eval<A> = Memoize(this)

        override val value: A get() = evaluate(this)
    }

    internal class Memoize<A>(val eval: Eval<A>) : Eval<A>()
    {
        var result: Any? = Nil

        override fun memoize(): Eval<A> = this

        override val value: A
            get()
            {
                val r = result
                return if (r !== Nil) r as A
                else
                {
                    val a = evaluate(this)
                    result = a
                    a
                }
            }
    }
}

data class Now<out A>(override val value: A) : Eval.Leaf<A>()
{
    override fun memoize(): Eval<A> = this
}

class Later<out A>(f: () -> A) : Eval.Leaf<A>()
{
    private var thunk: (() -> A)? = f

    override val value: A by lazy {
        val result = thunk!!()
        thunk = null
        result
    }

    override fun memoize(): Eval<A> = this
}

class Always<out A>(private val f: () -> A) : Eval.Leaf<A>()
{
    override val value: A = f()

    override fun memoize(): Eval<A> = Later(f)
}

private object Nil // memoized null

private sealed class FnStack<A, B> // stacks in flatMap via a series of Eval ops.

private class Ident<A> : FnStack<A, A>()

private class Many<A, B, C>(val first: (A) -> Eval<B>, val rest: FnStack<B, C>) : FnStack<A, C>()

private fun <A> evaluate(e: Eval<A>): A
{
    fun <A1> addToMemoize(m: Eval.Memoize<A1>): (A1) -> Eval<A1> = { a ->
        m.result = a
        Now(a)
    }

    tailrec fun <A1> loop(currentE: Eval<A1>, stack: FnStack<A1, A>): A = when (currentE)
    {
        is Eval.FlatMap<*, *> ->
        {
            val c = currentE as Eval.FlatMap<Any?, A1>
            when (val startedE = c.start())
            {
                is Eval.FlatMap<*, *> ->
                {
                    val cc = startedE as Eval.FlatMap<Any?, Any?>
                    loop(cc.start(), Many(cc.run, Many(c.run, stack)))
                }
                is Eval.Defer<*>      ->
                {
                    val dd = startedE
                    loop(dd.thunk(), Many(c.run, stack))
                }
                is Eval.Memoize<*>    ->
                {
                    val mm = startedE as Eval.Memoize<Any?>
                    val r = mm.result
                    if (r !== Nil)
                        loop(c.run(r), stack)
                    else
                        loop(mm.eval, Many(addToMemoize(mm), Many(c.run, stack)))
                }
                is Eval.Leaf<*>       ->
                {
                    loop(c.run(startedE.value), stack)
                }
            }
        }
        is Eval.Defer<*> ->
        {
            val d = currentE as Eval.Defer<A1>
            loop(d.thunk(), stack)
        }
        is Eval.Memoize<*> ->
        {
            val m = currentE as Eval.Memoize<A1>
            val r = m.result
            if (r !== Nil)
                when (stack)
                {
                    is Many<*, *, *> ->
                    {
                        val mm = stack as Many<A1, Any?, A>
                        loop(mm.first(r as A1), mm.rest)
                    }
                    is Ident<*>      -> r as A
                }
            else
                loop(m.eval, Many(addToMemoize(m), stack))
        }
        is Eval.Leaf<*> ->
        {
            val a1 = (currentE as Eval.Leaf<A1>).value
            when (stack)
            {
                is Many<*, *, *> ->
                {
                    val mm = stack as Many<A1, Any?, A>
                    loop(mm.first(a1), mm.rest)
                }
                is Ident<*>      -> a1 as A
            }
        }
    }
    return loop(e, Ident())
}
