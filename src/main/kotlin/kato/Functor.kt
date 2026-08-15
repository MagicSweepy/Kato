package kato

interface Functor<F : TypeAccessor<Unary>>
{
    fun <A, B> map(f: (A) -> B, fa: Kind<F, A>): Kind<F, B>
}