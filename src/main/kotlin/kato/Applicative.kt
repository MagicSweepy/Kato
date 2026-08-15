package kato

interface Applicative<F : TypeAccessor<Unary>> : Functor<F>
{
    fun <A> of(a: A?): Kind<F, A>

    fun <A, B> lift(ff: Kind<F, (A) -> B>): (Kind<F, A>) -> Kind<F, B>

    fun <A, B> ap(ff: Kind<F, (A) -> B>, fa: Kind<F, A>): Kind<F, B> = lift(ff)(fa)

    fun <A, B> ap(f: (A) -> B, fa: Kind<F, A>) = map(f, fa)

    // region mapN

    // map1 from Functor interface.

    fun <A, B, C> map2(fa: Kind<F, A>, fb: Kind<F, B>, f: (A) -> ((B) -> C)): Kind<F, C>
        = map2(fa, fb, f.uncurry())

    fun <A, B, C> map2(fa: Kind<F, A>, fb: Kind<F, B>, f: (A, B) -> C): Kind<F, C>
        = ap(map(f.curry(), fa), fb)

    fun <A, B, C, D> map3(fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, f: (A) -> ((B, C) -> D)): Kind<F, D>
        = map3(fa, fb, fc, f.uncurry())

    fun <A, B, C, D> map3(fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>, f: (A, B, C) -> D): Kind<F, D>
        = ap2(map(f.curry(), fa), fb, fc)

    // endregion

    // region apN

    fun <A, B, C> ap2(ff: Kind<F, (A, B) -> C>, fa: Kind<F, A>, fb: Kind<F, B>): Kind<F, C>
        = ap(ap(map({ it.curry() }, ff), fa), fb)

    fun <A, B, C, D> ap3(ff: Kind<F, (A, B, C) -> D>, fa: Kind<F, A>, fb: Kind<F, B>, fc: Kind<F, C>): Kind<F, D>
        = ap2(ap(map({ it.curry() }, ff), fa), fb, fc)

    // endregion

    // region liftN

    fun <A, B, C> lift2(ff: Kind<F, (A, B) -> C>): (Kind<F, A>, Kind<F, B>) -> Kind<F, C>
        = { fa, fb -> ap2(ff, fa, fb) }

    // endregion
}