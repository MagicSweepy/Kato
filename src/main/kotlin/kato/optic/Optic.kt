package kato.optic

import kato.kind.Kind2
import kato.kind.Profunctor
import kato.type.Binary
import kato.type.TypeAccessor

/**
 * @see VOptic Van Laarhoven encoding Optic.
 */
interface Optic<S, T, A, B>
{
    fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>

    infix fun <A1, B1> andThen(other: Optic<A, B, A1, B1>): Optic<S, T, A1, B1>
        = Composition(*arrayOf(this, other))
}

// TODO: It's that right? I think this composition is too raw :(
class Composition<S, T, A, B>(private vararg val optics: Optic<*, *, *, *>) : Optic<S, T, A, B>
{
    @Suppress("UNCHECKED_CAST")
    override fun <P : TypeAccessor<Binary>> eval(p: Profunctor<P>, pab: Kind2<P, A, B>): Kind2<P, S, T>
    {
        var _pab = pab as Kind2<P, Any, Any>
        for (i in optics.indices.reversed())
            _pab = (optics[i] as Optic<Any, Any, Any, Any>).eval(p, _pab)
        return _pab as Kind2<P, S, T>
    }
}