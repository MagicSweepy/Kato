package kato.kind

import kato.struct.Monoid
import kato.type.TypeAccessor
import kato.type.Unary

interface Foldable<F : TypeAccessor<Unary>>
{
    fun <G, A> foldMap(g: Monoid<G>, f: (A) -> G, fa: Kind<F, A>): G
}