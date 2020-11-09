package structural.part.one.decorators

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.processors.SoundProcessor
import structural.part.one.logging.LoggableObject

/**
 * Усиливает звук до какой-либо обработки.
 */
class GainFilter(processor: SoundProcessor) : SoundProcessorDecorator(processor) {
    private val log = LoggableObject("GainFilter", "decorator (derived)")

    /**
     * Усиление звука (в децибелах).
     *
     * Минимальное значение: 0.
     */
    var gain: Int = 0
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException("trying to assign $value to the variable with 0 as lower bound")
            }
            field = value
        }

    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        println("gain: $gain db")
        return super.process(data)
    }
}