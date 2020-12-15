package behavioral.memento

import common.logging.Loggable

/**
 * Опекун над [Memento] с определенным состоянием.
 */
class Caretaker<T> : Loggable("Caretaker") {
    /**
     * Хранимые образы состояний.
     */
    private val mementos = ArrayList<Memento<T>>()

    /**
     * Сохраняет образ состояния.
     */
    fun save(memento: Memento<T>) {
        log("save", "SaveMemento")
        mementos.add(memento)
    }

    /**
     * Восстанавливает [index]-й образ состояния.
     */
    fun restore(index: Int): Memento<T> {
        log("restore(I)", "RestoreMemento")
        return mementos[index]
    }

    /**
     * Восстанавливает последний образ состояния.
     */
    fun restore(): Memento<T> {
        log("restore", "RestoreMemento")
        return mementos.last()
    }
}