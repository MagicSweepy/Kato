package kato.law

/**
 * Constraint all instances of the lawed class should be the type which the generic hint.
 *
 * Usually not repeat use it though it can do.
 */
@Repeatable
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DerivativeLaw<@Suppress("unused") T : Any>
