package kato.optic

import kato.kind.Closed
import kato.kind.Kind2
import kato.kind.Profunctor
import kato.type.Binary
import kato.type.TypeAccessor

interface Grate<S, T, A, B> : Optic<S, T, A, B>
{
    fun grate(f: ((S) -> A) -> B): T

    fun over(f: (A) -> B, s: S): T = grate { f(it(s)) }

    fun set(b: B, s: S): T = grate { _ -> b }

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
    {
        val c = p as Closed<P>
        return c.dimap({ s -> { k: (S) -> A -> k(s) } }, { grate(it) }, c.close(pab))
    }

    companion object
    {
        fun <S, T, A, B> of(grate: (((S) -> A) -> B) -> T): Grate<S, T, A, B> = object : Grate<S, T, A, B>
        {
            override fun grate(f: ((S) -> A) -> B): T = grate(f)
        }
    }
}