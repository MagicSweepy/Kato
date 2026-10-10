package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface RecartesianP<P : TypeAccessor<Binary>> : Profunctor<P>
{
    fun <A, B, C> unfirst(pab: Kind2<P, Pair<A, C>, Pair<B, C>>): Kind2<P, A, B>

    fun <A, B, C> unsecond(pab: Kind2<P, Pair<C, A>, Pair<C, B>>): Kind2<P, A, B>
}