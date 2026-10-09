package kato.optic

import kato.kind.Applicative
import kato.law.DerivativeLaw

@DerivativeLaw<Applicative<*>>
interface VApplicativeOptic<S, T, A, B> : VOptic<S, T, A, B>