package delegation.and.proxy.io

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Logger
import java.io.File
import java.io.FileOutputStream

/**
 * Выходной поток, записывающий информацию в файл.
 */
class FileAudioOutput(private val path: String) : AudioOutput {
    init {
        Logger.log(this, "FileAudioOutput", "<init>")
    }

    private val writer by lazy {
        FileOutputStream(File(path))
    }

    override fun write(data: AudioData): Boolean {
        Logger.log(this, "FileAudioOutput", "write", "write")
        val content = arrayListOf<Byte>()
        with(ByteAudioOutput(content)) {
            write(data)
            close()
        }
        writer.write(content.toByteArray())
        return true
    }

    override fun close() {
        Logger.log(this, "FileAudioOutput", "close", "close")
        writer.close()
    }
}