package kato.kind

import kato.type.TypeAccessor
import kato.type.Unary

interface MonadError<F : TypeAccessor<Unary>, E> : Monad<F>
{
    fun <A> raiseError(e: E): Kind<F, A>

    fun <A> handleErrorWith(fa: Kind<F, A>, f: (E) -> Kind<F, A>): Kind<F, A>

    fun <A> handleError(fa: Kind<F, A>, f: (E) -> A): Kind<F, A>
            = handleErrorWith(fa) { a -> of(f(a)) }

    fun <A> recoverWith(fa: Kind<F, A>, default: Kind<F, A>): Kind<F, A>
            = handleErrorWith(fa) { _ -> default }

    fun <A> recover(fa: Kind<F, A>, a: A): Kind<F, A>
            = handleError(fa) { _ -> a }

    fun <A, B> redeem(fa: Kind<F, A>, recover: (E) -> B, f: (A) -> B): Kind<F, B>
            = handleError(map(f, fa), recover)

    fun <A> adaptError(fa: Kind<F, A>, partial: (E) -> E?): Kind<F, A>
            = handleErrorWith(fa) { e -> raiseError(partial(e) ?: e) }

    fun <A> onError(fa: Kind<F, A>, partial: (E) -> Kind<F, Unit>?): Kind<F, A>
            = handleErrorWith(fa) { e -> partial(e)?.let { raiseError(e) } ?: raiseError(e) }
}