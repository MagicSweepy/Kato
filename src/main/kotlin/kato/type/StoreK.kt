package kato.type

import kato.kind.Kind
import kato.kind.Store

// λ[α => Store[S, α]]
class StoreK<S> : TypeAccessor<Unary>

fun <S, A> Kind<StoreK<S>, A>.asStore(): Store<S, A> = this as Store<S, A>
