package delegation.and.proxy.processors

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Logger

/**
 * Обработчик типа "Квакушка".
 */
class WahWah : SingleProcessor {
    init {
        Logger.log(this, "WahWah", "<init>")
    }

    override fun process(data: AudioData): AudioData {
        Logger.log(this, "WahWah", "process", "process")
        return data
    }
}