package kato.optic

import kato.kind.Functor
import kato.kind.Kind
import kato.struct.Monoid
import kato.type.TypeAccessor
import kato.type.Unary

fun interface VGetter<S, T, A, B> : VFunctorOptic<S, T, A, B>
{
    fun get(s: S): A

    fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M = f(get(s))

    override fun <F : TypeAccessor<Unary>> mapF(f: (A) -> Kind<F, B>, s: S, ff: Functor<F>): Kind<F, T>
        = throw UnsupportedOperationException("Getter cannot output anything")

    companion object
    {
        fun <S, T, A, B> of(get: (S) -> A): VGetter<S, T, A, B> = VGetter { get(it) }
    }
}