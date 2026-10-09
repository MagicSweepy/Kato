package kato.kind

import kato.law.Law
import kato.type.ProcomposeK
import kato.type.FunctionK
import kato.type.asProcompose
import kato.type.asFunctionP

object FunctionPMonoidal : Profunctor<FunctionK>, Monoidal<FunctionK>, MonoidP<FunctionK>
{
    override fun <A, B, C, D> dimap(f: (C) -> A, g: (B) -> D, fab: Kind2<FunctionK, A, B>): Kind2<FunctionK, C, D>
        = FunctionP.of { g(fab.asFunctionP()(f(it))) }

    @Law("compose(id(), t) = t = compose(t, id())")
    @Law("compose(compose(t, u), v) = compose(t, compose(u, v))")
    override fun <A, B, C> compose(f: Kind2<FunctionK, B, C>, g: Kind2<FunctionK, A, B>): Kind2<FunctionK, A, C>
        = FunctionP.of { f.asFunctionP()(g.asFunctionP()(it)) }

    override fun <A> id(): Kind2<FunctionK, A, A> = FunctionP.of { it }

    @Law("par(id(), id()) = id()")
    @Law("par(f2, g2) ∘ par(f1, g1) = par(f2 ∘ f1, g2 ∘ g1)")
    override fun <A, B, C, D> par(a: Kind2<FunctionK, A, C>, b: Kind2<FunctionK, B, D>): Kind2<FunctionK, Pair<A, B>, Pair<C, D>>
        = FunctionP.of { (x, y) -> a.asFunctionP()(x) to b.asFunctionP()(y) }

    override fun <A, B> unit(pab: Kind2<FunctionK, A, B>): Kind2<FunctionK, A, B> = pab

    override fun <A, B> associate(pab: Kind2<ProcomposeK<FunctionK, FunctionK>, A, B>): Kind2<FunctionK, A, B>
        = cap(pab.asProcompose())

    private fun <A, B, C> cap(cmp: Procompose<FunctionK, FunctionK, C, A, B>): Kind2<FunctionK, A, B>
        = FunctionP.of { a -> cmp.second.asFunctionP()(cmp.first().asFunctionP()(a)) }
}
