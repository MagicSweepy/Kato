package kato.kind

import kato.law.Law
import kato.type.Binary
import kato.type.TypeAccessor

interface Monoidal<P : TypeAccessor<Binary>> : Category<P>
{
    @Law("par(id, id) = id")
    @Law("par(f2, g2) ∘ par(f1, g1) = par(f2 ∘ f1, g2 ∘ g1)")
    fun <A, B, C, D> par(a: Kind2<P, A, C>, b: Kind2<P, B, D>): Kind2<P, Pair<A, B>, Pair<C, D>>
}