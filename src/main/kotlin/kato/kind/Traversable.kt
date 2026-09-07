package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Traversable<F : TypeAccessor<Unary>> : Functor<F>, Foldable<F>
{
    fun <G : TypeAccessor<Unary>, A, B> traverse(ap: Applicative<G>, f: (A) -> Kind<G, B>, fa: Kind<F, A>): Kind<G, Kind<F, B>>

    fun <G : TypeAccessor<Unary>, A> flip(ap: Applicative<G>, fa: Kind<F, Kind<G, A>>)
        = traverse(ap, { it }, fa)
}