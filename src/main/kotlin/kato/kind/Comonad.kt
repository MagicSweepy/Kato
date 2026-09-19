package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

// TODO: Should we define Coapplicative and reimpl copure in it?
interface Comonad<F : TypeAccessor<Unary>> : Functor<F>
{
    fun <A> extract(fa: Kind<F, A>): A // copure

    fun <A, B> coflatMap(f: (Kind<F, A>) -> B, fa: Kind<F, A>): Kind<F, B>

    fun <A> duplicate(fa: Kind<F, A>): Kind<F, Kind<F, A>> // coflatten
        = coflatMap({ it }, fa)

    // region coflatMapN

    // TODO: Seems this impl will break structural and just flatten it,
    //       maybe it is not effect with Cofree or some structural context
    //       instances, maybe rework it in the future.

    fun <A, B, R> coflatMap2(fa: Kind<F, A>, fb: Kind<F, B>, f: (Kind<F, A>, Kind<F, B>) -> R): Kind<F, R>
        = coflatMap({ a -> extract(coflatMap({ b -> f(a, b) }, fb)) }, fa)

    fun <A, B, C, R> coflatMap3(fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, f: (Kind<F, A>, Kind<F, B>, Kind<F, C>) -> R): Kind<F, R>
        = coflatMap({ a -> extract(coflatMap({ b -> extract(coflatMap({ c -> f(a, b, c) }, fc)) }, fb)) }, fa)

    fun <A, B, C, D, R> coflatMap4(fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, fd: Kind<F, D>, f: (Kind<F, A>, Kind<F, B>, Kind<F, C>, Kind<F, D>) -> R): Kind<F, R>
        = coflatMap({ a -> extract(coflatMap({ b -> extract(coflatMap({ c -> extract(coflatMap({ d -> f(a, b, c, d) }, fd)) }, fc)) }, fb)) }, fa)

    // endregion
}