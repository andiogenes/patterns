package creational.factory_method.producers

import common.logging.Loggable
import common.processors.SoundProcessor
import creational.factory_method.processors.BitCrusher

/**
 * Производитель обработчика типа "бит-крашер".
 */
class BitCrusherProducer : Producer, Loggable("BitCrusherProducer", "ConcreteCreator") {
    override fun produce(): SoundProcessor {
        log("produce", "FactoryMethod")
        return BitCrusher()
    }
}