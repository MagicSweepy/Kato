package kato.kind

import kato.type.Binary
import kato.type.TypeAccessor

interface AffineP<P : TypeAccessor<Binary>> : CartesianP<P>, CocartesianP<P>