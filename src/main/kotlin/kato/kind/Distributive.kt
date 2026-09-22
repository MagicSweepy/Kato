package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Distributive<F : TypeAccessor<Unary>> : Functor<F>
{
    fun <G : TypeAccessor<Unary>, A, B> distribute(g: Functor<G>, ga: Kind<G, A>, f: (A) -> Kind<F, B>): Kind<F, Kind<G, B>>

    fun <G : TypeAccessor<Unary>, A> coflip(g: Functor<G>, ga: Kind<G, Kind<F, A>>): Kind<F, Kind<G, A>>
        = distribute(g, ga) { it }
}