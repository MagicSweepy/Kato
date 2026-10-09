package kato.optic

import kato.kind.Functor
import kato.kind.Kind
import kato.type.TypeAccessor
import kato.type.Unary

interface VIso<S, T, A, B> : VFunctorOptic<S, T, A, B>
{
    fun from(s: S): A

    fun to(b: B): T

    override fun <F : TypeAccessor<Unary>> mapF(f: (A) -> Kind<F, B>, s: S, ff: Functor<F>): Kind<F, T>
        = ff.map({ to(it) }, f(from(s)))

    companion object
    {
        fun <S, T, A, B> of(from: (S) -> A, to: (B) -> T): VIso<S, T, A, B> = object : VIso<S, T, A, B>
        {
            override fun from(s: S): A = from(s)

            override fun to(b: B): T = to(b)
        }
    }
}