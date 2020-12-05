package prepatterns.delegation

import common.logging.Loggable
import common.data.AudioData
import common.data.DummyAudioData
import common.io.AudioInput

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