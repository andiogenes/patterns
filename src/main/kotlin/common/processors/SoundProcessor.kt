package common.processors

import common.data.AudioData

/**
 * Звуковой обработчик.
 * Устройство, которое принимает звуковой сигнал, обрабатывает его и возвращает обработанный сигнал.
 */
interface SoundProcessor {
    /**
     * Обрабатывает звуковые данные [data].
     */
    fun process(data: AudioData): AudioData
}