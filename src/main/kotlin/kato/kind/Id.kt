package kato.kind

import kato.type.Identity

data class Id<A>(val value: A) : Kind<Identity, A>
