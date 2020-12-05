package common.logging.writers

/**
 * Интерфейс записи логов по назначению.
 */
interface LogWriter {
    /**
     * Записывает [line] в указанный в реализации ресурс.
     */
    fun log(line: String)
}
