package creational.prototype

import common.logging.Loggable
import common.processors.SoundProcessor
import creational.prototype.components.Component

abstract class ProcessorViewModel(vararg components: Component) : Loggable("ProcessorViewModel", "Prototype") {
    var x: Int = 0
    var y: Int = 0
    val components = mutableListOf(*components)

    abstract fun advanceCircuit(): List<SoundProcessor>

    abstract fun clone(): ProcessorViewModel
}