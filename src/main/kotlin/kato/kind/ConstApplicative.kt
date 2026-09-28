package kato.kind

import kato.struct.Monoid
import kato.type.ConstK
import kato.type.runConst

class ConstApplicative<M>(private val group: Monoid<M>) : Applicative<ConstK<M>>
{
    override fun <A> of(a: A?): Kind<ConstK<M>, A> = Const(group.empty())

    override fun <A, B> map(f: (A) -> B, fa: Kind<ConstK<M>, A>): Kind<ConstK<M>, B>
        = Const(fa.runConst())

    override fun <A, B> lift(ff: Kind<ConstK<M>, (A) -> B>): (Kind<ConstK<M>, A>) -> Kind<ConstK<M>, B>
        = { fa -> Const(group.combine(ff.runConst(), fa.runConst()))}
}