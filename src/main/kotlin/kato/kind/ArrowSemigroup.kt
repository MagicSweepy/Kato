package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface ArrowSemigroup<F : TypeAccessor<Binary>> : Arrow<F>
{
    fun <A, B> combine(f: Kind2<F, A, B>, g: Kind2<F, A, B>): Kind2<F, A, B>
}
