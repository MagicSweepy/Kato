package kato.optic

import kato.kind.Const
import kato.kind.ConstApplicative
import kato.kind.Functor
import kato.kind.Kind
import kato.struct.Monoid
import kato.type.TypeAccessor
import kato.type.Unary
import kato.type.runConst

interface VFold<S, T, A, B> : VFunctorOptic<S, T, A, B>
{
    fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M

    fun getAll(s: S): List<A> = foldMap(Monoid.list(), { listOf(it) }, s)

    fun preview(s: S): A? = foldMap(Monoid.firstOption(), { it }, s)

    fun length(s: S): Int = foldMap(Monoid.intAdd(), { 1 }, s)

    fun isEmpty(s: S): Boolean = !foldMap(Monoid.boolOr(), { true }, s)

    fun contains(p: (A) -> Boolean, s: S): Boolean = foldMap(Monoid.boolOr(), { p(it) }, s)

    fun find(p: (A) -> Boolean, s: S): A? = foldMap(Monoid.firstOption(), { if (p(it)) it else null }, s)

    override fun <F : TypeAccessor<Unary>> mapF(f: (A) -> Kind<F, B>, s: S, ff: Functor<F>): Kind<F, T>
        = TODO("Not yet implemented")

    companion object
    {
        fun <S, T, A, B> of(optic: VOptic<S, T, A, B>): VFold<S, T, A, B> = object : VFold<S, T, A, B>
        {
            override fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M
                = optic.modifyF({ Const(f(it)) }, s, ConstApplicative(m)).runConst()
        }
    }
}