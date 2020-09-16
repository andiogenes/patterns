package delegation.and.proxy.processors.single

import delegation.and.proxy.logging.Loggable
import delegation.and.proxy.data.AudioData
import delegation.and.proxy.processors.SingleProcessor

/**
 * Обработчик типа "Квакушка".
 */
class WahWah : SingleProcessor, Loggable("WahWah") {
    override fun process(data: AudioData): AudioData {
        log("process", "process")
        return data
    }
}