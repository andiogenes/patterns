package creational.abstract_factory.providers

import common.logging.Loggable
import common.processors.SoundProcessor
import common.processors.single.Delay
import creational.abstract_factory.amps.MediumPowerAmplifier
import creational.abstract_factory.amps.PowerAmplifier
import creational.abstract_factory.preamps.Preamplifier
import creational.abstract_factory.preamps.TwinReverb
import creational.abstract_factory.speakers.JensenC12N
import creational.abstract_factory.speakers.Speaker

/**
 * Поставщик модулей для сборки обработчика, эмулирующего Fender Twin Reverb.
 */
class FenderProvider : ModuleProvider, Loggable("FenderProvider", "ConcreteFactory") {
    override fun createPreamplifier(): Preamplifier {
        log("createPreamplifier", "CreateProduct1")
        return TwinReverb()
    }

    override fun createAmplifier(): PowerAmplifier {
        log("createAmplifier", "CreateProduct2")
        return MediumPowerAmplifier()
    }

    override fun createEffectsLoop(): SoundProcessor {
        log("createEffectsLoop")
        return Delay()
    }

    override fun createSpeaker(): Speaker {
        log("createSpeaker", "CreateProduct3")
        return JensenC12N()
    }
}