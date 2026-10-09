package kato.optic

import kato.kind.Kind2
import kato.kind.Profunctor
import kato.struct.Monoid
import kato.type.Binary
import kato.type.TypeAccessor

fun interface Getter<S, T, A, B> : Optic<S, T, A, B>
{
    fun get(s: S): A

    fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M = f(get(s))

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
        = p.dimap({ get(it) }, { throw UnsupportedOperationException("Getter cannot output anything") }, pab)

    companion object
    {
        fun <S, T, A, B> of(get: (S) -> A): Getter<S, T, A, B> = Getter { get(it) }
    }
}

fun <S, T, A, B> Getter<S, T, A, B>.asFold(): Fold<S, T, A, B> = object : Fold<S, T, A, B>
{
    override fun <M> foldMap(m: Monoid<M>, f: (A) -> M, s: S): M = f(this@asFold.get(s))

    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>, ): Kind2<P, S, T>
        = this@asFold.eval(p, pab)
}