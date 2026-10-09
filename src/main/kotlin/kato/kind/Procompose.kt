package kato.kind

import kato.type.Binary
import kato.type.ProcomposeK
import kato.type.TypeAccessor

class Procompose<F : TypeAccessor<Binary>, G : TypeAccessor<Binary>, C, A, B>(
    val first: () -> Kind2<F, A, C>, val second: Kind2<G, C, B>) : Kind2<ProcomposeK<F, G>, A, B>