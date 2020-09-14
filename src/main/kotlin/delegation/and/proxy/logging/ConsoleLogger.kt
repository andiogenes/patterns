package delegation.and.proxy.logging

/**
 * Логгер, протоколирующий в [System.out].
 */
internal class ConsoleLogger : Loggable {
    override fun log(obj: Any, role: String, method: String, methodRole: String, id: Int) {
        val methodRoleSeparator = if (methodRole.isNotEmpty()) "_" else ""
        println("${obj.resolveClassName()}_${role}_$id:$method$methodRoleSeparator$methodRole")
    }
}