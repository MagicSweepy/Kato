package kato.type

import kato.kind.Const
import kato.kind.Kind

// λ[α => Const M α]
class ConstK<M> : TypeAccessor<Unary>

fun <M, A> Kind<ConstK<M>, A>.asConst(): Const<M, A> = this as Const<M, A>

fun <M, A> Kind<ConstK<M>, A>.runConst(): M = asConst().value