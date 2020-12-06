package introduction.delegation

import common.logging.Loggable
import common.data.AudioData
import common.io.AudioOutput
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