package common.io

import common.data.AudioData

/**
 * Входной поток, через который можно читать звуковые данные.
 */
interface AudioInput: AudioStream {
    /**
     * Читает данные из источника.
     */
    fun read(): AudioData
}
