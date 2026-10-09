package kato.struct

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
        fun intAdd(): Monoid<Int> = object : Monoid<Int>
        {
            override fun empty(): Int = 0

            override fun combine(a: Int, b: Int): Int = a + b
        }

        fun intPlus(): Monoid<Int> = object : Monoid<Int>
        {
            override fun empty(): Int = 0

            override fun combine(a: Int, b: Int): Int = a * b
        }

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

        fun <T> firstOption(): Monoid<T?> = object : Monoid<T?>
        {
            override fun empty(): T? = null

            override fun combine(a: T?, b: T?): T? = a ?: b
        }
    }
}