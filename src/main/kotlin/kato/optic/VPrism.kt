package kato.optic

import kato.kind.Applicative
import kato.kind.Kind
import kato.struct.Either
import kato.type.TypeAccessor
import kato.type.Unary

interface VPrism<S, T, A, B> : VApplicativeOptic<S, T, A, B>
{
    fun match(s: S): Either<T, A>

    fun build(b: B): T

    fun preview(s: S): A? = match(s).getOrNull()

    fun matches(s: S): Boolean = match(s).isRight

    fun modify(f: (A) -> B, s: S): T = match(s).fold({ it }, { build(f(it)) })

    fun set(b: B, s: S): T = match(s).fold({ it }, { _ -> build(b) })

    override fun <F : TypeAccessor<Unary>> modifyF(f: (A) -> Kind<F, B>, s: S, ap: Applicative<F>): Kind<F, T>
        = match(s).fold({ ap.of(it) }, { a -> ap.map({ build(it) }, f(a)) })

    companion object
    {
        fun <S, T, A, B> of(match: (S) -> Either<T, A>, build: (B) -> T): VPrism<S, T, A, B> = object : VPrism<S, T, A, B>
        {
            override fun match(s: S): Either<T, A> = match(s)

            override fun build(b: B): T = build(b)
        }
    }
}