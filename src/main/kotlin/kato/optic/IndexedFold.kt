package kato.optic

import kato.kind.Kind2
import kato.kind.Profunctor
import kato.struct.Monoid
import kato.type.Binary
import kato.type.TypeAccessor

interface IndexedFold<I, S, T, A, B> : IndexedOptic<I, S, T, A, B>
{
    fun <M> foldMap(m: Monoid<M>, f: (I, A) -> M, s: S): M

    fun toList(s: S): List<Pair<I, A>> = foldMap(Monoid.list(), { i, a -> listOf(Pair(i, a)) }, s)

    fun getAll(s: S): List<A> = foldMap(Monoid.list(), { _, a -> listOf(a) }, s)

    fun preview(s: S): Pair<I, A>? = foldMap(Monoid.firstOption(), { i, a -> Pair(i, a) }, s)

    fun length(s: S): Int = foldMap(Monoid.intAdd(), { _, _ -> 1 }, s)

    fun isEmpty(s: S): Boolean = !foldMap(Monoid.boolOr(), { _, _ -> true }, s)

    fun exists(p: (I, A) -> Boolean, s: S): Boolean = foldMap(Monoid.boolOr(), { i, a -> p(i, a) }, s)

    fun find(p: (I, A) -> Boolean, s: S): Pair<I, A>?
        = foldMap(Monoid.firstOption(), { i, a -> if (p(i, a)) Pair(i, a) else null }, s)

    fun unindexed(): Fold<S, T, A, B> = object : Fold<S, T, A, B>
    {
        override fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M
            = this@IndexedFold.foldMap(m, { _, a -> f(a) }, s)

        override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
            = this@IndexedFold.eval(p, pab)
    }

    infix fun <M, N> andThen(other: Fold<A, B, M, N>): IndexedFold<I, S, T, M, N>
        = object : IndexedFold<I, S, T, M, N>
          {
              override fun <X> foldMap(m: Monoid<X>, f: (I, M) -> X, s: S): X
                  = this@IndexedFold.foldMap(m, { i, a -> other.foldMap(m, { mm -> f(i, mm) }, a) }, s)

              override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, M, N>): Kind2<P, S, T>
                  = this@IndexedFold.eval(p, other.eval(p, pab))
          }

    infix fun <J, M, N> andThenI(other: IndexedFold<J, A, B, M, N>): IndexedFold<Pair<I, J>, S, T, M, N>
        = object : IndexedFold<Pair<I, J>, S, T, M, N>
          {
              override fun <X> foldMap(m: Monoid<X>, f: (Pair<I, J>, M) -> X, s: S): X
                  = this@IndexedFold.foldMap(m, { i, a ->
                        other.foldMap(m, { j, b -> f(Pair(i, j), b) }, a)
                    }, s)

              override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, M, N>): Kind2<P, S, T>
                  = this@IndexedFold.eval(p, other.eval(p, pab))
          }
}