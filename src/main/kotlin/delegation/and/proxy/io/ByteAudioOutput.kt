package delegation.and.proxy.io

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Logger

/**
 * Выходной поток, записывающий данные в байтах в [collection].
 */
class ByteAudioOutput(private val collection: MutableCollection<Byte>) : AudioOutput {
    init {
        Logger.log(this, "ByteAudioOutput", "<init>")
    }

    override fun write(data: AudioData): Boolean {
        Logger.log(this, "ByteAudioOutput", "write", "write")
        collection.apply {
            clear()
            addAll(data.toByteArray().toTypedArray())
        }
        return true
    }

    override fun close() {
        Logger.log(this, "ByteAudioOutput", "close", "close")
    }
}