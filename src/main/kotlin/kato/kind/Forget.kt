package kato.kind

import kato.type.ForgetK

fun interface Forget<M, A, B> : Kind2<ForgetK<M>, A, B>
{
    fun run(a: A): M

    companion object
    {
        fun <M, A, B> of(f: (A) -> M): Forget<M, A, B> = Forget { f(it) }
    }
}