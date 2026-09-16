package kato.struct

sealed interface Either<L, out R>
{
    val isLeft: Boolean
        get() = this is Left

    val isRight: Boolean
        get() = this is Right

    fun <L2> lmap(f: (L) -> L2): Either<L2, R>
        = fold({ Left(f(it)) }, { Right(it) })

    fun <R2> rmap(f: (R) -> R2): Either<L, R2>
        = fold({ Left(it) }, { Right(f(it)) })

    fun <L2, R2> bimap(lf: (L) -> L2, rf: (R) -> R2): Either<L2, R2>
        = fold({ Left(lf(it)) }, { Right(rf(it)) })

    fun <L2> flatLMap(f: (L) -> Either<L2, @UnsafeVariance R>): Either<L2, R>
        = fold(f) { Right(it) }

    fun <R2> flatRMap(f: (R) -> Either<L, R2>): Either<L, R2>
        = fold({ Left(it) }, f)

    fun getOrElse(default: () -> @UnsafeVariance R): R
        = fold({ default() }, { it })

    fun getOrThrow(): R = fold({ throw NoSuchElementException() }, { it })

    fun getOrNull(): R? = fold({ null }, { it })

    fun swap(): Either<@UnsafeVariance R, L> = fold({ Right(it) }, { Left(it) })

    fun onLeft(action: (L) -> Unit): Either<L, R>
        = fold({ action(it); this }, { this })

    fun onRight(action: (R) -> Unit): Either<L, R>
        = fold({ this }, { action(it); this })

    fun <C> fold(ifLeft: (L) -> C, ifRight: (R) -> C): C

    companion object
    {
        fun <L, R> left(value: L): Either<L, R> = Left(value)

        fun <L, R> right(value: R): Either<L, R> = Right(value)

        fun <R> catch(block: () -> R): Either<Throwable, R>
            = try { Right(block()) } catch (e: Throwable) { Left(e) }
    }
}

data class Left<L, R>(val value: L) : Either<L, R>
{
    override fun <C> fold(ifLeft: (L) -> C, ifRight: (R) -> C): C = ifLeft(value)
}

data class Right<L, R>(val value: R) : Either<L, R>
{
    override fun <C> fold(ifLeft: (L) -> C, ifRight: (R) -> C): C = ifRight(value)
}
