package kato.optic

import kato.kind.Kind2
import kato.kind.Profunctor
import kato.type.Binary
import kato.type.TypeAccessor

interface IndexedOptic<I, S, T, A, B>
{
    fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>

    infix fun <M, N> andThen(other: Optic<A, B, M, N>): IndexedOptic<I, S, T, M, N>
        = object : IndexedOptic<I, S, T, M, N>
          {
              override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, M, N>): Kind2<P, S, T>
                  = this@IndexedOptic.eval(p, other.eval(p, pab))
          }

    infix fun <J, M, N> andThenI(other: IndexedOptic<J, A, B, M, N>): IndexedOptic<Pair<I, J>, S, T, M, N>
        = object : IndexedOptic<Pair<I, J>, S, T, M, N>
          {
              override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, M, N>): Kind2<P, S, T>
                  = this@IndexedOptic.eval(p, other.eval(p, pab))
          }
}