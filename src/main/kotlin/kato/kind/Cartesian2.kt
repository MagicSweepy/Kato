package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

// Binary Cartesian
interface Cartesian2<F : TypeAccessor<Binary>> : Profunctor<F>
{
    fun <A, B, C> first(fa: Kind2<F, A, B>): Kind2<F, Pair<A, C>, Pair<B, C>>

    fun <A, B, C> second(fa: Kind2<F, A, B>): Kind2<F, Pair<C, A>, Pair<C, B>>
}