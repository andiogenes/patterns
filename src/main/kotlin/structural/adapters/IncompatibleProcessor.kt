package structural.adapters

import common.data.AudioData
import common.logging.Loggable
import common.processors.SoundProcessor

/**
 * Обработчик, интерфейс которого не совместим с [SoundProcessor].
 */
open class IncompatibleProcessor : Loggable("IncompatibleProcessor", "adaptee") {
    open fun process(data: AudioData): AudioData {
        log("process", "specificRequest")
        return data
    }
}