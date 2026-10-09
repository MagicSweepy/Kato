package kato.optic

import kato.kind.Applicative
import kato.kind.Const
import kato.kind.ConstApplicative
import kato.kind.Id
import kato.kind.IdApplicative
import kato.kind.Kind
import kato.kind.Wander
import kato.struct.Monoid
import kato.type.TypeAccessor
import kato.type.Unary
import kato.type.runConst
import kato.type.runId

interface VTraversal<S, T, A, B> : VApplicativeOptic<S, T, A, B>, Wander<S, T, A, B>
{
    fun modify(f: (A) -> B, s: S): T = wander(IdApplicative, { Id(f(it)) })(s).runId()

    fun set(b: B, s: S): T = modify({ b }, s)

    fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M
        = wander(ConstApplicative(m), { Const(f(it)) })(s).runConst()

    fun getAll(s: S): List<A> = foldMap(Monoid.list(), { listOf(it) }, s)

    fun preview(s: S): A? = foldMap(Monoid.firstOption(), { it }, s)

    override fun <F : TypeAccessor<Unary>> modifyF(f: (A) -> Kind<F, B>, s: S, ap: Applicative<F>): Kind<F, T>
        = wander(ap, f)(s)

    companion object
    {
        fun <S, T, A, B> of(wander: Wander<S, T, A, B>): VTraversal<S, T, A, B> = object : VTraversal<S, T, A, B>
        {
            override fun <F : TypeAccessor<Unary>> wander(ap: Applicative<F>, fab: (A) -> Kind<F, B>): (S) -> Kind<F, T>
                = wander.wander(ap, fab)
        }
    }
}