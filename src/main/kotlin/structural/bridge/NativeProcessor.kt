package structural.bridge

import common.data.AudioData
import common.logging.Loggable
import common.processors.SoundProcessor

/**
 * Абстракция над платфорно-зависимыми реализациями обработчиков.
 */
open class NativeProcessor(
    /**
     * Реализация обработчика.
     */
    private val impl: NativeProcessorImpl = LibsoundioProcessorImpl()
) : SoundProcessor, Loggable("NativeProcessor", "Abstraction") {
    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return impl.process(data)
    }
}