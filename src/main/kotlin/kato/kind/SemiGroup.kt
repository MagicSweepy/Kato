package kato.kind

fun interface SemiGroup<T>
{
    fun combine(a: T, b: T): T
}