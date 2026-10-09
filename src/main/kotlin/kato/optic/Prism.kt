package kato.optic

import kato.kind.CocartesianP
import kato.kind.Kind2
import kato.kind.Profunctor
import kato.struct.Either
import kato.type.Binary
import kato.type.TypeAccessor

interface Prism<S, T, A, B> : Optic<S, T, A, B>
{
    fun match(s: S): Either<T, A>

    fun build(b: B): T

    fun preview(s: S): A? = match(s).getOrNull()

    fun matches(s: S): Boolean = match(s).isRight

    fun set(b: B, s: S): T = match(s).fold({ it }, { _ -> build(b) })

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
    {
        val c = p as CocartesianP<P>
        return c.dimap({ match(it) }, { e: Either<T, B> -> e.fold({ it }, { build(it) }) }, c.right(pab))
    }

    companion object
    {
        fun <S, T, A, B> of(match: (S) -> Either<T, A>, build: (B) -> T): Prism<S, T, A, B> = object : Prism<S, T, A, B>
        {
            override fun match(s: S): Either<T, A> = match(s)

            override fun build(b: B): T = build(b)
        }
    }
}