package kato.kind

import kato.type.PStoreK
import kato.type.asPStore

class PStoreFunctor<I, O> : Functor<PStoreK<I, O>>
{
    override fun <A1, B> map(f: (A1) -> B, fa: Kind<PStoreK<I, O>, A1>): Kind<PStoreK<I, O>, B>
    {
        val p = fa.asPStore()
        return PStore.of({ f(p.peek(it)) }, { p.pos() })
    }
}
