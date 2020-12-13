package creational.factory_method.processors

import common.data.AudioData
import common.logging.Loggable
import common.processors.SingleProcessor

/**
 * Биткрашер - это звуковой эффект, вызывающий искажение за счет уменьшения разрешения или
 * полосы пропускания цифровых аудиоданных. Результирующий шум квантования может производить
 * впечатление «более теплого» или резкого звука, в зависимости от степени уменьшения.
 */
class BitCrusher : SingleProcessor, Loggable("BitCrusher", "ConcreteProduct") {
    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return data
    }
}