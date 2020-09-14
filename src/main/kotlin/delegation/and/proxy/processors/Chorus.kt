package delegation.and.proxy.processors

import delegation.and.proxy.data.AudioData

/**
 * Обработчик типа "Хор".
 */
class Chorus : SingleProcessor {
    override fun process(data: AudioData): AudioData = data
}