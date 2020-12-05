package prepatterns.delegation

import common.logging.Loggable
import common.data.AudioData
import common.io.AudioInput
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