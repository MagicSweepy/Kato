package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface Arrow<F : TypeAccessor<Binary>> : Category<F>, Cartesian2<F>
{
    fun <A, B> lift(f: (A) -> B): Kind2<F, A, B>

    override fun <A> id(): Kind2<F, A, A> = lift { it }

    override fun <A, B, C, D> dimap(f: (C) -> A, g: (B) -> D, fab: Kind2<F, A, B>): Kind2<F, C, D>
        = compose(lift(g), invoke(lift(f), fab))

    override fun <A, B, C> second(fa: Kind2<F, A, B>): Kind2<F, Pair<C, A>, Pair<C, B>>
    {
        fun <X, Y> swap(): Kind2<F, Pair<X, Y>, Pair<Y, X>> = lift { (x, y) -> y to x }
        return compose(swap(), compose(first(fa), swap()))
    }

    fun <A, B, C, D> split(f: Kind2<F, A, B>, g: Kind2<F, C, D>): Kind2<F, Pair<A, C>, Pair<B, D>>
        = invoke(first(f), second(g))

    fun <A, B, C> merge(f: Kind2<F, A, B>, g: Kind2<F, A, C>): Kind2<F, A, Pair<B, C>>
        = invoke(lift { a -> Pair(a, a) }, split(f, g))
}