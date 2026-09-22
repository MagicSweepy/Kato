package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface ArrowMonoid<F : TypeAccessor<Binary>> : ArrowSemigroup<F>
{
    fun <A, B> empty(): Kind2<F, A, B>

    fun <A, B> combineAll(elements: Iterable<Kind2<F, A, B>>): Kind2<F, A, B>
    {
        var result = empty<A, B>()
        elements.forEach { result = combine(result, it) }
        return result
    }
}
