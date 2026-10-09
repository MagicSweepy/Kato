package kato.optic

import kato.kind.Forget
import kato.kind.ForgetMonoid
import kato.kind.Kind2
import kato.kind.Profunctor
import kato.struct.Monoid
import kato.type.Binary
import kato.type.TypeAccessor
import kato.type.asForget

interface Fold<S, T, A, B> : Optic<S, T, A, B>
{
    fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M

    fun getAll(s: S): List<A> = foldMap(Monoid.list(), { listOf(it) }, s)

    fun preview(s: S): A? = foldMap(Monoid.firstOption(), { it }, s)

    fun length(s: S): Int = foldMap(Monoid.intAdd(), { 1 }, s)

    fun isEmpty(s: S): Boolean = !foldMap(Monoid.boolOr(), { true }, s)

    fun contains(p: (A) -> Boolean, s: S): Boolean = foldMap(Monoid.boolOr(), { p(it) }, s)

    fun find(p: (A) -> Boolean, s: S): A? = foldMap(Monoid.firstOption(), { if (p(it)) it else null }, s)
}

fun <S, T, A, B> Optic<S, T, A, B>.asFold(): Fold<S, T, A, B> = object : Fold<S, T, A, B>
{
    override fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M
    {
        val ff = ForgetMonoid(m)
        return this@asFold.eval(ff, Forget.of(f)).asForget().run(s)
    }

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
        = this@asFold.eval(p, pab)
}