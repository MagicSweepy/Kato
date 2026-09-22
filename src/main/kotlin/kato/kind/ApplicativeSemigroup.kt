package kato.kind

import kato.struct.SemiGroup
import kato.type.TypeAccessor
import kato.type.Unary

abstract class ApplicativeSemigroup<F : TypeAccessor<Unary>, A>(private val group: SemiGroup<A>) : Applicative<F>, SemigroupK<F, A>
{
    abstract override fun <A> of(a: A?): Kind<F, A>

    abstract override fun <A, B> lift(ff: Kind<F, (A) -> B>): (Kind<F, A>) -> Kind<F, B>

    abstract override fun <A, B> map(f: (A) -> B, fa: Kind<F, A>): Kind<F, B>

    override fun combine(a: Kind<F, A>, b: Kind<F, A>): Kind<F, A>
        = map2(a, b) { a, b -> group.combine(a, b) }
}