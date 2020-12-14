package creational.prototype.view_models

import common.logging.LoggableObject
import creational.prototype.ProcessorViewModel
import creational.prototype.components.Component

/**
 * Модель представления звукового входа в программе.
 */
class InputViewModel(vararg components: Component) : ProcessorViewModel(*components) {
    private val _log = LoggableObject("InputViewModel", "ConcretePrototype")

    override fun clone(): ProcessorViewModel {
        _log("clone", "Clone")
        return InputViewModel(*components.map { it.clone() }.toTypedArray()).bindData()
    }
}