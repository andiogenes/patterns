package common.logging.writers

/**
 * [LogWriter] протоколирующий в [System.out].
 */
internal class ConsoleLogWriter : LogWriter {
    override fun log(line: String) {
        println(line)
    }
}