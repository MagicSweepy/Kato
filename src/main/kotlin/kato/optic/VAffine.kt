package kato.optic

import kato.kind.Applicative
import kato.kind.Kind
import kato.struct.Either
import kato.type.TypeAccessor
import kato.type.Unary

interface VAffine<S, T, A, B> : VApplicativeOptic<S, T, A, B>
{
    fun preview(s: S): Either<T, A>

    fun set(b: B, s: S): T

    fun matches(s: S): Boolean = preview(s).isRight

    fun modify(f: (A) -> B, s: S): T = preview(s).fold({ it }, { set(f(it), s) })

    override fun <F : TypeAccessor<Unary>> modifyF(f: (A) -> Kind<F, B>, s: S, ap: Applicative<F>): Kind<F, T>
        = preview(s).fold({ ap.of(it) }, { a -> ap.map({ set(it, s) }, f(a)) })

    companion object
    {
        fun <S, T, A, B> of(preview: (S) -> Either<T, A>, set: (B, S) -> T): VAffine<S, T, A, B> = object : VAffine<S, T, A, B>
        {
            override fun preview(s: S): Either<T, A> = preview(s)

            override fun set(b: B, s: S): T = set(b, s)
        }
    }
}