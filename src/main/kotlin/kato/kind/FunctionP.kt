package kato.kind

import kato.type.FunctionK

fun interface FunctionP<A, B> : Kind2<FunctionK, A, B>
{
    operator fun invoke(a: A): B

    companion object
    {
        fun <A, B> of(f: (A) -> B): FunctionP<A, B> = FunctionP { f(it) }
    }
}