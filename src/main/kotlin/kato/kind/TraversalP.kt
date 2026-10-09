package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface TraversalP<P : TypeAccessor<Binary>> : AffineP<P>
{
    fun <S, T, A, B> wander(w: Wander<S, T, A, B>, pab: Kind2<P, A, B>): Kind2<P, S, T>
}
