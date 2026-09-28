package kato.type

import kato.kind.Id
import kato.kind.Kind

// λ[α => α]
object Identity : TypeAccessor<Unary>

fun <A> Kind<Identity, A>.asId(): Id<A> = this as Id<A>

fun <A> Kind<Identity, A>.runId(): A = asId().value