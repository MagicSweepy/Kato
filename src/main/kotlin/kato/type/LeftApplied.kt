@file:Suppress("UNCHECKED_CAST")
package kato.type

import kato.kind.Kind
import kato.kind.Kind2

// λ[β => F[A, β]]
class LeftApplied<F : TypeAccessor<Binary>, A> : TypeAccessor<Unary>

fun <F : TypeAccessor<Binary>, A, B> Kind<LeftApplied<F, A>, B>.asLeftKind2(): Kind2<F, A, B>
    = this as Kind2<F, A, B>

fun <F : TypeAccessor<Binary>, A, B> Kind2<F, A, B>.asLeftApplied(): Kind<LeftApplied<F, A>, B>
    = this as Kind<LeftApplied<F, A>, B>
