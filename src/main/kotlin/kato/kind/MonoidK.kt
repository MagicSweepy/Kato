package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface MonoidK<F : TypeAccessor<Unary>, A> : SemigroupK<F, A>
{
    fun empty(): Kind<F, A>

    fun combineAll(elements: Iterable<Kind<F, A>>): Kind<F, A>
    {
        var result = empty()
        elements.forEach { result = combine(result, it) }
        return result
    }

    fun isEmpty(a: Kind<F, A>): Boolean = empty() == a
}