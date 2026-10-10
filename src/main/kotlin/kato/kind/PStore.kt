package kato.kind

import kato.type.PStoreK

interface PStore<I, O, A> : Kind<PStoreK<I, O>, A>
{
    fun peek(o: O): A

    fun pos(): I

    companion object
    {
        fun <I, O, A> of(peek: (O) -> A, pos: () -> I): PStore<I, O, A> = object : PStore<I, O, A>
        {
            override fun peek(o: O): A = peek(o)

            override fun pos(): I = pos()
        }
    }
}
