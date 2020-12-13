package creational.abstract_factory.amps

import common.data.AudioData
import common.logging.Loggable

/**
 * "Малый" мощник.
 */
class SmallPowerAmplifier : PowerAmplifier, Loggable("SmallPowerAmplifier", "ConcreteProduct2") {
    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return data
    }
}