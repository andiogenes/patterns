package creational.prototype

import common.logging.Loggable
import common.processors.SoundProcessor
import creational.prototype.components.Component

/**
 * Модель представления обработчика в программе.
 *
 * Содержит модели представления своих компонентов (элементов управления - ползунков, переключателей и т.п.)
 * и положение представления обработчика в рабочем пространстве.
 */
abstract class ProcessorViewModel(
    vararg components: Component
) : Cloneable<ProcessorViewModel>, Loggable("ProcessorViewModel", "Prototype") {
    var x: Int = 0
    var y: Int = 0
    var components = mutableListOf(*components)

    /**
     * Привязывает к копируемому объекту базовое состояние прототипа.
     *
     * Должен вызываться каждый раз от скопированного объекта после копирования.
     */
    fun ProcessorViewModel.bindData(): ProcessorViewModel = this.also {
        x = this@ProcessorViewModel.x
        y = this@ProcessorViewModel.y
    }

    override fun toString(): String =
        "id: ${hashCode()}, x: $x, y: $y, components: [${components.joinToString(", ")}]"
}