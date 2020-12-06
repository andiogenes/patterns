package structural.composites

import common.data.AudioData
import common.logging.LoggableObject
import common.processors.ComposableProcessor
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

/**
 * Микшер.
 *
 * Позволяет смешивать сигнал двух обработчиков.
 */
class Mixer(
    leftProcessor: ComposableProcessor,
    rightProcessor: ComposableProcessor,
    balance: Double = 0.5
) : CompositeProcessor() {
    private val log = LoggableObject("Mixer", "composite (derived)")

    init {
        super.addChild(leftProcessor)
        super.addChild(rightProcessor)
    }

    /**
     * Левый микшируемый обработчик.
     */
    var leftProcessor = leftProcessor
        set(value) {
            if (value == this) {
                throw IllegalArgumentException("mixer must not contain itself")
            }
            super.removeChild(leftProcessor)
            super.addChild(leftProcessor)
            field = value
        }

    /**
     * Правый микшируемый обработчик.
     */
    var rightProcessor = rightProcessor
        set(value) {
            if (value == this) {
                throw IllegalArgumentException("mixer must not contain itself")
            }
            super.removeChild(rightProcessor)
            super.addChild(rightProcessor)
            field = value
        }

    /**
     * Баланс каналов.
     *
     * Минимальное значение = 0.
     * Максимальное значение = 1.
     */
    var balance: Double = balance
        set(value) {
            if (value > 1 || value < 0) {
                throw IllegalArgumentException("balance lies in [0, 1] range")
            }
            field = value
        }

    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        println("Mixer: left processor - ${balance * 100}%, right processor - ${(1 - balance) * 100}%")
        return super.process(data)
    }

    /**
     * Добавлять элементы в микшер через [addChild] запрещено.
     */
    override fun addChild(child: ComposableProcessor): ComposableProcessor {
        throw IllegalStateException("method not allowed")
    }

    /**
     * Удалять элементы из миксера через [removeChild] запрещено.
     */
    override fun removeChild(child: ComposableProcessor): ComposableProcessor {
        throw IllegalStateException("method not allowed")
    }
}