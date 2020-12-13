package creational.abstract_factory.providers

import common.logging.Loggable
import common.processors.SoundProcessor
import common.processors.single.Distortion
import creational.abstract_factory.amps.PowerAmplifier
import creational.abstract_factory.amps.SmallPowerAmplifier
import creational.abstract_factory.preamps.AC30
import creational.abstract_factory.preamps.Preamplifier
import creational.abstract_factory.speakers.CelestionG12M
import creational.abstract_factory.speakers.Speaker

/**
 * Поставщик модулей для сборки обработчика, эмулирующего Vox AC30.
 */
class VoxProvider : ModuleProvider, Loggable("VoxProvider", "ConcreteFactory") {
    override fun createPreamplifier(): Preamplifier {
        log("createPreamplifier", "CreateProduct1")
        return AC30()
    }

    override fun createAmplifier(): PowerAmplifier {
        log("createAmplifier", "CreateProduct2")
        return SmallPowerAmplifier()
    }

    override fun createEffectsLoop(): SoundProcessor {
        log("createEffectsLoop")
        return Distortion()
    }

    override fun createSpeaker(): Speaker {
        log("createSpeaker", "CreateProduct3")
        return CelestionG12M()
    }
}