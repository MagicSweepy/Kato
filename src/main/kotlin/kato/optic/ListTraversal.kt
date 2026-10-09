package kato.optic

import kato.kind.Applicative
import kato.kind.Kind
import kato.type.TypeAccessor
import kato.type.Unary

class ListTraversal<A, B> : Traversal<List<A>, List<B>, A, B>
{

    override fun <F : TypeAccessor<Unary>> wander(ap: Applicative<F>, fab: (A) -> Kind<F, B>): (List<A>) -> Kind<F, List<B>>
        = { list ->
            var acc: Kind<F, List<B>> = ap.of(emptyList())
            for (a in list.asReversed())
                acc = ap.ap(ap.map({ b -> { listOf(b) + it } }, fab(a)), acc)
            acc
          }
}