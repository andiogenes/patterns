package creational.abstract_factory.preamps

import common.data.AudioData
import common.logging.Loggable

/**
 * Обработчик, эмулирующий предусилитель усилителя Fender Twin Reverb.
 */
class TwinReverb : Preamplifier, Loggable("TwinReverb", "ConcreteProduct1") {
    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return data
    }
}