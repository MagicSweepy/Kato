@file:Suppress("unused")
package kato

// region curryN

fun <T1, T2, R> ((T1, T2) -> R).curry(): (T1) -> ((T2) -> R)
    = { t1: T1 -> { t2: T2 -> invoke(t1, t2) } }

fun <T1, T2, T3, R> ((T1, T2, T3) -> R).curry(): (T1) -> ((T2, T3) -> R)
    = { t1: T1 -> { t2: T2, t3: T3 -> invoke(t1, t2, t3) } }

fun <T1, T2, T3, R> ((T1, T2, T3) -> R).curry2(): (T1, T2) -> ((T3) -> R)
    = { t1: T1, t2: T2 -> { t3: T3 -> invoke(t1, t2, t3) } }

fun <T1, T2, T3, T4, R> ((T1, T2, T3, T4) -> R).curry(): (T1) -> ((T2, T3, T4) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4 -> invoke(t1, t2, t3, t4) } }

fun <T1, T2, T3, T4, R> ((T1, T2, T3, T4) -> R).curry2(): (T1, T2) -> ((T3, T4) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4 -> invoke(t1, t2, t3, t4) } }

fun <T1, T2, T3, T4, R> ((T1, T2, T3, T4) -> R).curry3(): (T1, T2, T3) -> ((T4) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4 -> invoke(t1, t2, t3, t4) } }

fun <T1, T2, T3, T4, T5, R> ((T1, T2, T3, T4, T5) -> R).curry(): (T1) -> ((T2, T3, T4, T5) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5 -> invoke(t1, t2, t3, t4, t5) } }

fun <T1, T2, T3, T4, T5, R> ((T1, T2, T3, T4, T5) -> R).curry2(): (T1, T2) -> ((T3, T4, T5) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5 -> invoke(t1, t2, t3, t4, t5) } }

fun <T1, T2, T3, T4, T5, R> ((T1, T2, T3, T4, T5) -> R).curry3(): (T1, T2, T3) -> ((T4, T5) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5 -> invoke(t1, t2, t3, t4, t5) } }

fun <T1, T2, T3, T4, T5, R> ((T1, T2, T3, T4, T5) -> R).curry4(): (T1, T2, T3, T4) -> ((T5) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5 -> invoke(t1, t2, t3, t4, t5) } }

fun <T1, T2, T3, T4, T5, T6, R> ((T1, T2, T3, T4, T5, T6) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> invoke(t1, t2, t3, t4, t5, t6) } }

fun <T1, T2, T3, T4, T5, T6, R> ((T1, T2, T3, T4, T5, T6) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6 -> invoke(t1, t2, t3, t4, t5, t6) } }

fun <T1, T2, T3, T4, T5, T6, R> ((T1, T2, T3, T4, T5, T6) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6 -> invoke(t1, t2, t3, t4, t5, t6) } }

fun <T1, T2, T3, T4, T5, T6, R> ((T1, T2, T3, T4, T5, T6) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6 -> invoke(t1, t2, t3, t4, t5, t6) } }

