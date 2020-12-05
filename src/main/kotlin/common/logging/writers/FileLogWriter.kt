package common.logging.writers

import java.io.PrintWriter
import java.time.Instant

/**
 * [LogWriter] протоколирующий в файл с именем [fileName].
 */
internal class FileLogWriter(
    /**
     * Префикс лога.
     */
    private val baseName: String = "",
    /**
     * Директория с логами.
     */
    private val baseDir: String = "logs",
    /**
     * Конкретное имя файла, в который идёт протоколирование.
     */
    private val fileName: String = "$baseDir/${baseName}_${Instant.now()}.log"
) : LogWriter {
    private val writer = PrintWriter(fileName, "UTF-8")

    override fun log(line: String) {
        writer.println(line)
        writer.flush()
    }
}