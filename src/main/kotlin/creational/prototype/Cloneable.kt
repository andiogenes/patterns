package creational.prototype

/**
 * Обобщенный интерфейс для объектов, которые можно создавать копированием.
 */
interface Cloneable<T> {
    /**
     * Копирует объект.
     */
    fun clone(): T
}