package kato.kind

import kato.struct.Either
import kato.struct.Monoid
import kato.type.ForgetK
import kato.type.asForget
import kato.type.runConst

class ForgetMonoid<M>(private val group: Monoid<M>) : TraversalP<ForgetK<M>>, GetterP<ForgetK<M>>
{
    override fun <A, B, C, D> dimap(f: (C) -> A, g: (B) -> D, fab: Kind2<ForgetK<M>, A, B>): Kind2<ForgetK<M>, C, D>
        = Forget { fab.asForget().run(f(it)) }

    override fun <A, B, C, D> cimap(g: (C) -> A, h: (D) -> B, pab: () -> Kind2<ForgetK<M>, A, B>): Kind2<ForgetK<M>, C, D>
        = Forget { pab().asForget().run(g(it)) }

    override fun <A, B, C> first(fa: Kind2<ForgetK<M>, A, B>): Kind2<ForgetK<M>, Pair<A, C>, Pair<B, C>>
        = Forget { fa.asForget().run(it.first) }

    override fun <A, B, C> second(fa: Kind2<ForgetK<M>, A, B>): Kind2<ForgetK<M>, Pair<C, A>, Pair<C, B>>
        = Forget { fa.asForget().run(it.second) }

    override fun <A, B, C> left(fab: Kind2<ForgetK<M>, A, B>): Kind2<ForgetK<M>, Either<A, C>, Either<B, C>>
        = Forget { e -> e.fold({ fab.asForget().run(it) }, { group.empty() }) }

    override fun <A, B, C> right(fab: Kind2<ForgetK<M>, A, B>): Kind2<ForgetK<M>, Either<C, A>, Either<C, B>>
        = Forget { e -> e.fold({ group.empty() }, { fab.asForget().run(it) })}

    override fun <S, T, A, B> wander(w: Wander<S, T, A, B>, pab: Kind2<ForgetK<M>, A, B>): Kind2<ForgetK<M>, S, T>
        = Forget { s ->
            val ap = ConstApplicative(group)
            val fab = { a: A -> Const<M, B>(pab.asForget().run(a)) }
            w.wander(ap, fab)(s).runConst()
          }
}