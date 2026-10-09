package kato.optic

import kato.kind.Applicative
import kato.kind.Kind
import kato.type.TypeAccessor
import kato.type.Unary

class SetTraversal<A, B> : Traversal<Set<A>, Set<B>, A, B>
{
    override fun <F : TypeAccessor<Unary>> wander(ap: Applicative<F>, fab: (A) -> Kind<F, B>): (Set<A>) -> Kind<F, Set<B>>
        = { set ->
            var acc: Kind<F, Set<B>> = ap.of(emptySet())
            for (a in set)
                acc = ap.ap(ap.map({ b: B -> { it + b } }, fab(a)), acc)
            acc
          }
}