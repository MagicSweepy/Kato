package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface GroupK<F : TypeAccessor<Unary>, A> : MonoidK<F, A>
{
    fun inverse(a: Kind<F, A>): Kind<F, A>
}