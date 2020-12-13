package creational.abstract_factory

import common.data.AudioData
import common.logging.Loggable
import common.processors.SoundProcessor
import creational.abstract_factory.providers.ModuleProvider

/**
 * Модульный гитарный обработчик.
 *
 * Состоит из предусилителя, мощника, петли эффектов, импульсной характеристики кабинета.
 */
class ModularProcessor(provider: ModuleProvider) : SoundProcessor, Loggable("ModuleProcessor", "Client") {
    private val preamp = provider.createPreamplifier()
    private val powerAmp = provider.createAmplifier()
    private val effects = provider.createEffectsLoop()
    private val speaker = provider.createSpeaker()

    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return data.let { preamp.process(it) }
                .let { powerAmp.process(it) }
                .let { effects.process(it) }
                .let { speaker.process(it) }
    }
}