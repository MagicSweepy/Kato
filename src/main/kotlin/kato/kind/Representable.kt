package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Representable<F : TypeAccessor<Unary>> : Functor<F>
{
    fun <A> from(fa: Kind<F, A>): (Representable<F>) -> A

    fun <A> to(f: (Representable<F>) -> A): Kind<F, A>
}