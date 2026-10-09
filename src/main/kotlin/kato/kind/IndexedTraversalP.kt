package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface IndexedTraversalP<P : TypeAccessor<Binary>> : AffineP<P>
{
    fun <I, S, T, A, B> wanderI(w: IndexedWander<I, S, T, A, B>, pab: Kind2<P, A, B>): Kind2<P, S, T>
}
