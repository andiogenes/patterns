package structural.part.one.logging

import delegation.and.proxy.logging.Loggable

/**
 * Логгирует поведение объектов аналогично [Loggable],
 * но подключается в классы через композицию, а не наследование.
 */
class LoggableObject(
    name: String,
    role: String,
    logDefaultConstructor: Boolean = true
) : Loggable(name, role, logDefaultConstructor) {

    constructor(name: String, logDefaultConstructor: Boolean = true) : this(name, name, logDefaultConstructor)

    /**
     * Логгирует вызов метода объекта.
     */
    operator fun invoke(method: String = "<init>", methodRole: String = "") = super.log(method, methodRole)
}