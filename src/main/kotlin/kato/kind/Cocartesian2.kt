package kato.kind

import kato.struct.Either
import kato.type.Binary
import kato.type.TypeAccessor

interface Cocartesian2<F : TypeAccessor<Binary>> : Profunctor<F>
{
    fun <A, B, C> left(fab: Kind2<F, A, B>): Kind2<F, Either<A, C>, Either<B, C>>

    fun <A, B, C> right(fab: Kind2<F, A, B>): Kind2<F, Either<C, A>, Either<C, B>>
}