package kato.optic

import kato.law.Law

@Law("all instance should be applicative")
interface VApplicativeOptic<S, T, A, B> : VOptic<S, T, A, B>