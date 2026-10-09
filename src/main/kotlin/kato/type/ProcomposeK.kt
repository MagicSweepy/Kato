@file:Suppress("UNCHECKED_CAST")
package kato.type

import kato.kind.Procompose
import kato.kind.Kind2

// λ[(A, B) => ∃ C. F[A, C] × G[C, B]]
class ProcomposeK<F : TypeAccessor<Binary>, G : TypeAccessor<Binary>> : TypeAccessor<Binary>

fun <F : TypeAccessor<Binary>, G : TypeAccessor<Binary>, A, B> Kind2<ProcomposeK<F, G>, A, B>.asProcompose(): Procompose<F, G, *, A, B>
    = this as Procompose<F, G, *, A, B>
