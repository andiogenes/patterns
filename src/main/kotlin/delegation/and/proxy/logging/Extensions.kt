package delegation.and.proxy.logging

/**
 * Определяет короткое имя класса для объекта.
 */
fun Any.resolveClassName(): String = this.javaClass.simpleName