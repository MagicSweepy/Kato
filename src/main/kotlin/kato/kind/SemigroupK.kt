package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface SemigroupK<F : TypeAccessor<Unary>, A>
{
    fun combine(a: Kind<F, A>, b: Kind<F, A>): Kind<F, A>
}