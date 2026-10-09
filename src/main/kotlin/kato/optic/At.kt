package kato.optic

fun interface At<I, S, T, A, B>
{
    fun at(i: I): Lens<S, T, A?, B?>

    fun get(i: I, s: S): A? = at(i).view(s)

    companion object
    {
        fun <I, S, T, A, B> of(at: (I) -> Lens<S, T, A?, B?>): At<I, S, T, A, B> = At { at(it) }
    }
}