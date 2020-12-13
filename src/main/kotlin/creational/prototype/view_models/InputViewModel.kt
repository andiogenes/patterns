package creational.prototype.view_models

import common.logging.LoggableObject
import common.processors.SoundProcessor
import creational.prototype.ProcessorViewModel
import creational.prototype.components.Component

class InputViewModel(private val out: ProcessorViewModel, vararg components: Component) : ProcessorViewModel(*components) {
    private val _log = LoggableObject("InputViewModel", "ConcretePrototype")

    override fun advanceCircuit(): List<SoundProcessor> {
        _log("advanceCircuit", "Operation")
        return out.advanceCircuit()
    }

    override fun clone(): ProcessorViewModel {
        _log("clone", "Clone")
        return InputViewModel(out, *components.map { it.clone() }.toTypedArray())
    }
}