package delegation.and.proxy.logging

import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

/**
 * Логгирует создание объекта класса [name] и предоставляет
 * наследникам интерфейс для логгирования вызовов.
 *
 * Если в конструкторе указан [role], в логе (см. [Logger.log])
 * будет указана соответствующая роль.
 *
 * Если конструктор содержит только [name], за роль будет взято [name].
 */
abstract class Loggable(
    /**
     * Имя класса-наследника
     */
    private val name: String,
    /**
     * Роль класса-наследника на диаграмме UML.
     */
    private val role: String,
    /**
     * Пометка, логгировать ли вызов конструктора как <init>.
     */
    private val logDefaultConstructor: Boolean = true,
) {
    constructor(name: String, logDefaultConstructor: Boolean = true) : this(name, name, logDefaultConstructor)

    /**
     * Идентификатор объекта, выдаваемый на основе текущего времени.
     */
    private val id = formatter.format(Instant.now())

    init {
        // Логгированиие конструктора по умолчанию
        if (logDefaultConstructor) log()
    }

    /**
     * Логгирует вызов метода объекта.
     */
    protected fun log(method: String = "<init>", methodRole: String = "") {
        Logger.log(name, role, id, method, methodRole)
    }

    companion object {
        /**
         * Шаблон записи TimeStamp.
         */
        private const val timePattern = "HH:mm:ss.SSSSSS"

        /**
         * Форматировщик TimeStamp.
         */
        private val formatter = DateTimeFormatter
            .ofPattern(timePattern)
            .withZone(ZoneOffset.UTC)
    }
}