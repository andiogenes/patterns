package delegation.and.proxy.io

import delegation.and.proxy.logging.Loggable
import delegation.and.proxy.data.AudioData
import java.io.File
import java.io.FileOutputStream

/**
 * Выходной поток, записывающий информацию в файл.
 */
class FileAudioOutput(private val path: String) : AudioOutput, Loggable("FileAudioOutput") {
    private val writer by lazy {
        FileOutputStream(File(path))
    }

    override fun write(data: AudioData): Boolean {
        log("write", "write")
        val content = arrayListOf<Byte>()
        with(ByteAudioOutput(content)) {
            write(data)
            close()
        }
        writer.write(content.toByteArray())
        return true
    }

    override fun close() {
        log("close", "close")
        writer.close()
    }
}