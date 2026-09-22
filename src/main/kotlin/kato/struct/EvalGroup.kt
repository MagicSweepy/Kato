package kato.struct

class EvalGroup<A>(private val group: Group<A>): Group<Eval<A>>
{
    override fun empty(): Eval<A> = Later { group.empty() }

    override fun combine(a: Eval<A>, b: Eval<A>): Eval<A>
        = a.flatMap { x -> b.map { y -> group.combine(x, y) } }

    override fun inverse(a: Eval<A>): Eval<A>
        = a.map { group.inverse(it) }
}