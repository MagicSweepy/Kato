@file:Suppress("UNCHECKED_CAST")
package kato.kind

import kato.type.Binary
import kato.type.LeftApplied
import kato.type.TypeAccessor
import kato.type.asLeftApplied
import kato.type.asLeftKind2

class ArrowApplicative<F : TypeAccessor<Binary>, A>(private val arrow: Arrow<F>) : Applicative<LeftApplied<F, A>>
{
    override fun <A1> of(a: A1?): Kind<LeftApplied<F, A>, A1>
        = arrow.lift { _: A -> a as A1 }.asLeftApplied()

    override fun <B, C> map(f: (B) -> C, fa: Kind<LeftApplied<F, A>, B>): Kind<LeftApplied<F, A>, C>
        = arrow.rmap(f, fa.asLeftKind2()).asLeftApplied()

    override fun <B, C> lift(ff: Kind<LeftApplied<F, A>, (B) -> C>): (Kind<LeftApplied<F, A>, B>) -> Kind<LeftApplied<F, A>, C>
        = { fb -> ap(ff, fb) }

    override fun <B, C> ap(ff: Kind<LeftApplied<F, A>, (B) -> C>, fa: Kind<LeftApplied<F, A>, B>): Kind<LeftApplied<F, A>, C>
        = arrow.rmap({ (f, b) -> f(b) }, arrow.merge(ff.asLeftKind2(), fa.asLeftKind2())).asLeftApplied()

    fun <B, C> product(fb: Kind<LeftApplied<F, A>, B>, fc: Kind<LeftApplied<F, A>, C>): Kind<LeftApplied<F, A>, Pair<B, C>>
        = arrow.merge(fb.asLeftKind2(), fc.asLeftKind2()).asLeftApplied()
}
