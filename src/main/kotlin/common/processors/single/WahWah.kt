package common.processors.single

import common.logging.Loggable
import common.data.AudioData
import common.processors.SingleProcessor

/**
 * Обработчик типа "Квакушка".
 */
class WahWah : SingleProcessor, Loggable("WahWah") {
    override fun process(data: AudioData): AudioData {
        log("process", "process")
        return data
    }
}