package delegation.and.proxy.io

import delegation.and.proxy.logging.Loggable
import delegation.and.proxy.data.AudioData
import java.io.File
import java.nio.file.Files

/**
 * Входной поток, читающий звуковую информацию из файла.
 */
class FileAudioInput(private val path: String) : AudioInput, Loggable("FileAudioInput") {
    override fun read(): AudioData {
        log("read", "read")
        val bytes = Files.readAllBytes(File(path).toPath())
        return with(ByteAudioInput(bytes)) {
            val data = read()
            close()
            data
        }
    }

    override fun close() {
        log("close", "close")
    }
}