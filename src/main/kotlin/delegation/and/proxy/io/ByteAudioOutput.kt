package delegation.and.proxy.io

import delegation.and.proxy.logging.Loggable
import delegation.and.proxy.data.AudioData

/**
 * Выходной поток, записывающий данные в байтах в [collection].
 */
class ByteAudioOutput(private val collection: MutableCollection<Byte>) : AudioOutput, Loggable("ByteAudioOutput") {
    override fun write(data: AudioData): Boolean {
        log("write", "write")
        collection.apply {
            clear()
            addAll(data.toByteArray().toTypedArray())
        }
        return true
    }

    override fun close() {
        log("close", "close")
    }
}