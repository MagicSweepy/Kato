package kato.kind

import kato.extension.curry
import kato.extension.uncurry
import kato.type.TypeAccessor
import kato.type.Unary

interface Applicative<F : TypeAccessor<Unary>> : Functor<F>
{
    fun <A> of(a: A?): Kind<F, A>

    fun <A, B> lift(ff: Kind<F, (A) -> B>): (Kind<F, A>) -> Kind<F, B>

    fun <A, B> ap(ff: Kind<F, (A) -> B>, fa: Kind<F, A>): Kind<F, B> = lift(ff)(fa)

    fun <A, B> ap(f: (A) -> B, fa: Kind<F, A>) = map(f, fa)

    // region mapN

    // map1 from Functor interface.

    fun <A, B, R> map2(fa: Kind<F, A>, fb: Kind<F, B>, f: (A) -> ((B) -> R)): Kind<F, R>
        = map2(fa, fb, f.uncurry())

    fun <A, B, R> map2(fa: Kind<F, A>, fb: Kind<F, B>, f: (A, B) -> R): Kind<F, R>
        = ap(map(f.curry(), fa), fb)

    fun <A, B, C, R> map3(fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, f: (A) -> ((B, C) -> R)): Kind<F, R>
        = map3(fa, fb, fc, f.uncurry())

    fun <A, B, C, R> map3(fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, f: (A, B, C) -> R): Kind<F, R>
        = ap2(map(f.curry(), fa), fb, fc)

    fun <A, B, C, D, R> map4(fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, fd: Kind<F, D>, f: (A) -> ((B, C, D) -> R)): Kind<F, R>
        = map4(fa, fb, fc, fd, f.uncurry())

    fun <A, B, C, D, R> map4(fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, fd: Kind<F, D>, f: (A, B, C, D) -> R): Kind<F, R>
        = ap3(map(f.curry(), fa), fb, fc, fd)

    // endregion

    // region liftN

    fun <A, B, R> lift2(ff: Kind<F, (A, B) -> R>): (Kind<F, A>, Kind<F, B>) -> Kind<F, R>
        = { fa, fb -> ap2(ff, fa, fb) }

    fun <A, B, C, R> lift3(ff: Kind<F, (A, B, C) -> R>): (Kind<F, A>, Kind<F, B>, Kind<F, C>) -> Kind<F, R>
        = { fa, fb, fc -> ap3(ff, fa, fb, fc) }

    fun <A, B, C, D, R> lift4(ff: Kind<F, (A, B, C, D) -> R>): (Kind<F, A>, Kind<F, B>, Kind<F, C>, Kind<F, D>) -> Kind<F, R>
        = { fa, fb, fc, fd -> ap4(ff, fa, fb, fc, fd) }

    // endregion

    // region apN

    fun <A, B, R> ap2(ff: Kind<F, (A, B) -> R>, fa: Kind<F, A>, fb: Kind<F, B>): Kind<F, R>
        = ap(ap(map({ it.curry() }, ff), fa), fb)
    
    fun <A, B, C, R> ap3(ff: Kind<F, (A, B, C) -> R>, fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>): Kind<F, R>
        = ap2(ap(map({ it.curry() }, ff), fa), fb, fc)
    
    fun <A, B, C, D, R> ap4(ff: Kind<F, (A, B, C, D) -> R>, fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, fd: Kind<F, D>): Kind<F, R>
        = ap3(ap(map({ it.curry() }, ff), fa), fb, fc, fd)

    // endregion
}