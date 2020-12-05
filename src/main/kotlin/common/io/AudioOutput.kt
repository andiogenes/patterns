package common.io

import common.data.AudioData

/**
 * Выходной поток для записи аудиоданных.
 */
interface AudioOutput: AudioStream {
    /**
     * Записывает данные по назначению.
     */
    fun write(data: AudioData): Boolean
}
