package kato.kind

import kato.type.ConstK

data class Const<M, A>(val value: M) : Kind<ConstK<M>, A>