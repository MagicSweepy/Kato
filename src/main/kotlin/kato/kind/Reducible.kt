package kato.kind

import kato.struct.Eval
import kato.type.TypeAccessor
import kato.type.Unary

interface Reducible<F : TypeAccessor<Unary>> : Foldable<F>
{
    fun <A, B> reduceLTo(fa: Kind<F, A>, f: (A) -> B, g: (B, A) -> B): B

    fun <A, B> reduceRTo(fa: Kind<F, A>, f: (A) -> B, g: (A, Eval<B>) -> Eval<B>): Eval<B>

    fun <A> reduceL(fa: Kind<F, A>, f: (A, A) -> A): A
        = reduceLTo(fa, { it }, f)

    fun <A> reduceR(fa: Kind<F, A>, f: (A, Eval<A>) -> Eval<A>): Eval<A>
        = reduceRTo(fa, { it }, f)
}