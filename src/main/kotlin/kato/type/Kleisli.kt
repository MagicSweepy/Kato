@file:Suppress("UNCHECKED_CAST")
package kato.type

import kato.kind.Kind
import kato.kind.Kind2

// λ[(A, B) => A -> M[B]]
class Kleisli<M : TypeAccessor<Unary>> : TypeAccessor<Binary>

class KleisliArrow<M : TypeAccessor<Unary>, A, B>(val run: (A) -> Kind<M, B>) : Kind2<Kleisli<M>, A, B>

fun <M : TypeAccessor<Unary>, A, B> Kind2<Kleisli<M>, A, B>.asKleisli(): KleisliArrow<M, A, B>
    = this as KleisliArrow<M, A, B>
