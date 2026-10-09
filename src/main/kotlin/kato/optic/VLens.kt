package kato.optic

import kato.kind.Applicative
import kato.kind.Functor
import kato.kind.Kind
import kato.type.TypeAccessor
import kato.type.Unary

interface VLens<S, T, A, B> : VFunctorOptic<S, T, A, B>
{
    fun view(s: S): A

    fun set(b: B, s: S): T

    fun modify(f: (A) -> B, s: S): T = set(f(view(s)), s)

    override fun <F : TypeAccessor<Unary>> mapF(f: (A) -> Kind<F, B>, s: S, ff: Functor<F>): Kind<F, T>
        = ff.map({ set(it, s) }, f(view(s)))

    companion object
    {
        fun <S, T, A, B> of(view: (S) -> A, set: (B, S) -> T): VLens<S, T, A, B> = object : VLens<S, T, A, B>
        {
            override fun view(s: S): A = view(s)

            override fun set(b: B, s: S): T = set(b, s)
        }
    }
}