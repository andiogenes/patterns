package creational.factory_method.producers

import common.logging.Loggable
import common.processors.SoundProcessor
import creational.factory_method.processors.Flanger

/**
 * Производитель обработчика типа "флэнджер".
 */
class FlangerProducer : Producer, Loggable("FlangerProducer", "ConcreteCreator") {
    override fun produce(): SoundProcessor {
        log("produce", "FactoryMethod")
        return Flanger()
    }
}