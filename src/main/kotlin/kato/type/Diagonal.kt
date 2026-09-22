@file:Suppress("UNCHECKED_CAST")
package kato.type

import kato.kind.Kind
import kato.kind.Kind2

// λ[α => F[α, α]]
class Diagonal<F : TypeAccessor<Binary>> : TypeAccessor<Unary>

fun <F : TypeAccessor<Binary>, A> Kind<Diagonal<F>, A>.asKind2(): Kind2<F, A, A>
    = this as Kind2<F, A, A>

fun <F : TypeAccessor<Binary>, A> Kind2<F, A, A>.asDiagonal(): Kind<Diagonal<F>, A>
    = this as Kind<Diagonal<F>, A>