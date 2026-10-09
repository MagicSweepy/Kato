package kato.optic

import kato.kind.Functor
import kato.kind.Kind
import kato.type.TypeAccessor
import kato.type.Unary

fun interface VSetter<S, T, A, B> : VFunctorOptic<S, T, A, B>
{
    fun modify(f: (A) -> B, s: S): T

    fun set(b: B, s: S): T = modify({ b }, s)

    override fun <F : TypeAccessor<Unary>> mapF(f: (A) -> Kind<F, B>, s: S, ff: Functor<F>): Kind<F, T>
        = throw UnsupportedOperationException("Setter cannot evaluate anything")

    companion object
    {
        fun <S, T, A, B> of(modify: ((A) -> B, S) -> T): VSetter<S, T, A, B> = VSetter { f, s -> modify(f, s) }
    }
}