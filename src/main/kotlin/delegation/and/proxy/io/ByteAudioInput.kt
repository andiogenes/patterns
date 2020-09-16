package delegation.and.proxy.io

import delegation.and.proxy.logging.Loggable
import delegation.and.proxy.data.AudioData
import delegation.and.proxy.data.DummyAudioData

/**
 * Входной поток, читающий данные из последовательности байтов [bytes].
 */
class ByteAudioInput(private val bytes: ByteArray) : AudioInput, Loggable("ByteAudioInput") {
    override fun read(): AudioData {
        log("read", "read")
        return DummyAudioData(bytes)
    }

    override fun close() {
        log("close", "close")
    }
}