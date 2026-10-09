package kato.optic

import kato.kind.CartesianP
import kato.kind.CocartesianP
import kato.kind.Kind2
import kato.kind.Profunctor
import kato.struct.Either
import kato.type.Binary
import kato.type.TypeAccessor

interface Affine<S, T, A, B> : Optic<S, T, A, B>
{
    fun preview(s: S): Either<T, A>

    fun set(b: B, s: S): T

    fun matches(s: S): Boolean = preview(s).isRight

    @Suppress("UNCHECKED_CAST")
    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
    {
        val c = p as CartesianP<P>
        val cc = p as CocartesianP<P>
        val pp = c.rmap({ p: Pair<B, S> -> set(p.first, p.second) }, c.first(pab))
        return cc.dimap({ s: S -> preview(s).fold({ Either.right<Pair<A, S>, T>(it) },
                                                  { Either.left<Pair<A, S>, T>(Pair(it, it) as Pair<A, S>) }) },
                        { e: Either<T, T> -> e.fold({ it }, { it })},
                        cc.left(pp))
    }

    companion object
    {
        fun <S, T, A, B> of(preview: (S) -> Either<T, A>, set: (B, S) -> T): Affine<S, T, A, B> = object : Affine<S, T, A, B>
        {
            override fun preview(s: S): Either<T, A> = preview(s)

            override fun set(b: B, s: S): T = set(b, s)
        }
    }
}