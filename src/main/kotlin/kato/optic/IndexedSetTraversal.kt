package kato.optic

import kato.kind.Applicative
import kato.kind.Kind
import kato.type.TypeAccessor
import kato.type.Unary

class IndexedSetTraversal<A, B> : IndexedTraversal<Int, Set<A>, Set<B>, A, B>
{
    override fun <F : TypeAccessor<Unary>> wanderI(ap: Applicative<F>, f: (Int, A) -> Kind<F, B>): (Set<A>) -> Kind<F, Set<B>>
        = { set ->
            val xs = set.toList()
            var acc: Kind<F, Set<B>> = ap.of(emptySet())
            for (i in xs.indices.reversed())
                acc = ap.ap(ap.map({ b: B -> { it + b } }, f(i, xs[i])), acc)
            acc
          }
}