package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Natural<F : TypeAccessor<Unary>, G : TypeAccessor<Unary>> // F ~> G
{
    fun <A> apply(fa: Kind<F, A>): Kind<G, A>

    operator fun <A> invoke(fa: Kind<F, A>): Kind<G, A> = apply(fa)

    infix fun <H : TypeAccessor<Unary>> andThen(fg: Natural<G, H>): Natural<F, H> = object : Natural<F, H>
    {
        override fun <A> apply(fa: Kind<F, A>): Kind<H, A> = fg(this@Natural(fa))
    }

    infix fun <H : TypeAccessor<Unary>> compose(fh: Natural<H, F>): Natural<H, G> = object : Natural<H, G>
    {
        override fun <A> apply(fa: Kind<H, A>): Kind<G, A> = this@Natural(fh(fa))
    }

    companion object
    {
        fun <F : TypeAccessor<Unary>> id(): Natural<F, F> = object : Natural<F, F>
        {
            override fun <A> apply(fa: Kind<F, A>): Kind<F, A> = fa
        }
    }
}