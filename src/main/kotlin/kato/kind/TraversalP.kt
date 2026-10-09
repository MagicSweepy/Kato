package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor
import kato.type.Unary

interface TraversalP<P : TypeAccessor<Binary>> : IndexedTraversalP<P>
{
    fun <S, T, A, B> wander(w: Wander<S, T, A, B>, pab: Kind2<P, A, B>): Kind2<P, S, T>

    override fun <I, S, T, A, B> wanderI(w: IndexedWander<I, S, T, A, B>, pab: Kind2<P, A, B>): Kind2<P, S, T>
        = wander(object : Wander<S, T, A, B>
          {
              override fun <F : TypeAccessor<Unary>> wander(ap: Applicative<F>, fab: (A) -> Kind<F, B>): (S) -> Kind<F, T>
                  = w.wanderI(ap, { _, a -> fab(a) })
          }, pab)
}
