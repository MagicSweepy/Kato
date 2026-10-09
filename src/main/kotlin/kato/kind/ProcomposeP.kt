package kato.kind

import kato.type.Binary
import kato.type.ProcomposeK
import kato.type.TypeAccessor
import kato.type.asProcompose

class ProcomposeP<F : TypeAccessor<Binary>, G : TypeAccessor<Binary>>(
    private val p1: Profunctor<F>, private val p2: Profunctor<G>) : Profunctor<ProcomposeK<F, G>>
{
    override fun <A, B, C, D> dimap(f: (C) -> A, g: (B) -> D, fab: Kind2<ProcomposeK<F, G>, A, B>): Kind2<ProcomposeK<F, G>, C, D>
        = cap(fab.asProcompose(), f, g)

    private fun <A, B, C, D, E> cap(cmp: Procompose<F, G, E, A, B>, f: (C) -> A, g: (B) -> D): Kind2<ProcomposeK<F, G>, C, D>
        = Procompose({ p1.dimap(f, { it }, cmp.first()) }, p2.dimap({ it }, g, cmp.second))
}