package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Cartesian<F : TypeAccessor<Unary>, C> : Traversable<F>
{
    fun <A> from(ga: Pair<C, A>): Kind<F, A>

    fun <A> to(fa: Kind<F, A>): Pair<C, A>

    override fun <A, B> map(f: (A) -> B, fa: Kind<F, A>): Kind<F, B>
    {
        val (c, a) = to(fa)
        return from(c to f(a))
    }

    override fun <G, A> foldMap(g: Monoid<G>, f: (A) -> G, fa: Kind<F, A>): G
    {
        val (_, a) = to(fa)
        return f(a)
    }

    override fun <G : TypeAccessor<Unary>, A, B> traverse(ap: Applicative<G>,
                                                          f: (A) -> Kind<G, B>,
                                                          fa: Kind<F, A>): Kind<G, Kind<F, B>>
    {
        val (c, a) = to(fa)
        return ap.map2(ap.of(c), f(a)) { c2, b -> from(c2 to b) }
    }
}