package delegation.and.proxy.processors

import delegation.and.proxy.logging.Loggable
import delegation.and.proxy.data.AudioData

/**
 * Обработчик, который может объединять [SingleProcessor] в последовательную цепь обработки звука.
 */
class SequentialProcessor(processors: List<SingleProcessor> = listOf()) : ComposableProcessor, Loggable("SequentialProcessor") {
    /**
     * Цепь обработки звука.
     */
    private val _processors = processors.toMutableList()

    override fun process(data: AudioData): AudioData {
        log("process", "process")
        // Обрабатывает звук в последовательности input -> p1 -> p2 -> ... -> pn -> output.
        return _processors.fold(data) { d, p -> p.process(d) }
    }

    /**
     * Добавляет [processor] в конец цепи.
     */
    fun add(processor: SingleProcessor): Boolean {
        log("add", "add")
        return _processors.add(processor)
    }

    /**
     * Удаляет [processor] из цепи.
     */
    fun remove(processor: SoundProcessor): Boolean {
        log("remove", "remove")
        return _processors.remove(processor)
    }
}

