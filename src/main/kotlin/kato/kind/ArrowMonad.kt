package kato.kind

import kato.type.Binary
import kato.type.Kleisli
import kato.type.KleisliArrow
import kato.type.LeftApplied
import kato.type.TypeAccessor
import kato.type.Unary
import kato.type.asKleisli
import kato.type.asLeftApplied
import kato.type.asLeftKind2

interface ArrowMonad<F : TypeAccessor<Binary>> : Arrow<F>
{
    fun <A, B, C> flatMap(f: (B) -> Kind2<F, A, C>, fab: Kind2<F, A, B>): Kind2<F, A, C>

    fun <A, B> flatten(ff: Kind2<F, A, Kind2<F, A, B>>): Kind2<F, A, B> = flatMap({ it }, ff)

    fun <A> toMonad(): Monad<LeftApplied<F, A>> = object : Monad<LeftApplied<F, A>>
    {
        private val applicative = ArrowApplicative<F, A>(this@ArrowMonad)

        override fun <B> of(b: B?): Kind<LeftApplied<F, A>, B> = applicative.of(b)

        override fun <B, C> map(f: (B) -> C, fa: Kind<LeftApplied<F, A>, B>): Kind<LeftApplied<F, A>, C>
            = applicative.map(f, fa)

        override fun <B, C> lift(ff: Kind<LeftApplied<F, A>, (B) -> C>): (Kind<LeftApplied<F, A>, B>) -> Kind<LeftApplied<F, A>, C>
            = applicative.lift(ff)

        override fun <B, C> flatMap(f: (B) -> Kind<LeftApplied<F, A>, C>, fa: Kind<LeftApplied<F, A>, B>): Kind<LeftApplied<F, A>, C>
            = this@ArrowMonad.flatMap({ b -> f(b).asLeftKind2() }, fa.asLeftKind2()).asLeftApplied()
    }
}

fun <M : TypeAccessor<Unary>> Monad<M>.toArrowMonad(): ArrowMonad<Kleisli<M>> = object : ArrowMonad<Kleisli<M>>
{
    override fun <A, B, C> compose(f: Kind2<Kleisli<M>, B, C>, g: Kind2<Kleisli<M>, A, B>): Kind2<Kleisli<M>, A, C>
        = KleisliArrow { a -> this@toArrowMonad.flatMap({ b -> f.asKleisli().run(b) }, g.asKleisli().run(a)) }

    override fun <A, B> lift(f: (A) -> B): Kind2<Kleisli<M>, A, B>
        = KleisliArrow { a -> this@toArrowMonad.of(f(a)) }

    override fun <A, B, C> first(fa: Kind2<Kleisli<M>, A, B>): Kind2<Kleisli<M>, Pair<A, C>, Pair<B, C>>
        = KleisliArrow { (a, c) -> this@toArrowMonad.map({ b -> b to c }, fa.asKleisli().run(a)) }

    override fun <A, B, C> flatMap(f: (B) -> Kind2<Kleisli<M>, A, C>, fab: Kind2<Kleisli<M>, A, B>): Kind2<Kleisli<M>, A, C>
        = KleisliArrow { a -> this@toArrowMonad.flatMap({ b -> f(b).asKleisli().run(a) }, fab.asKleisli().run(a)) }
}
