package creational.prototype.view_models

import common.logging.LoggableObject
import common.processors.SoundProcessor
import creational.prototype.ProcessorViewModel
import creational.prototype.components.Component

class NodeViewModel(
        private val out: ProcessorViewModel,
        private val processor: SoundProcessor,
        vararg components: Component
) : ProcessorViewModel(*components) {
    private val _log = LoggableObject("NodViewModel", "ConcretePrototype")

    override fun advanceCircuit(): List<SoundProcessor> {
        _log("advanceCircuit", "Operation")
        return listOf(processor, *out.advanceCircuit().toTypedArray())
    }

    override fun clone(): ProcessorViewModel {
        _log("clone", "Clone")
        return NodeViewModel(out, processor, *components.map { it.clone() }.toTypedArray())
    }
}