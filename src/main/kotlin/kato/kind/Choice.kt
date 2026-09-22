package kato.kind

import kato.struct.Either
import kato.type.Binary
import kato.type.TypeAccessor

interface Choice<F : TypeAccessor<Binary>> : Category<F>
{
    fun <A, B, C> choice(f: Kind2<F, A, C>, g: Kind2<F, B, C>): Kind2<F, Either<A, B>, C>

    fun <A> codiagonal(): Kind2<F, Either<A, A>, A> = choice(id(), id())
}