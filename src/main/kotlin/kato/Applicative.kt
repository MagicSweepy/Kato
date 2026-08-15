@file:Suppress("unused")
package kato

interface Applicative<F : TypeAccessor<Unary>> : Functor<F>
{
    fun <T1> of(t1: T1?): Kind<F, T1>

    fun <T1, T2> lift(ff: Kind<F, (T1) -> T2>): (Kind<F, T1>) -> Kind<F, T2>

    fun <T1, T2> ap(ff: Kind<F, (T1) -> T2>, f1: Kind<F, T1>): Kind<F, T2> = lift(ff)(f1)

    fun <T1, T2> ap(f: (T1) -> T2, f1: Kind<F, T1>) = map(f, f1)

    // region mapN

    // map1 from Functor interface.

    fun <T1, T2, R> map2(f1: Kind<F, T1>, f2: Kind<F, T2>, f: (T1) -> ((T2) -> R)): Kind<F, R>
        = map2(f1, f2, f.uncurry())
    
    fun <T1, T2, R> map2(f1: Kind<F, T1>, f2: Kind<F, T2>, f: (T1, T2) -> R): Kind<F, R>
        = ap(map(f.curry(), f1), f2)
    
    fun <T1, T2, T3, R> map3(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f: (T1) -> ((T2, T3) -> R)): Kind<F, R>
        = map3(f1, f2, f3, f.uncurry())
    
    fun <T1, T2, T3, R> map3(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f: (T1, T2, T3) -> R): Kind<F, R>
        = ap2(map(f.curry(), f1), f2, f3)
    
    fun <T1, T2, T3, T4, R> map4(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f: (T1) -> ((T2, T3, T4) -> R)): Kind<F, R>
        = map4(f1, f2, f3, f4, f.uncurry())
    
    fun <T1, T2, T3, T4, R> map4(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f: (T1, T2, T3, T4) -> R): Kind<F, R>
        = ap3(map(f.curry(), f1), f2, f3, f4)
    
