package creational.factory_method.processors

import common.data.AudioData
import common.logging.Loggable
import common.processors.SingleProcessor

/**
 * Фланжер — эффект, напоминающий «летящее» звучание.
 */
class Flanger : SingleProcessor, Loggable("Flanger", "ConcreteProduct") {
    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return data
    }
}