package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface MonadZero<F : TypeAccessor<Unary>, A> : Monad<F>, Alternative<F, A>
{
    override fun empty(): Kind<F, A>

    fun filter(fa: Kind<F, A>, condition: (A) -> Boolean): Kind<F, A>
        = flatMap({ a -> if (condition(a)) of(a) else empty() }, fa)
}