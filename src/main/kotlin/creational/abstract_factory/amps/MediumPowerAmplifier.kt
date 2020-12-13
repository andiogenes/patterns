package creational.abstract_factory.amps

import common.data.AudioData
import common.logging.Loggable

/**
 * "Средний" мощник.
 */
class MediumPowerAmplifier : PowerAmplifier, Loggable("MediumPowerAmplifier", "ConcreteProduct2") {
    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return data
    }
}