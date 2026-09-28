package kato.kind

import kato.type.ConstK
import kato.type.runConst

class ConstFunctor<M> : Functor<ConstK<M>>
{
    override fun <A, B> map(f: (A) -> B, fa: Kind<ConstK<M>, A>): Kind<ConstK<M>, B>
        = Const(fa.runConst())
}