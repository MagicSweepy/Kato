package kato.optic

import kato.kind.Applicative
import kato.kind.Functor
import kato.kind.Kind
import kato.type.TypeAccessor
import kato.type.Unary

interface VFunctorOptic<S, T, A, B> : VOptic<S, T, A, B>
{
    fun <F : TypeAccessor<Unary>> mapF(f: (A) -> Kind<F, B>, s: S, ff: Functor<F>): Kind<F, T>

    override fun <F : TypeAccessor<Unary>> modifyF(f: (A) -> Kind<F, B>, s: S, ap: Applicative<F>): Kind<F, T>
        = mapF(f, s, ap)

    infix fun <A1, B1> andThen(other: VFunctorOptic<A, B, A1, B1>): VFunctorOptic<S, T, A1, B1> = object : VFunctorOptic<S, T, A1, B1>
    {
        override fun <F : TypeAccessor<Unary>> mapF(f: (A1) -> Kind<F, B1>, s: S, ff: Functor<F>): Kind<F, T>
            = this@VFunctorOptic.mapF({ a -> other.mapF(f, a, ff) }, s, ff)
    }
}