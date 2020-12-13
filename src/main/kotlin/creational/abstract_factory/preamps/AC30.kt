package creational.abstract_factory.preamps

import common.data.AudioData
import common.logging.Loggable

/**
 * Обработчик, эмулирующий предусилитель усилителя Vox AC30.
 */
class AC30 : Preamplifier, Loggable("AC30", "ConcreteProduct1") {
    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return data
    }
}