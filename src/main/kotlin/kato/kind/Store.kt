package kato.kind

import kato.type.StoreK

interface Store<S, A> : Kind<StoreK<S>, A>
{
    fun peek(s: S): A

    fun pos(): S

    companion object
    {
        fun <S, A> of(peek: (S) -> A, pos: () -> S): Store<S, A> = object : Store<S, A>
        {
            override fun peek(s: S): A = peek(s)

            override fun pos(): S = pos()
        }
    }
}
