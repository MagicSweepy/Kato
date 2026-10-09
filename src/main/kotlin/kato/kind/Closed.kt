package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface Closed<P : TypeAccessor<Binary>> : Profunctor<P>
{
    fun <A, B, R> close(pab: Kind2<P, A, B>): Kind2<P, (R) -> A, (R) -> B>
}