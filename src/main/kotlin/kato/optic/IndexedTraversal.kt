package kato.optic

import kato.kind.Applicative
import kato.kind.Const
import kato.kind.ConstApplicative
import kato.kind.Id
import kato.kind.IdApplicative
import kato.kind.IndexedTraversalP
import kato.kind.IndexedWander
import kato.kind.Kind
import kato.kind.Kind2
import kato.kind.Profunctor
import kato.kind.Wander
import kato.optic.IndexedFold
import kato.struct.Monoid
import kato.type.Binary
import kato.type.TypeAccessor
import kato.type.Unary
import kato.type.runConst
import kato.type.runId

interface IndexedTraversal<I, S, T, A, B> : IndexedOptic<I, S, T, A, B>, IndexedWander<I, S, T, A, B>
{
    fun over(f: (I, A) -> B, s: S): T = wanderI(IdApplicative, { i, a -> Id(f(i, a)) })(s).runId()

    fun set(b: B, s: S): T = over({ _, _ -> b }, s)

    fun <M> foldMap(m: Monoid<M>, f: (I, A) -> M, s: S): M
        = wanderI(ConstApplicative(m), { i, a -> Const(f(i, a)) })(s).runConst()

    fun toList(s: S): List<Pair<I, A>> = foldMap(Monoid.list(), { i, a -> listOf(Pair(i, a)) }, s)

    fun getAll(s: S): List<A> = foldMap(Monoid.list(), { _, a -> listOf(a) }, s)

    fun preview(s: S): Pair<I, A>? = foldMap(Monoid.firstOption(), { i, a -> Pair(i, a) }, s)

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
        = (p as IndexedTraversalP<P>).wanderI(this, pab)

    fun unindexed(): Traversal<S, T, A, B> = Traversal.of(object : Wander<S, T, A, B>
    {
        override fun <F : TypeAccessor<Unary>> wander(ap: Applicative<F>, fab: (A) -> Kind<F, B>): (S) -> Kind<F, T>
            = this@IndexedTraversal.wanderI(ap, { _, a -> fab(a) })
    })

    fun asIndexedFold(): IndexedFold<I, S, T, A, B> = object : IndexedFold<I, S, T, A, B>
    {
        override fun <M> foldMap(m: Monoid<M>, f: (I, A) -> M, s: S): M
            = this@IndexedTraversal.foldMap(m, f, s)

        override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
            = this@IndexedTraversal.eval(p, pab)
    }

    infix fun <M, N> andThen(other: Traversal<A, B, M, N>): IndexedTraversal<I, S, T, M, N>
        = of(object : IndexedWander<I, S, T, M, N>
          {
              override fun <F : TypeAccessor<Unary>> wanderI(ap: Applicative<F>, f: (I, M) -> Kind<F, N>): (S) -> Kind<F, T>
                  = this@IndexedTraversal.wanderI(ap, { i, a -> other.wander(ap, { m -> f(i, m) })(a) })
          })

    infix fun <J, M, N> andThenI(other: IndexedTraversal<J, A, B, M, N>): IndexedTraversal<Pair<I, J>, S, T, M, N>
        = of(object : IndexedWander<Pair<I, J>, S, T, M, N>
          {
              override fun <F : TypeAccessor<Unary>> wanderI(ap: Applicative<F>, f: (Pair<I, J>, M) -> Kind<F, N>): (S) -> Kind<F, T>
                  = this@IndexedTraversal.wanderI(ap, { i, a ->
                        other.wanderI(ap, { j, b -> f(Pair(i, j), b) })(a)
                    })
          })

    companion object
    {
        fun <I, S, T, A, B> of(wanderI: IndexedWander<I, S, T, A, B>): IndexedTraversal<I, S, T, A, B>
            = object : IndexedTraversal<I, S, T, A, B>
              {
                  override fun <F : TypeAccessor<Unary>> wanderI(ap: Applicative<F>, f: (I, A) -> Kind<F, B>): (S) -> Kind<F, T>
                      = wanderI.wanderI(ap, f)
              }
    }
}