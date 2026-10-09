package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface BiContravariant<P : TypeAccessor<Binary>>
{
    fun <A, B, C, D> cimap(g: (C) -> A, h: (D) -> B, pab: () -> Kind2<P, A, B>): Kind2<P, C, D>
}