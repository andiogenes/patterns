package introduction.delegation

import common.logging.Loggable
import common.data.AudioData
import common.io.AudioOutput

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