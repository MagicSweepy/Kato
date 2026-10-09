package kato.kind

import kato.law.Law
import kato.type.Binary
import kato.type.TypeAccessor

interface Enriched<V : TypeAccessor<Binary>, H : TypeAccessor<Binary>>
{
    val base: Monoidal<V>

    @Law("compose ∘ par(id(), f) = f") // left identity up to the unitor λ
    @Law("compose ∘ par(f, id()) = f") // right identity up to the unitor ρ
    @Law("compose ∘ par(compose, 1) = compose ∘ par(1, compose)") // associativity up to the associator α
    fun <A, B, C> compose(): Kind2<V, Pair<Kind2<H, B, C>, Kind2<H, A, B>>, Kind2<H, A, C>>

    fun <A> id(): Kind2<V, Unit, Kind2<H, A, A>>
}
