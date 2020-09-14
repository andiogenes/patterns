package delegation.and.proxy.processors

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Logger

/**
 * Обработчик типа "Эхо".
 */
class Delay : SingleProcessor {
    init {
        Logger.log(this, "Delay", "<init>")
    }

    override fun process(data: AudioData): AudioData {
        Logger.log(this, "Delay", "process", "process")
        return data
    }
}