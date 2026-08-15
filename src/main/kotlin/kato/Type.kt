package kato

sealed interface Type

interface TypeAccessor<T : Type>

// F[_]
object Unary : Type

// F[_, _]
object Binary : Type