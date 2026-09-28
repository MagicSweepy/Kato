package kato.type

import kato.kind.FunctionP
import kato.kind.Kind2

// λ[(A, B) => A -> B]
object FunctionK : TypeAccessor<Binary>

fun <A, B> Kind2<FunctionK, A, B>.asFunctionP(): FunctionP<A, B> = this as FunctionP<A, B>