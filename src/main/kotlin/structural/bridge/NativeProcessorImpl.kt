package structural.bridge

import common.data.AudioData
import common.logging.LoggableObject
import common.processors.SoundProcessor

/**
 * Интерфейс реализации платформо-зависимого обработчика.
 */
abstract class NativeProcessorImpl : SoundProcessor {
    private val log = LoggableObject("NativeProcessorImpl", "Implementor")

    final override fun process(data: AudioData): AudioData {
        log("process", "operationImpl")
        return processImpl(data)
    }

    /**
     * Обрабатывает звук платформо-зависимыми инструментами.
     */
    protected abstract fun processImpl(data: AudioData): AudioData
}