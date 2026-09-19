package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Alternative<F : TypeAccessor<Unary>, A> : Applicative<F>, MonoidK<F, A>
{
    override fun empty(): Kind<F, A>

    fun orElse(fa: Kind<F, A>, eval: () -> Kind<F, A>): Kind<F, A>
}