package structural.part.one.decorators

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.processors.SoundProcessor
import structural.part.one.logging.LoggableObject

/**
 * Декорирует [SoundProcessor].
 *
 * Все другие декораторы [SoundProcessor] должны наследоваться от этого класса.
 */
abstract class SoundProcessorDecorator(private val processor: SoundProcessor) : SoundProcessor {
    private val log = LoggableObject("SoundProcessorDecorator", "decorator (base)")

    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return processor.process(data)
    }
}