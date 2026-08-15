package kato

// region curryN

fun <A, B, C> ((A, B) -> C).curry(): (A) -> ((B) -> C)
    = { a: A -> { b: B -> invoke(a, b)} }

fun <A, B, C, D> ((A, B, C) -> D).curry(): (A) -> ((B, C) -> D)
    = { a: A -> { b: B, c: C -> invoke(a, b, c) } }

fun <A, B, C, D> ((A, B, C) -> D).curry2(): (A, B) -> ((C) -> D)
    = { a: A, b: B -> { c: C -> invoke(a, b, c) } }

fun <A, B, C, D, E> ((A, B, C, D) -> E).curry(): (A) -> ((B, C, D) -> E)
    = { a: A -> { b: B, c: C, d: D -> invoke(a, b, c, d) } }

fun <A, B, C, D, E> ((A, B, C, D) -> E).curry2(): (A, B) -> ((C, D) -> E)
    = { a: A, b: B -> { c: C, d: D -> invoke(a, b, c, d) } }

fun <A, B, C, D, E> ((A, B, C, D) -> E).curry3(): (A, B, C) -> ((D) -> E)
    = { a: A, b: B, c: C -> { d: D -> invoke(a, b, c, d) } }

// endregion

// region uncurryN

fun <A, B, C> ((A) -> ((B) -> C)).uncurry(): (A, B) -> C
    = { a: A, b: B -> invoke(a)(b) }

fun <A, B, C, D> ((A) -> ((B, C) -> D)).uncurry(): (A, B, C) -> D
    = { a: A, b: B, c: C -> invoke(a)(b, c) }

fun <A, B, C, D> ((A, B) -> ((C) -> D)).uncurry2(): (A, B, C) -> D
    = { a: A, b: B, c: C -> invoke(a, b)(c) }

fun <A, B, C, D, E> ((A) -> ((B, C, D) -> E)).uncurry()
    = { a: A, b: B, c: C, d: D -> invoke(a)(b, c, d) }

fun <A, B, C, D, E> ((A, B) -> ((C, D) -> E)).uncurry2()
    = { a: A, b: B, c: C, d: D -> invoke(a, b)(c, d) }

fun <A, B, C, D, E> ((A, B, C) -> ((D) -> E)).uncurry3()
    = { a: A, b: B, c: C, d: D -> invoke(a, b, c)(d) }

// endregion