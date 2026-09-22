package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface Profunctor<F : TypeAccessor<Binary>>
{
    fun <A, B, C, D> dimap(f: (C) -> A, g: (B) -> D, fab: Kind2<F, A, B>): Kind2<F, C, D>

    fun <A, B, C> lmap(f: (C) -> A, fab: Kind2<F, A, B>): Kind2<F, C, B>
        = dimap(f, { it }, fab)

    fun <A, B, C> rmap(g: (B) -> C, fab: Kind2<F, A, B>): Kind2<F, A, C>
        = dimap({ it }, g, fab)
}