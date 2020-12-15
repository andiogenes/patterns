package behavioral.memento

import common.logging.Loggable

/**
 * Хранитель состояния.
 */
data class Memento<T>(val state: T) : Loggable("Memento")