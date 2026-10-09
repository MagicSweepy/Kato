package kato.optic

import kato.kind.Kind2
import kato.kind.Profunctor
import kato.type.Binary
import kato.type.TypeAccessor

fun interface Setter<S, T, A, B> : Optic<S, T, A, B>
{
    fun modify(f: (A) -> B, s: S): T

    fun set(b: B, s: S): T = modify({ b }, s)

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
        = throw UnsupportedOperationException("Setter cannot evaluate anything")

    companion object
    {
        fun <S, T, A, B> of(modify: ((A) -> B, S) -> T): Setter<S, T, A, B> = Setter { f, s -> modify(f, s) }
    }
}