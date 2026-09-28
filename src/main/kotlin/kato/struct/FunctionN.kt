@file:Suppress("unused")

package kato.struct

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

// region andThenN

infix fun <A, B, C> ((A) -> B).andThen(f: (B) -> C): (A) -> C
    = { a -> f(this(a)) }

infix fun <A, B, C, D> ((A, B) -> C).andThen(f: (C) -> D): (A, B) -> D
    = { a, b -> f(this(a, b)) }

infix fun <A, B, C, D, E> ((A, B, C) -> D).andThen(f: (D) -> E): (A, B, C) -> E
    = { a, b, c -> f(this(a, b, c)) }

infix fun <A, B, C, D, E, F> ((A, B, C, D) -> E).andThen(f: (E) -> F): (A, B, C, D) -> F
    = { a, b, c, d -> f(this(a, b, c, d)) }

// endregion

// region composeN

infix fun <A, B, C> ((B) -> C).compose(f: (A) -> B): (A) -> C
    = { a -> this(f(a)) }

infix fun <A, B, C, D> ((C) -> D).compose(f: (A, B) -> C): (A, B) -> D
    = { a, b -> this(f(a, b)) }

infix fun <A, B, C, D, E> ((D) -> E).compose(f: (A, B, C) -> D): (A, B, C) -> E
    = { a, b, c -> this(f(a, b, c)) }

infix fun <A, B, C, D, E, F> ((E) -> F).compose(f: (A, B, C, D) -> E): (A, B, C, D) -> F
    = { a, b, c, d -> this(f(a, b, c, d)) }

// endregion