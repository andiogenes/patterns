package delegation.and.proxy.proxy

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Logger
import delegation.and.proxy.processors.SingleProcessor

/**
 * Обёртка над [SingleProcessor], автоматически протоколирующая вызовы методов.
 */
class AutoLoggedProcessor(private val processor: SingleProcessor, private val role: String): SingleProcessor {
    private val proxyRole = "AutoLoggedProcessor (Proxy)"

    init {
        val method = "<init>"
        // Здесь лог замещаемого объекта идет выше, так как он создается раньше.
        Logger.log(processor, role, method)
        Logger.log(this, proxyRole, method)
    }

    override fun process(data: AudioData): AudioData {
        // Логгирование информации о прокси и замещаем объекте.
        val method = "process"
        Logger.log(this, proxyRole, method, method)
        Logger.log(processor, role, method, method)

        // Выполнение функций замещаемого объекта
        return processor.process(data)
    }
}