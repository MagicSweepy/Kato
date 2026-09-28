package kato.kind

import kato.type.Identity
import kato.type.runId

object IdApplicative: Applicative<Identity>
{
    override fun <A> of(a: A?): Kind<Identity, A>
        = a?.let { Id(it) } ?: throw NullPointerException("The value in Id must be non-null")

    override fun <A, B> map(f: (A) -> B, fa: Kind<Identity, A>): Kind<Identity, B>
        = Id(f(fa.runId()))

    override fun <A, B> lift(ff: Kind<Identity, (A) -> B>): (Kind<Identity, A>) -> Kind<Identity, B>
        = { fa -> Id(ff.runId()(fa.runId()))}
}