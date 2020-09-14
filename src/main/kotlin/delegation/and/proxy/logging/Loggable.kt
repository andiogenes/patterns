package delegation.and.proxy.logging

/**
 * Интерфейс протоколирования данных об объектах.
 */
internal interface Loggable {
    /**
     * Логгирует информацию об объекте [obj]:
     * - [role] - его роль на UML-диаграмме
     * - [method] - вызываемый в текущий момент времени метод
     * - [methodRole] - образ метода на UML-диаграмме (если задан)
     * - [id] - id объекта
     */
    fun log(obj: Any, role: String, method: String, methodRole: String = "", id: Int = -1)
}