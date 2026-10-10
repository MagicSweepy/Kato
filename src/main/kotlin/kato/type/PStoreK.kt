package kato.type

import kato.kind.Kind
import kato.kind.PStore

// λ[α => PStore[I, O, α]]
class PStoreK<I, O> : TypeAccessor<Unary>

fun <I, O, A> Kind<PStoreK<I, O>, A>.asPStore(): PStore<I, O, A> = this as PStore<I, O, A>
