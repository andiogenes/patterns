package delegation.and.proxy.processors

import delegation.and.proxy.logging.Loggable
import delegation.and.proxy.data.AudioData

/**
 * Обработчик типа "Квакушка".
 */
class WahWah : SingleProcessor, Loggable("WahWah") {
    override fun process(data: AudioData): AudioData {
        log("process", "process")
        return data
    }
}