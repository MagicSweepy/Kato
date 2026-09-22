package kato.kind

import kato.struct.SemiGroup
import kato.type.Binary
import kato.type.Diagonal
import kato.type.TypeAccessor
import kato.type.asDiagonal
import kato.type.asKind2

interface Compose<F : TypeAccessor<Binary>>
{
    fun <A, B, C> compose(f: Kind2<F, B, C>, g: Kind2<F, A, B>): Kind2<F, A, C>

    operator fun <A, B, C> invoke(f: Kind2<F, A, B>, g: Kind2<F, B, C>): Kind2<F, A, C> = compose(g, f)

    fun <A> algebra(): SemiGroup<Kind2<F, A, A>> = SemiGroup { f, g -> compose(f, g) }

    fun <A> algebraK(): SemigroupK<Diagonal<F>, A> = object : SemigroupK<Diagonal<F>, A>
    {
        override fun combine(a: Kind<Diagonal<F>, A>, b: Kind<Diagonal<F>, A>): Kind<Diagonal<F>, A>
            = compose(a.asKind2(), b.asKind2()).asDiagonal()
    }
}