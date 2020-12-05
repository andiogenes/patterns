package structural.decorators

import common.data.AudioData
import common.processors.SoundProcessor
import common.logging.LoggableObject

/**
 * Меняет уровень звука.
 */
class VolumeFilter(processor: SoundProcessor) : SoundProcessorDecorator(processor) {
    private val log = LoggableObject("VolumeFilter", "decorator (derived)")

    /**
     * Прирост (спад) уровня звука (в децибелах).
     */
    var volume: Int = 0

    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        println("volume: $volume db")
        return super.process(data)
    }
}