    fun <T1, T2, T3, T4, T5, R> map5(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f: (T1) -> ((T2, T3, T4, T5) -> R)): Kind<F, R>
        = map5(f1, f2, f3, f4, f5, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, R> map5(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f: (T1, T2, T3, T4, T5) -> R): Kind<F, R>
        = ap4(map(f.curry(), f1), f2, f3, f4, f5)
    
    fun <T1, T2, T3, T4, T5, T6, R> map6(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f: (T1) -> ((T2, T3, T4, T5, T6) -> R)): Kind<F, R>
        = map6(f1, f2, f3, f4, f5, f6, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, R> map6(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f: (T1, T2, T3, T4, T5, T6) -> R): Kind<F, R>
        = ap5(map(f.curry(), f1), f2, f3, f4, f5, f6)
    
    fun <T1, T2, T3, T4, T5, T6, T7, R> map7(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f: (T1) -> ((T2, T3, T4, T5, T6, T7) -> R)): Kind<F, R>
        = map7(f1, f2, f3, f4, f5, f6, f7, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, R> map7(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f: (T1, T2, T3, T4, T5, T6, T7) -> R): Kind<F, R>
        = ap6(map(f.curry(), f1), f2, f3, f4, f5, f6, f7)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, R> map8(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8) -> R)): Kind<F, R>
        = map8(f1, f2, f3, f4, f5, f6, f7, f8, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, R> map8(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f: (T1, T2, T3, T4, T5, T6, T7, T8) -> R): Kind<F, R>
        = ap7(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> map9(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9) -> R)): Kind<F, R>
        = map9(f1, f2, f3, f4, f5, f6, f7, f8, f9, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> map9(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R): Kind<F, R>
        = ap8(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> map10(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R)): Kind<F, R>
        = map10(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> map10(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R): Kind<F, R>
        = ap9(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> map11(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R)): Kind<F, R>
        = map11(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> map11(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R): Kind<F, R>
        = ap10(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> map12(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R)): Kind<F, R>
        = map12(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> map12(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R): Kind<F, R>
        = ap11(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> map13(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R)): Kind<F, R>
        = map13(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> map13(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R): Kind<F, R>
        = ap12(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> map14(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)): Kind<F, R>
        = map14(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> map14(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R): Kind<F, R>
        = ap13(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> map15(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)): Kind<F, R>
        = map15(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> map15(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R): Kind<F, R>
        = ap14(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> map16(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)): Kind<F, R>
        = map16(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> map16(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R): Kind<F, R>
        = ap15(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> map17(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)): Kind<F, R>
        = map17(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> map17(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R): Kind<F, R>
        = ap16(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> map18(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)): Kind<F, R>
        = map18(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> map18(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R): Kind<F, R>
        = ap17(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> map19(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)): Kind<F, R>
        = map19(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> map19(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R): Kind<F, R>
        = ap18(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> map20(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f20: Kind<F, T20>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)): Kind<F, R>
        = map20(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> map20(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f20: Kind<F, T20>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R): Kind<F, R>
        = ap19(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> map21(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f20: Kind<F, T20>, f21: Kind<F, T21>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)): Kind<F, R>
        = map21(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> map21(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f20: Kind<F, T20>, f21: Kind<F, T21>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R): Kind<F, R>
        = ap20(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> map22(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f20: Kind<F, T20>, f21: Kind<F, T21>, f22: Kind<F, T22>, f: (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)): Kind<F, R>
        = map22(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f.uncurry())
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> map22(f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f20: Kind<F, T20>, f21: Kind<F, T21>, f22: Kind<F, T22>, f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R): Kind<F, R>
        = ap21(map(f.curry(), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22)

    // endregion

    // region apN

    fun <T1, T2, R> ap2(ff: Kind<F, (T1, T2) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>): Kind<F, R>
        = ap(ap(map({ it.curry() }, ff), f1), f2)
    
    fun <T1, T2, T3, R> ap3(ff: Kind<F, (T1, T2, T3) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>): Kind<F, R>
        = ap2(ap(map({ it.curry() }, ff), f1), f2, f3)
    
    fun <T1, T2, T3, T4, R> ap4(ff: Kind<F, (T1, T2, T3, T4) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>): Kind<F, R>
        = ap3(ap(map({ it.curry() }, ff), f1), f2, f3, f4)
    
    fun <T1, T2, T3, T4, T5, R> ap5(ff: Kind<F, (T1, T2, T3, T4, T5) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>): Kind<F, R>
        = ap4(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5)
    
    fun <T1, T2, T3, T4, T5, T6, R> ap6(ff: Kind<F, (T1, T2, T3, T4, T5, T6) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>): Kind<F, R>
        = ap5(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6)
    
    fun <T1, T2, T3, T4, T5, T6, T7, R> ap7(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>): Kind<F, R>
        = ap6(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ap8(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>): Kind<F, R>
        = ap7(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ap9(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>): Kind<F, R>
        = ap8(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ap10(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>): Kind<F, R>
        = ap9(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ap11(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>): Kind<F, R>
        = ap10(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ap12(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>): Kind<F, R>
        = ap11(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ap13(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>): Kind<F, R>
        = ap12(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ap14(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>): Kind<F, R>
        = ap13(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ap15(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>): Kind<F, R>
        = ap14(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ap16(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>): Kind<F, R>
        = ap15(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ap17(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>): Kind<F, R>
        = ap16(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ap18(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>): Kind<F, R>
        = ap17(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ap19(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>): Kind<F, R>
        = ap18(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ap20(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f20: Kind<F, T20>): Kind<F, R>
        = ap19(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ap21(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f20: Kind<F, T20>, f21: Kind<F, T21>): Kind<F, R>
        = ap20(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21)
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ap22(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R>, f1: Kind<F, T1>, f2: Kind<F, T2>, f3: Kind<F, T3>, f4: Kind<F, T4>, f5: Kind<F, T5>, f6: Kind<F, T6>, f7: Kind<F, T7>, f8: Kind<F, T8>, f9: Kind<F, T9>, f10: Kind<F, T10>, f11: Kind<F, T11>, f12: Kind<F, T12>, f13: Kind<F, T13>, f14: Kind<F, T14>, f15: Kind<F, T15>, f16: Kind<F, T16>, f17: Kind<F, T17>, f18: Kind<F, T18>, f19: Kind<F, T19>, f20: Kind<F, T20>, f21: Kind<F, T21>, f22: Kind<F, T22>): Kind<F, R>
        = ap21(ap(map({ it.curry() }, ff), f1), f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22)

    // endregion

    // region liftN

    fun <T1, T2, R> lift2(ff: Kind<F, (T1, T2) -> R>): (Kind<F, T1>, Kind<F, T2>) -> Kind<F, R>
        = { f1, f2 -> ap2(ff, f1, f2) }
    
    fun <T1, T2, T3, R> lift3(ff: Kind<F, (T1, T2, T3) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>) -> Kind<F, R>
        = { f1, f2, f3 -> ap3(ff, f1, f2, f3) }
    
    fun <T1, T2, T3, T4, R> lift4(ff: Kind<F, (T1, T2, T3, T4) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>) -> Kind<F, R>
        = { f1, f2, f3, f4 -> ap4(ff, f1, f2, f3, f4) }
    
    fun <T1, T2, T3, T4, T5, R> lift5(ff: Kind<F, (T1, T2, T3, T4, T5) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5 -> ap5(ff, f1, f2, f3, f4, f5) }
    
    fun <T1, T2, T3, T4, T5, T6, R> lift6(ff: Kind<F, (T1, T2, T3, T4, T5, T6) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6 -> ap6(ff, f1, f2, f3, f4, f5, f6) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, R> lift7(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7 -> ap7(ff, f1, f2, f3, f4, f5, f6, f7) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, R> lift8(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8 -> ap8(ff, f1, f2, f3, f4, f5, f6, f7, f8) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> lift9(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9 -> ap9(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> lift10(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10 -> ap10(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> lift11(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11 -> ap11(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> lift12(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12 -> ap12(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> lift13(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>, Kind<F, T13>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13 -> ap13(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> lift14(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>, Kind<F, T13>, Kind<F, T14>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14 -> ap14(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> lift15(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>, Kind<F, T13>, Kind<F, T14>, Kind<F, T15>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15 -> ap15(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> lift16(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>, Kind<F, T13>, Kind<F, T14>, Kind<F, T15>, Kind<F, T16>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16 -> ap16(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> lift17(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>, Kind<F, T13>, Kind<F, T14>, Kind<F, T15>, Kind<F, T16>, Kind<F, T17>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17 -> ap17(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> lift18(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>, Kind<F, T13>, Kind<F, T14>, Kind<F, T15>, Kind<F, T16>, Kind<F, T17>, Kind<F, T18>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18 -> ap18(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> lift19(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>, Kind<F, T13>, Kind<F, T14>, Kind<F, T15>, Kind<F, T16>, Kind<F, T17>, Kind<F, T18>, Kind<F, T19>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19 -> ap19(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> lift20(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>, Kind<F, T13>, Kind<F, T14>, Kind<F, T15>, Kind<F, T16>, Kind<F, T17>, Kind<F, T18>, Kind<F, T19>, Kind<F, T20>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20 -> ap20(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> lift21(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>, Kind<F, T13>, Kind<F, T14>, Kind<F, T15>, Kind<F, T16>, Kind<F, T17>, Kind<F, T18>, Kind<F, T19>, Kind<F, T20>, Kind<F, T21>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21 -> ap21(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21) }
    
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> lift22(ff: Kind<F, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R>): (Kind<F, T1>, Kind<F, T2>, Kind<F, T3>, Kind<F, T4>, Kind<F, T5>, Kind<F, T6>, Kind<F, T7>, Kind<F, T8>, Kind<F, T9>, Kind<F, T10>, Kind<F, T11>, Kind<F, T12>, Kind<F, T13>, Kind<F, T14>, Kind<F, T15>, Kind<F, T16>, Kind<F, T17>, Kind<F, T18>, Kind<F, T19>, Kind<F, T20>, Kind<F, T21>, Kind<F, T22>) -> Kind<F, R>
        = { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22 -> ap22(ff, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22) }

    // endregion
}