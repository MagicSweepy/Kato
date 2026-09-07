package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Monad<F : TypeAccessor<Unary>> : Applicative<F>
{
    fun <T1, T2> flatMap(f: (T1) -> Kind<F, T2>, t1: Kind<F, T1>): Kind<F, T2>

    // region flatMapN

    fun <T1, T2, R> flatMap2(t1: Kind<F, T1>, t2: Kind<F, T2>, f: (T1, T2) -> Kind<F, R>): Kind<F, R>
        = flatMap({ a1 -> flatMap({ a2 -> f(a1, a2) }, t2) }, t1)

    fun <T1, T2, T3, R> flatMap3(t1: Kind<F, T1>, t2: Kind<F, T2>, t3: Kind<F, T3>, f: (T1, T2, T3) -> Kind<F, R>): Kind<F, R>
        = flatMap({ a1 -> flatMap({ a2 -> flatMap({ a3 -> f(a1, a2, a3) }, t3) }, t2) }, t1)

    fun <T1, T2, T3, T4, R> flatMap4(t1: Kind<F, T1>, t2: Kind<F, T2>, t3: Kind<F, T3>, t4: Kind<F, T4>, f: (T1, T2, T3, T4) -> Kind<F, R>): Kind<F, R>
        = flatMap({ a1 -> flatMap({ a2 -> flatMap({ a3 -> flatMap({ a4 -> f(a1, a2, a3, a4) }, t4) }, t3) }, t2) }, t1)

    // endregion
}