fun <T1, T2, T3, T4, T5, T6, R> ((T1, T2, T3, T4, T5, T6) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6 -> invoke(t1, t2, t3, t4, t5, t6) } }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2, T3, T4, T5, T6, T7) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> invoke(t1, t2, t3, t4, t5, t6, t7) } }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2, T3, T4, T5, T6, T7) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> invoke(t1, t2, t3, t4, t5, t6, t7) } }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2, T3, T4, T5, T6, T7) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7 -> invoke(t1, t2, t3, t4, t5, t6, t7) } }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2, T3, T4, T5, T6, T7) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7 -> invoke(t1, t2, t3, t4, t5, t6, t7) } }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2, T3, T4, T5, T6, T7) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7 -> invoke(t1, t2, t3, t4, t5, t6, t7) } }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2, T3, T4, T5, T6, T7) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7 -> invoke(t1, t2, t3, t4, t5, t6, t7) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R).curry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> { t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> { t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R).curry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> { t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> { t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> { t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R).curry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> { t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> { t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> { t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> { t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R).curry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> { t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> { t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> { t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> { t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> { t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R).curry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> { t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> { t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> { t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> { t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> { t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17, T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> { t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R).curry17(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> ((T18) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> { t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> { t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> { t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> { t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> { t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17, T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> { t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry17(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> ((T18, T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> { t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R).curry18(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> ((T19) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> { t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> { t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> { t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> { t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> { t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17, T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> { t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry17(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> ((T18, T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> { t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry18(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> ((T19, T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> { t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R).curry19(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> ((T20) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> { t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> { t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> { t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> { t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> { t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17, T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> { t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry17(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> ((T18, T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> { t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry18(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> ((T19, T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> { t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry19(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> ((T20, T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> { t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R).curry20(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> ((T21) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> { t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry(): (T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1 -> { t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry2(): (T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2 -> { t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry3(): (T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3 -> { t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry4(): (T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> { t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry5(): (T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> { t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry6(): (T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> { t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry7(): (T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> { t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry8(): (T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> { t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> { t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> { t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> { t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> { t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> { t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> { t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> { t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17, T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> { t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry17(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> ((T18, T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> { t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry18(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> ((T19, T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> { t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry19(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> ((T20, T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> { t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry20(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> ((T21, T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> { t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R).curry21(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> ((T22) -> R)
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> { t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) } }

// endregion

// region uncurryN

fun <T1, T2, R> ((T1) -> ((T2) -> R)).uncurry(): (T1, T2) -> R
    = { t1: T1, t2: T2 -> invoke(t1)(t2) }

fun <T1, T2, T3, R> ((T1) -> ((T2, T3) -> R)).uncurry(): (T1, T2, T3) -> R
    = { t1: T1, t2: T2, t3: T3 -> invoke(t1)(t2, t3) }

fun <T1, T2, T3, R> ((T1, T2) -> ((T3) -> R)).uncurry2(): (T1, T2, T3) -> R
    = { t1: T1, t2: T2, t3: T3 -> invoke(t1, t2)(t3) }

fun <T1, T2, T3, T4, R> ((T1) -> ((T2, T3, T4) -> R)).uncurry(): (T1, T2, T3, T4) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> invoke(t1)(t2, t3, t4) }

fun <T1, T2, T3, T4, R> ((T1, T2) -> ((T3, T4) -> R)).uncurry2(): (T1, T2, T3, T4) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> invoke(t1, t2)(t3, t4) }

fun <T1, T2, T3, T4, R> ((T1, T2, T3) -> ((T4) -> R)).uncurry3(): (T1, T2, T3, T4) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4 -> invoke(t1, t2, t3)(t4) }

fun <T1, T2, T3, T4, T5, R> ((T1) -> ((T2, T3, T4, T5) -> R)).uncurry(): (T1, T2, T3, T4, T5) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> invoke(t1)(t2, t3, t4, t5) }

fun <T1, T2, T3, T4, T5, R> ((T1, T2) -> ((T3, T4, T5) -> R)).uncurry2(): (T1, T2, T3, T4, T5) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> invoke(t1, t2)(t3, t4, t5) }

fun <T1, T2, T3, T4, T5, R> ((T1, T2, T3) -> ((T4, T5) -> R)).uncurry3(): (T1, T2, T3, T4, T5) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> invoke(t1, t2, t3)(t4, t5) }

fun <T1, T2, T3, T4, T5, R> ((T1, T2, T3, T4) -> ((T5) -> R)).uncurry4(): (T1, T2, T3, T4, T5) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5 -> invoke(t1, t2, t3, t4)(t5) }

fun <T1, T2, T3, T4, T5, T6, R> ((T1) -> ((T2, T3, T4, T5, T6) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> invoke(t1)(t2, t3, t4, t5, t6) }

fun <T1, T2, T3, T4, T5, T6, R> ((T1, T2) -> ((T3, T4, T5, T6) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> invoke(t1, t2)(t3, t4, t5, t6) }

fun <T1, T2, T3, T4, T5, T6, R> ((T1, T2, T3) -> ((T4, T5, T6) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> invoke(t1, t2, t3)(t4, t5, t6) }

fun <T1, T2, T3, T4, T5, T6, R> ((T1, T2, T3, T4) -> ((T5, T6) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> invoke(t1, t2, t3, t4)(t5, t6) }

fun <T1, T2, T3, T4, T5, T6, R> ((T1, T2, T3, T4, T5) -> ((T6) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6 -> invoke(t1, t2, t3, t4, t5)(t6) }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1) -> ((T2, T3, T4, T5, T6, T7) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> invoke(t1)(t2, t3, t4, t5, t6, t7) }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2) -> ((T3, T4, T5, T6, T7) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> invoke(t1, t2)(t3, t4, t5, t6, t7) }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2, T3) -> ((T4, T5, T6, T7) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> invoke(t1, t2, t3)(t4, t5, t6, t7) }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2, T3, T4) -> ((T5, T6, T7) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> invoke(t1, t2, t3, t4)(t5, t6, t7) }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2, T3, T4, T5) -> ((T6, T7) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> invoke(t1, t2, t3, t4, t5)(t6, t7) }

fun <T1, T2, T3, T4, T5, T6, T7, R> ((T1, T2, T3, T4, T5, T6) -> ((T7) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7 -> invoke(t1, t2, t3, t4, t5, t6)(t7) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12, t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13) -> R)).uncurry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)(t13) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12, t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14) -> R)).uncurry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)(t13, t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14) -> R)).uncurry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)(t14) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12, t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15) -> R)).uncurry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)(t13, t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15) -> R)).uncurry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)(t14, t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15) -> R)).uncurry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)(t15) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12, t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16) -> R)).uncurry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)(t13, t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16) -> R)).uncurry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)(t14, t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16) -> R)).uncurry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)(t15, t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16) -> R)).uncurry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15)(t16) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12, t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17) -> R)).uncurry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)(t13, t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17) -> R)).uncurry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)(t14, t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17) -> R)).uncurry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)(t15, t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17) -> R)).uncurry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15)(t16, t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17) -> R)).uncurry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16)(t17) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17, T18) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12, t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17, T18) -> R)).uncurry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)(t13, t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17, T18) -> R)).uncurry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)(t14, t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17, T18) -> R)).uncurry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)(t15, t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17, T18) -> R)).uncurry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15)(t16, t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17, T18) -> R)).uncurry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16)(t17, t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> ((T18) -> R)).uncurry17(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17)(t18) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12, t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17, T18, T19) -> R)).uncurry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)(t13, t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17, T18, T19) -> R)).uncurry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)(t14, t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17, T18, T19) -> R)).uncurry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)(t15, t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17, T18, T19) -> R)).uncurry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15)(t16, t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17, T18, T19) -> R)).uncurry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16)(t17, t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> ((T18, T19) -> R)).uncurry17(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17)(t18, t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> ((T19) -> R)).uncurry18(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18)(t19) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12, t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)(t13, t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17, T18, T19, T20) -> R)).uncurry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)(t14, t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17, T18, T19, T20) -> R)).uncurry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)(t15, t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17, T18, T19, T20) -> R)).uncurry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15)(t16, t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17, T18, T19, T20) -> R)).uncurry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16)(t17, t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> ((T18, T19, T20) -> R)).uncurry17(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17)(t18, t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> ((T19, T20) -> R)).uncurry18(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18)(t19, t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> ((T20) -> R)).uncurry19(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19)(t20) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12, t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)(t13, t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)(t14, t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17, T18, T19, T20, T21) -> R)).uncurry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)(t15, t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17, T18, T19, T20, T21) -> R)).uncurry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15)(t16, t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17, T18, T19, T20, T21) -> R)).uncurry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16)(t17, t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> ((T18, T19, T20, T21) -> R)).uncurry17(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17)(t18, t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> ((T19, T20, T21) -> R)).uncurry18(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18)(t19, t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> ((T20, T21) -> R)).uncurry19(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19)(t20, t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> ((T21) -> R)).uncurry20(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20)(t21) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1) -> ((T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1)(t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2) -> ((T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry2(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2)(t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3) -> ((T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry3(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3)(t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4) -> ((T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry4(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4)(t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5) -> ((T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry5(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5)(t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6) -> ((T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry6(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6)(t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7) -> ((T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry7(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7)(t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8) -> ((T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry8(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8)(t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9) -> ((T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry9(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9)(t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> ((T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry10(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)(t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> ((T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry11(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)(t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> ((T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry12(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)(t13, t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> ((T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry13(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)(t14, t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> ((T15, T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry14(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)(t15, t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> ((T16, T17, T18, T19, T20, T21, T22) -> R)).uncurry15(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15)(t16, t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> ((T17, T18, T19, T20, T21, T22) -> R)).uncurry16(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16)(t17, t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> ((T18, T19, T20, T21, T22) -> R)).uncurry17(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17)(t18, t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> ((T19, T20, T21, T22) -> R)).uncurry18(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18)(t19, t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> ((T20, T21, T22) -> R)).uncurry19(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19)(t20, t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> ((T21, T22) -> R)).uncurry20(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20)(t21, t22) }

fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> ((T22) -> R)).uncurry21(): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R
    = { t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22 -> invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21)(t22) }

// endregion