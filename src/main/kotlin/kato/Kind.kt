package kato

interface Kind<F : TypeAccessor<*>, A> // F[A]

interface Kind2<F : TypeAccessor<*>, A, B> // F[A, B]