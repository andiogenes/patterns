package behavioral.state

import common.data.AudioData
import common.logging.Loggable
import common.logging.LoggableObject
import common.processors.SoundProcessor

/**
 * Обработчик, который может на время переключаться в другой режим работы.
 */
class MultiModeProcessor : SoundProcessor, Loggable("MultiModeProcessor", "Context") {
    /**
     * Текущий режим работы.
     */
    private var mode: Mode = Mode.Standard(this)

    /**
     * Режим работы обработчика  [context].
     */
    sealed class Mode(private val context: MultiModeProcessor) : Loggable("Mode", "State") {
        open fun process(data: AudioData): AudioData {
            log("process", "Operation")
            return data
        }

        /**
         * Меняет режим обработчика на [mode].
         */
        fun changeMode(mode: Mode): Mode {
            log("changeMode", "ChangeState")
            context.mode = mode
            return mode
        }

        /**
         * Стандартный режим работы. Не переходит в другие режимы.
         */
        class Standard(context: MultiModeProcessor) : Mode(context) {
            private val _log = LoggableObject("Standard", "ConcreteState")
            override fun process(data: AudioData): AudioData {
                _log("process", "Operation")
                val fallthrough = super.process(data)
                println("Current mode: Standard")
                return fallthrough
            }
        }

        /**
         * Режим работы "Заморозка". Обрабатывает звуковые данные в таком режиме [duration] раз,
         * потом переходит в стандартный режим работы.
         */
        class Freeze(private val context: MultiModeProcessor, private var duration: Int = 5) : Mode(context) {
            private val _log = LoggableObject("Freeze", "ConcreteState")
            override fun process(data: AudioData): AudioData {
                _log("process", "Operation")
                return if (duration > 0) {
                    println("Current mode: Freeze, $duration operations remain before switching to Standard mode")
                    duration--
                    super.process(data)
                } else {
                    val standard = changeMode(Standard(context))
                    standard.process(data)
                }
            }
        }
    }

    /**
     * Переводит обработчик в режим работы "Заморозка".
     */
    fun freeze(duration: Int = 5) {
        log("freeze", "ChangeState(Freeze)")
        mode = Mode.Freeze(this, duration)
    }

    override fun process(data: AudioData): AudioData {
        log("process", "Operation")
        return mode.process(data)
    }
}