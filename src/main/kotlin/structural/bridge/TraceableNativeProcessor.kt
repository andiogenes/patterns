package structural.bridge

import common.data.AudioData
import common.logging.LoggableObject

/**
 * Трассируемый нативный обработчик.
 *
 * Его назначение - пытаться преобразовывать SEGFAULT'ы нативного кода в stack trace виртуальной машины Java.
 *
 * В данной работе преобразовывает ошибки, которые должен бросать JNI-код в стандартные исключения.
 */
class TraceableNativeProcessor(
    /**
     * Реализация обработчика.
     */
    impl: NativeProcessorImpl = LibsoundioProcessorImpl()
) : NativeProcessor(impl) {
    private val log_ = LoggableObject("TraceableNativeProcessor", "RefinedAbstraction")

    override fun process(data: AudioData): AudioData {
        log_("process", "operation")
        return try {
            super.process(data)
        } catch (e: NativeVendorException) {
            throw SecurityException("${e.error}")
        }
    }
}