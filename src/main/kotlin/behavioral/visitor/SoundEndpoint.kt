package behavioral.visitor

import common.logging.Loggable
import common.logging.LoggableObject

/**
 * Точки обработки звука.
 */
sealed class SoundEndpoint(val name: String) : Loggable("SoundEndpoint", "Element") {
    /**
     * Интерфейс посетителя [SoundEndpoint].
     */
    interface Visitor {
        fun visit(point: Input)
        fun visit(point: Regular)
        fun visit(point: Output)
    }

    /**
     * Определяет, какой метод посетителя вызывать.
     */
    abstract fun accept(visitor: Visitor)

    /**
     * Вход.
     */
    class Input(name: String, val inputVolume: Float = 1f) : SoundEndpoint(name) {
        private val log_ = LoggableObject("Input", "ConcreteElement")

        override fun accept(visitor: Visitor) {
            log_("accept", "accept")
            return visitor.visit(this)
        }
    }

    /**
     * Обычный узел со входом и выходом.
     */
    class Regular(name: String, var from: SoundEndpoint? = null, var to: SoundEndpoint? = null) : SoundEndpoint(name) {
        private val log_ = LoggableObject("Regular", "ConcreteElement")
        override fun accept(visitor: Visitor) {
            log_("accept", "accept")
            return visitor.visit(this)
        }
    }

    /**
     * Выход.
     */
    class Output(name: String, val outputVolume: Float = 1f) : SoundEndpoint(name) {
        private val log_ = LoggableObject("Output", "ConcreteElement")
        override fun accept(visitor: Visitor) {
            log_("accept", "accept")
            return visitor.visit(this)
        }
    }
}