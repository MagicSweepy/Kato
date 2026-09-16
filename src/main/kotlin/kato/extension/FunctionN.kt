@file:Suppress("unused")

package kato.extension

// region curryN

fun <A, B, R> ((A, B) -> R).curry(): (A) -> ((B) -> R)
    = { a -> { b -> invoke(a, b) } }

fun <A, B, C, R> ((A, B, C) -> R).curry(): (A) -> ((B, C) -> R)
    = { a -> { b, c -> invoke(a, b, c) } }

fun <A, B, C, R> ((A, B, C) -> R).curry2(): (A, B) -> ((C) -> R)
    = { a, b -> { c -> invoke(a, b, c) } }

fun <A, B, C, D, R> ((A, B, C, D) -> R).curry(): (A) -> ((B, C, D) -> R)
    = { a -> { b, c, d -> invoke(a, b, c, d) } }

fun <A, B, C, D, R> ((A, B, C, D) -> R).curry2(): (A, B) -> ((C, D) -> R)
    = { a, b -> { c, d -> invoke(a, b, c, d) } }

fun <A, B, C, D, R> ((A, B, C, D) -> R).curry3(): (A, B, C) -> ((D) -> R)
    = { a, b, c -> { d -> invoke(a, b, c, d) } }

// endregion

// region uncurryN

fun <A, B, R> ((A) -> ((B) -> R)).uncurry(): (A, B) -> R
    = { a, b -> invoke(a)(b) }

fun <A, B, C, R> ((A) -> ((B, C) -> R)).uncurry(): (A, B, C) -> R
    = { a, b, c -> invoke(a)(b, c) }

fun <A, B, C, R> ((A, B) -> ((C) -> R)).uncurry2(): (A, B, C) -> R
    = { a, b, c -> invoke(a, b)(c) }

fun <A, B, C, D, R> ((A) -> ((B, C, D) -> R)).uncurry(): (A, B, C, D) -> R
    = { a, b, c, d -> invoke(a)(b, c, d) }

fun <A, B, C, D, R> ((A, B) -> ((C, D) -> R)).uncurry2(): (A, B, C, D) -> R
    = { a, b, c, d -> invoke(a, b)(c, d) }

fun <A, B, C, D, R> ((A, B, C) -> ((D) -> R)).uncurry3(): (A, B, C, D) -> R
    = { a, b, c, d -> invoke(a, b, c)(d) }

// endregion

// region tupledN

fun <A, B, R> ((A, B) -> R).tupled(): (Pair<A, B>) -> R
    = { t -> invoke(t.first, t.second) }

fun <A, B, C, R> ((A, B, C) -> R).tupled(): (Triple<A, B, C>) -> R
    = { t -> invoke(t.first, t.second, t.third) }

// endregion

// region untupledN

fun <A, B, R> ((Pair<A, B>) -> R).untupled(): (A, B) -> R
    = { a1, a2 -> invoke(Pair(a1, a2)) }

fun <A, B, C, R> ((Triple<A, B, C>) -> R).untupled(): (A, B, C) -> R
    = { a1, a2, a3 -> invoke(Triple(a1, a2, a3)) }

// endregion