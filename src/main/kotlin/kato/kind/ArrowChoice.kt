package kato.kind

import kato.struct.Either
import kato.type.Binary
import kato.type.TypeAccessor

interface ArrowChoice<F : TypeAccessor<Binary>> : Arrow<F>, Choice<F>
{
    fun <A, B, C, D> choose(f: Kind2<F, A, C>, g: Kind2<F, B, D>): Kind2<F, Either<A, B>, Either<C, D>>

    fun <A, B, C> left(fab: Kind2<F, A, B>): Kind2<F, Either<A, C>, Either<B, C>>
        = choose(fab, lift { it })

    fun <A, B, C> right(fab: Kind2<F, A, B>): Kind2<F, Either<C, A>, Either<C, B>>
        = choose(lift { it }, fab)

    override fun <A, B, C> choice(f: Kind2<F, A, C>, g: Kind2<F, B, C>): Kind2<F, Either<A, B>, C>
        = rmap({ c -> c.fold({ it }, { it }) }, choose(f, g))
}