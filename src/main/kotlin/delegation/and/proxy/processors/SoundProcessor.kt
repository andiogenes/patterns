package delegation.and.proxy.processors

import delegation.and.proxy.data.AudioData

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