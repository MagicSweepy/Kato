package kato.optic

import kato.kind.Applicative
import kato.kind.Const
import kato.kind.ConstApplicative
import kato.kind.Id
import kato.kind.IdApplicative
import kato.kind.Kind
import kato.kind.Kind2
import kato.kind.Profunctor
import kato.kind.TraversalP
import kato.kind.Wander
import kato.struct.Monoid
import kato.type.Binary
import kato.type.TypeAccessor
import kato.type.Unary
import kato.type.runConst
import kato.type.runId

interface Traversal<S, T, A, B> : Optic<S, T, A, B>, Wander<S, T, A, B>
{
    fun over(f: (A) -> B, s: S): T = wander(IdApplicative, { Id(f(it)) })(s).runId()

    fun set(b: B, s: S): T = over({ b }, s)

    fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M
        = wander(ConstApplicative(m), { Const(f(it)) })(s).runConst()

    fun getAll(s: S): List<A> = foldMap(Monoid.list(), { listOf(it) }, s)

    fun preview(s: S): A? = foldMap(Monoid.firstOption(), { it }, s)

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
        = (p as TraversalP<P>).wander(this, pab)

    companion object
    {
        fun <S, T, A, B> of(wander: Wander<S, T, A, B>): Traversal<S, T, A, B> = object : Traversal<S, T, A, B>
        {
            override fun <F : TypeAccessor<Unary>> wander(ap: Applicative<F>, fab: (A) -> Kind<F, B>): (S) -> Kind<F, T>
                = wander.wander(ap, fab)
        }
    }
}