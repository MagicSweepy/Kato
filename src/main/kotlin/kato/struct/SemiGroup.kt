package kato.struct

fun interface SemiGroup<T>
{
    fun combine(a: T, b: T): T
}