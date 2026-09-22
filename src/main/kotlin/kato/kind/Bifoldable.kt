package kato.kind

import kato.struct.Monoid
import kato.type.Binary
import kato.type.TypeAccessor

interface Bifoldable<F : TypeAccessor<Binary>>
{
    fun <G, A, B> bifold(g: G, fab: Kind2<F, A, B>, f: (G, A) -> G, h: (G, B) -> G): G

    fun <G, A, B> bifoldMap(g: Monoid<G>, fab: Kind2<F, A, B>, f: (A) -> G, h: (B) -> G): G
        = bifold(g.empty(), fab, { g1, a -> g.combine(g1, f(a)) }, { c, b -> g.combine(c, h(b)) })
}