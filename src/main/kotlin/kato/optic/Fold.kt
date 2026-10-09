package kato.optic

import kato.struct.Monoid

interface Fold<S, T, A, B> : Optic<S, T, A, B>
{
    fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M

    fun getAll(s: S): List<A> = foldMap(Monoid.list(), { listOf(it) }, s)

    fun preview(s: S): A? = foldMap(Monoid.firstOption(), { it }, s)

    fun length(s: S): Int = foldMap(Monoid.intAdd(), { 1 }, s)

    fun isEmpty(s: S): Boolean = !foldMap(Monoid.boolOr(), { true }, s)
}