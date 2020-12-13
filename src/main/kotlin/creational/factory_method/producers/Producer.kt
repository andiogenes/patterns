package creational.factory_method.producers

import common.processors.SoundProcessor

/**
 * Создает обработчик звука.
 */
interface Producer {
    fun produce(): SoundProcessor
}