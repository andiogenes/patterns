package structural.part.one.decorators

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.processors.SoundProcessor
import structural.part.one.logging.LoggableObject

/**
 * Распределяет звук в пространстве в стереосистеме.
 */
class PanFilter(processor: SoundProcessor) : SoundProcessorDecorator(processor) {
    private val log = LoggableObject("PanFilter", "decorator (derived)")

    /**
     * Баланс звука.
     *
     * Чем значение меньше, тем сильнее звук будет отдаваться в левой части системы.
     * Чем значение больше, тем сильнее звук будет отдаваться в правой части системы.
     *
     * Минимальное значение: 0.
     *
     * Максимальное значение: 100.
     */
    var balance: Int = 50
        set(value) {
            if (value < 0 || value > 100) {
                throw IllegalArgumentException(
                    "trying to assign $value to the variable with 0 as lower bound and 100 as upper bound"
                )
            }
            field = value
        }

    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        println("pan balance: $balance%")
        return super.process(data)
    }
}