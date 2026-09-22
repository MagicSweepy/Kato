package kato.kind

import kato.struct.Monoid
import kato.type.Binary
import kato.type.Diagonal
import kato.type.TypeAccessor
import kato.type.asDiagonal
import kato.type.asKind2

interface Category<F : TypeAccessor<Binary>> : Compose<F>
{
    fun <A> id(): Kind2<F, A, A>

    override fun <A> algebra(): Monoid<Kind2<F, A, A>> = object : Monoid<Kind2<F, A, A>>
    {
        override fun empty(): Kind2<F, A, A> = id()

        override fun combine(a: Kind2<F, A, A>, b: Kind2<F, A, A>): Kind2<F, A, A> = compose(a, b)
    }

    override fun <A> algebraK(): MonoidK<Diagonal<F>, A> = object : MonoidK<Diagonal<F>, A>
    {
        override fun empty(): Kind<Diagonal<F>, A> = id<A>().asDiagonal()

        override fun combine(a: Kind<Diagonal<F>, A>, b: Kind<Diagonal<F>, A>): Kind<Diagonal<F>, A>
            = compose(a.asKind2(), b.asKind2()).asDiagonal()
    }
}