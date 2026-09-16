package kato.kind

import kato.struct.Either
import kato.struct.Left
import kato.struct.Monoid
import kato.struct.Right
import kato.type.TypeAccessor
import kato.type.Unary

interface Cocartesian<F : TypeAccessor<Unary>, C> : Traversable<F>
{
    fun <A> from(fa: Either<C, A>): Kind<F, A>

    fun <A> to(fa: Kind<F, A>): Either<C, A>

    override fun <A, B> map(f: (A) -> B, fa: Kind<F, A>): Kind<F, B> = when (val e = to(fa))
    {
        is Left -> from(Left(e.value))
        is Right -> from(Right(f(e.value)))
    }


    override fun <G, A> foldMap(g: Monoid<G>, f: (A) -> G, fa: Kind<F, A>): G = when (val e = to(fa))
    {
        is Left -> g.empty()
        is Right -> f(e.value)
    }

    override fun <G : TypeAccessor<Unary>, A, B> traverse(ap: Applicative<G>,
                                                          f: (A) -> Kind<G, B>,
                                                          fa: Kind<F, A>): Kind<G, Kind<F, B>> = when (val e = to(fa))
    {
        is Left -> ap.map({ c -> from(Left(c)) }, ap.of(e.value))
        is Right -> ap.map({ b -> from(Right(b)) }, f(e.value))
    }
}