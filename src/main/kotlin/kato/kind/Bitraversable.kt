package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor
import kato.type.Unary

interface Bitraversable<F : TypeAccessor<Binary>> : Bifunctor<F>, Bifoldable<F>
{
    fun <G : TypeAccessor<Unary>, A, B, C, D> bitraverse(ap: Applicative<G>, f: (A) -> Kind<G, C>, g: (B) -> Kind<G, D>, fab: Kind2<F, A, B>)
}