package kato.kind

import kato.struct.Either
import kato.type.Binary
import kato.type.TypeAccessor

interface RecocartesianP<P : TypeAccessor<Binary>> : Profunctor<P>
{
    fun <A, B, C> unleft(pab: Kind2<P, Either<A, C>, Either<B, C>>): Kind2<P, A, B>

    fun <A, B, C> unright(pab: Kind2<P, Either<C, A>, Either<C, B>>): Kind2<P, A, B>
}