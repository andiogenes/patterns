package creational.prototype.view_models

import common.logging.LoggableObject
import common.processors.SoundProcessor
import creational.prototype.ProcessorViewModel
import creational.prototype.components.Component

class OutputViewModel(vararg components: Component) : ProcessorViewModel(*components) {
    private val _log = LoggableObject("OutputViewModel", "ConcretePrototype")

    override fun advanceCircuit(): List<SoundProcessor> {
        _log("advanceCircuit", "Operation")
        return listOf()
    }

    override fun clone(): ProcessorViewModel {
        _log("clone", "Clone")
        return OutputViewModel(*components.map { it.clone() }.toTypedArray())
    }
}