package kato.optic

import kato.kind.Applicative
import kato.kind.Kind
import kato.type.TypeAccessor
import kato.type.Unary

class IndexedListTraversal<A, B> : IndexedTraversal<Int, List<A>, List<B>, A, B>
{
    override fun <F : TypeAccessor<Unary>> wanderI(ap: Applicative<F>, f: (Int, A) -> Kind<F, B>): (List<A>) -> Kind<F, List<B>>
        = { list ->
            var acc: Kind<F, List<B>> = ap.of(emptyList())
            for (i in list.indices.reversed())
                acc = ap.ap(ap.map({ b: B -> { listOf(b) + it } }, f(i, list[i])), acc)
            acc
          }
}