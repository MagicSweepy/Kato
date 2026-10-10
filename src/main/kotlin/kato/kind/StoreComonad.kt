package kato.kind

import kato.type.StoreK
import kato.type.asStore

class StoreComonad<S> : Comonad<StoreK<S>>
{
    override fun <A, B> map(f: (A) -> B, fa: Kind<StoreK<S>, A>): Kind<StoreK<S>, B>
    {
        val s = fa.asStore()
        return Store.of({ f(s.peek(it)) }, { s.pos() })
    }

    override fun <A> extract(fa: Kind<StoreK<S>, A>): A
    {
        val s = fa.asStore()
        return s.peek(s.pos())
    }

    override fun <A, B> coflatMap(f: (Kind<StoreK<S>, A>) -> B, fa: Kind<StoreK<S>, A>): Kind<StoreK<S>, B>
    {
        val s = fa.asStore()
        return Store.of({ ss -> f(Store.of({ s.peek(it) }, { ss })) }, { s.pos() })
    }
}
