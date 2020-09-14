package delegation.and.proxy.io

import delegation.and.proxy.data.AudioData

/**
 * Выходной поток для записи аудиоданных.
 */
interface AudioOutput: AudioStream {
    /**
     * Записывает данные по назначению.
     */
    fun write(data: AudioData): Boolean
}
