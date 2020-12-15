package behavioral.memento

import common.data.AudioData
import common.logging.Loggable
import common.processors.SoundProcessor

/**
 * Обработчик-"комбайн". Имеет множество настроек и режимов работы.
 *
 * Настройки и режимы работы взяты с [Strymon Big Sky](https://www.strymon.net/product/bigsky/).
 */
class ReverbCombine(var state: Settings) : SoundProcessor, Loggable("DelayCombine", "Originator") {
    /**
     * Режимы работы процессора.
     */
    enum class WorkMode {
        Cloud, Chorale, Shimmer, Magneto, Nonlinear, Reflections,
        Room, Hall, Plate, Spring, Swell, Bloom
    }

    /**
     * Настраиваемые параметры обработчика.
     */
    data class Settings(
            var mode: WorkMode,
            var decay: Double,
            var preDelay: Double,
            var mix: Double,
            var tone: Double,
            var param1: Double,
            var param2: Double,
            var mod: Double
    ): Loggable("Settings", "State (Memento)")

    /**
     * Создаёт образ состояния обработчика.
     */
    fun createMemento(): Memento<Settings> {
        log("createMemento", "CreateMemento")
        return Memento(state.copy())
    }

    /**
     * Устанавливает состояние обработчика согласно образу.
     */
    fun setMemento(memento: Memento<Settings>) {
        log("setMemento", "SetMemento")
        state = memento.state
    }

    override fun process(data: AudioData): AudioData {
        log("process", "Operation")
        println("Current state: $state")
        return data
    }
}