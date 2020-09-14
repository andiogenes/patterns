package delegation.and.proxy.processors

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Logger

/**
 * Обработчик типа "искажение".
 */
class Distortion : SingleProcessor {
    init {
        Logger.log(this, "Distortion", "<init>")
    }

    override fun process(data: AudioData): AudioData {
        Logger.log(this, "Distortion", "process", "process")
        return data
    }
}