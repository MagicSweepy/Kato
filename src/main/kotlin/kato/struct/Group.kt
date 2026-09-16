package kato.struct

interface Group<A> : Monoid<A>
{
    fun inverse(a: A): A
}