package kato.optic

import kato.kind.Applicative
import kato.kind.CartesianP
import kato.kind.IndexedWander
import kato.kind.Kind
import kato.kind.Kind2
import kato.kind.Profunctor
import kato.struct.Monoid
import kato.type.Binary
import kato.type.TypeAccessor
import kato.type.Unary

interface IndexedLens<I, S, T, A, B> : IndexedOptic<I, S, T, A, B>
{
    fun index(): I

    fun get(s: S): A

    fun set(b: B, s: S): T

    fun modify(f: (A) -> B, s: S): T = set(f(get(s)), s)

    fun getI(s: S): Pair<I, A> = Pair(index(), get(s))

    fun modifyI(f: (I, A) -> B, s: S): T = set(f(index(), get(s)), s)

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
    {
        val c = p as CartesianP<P>
        return c.dimap({ Pair(get(it), it) }, { pr: Pair<B, S> -> set(pr.first, pr.second) }, c.first(pab))
    }

    fun unindexed(): Lens<S, T, A, B> = Lens.of({ get(it) }, { b, s -> set(b, s) })

    fun asIndexedTraversal(): IndexedTraversal<I, S, T, A, B> = IndexedTraversal.of(object : IndexedWander<I, S, T, A, B>
    {
        override fun <F : TypeAccessor<Unary>> wanderI(ap: Applicative<F>, f: (I, A) -> Kind<F, B>): (S) -> Kind<F, T>
            = { s -> ap.map({ b -> set(b, s) }, f(index(), get(s))) }
    })

    fun asIndexedFold(): IndexedFold<I, S, T, A, B> = object : IndexedFold<I, S, T, A, B>
    {
        override fun <M> foldMap(m: Monoid<M>, f: (I, A) -> M, s: S): M = f(index(), get(s))

        override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
            = this@IndexedLens.eval(p, pab)
    }

    companion object
    {
        fun <I, S, T, A, B> of(index: I, get: (S) -> A, set: (B, S) -> T): IndexedLens<I, S, T, A, B>
            = object : IndexedLens<I, S, T, A, B>
              {
                  override fun index(): I = index

                  override fun get(s: S): A = get(s)

                  override fun set(b: B, s: S): T = set(b, s)
              }
    }
}