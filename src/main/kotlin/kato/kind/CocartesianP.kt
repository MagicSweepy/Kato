package kato.kind

import kato.struct.Either
import kato.type.Binary
import kato.type.TypeAccessor

interface CocartesianP<P : TypeAccessor<Binary>> : Profunctor<P>
{
    fun <A, B, C> left(pab: Kind2<P, A, B>): Kind2<P, Either<A, C>, Either<B, C>>

    fun <A, B, C> right(pab: Kind2<P, A, B>): Kind2<P, Either<C, A>, Either<C, B>>
}