package common.processors.single

import common.logging.Loggable
import common.data.AudioData
import common.processors.SingleProcessor

/**
 * Обработчик типа "Эхо".
 */
class Delay : SingleProcessor, Loggable("Delay") {
    override fun process(data: AudioData): AudioData {
        log("process", "process")
        return data
    }
}