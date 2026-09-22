package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface Bifunctor<F : TypeAccessor<Binary>>
{
    fun <A, B, C, D> bimap(f: (A) -> C, g: (B) -> D, fab: Kind2<F, A, B>): Kind2<F, C, D>

    fun <A, B, C> lmap(f: (A) -> C, fab: Kind2<F, A, B>): Kind2<F, C, B>
        = bimap(f, { it }, fab)

    fun <A, B, D> rmap(g: (B) -> D, fab: Kind2<F, A, B>): Kind2<F, A, D>
        = bimap({ it }, g, fab)
}