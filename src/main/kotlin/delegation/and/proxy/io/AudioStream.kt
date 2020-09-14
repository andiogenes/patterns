package delegation.and.proxy.io

/**
 * Поток, через который передаются звуковые данные.
 */
interface AudioStream {
    /**
     * Закрывает поток для чтения-записи и освобождает ресурсы.
     */
    fun close()
}