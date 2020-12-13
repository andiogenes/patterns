package creational.factory_method.producers

import common.logging.Loggable
import common.processors.SoundProcessor
import creational.factory_method.processors.Overdrive

/**
 * Производитель обработчика типа "перегруз".
 */
class OverdriveProducer : Producer, Loggable("OverdriveProducer", "ConcreteCreator") {
    override fun produce(): SoundProcessor {
        log("produce", "FactoryMethod")
        return Overdrive()
    }
}