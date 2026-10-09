package kato.optic

import kato.kind.Kind2
import kato.kind.Profunctor
import kato.type.Binary
import kato.type.TypeAccessor

interface Iso<S, T, A, B> : Optic<S, T, A, B>
{
    fun from(s: S): A

    fun to(b: B): T

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
        = p.dimap({ from(it) }, { to(it) }, pab)

    companion object
    {
        fun <S, T, A, B> of(from: (S) -> A, to: (B) -> T): Iso<S, T, A, B> = object : Iso<S, T, A, B>
        {
            override fun from(s: S): A = from(s)

            override fun to(b: B): T = to(b)
        }
    }
}