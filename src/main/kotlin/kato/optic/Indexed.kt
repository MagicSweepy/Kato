package kato.optic

fun interface Indexed<I, S, T, A, B>
{
    fun index(i: I): Traversal<S, T, A, B>

    companion object
    {
        fun <I, S, T, A, B> of(index: (I) -> Traversal<S, T, A, B>): Indexed<I, S, T, A, B> = Indexed { index(it) }
    }
}