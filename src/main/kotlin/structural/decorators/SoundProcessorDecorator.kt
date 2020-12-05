package structural.decorators

import common.data.AudioData
import common.processors.SoundProcessor
import common.logging.LoggableObject

/**
 * Декорирует [SoundProcessor].
 *
 * Все другие декораторы [SoundProcessor] должны наследоваться от этого класса.
 */
abstract class SoundProcessorDecorator(private val processor: SoundProcessor) :
    SoundProcessor {
    private val log =
        LoggableObject("SoundProcessorDecorator", "decorator (base)")

    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return processor.process(data)
    }
}