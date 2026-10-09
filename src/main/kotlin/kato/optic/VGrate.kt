package kato.optic

import kato.kind.Functor
import kato.kind.Kind
import kato.type.TypeAccessor
import kato.type.Unary

interface VGrate<S, T, A, B> : VFunctorOptic<S, T, A, B>
{
    fun grate(f: ((S) -> A) -> B): T

    fun modify(f: (A) -> B, s: S): T = grate { f(it(s)) }

    fun set(b: B, s: S): T = grate { _ -> b }

    override fun <F : TypeAccessor<Unary>> mapF(f: (A) -> Kind<F, B>, s: S, ff: Functor<F>): Kind<F, T>
        = TODO("Not yet implemented")

    companion object
    {
        fun <S, T, A, B> of(grate: (((S) -> A) -> B) -> T): VGrate<S, T, A, B> = object : VGrate<S, T, A, B>
        {
            override fun grate(f: ((S) -> A) -> B): T = grate(f)
        }
    }
}