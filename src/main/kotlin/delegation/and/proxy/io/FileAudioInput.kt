package delegation.and.proxy.io

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Logger
import java.io.File
import java.nio.file.Files

/**
 * Входной поток, читающий звуковую информацию из файла.
 */
class FileAudioInput(private val path: String) : AudioInput {
    init {
        Logger.log(this, "FileAudioInput", "<init>")
    }

    override fun read(): AudioData {
        Logger.log(this, "FileAudioInput", "read", "read")
        val data = Files.readAllBytes(File(path).toPath())
        return ByteAudioInput(data).read()
    }

    override fun close() {
        Logger.log(this, "FileAudioInput", "close", "close")
    }
}