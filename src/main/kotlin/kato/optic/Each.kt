package kato.optic

fun interface Each<S, T, A, B>
{
    fun each(): Traversal<S, T, A, B>

    companion object
    {
        fun <S, T, A, B> of(each: () -> Traversal<S, T, A, B>): Each<S, T, A, B> = Each { each() }
    }
}