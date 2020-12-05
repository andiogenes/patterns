package common.processors.single

import common.logging.Loggable
import common.data.AudioData
import common.processors.SingleProcessor

/**
 * Обработчик типа "искажение".
 */
class Distortion : SingleProcessor, Loggable("Distortion") {
    override fun process(data: AudioData): AudioData {
        log("process", "process")
        return data
    }
}