package creational.prototype.view_models

import common.logging.LoggableObject
import common.processors.SoundProcessor
import creational.prototype.ProcessorViewModel
import creational.prototype.components.Component

/**
 * Модель представления звукового выхода в программе.
 *
 * Имеет один вход.
 */
class OutputViewModel(var input: ProcessorViewModel?, vararg components: Component) : ProcessorViewModel(*components) {
    private val _log = LoggableObject("OutputViewModel", "ConcretePrototype")

    override fun clone(): ProcessorViewModel {
        _log("clone", "Clone")
        return OutputViewModel(input, *components.map { it.clone() }.toTypedArray()).bindData()
    }

    override fun toString(): String =
        "${super.toString()}, input id: ${input.hashCode()}"
}