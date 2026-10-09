package kato.kind

import kato.law.Law
import kato.type.Binary
import kato.type.ProcomposeK
import kato.type.FunctionK
import kato.type.TypeAccessor

interface MonoidP<P : TypeAccessor<Binary>> : Profunctor<P>
{
    @Law("left unit: associate(ComposeP(unit(f), id)) = f")
    @Law("right unit: associate(ComposeP(id, unit(f))) = f")
    fun <A, B> unit(pab: Kind2<FunctionK, A, B>): Kind2<P, A, B>

    @Law("associativity: associate(ComposeP(associate(ComposeP(z, y)), x)) = associate(ComposeP(z, associate(ComposeP(y, x))))")
    fun <A, B> associate(pab: Kind2<ProcomposeK<P, P>, A, B>): Kind2<P, A, B>

    fun <A, B, C> compose(pbc: Kind2<P, B, C>, pab: () -> Kind2<P, A, B>): Kind2<P, A, C>
        = associate(Procompose(pab, pbc))
}
