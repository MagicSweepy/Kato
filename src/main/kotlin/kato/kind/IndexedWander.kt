package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface IndexedWander<I, S, T, A, B>
{
    fun <F : TypeAccessor<Unary>> wanderI(ap: Applicative<F>, f: (I, A) -> Kind<F, B>): (S) -> Kind<F, T>
}
