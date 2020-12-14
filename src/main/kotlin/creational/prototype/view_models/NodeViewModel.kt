package creational.prototype.view_models

import common.logging.LoggableObject
import creational.prototype.ProcessorViewModel
import creational.prototype.components.Component

/**
 * Модель представления обработчика в программе.
 *
 * Имеет задаваемое количество точек входа. Точка выхода унифицирована.
 */
class NodeViewModel(val inputs: Array<ProcessorViewModel?>, vararg components: Component) : ProcessorViewModel(*components) {
    private val _log = LoggableObject("NodeViewModel", "ConcretePrototype")

    override fun clone(): ProcessorViewModel {
        _log("clone", "Clone")
        return NodeViewModel(inputs.map { it }.toTypedArray(), *components.map { it.clone() }.toTypedArray()).bindData()
    }

    override fun toString(): String =
        "${super.toString()}, input ids: ${inputs.map { it.hashCode() }.joinToString(", ")}"
}