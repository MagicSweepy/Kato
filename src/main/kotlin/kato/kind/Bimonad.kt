package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface Bimonad<F : TypeAccessor<Unary>> : Monad<F>, Comonad<F>