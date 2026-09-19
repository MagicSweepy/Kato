package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Monad<F : TypeAccessor<Unary>> : Applicative<F>
{
    fun <A, B> flatMap(f: (A) -> Kind<F, B>, fa: Kind<F, A>): Kind<F, B>

    // region flatMapN

    fun <A, B, R> flatMap2(fa: Kind<F, A>, fb: Kind<F, B>, f: (A, B) -> Kind<F, R>): Kind<F, R>
        = flatMap({ a1 -> flatMap({ a2 -> f(a1, a2) }, fb) }, fa)

    fun <A, B, C, R> flatMap3(fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, f: (A, B, C) -> Kind<F, R>): Kind<F, R>
        = flatMap({ a1 -> flatMap({ a2 -> flatMap({ a3 -> f(a1, a2, a3) }, fc) }, fb) }, fa)

    fun <A, B, C, D, R> flatMap4(fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, fd: Kind<F, D>, f: (A, B, C, D) -> Kind<F, R>): Kind<F, R>
        = flatMap({ a1 -> flatMap({ a2 -> flatMap({ a3 -> flatMap({ a4 -> f(a1, a2, a3, a4) }, fd) }, fc) }, fb) }, fa)

    // endregion
}