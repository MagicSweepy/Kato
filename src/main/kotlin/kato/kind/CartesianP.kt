package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface CartesianP<P : TypeAccessor<Binary>> : Profunctor<P>
{
    fun <A, B, C> first(pab: Kind2<P, A, B>): Kind2<P, Pair<A, C>, Pair<B, C>>

    fun <A, B, C> second(pab: Kind2<P, A, B>): Kind2<P, Pair<C, A>, Pair<C, B>>
}