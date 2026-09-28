package kato.law

/**
 * A law is something cannot protect by compiler or runtime, but it is required
 * in the structure, e.g. commutative or associative.
 *
 * For multiple laws, please repeat it with multiple annotations on it.
 *
 * @param condition The condition the law described.
 */
@Repeatable
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Law(val condition: String)