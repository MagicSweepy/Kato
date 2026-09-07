package kato.type

sealed interface Type

object Unary : Type // F[_]

object Binary : Type // F[_, _]