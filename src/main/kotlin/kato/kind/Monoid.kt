package kato.kind

interface Monoid<T> : SemiGroup<T>
{
    fun empty(): T

    fun combineAll(elements: Iterable<T>): T
    {
        var result = empty()
        elements.forEach { result = combine(result, it) }
        return result
    }

    fun isEmpty(a: T): Boolean = empty() == a

    companion object
    {
        fun <T> list(): Monoid<List<T>> = object : Monoid<List<T>>
        {
            override fun empty(): List<T> = emptyList()

            override fun combine(a: List<T>, b: List<T>): List<T> = a + b
        }

        fun <T> set(): Monoid<Set<T>> = object : Monoid<Set<T>>
        {
            override fun empty(): Set<T> = emptySet()

            override fun combine(a: Set<T>, b: Set<T>): Set<T> = a + b
        }
    }
}