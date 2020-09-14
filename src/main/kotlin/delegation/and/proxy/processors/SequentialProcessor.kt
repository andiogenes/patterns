package delegation.and.proxy.processors

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Logger

/**
 * Обработчик, который может объединять [SingleProcessor] в последовательную цепь обработки звука.
 */
class SequentialProcessor(processors: List<SingleProcessor> = listOf()) : ComposableProcessor {
    init {
        Logger.log(this, "SequentialProcessor", "<init>")
    }

    /**
     * Цепь обработки звука.
     */
    private val _processors = processors.toMutableList()

    override fun process(data: AudioData): AudioData {
        Logger.log(this, "SequentialProcessor", "process", "process")
        // Обрабатывает звук в последовательности input -> p1 -> p2 -> ... -> pn -> output.
        return _processors.fold(data) { d, p -> p.process(d) }
    }

    /**
     * Добавляет [processor] в конец цепи.
     */
    fun add(processor: SingleProcessor): Boolean {
        Logger.log(this, "SequentialProcessor", "add", "add")
        return _processors.add(processor)
    }

    /**
     * Удаляет [processor] из цепи.
     */
    fun remove(processor: SoundProcessor): Boolean {
        Logger.log(this, "SequentialProcessor", "remove", "remove")
        return _processors.remove(processor)
    }
}

