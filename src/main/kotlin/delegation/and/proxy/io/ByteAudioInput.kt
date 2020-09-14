package delegation.and.proxy.io

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.data.DummyAudioData
import delegation.and.proxy.logging.Logger

/**
 * Входной поток, читающий данные из последовательности байтов [bytes].
 */
class ByteAudioInput(private val bytes: ByteArray) : AudioInput {
    init {
        Logger.log(this, "ByteAudioInput", "<init>")
    }

    override fun read(): AudioData {
        Logger.log(this, "ByteAudioInput", "read", "read")
        return DummyAudioData(bytes)
    }

    override fun close() {
        Logger.log(this, "ByteAudioInput", "close", "close")
    }
}