package creational.abstract_factory.providers

import common.processors.SoundProcessor
import creational.abstract_factory.amps.PowerAmplifier
import creational.abstract_factory.preamps.Preamplifier
import creational.abstract_factory.speakers.Speaker

/**
 * Поставщик модулей для сборного обработчика.
 */
interface ModuleProvider {
    /**
     * Создает предусилитель.
     */
    fun createPreamplifier(): Preamplifier

    /**
     * Создает усилитель.
     */
    fun createAmplifier(): PowerAmplifier

    /**
     * Создает петлю эффектов.
     */
    fun createEffectsLoop(): SoundProcessor

    /**
     * Создает обработчик по импульсной характеристике кабинета.
     */
    fun createSpeaker(): Speaker
}