package kato.kind

import kato.struct.Either
import kato.type.TypeAccessor
import kato.type.Unary

interface Selective<F : TypeAccessor<Unary>> : Applicative<F>
{
    fun <A, B> select(fab: Kind<F, Either<A, B>>, ff: Kind<F, (A) -> B>): Kind<F, B>

    fun <A, B, C> branch(fab: Kind<F, Either<A, B>>, fl: Kind<F, (A) -> C>, fr: Kind<F, (B) -> C>): Kind<F, C>
        = select(select(map({ e -> e.rmap { b -> Either.left(b) } }, fab),
                        map({ f -> { a: A -> Either.right(f(a)) } }, fl)), fr)
}