package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Wander<S, T, A, B>
{
    fun <F : TypeAccessor<Unary>> wander(ap: Applicative<F>, fab: (A) -> Kind<F, B>): (S) -> Kind<F, T>
}