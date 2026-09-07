package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Functor<F : TypeAccessor<Unary>>
{
    fun <A, B> map(f: (A) -> B, fa: Kind<F, A>): Kind<F, B>
}