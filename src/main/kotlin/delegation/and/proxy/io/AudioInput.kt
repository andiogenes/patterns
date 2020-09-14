package delegation.and.proxy.io

import delegation.and.proxy.data.AudioData

/**
 * Входной поток, через который можно читать звуковые данные.
 */
interface AudioInput: AudioStream {
    /**
     * Читает данные из источника.
     */
    fun read(): AudioData
}
