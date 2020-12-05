package common.logging

import common.logging.writers.LogWriter

/**
 * Логгер проекта.
 */
object Logger {
    /**
     * Объекты, пишущие информацию в лог.
     */
    private val writers = mutableListOf<LogWriter>()

    /**
     * Устанавливает объекты, пишущие информацию в лог.
     */
    fun setWriters(vararg writer: LogWriter) {
        writers.apply {
            clear()
            addAll(writer)
        }
    }

    /**
     * Форматирует строку лога по типу [name]_[role]_[id]:[method]_[methodRole], где:
     * - [name] - конкретное имя класса
     * - [role] - его роль на UML-диаграмме
     * - [id] - id объекта
     * - [method] - вызываемый в текущий момент времени метод
     * - [methodRole] - образ метода на UML-диаграмме (если задан)
     */
    private fun formatLog(name: String, role: String, id: String, method: String, methodRole: String): String {
        val methodRoleSeparator = if (methodRole.isNotEmpty()) "_" else ""
        return "${name}_${role}_$id:$method$methodRoleSeparator$methodRole"
    }

    /**
     * Пишет в лог [name]_[role]_[id]:[method]_[methodRole], где:
     * - [name] - конкретное имя класса
     * - [role] - его роль на UML-диаграмме
     * - [id] - id объекта
     * - [method] - вызываемый в текущий момент времени метод
     * - [methodRole] - образ метода на UML-диаграмме (если задан)
     */
    fun log(name: String, role: String, id: String, method: String, methodRole: String = "") {
        val line = formatLog(name, role, id, method, methodRole)
        writers.forEach {
            it.log(line)
        }
    }
}