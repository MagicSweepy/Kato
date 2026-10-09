package kato.optic

import kato.kind.Applicative
import kato.kind.Kind
import kato.type.TypeAccessor
import kato.type.Unary

/**
 * @see Optic Profunctor encoding Optic
 */
interface VOptic<S, T, A, B>
{
    fun <F : TypeAccessor<Unary>> modifyF(f: (A) -> Kind<F, B>, s: S, ap: Applicative<F>): Kind<F, T>

    infix fun <A1, B1> andThen(other: VOptic<A, B, A1, B1>): VOptic<S, T, A1, B1> = object : VOptic<S, T, A1, B1>
    {
        override fun <F : TypeAccessor<Unary>> modifyF(f: (A1) -> Kind<F, B1>, s: S, ap: Applicative<F>): Kind<F, T>
            = this@VOptic.modifyF({ a -> other.modifyF(f, a, ap) }, s, ap)
    }
}