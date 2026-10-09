package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface GetterP<P : TypeAccessor<Binary>> : Profunctor<P>, BiContravariant<P>
{
    fun <A, B, C> secondPhantom(pcb: Kind2<P, C, B>): Kind2<P, C, A>
        = cimap({ c: C -> c }, { _: A -> null }, { rmap({ _: B -> null }, pcb) })
}