package kato.type

import kato.kind.Forget
import kato.kind.Kind2

// λ[(A, B) => A -> M]
class ForgetK<M> : TypeAccessor<Binary>

fun <M, A, B> Kind2<ForgetK<M>, A, B>.asForget(): Forget<M, A, B> = this as Forget<M, A, B>