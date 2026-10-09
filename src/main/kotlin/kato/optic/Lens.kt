package kato.optic

import kato.kind.Cartesian2
import kato.kind.Kind2
import kato.kind.Profunctor
import kato.type.Binary
import kato.type.TypeAccessor

interface Lens<S, T, A, B> : Optic<S, T, A, B>
{
    fun view(s: S): A

    fun update(b: B, s: S): T

    fun modify(f: (A) -> B, s: S): T = update(f(view(s)), s)

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
    {
        val c = p as Cartesian2<P>
        return c.dimap({ Pair(view(it), it) }, { p: Pair<B, S> -> update(p.first, p.second) }, c.first(pab))
    }

    companion object
    {
        fun <S, T, A, B> of(view: (S) -> A, update: (B, S) -> T): Lens<S, T, A, B> = object : Lens<S, T, A, B>
        {
            override fun view(s: S): A = view(s)

            override fun update(b: B, s: S): T = update(b, s)
        }
    }
}