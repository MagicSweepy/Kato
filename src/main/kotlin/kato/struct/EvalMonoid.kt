package kato.struct

class EvalMonoid<A>(private val group: Monoid<A>) : Monoid<Eval<A>>
{
    override fun empty(): Eval<A> = Later { group.empty() }

    override fun combine(a: Eval<A>, b: Eval<A>): Eval<A>
        = a.flatMap { x -> b.map { y -> group.combine(x, y) } }
}