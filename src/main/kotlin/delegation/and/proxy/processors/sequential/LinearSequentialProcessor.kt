package delegation.and.proxy.processors.sequential

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Loggable
import delegation.and.proxy.processors.SingleProcessor

/**
 * Обработчик, который может объединять [SingleProcessor] в __линейную__ последовательную цепь обработки звука.
 */
class LinearSequentialProcessor(processors: List<SingleProcessor> = listOf()) : SequentialProcessor,
    Loggable("SequentialProcessor") {
    /**
     * Цепь обработки звука.
     */
    private val _processors = processors.toMutableList()

    override fun process(data: AudioData): AudioData {
        log("process", "process")
        // Обрабатывает звук в последовательности input -> p1 -> p2 -> ... -> pn -> output.
        return _processors.fold(data) { d, p -> p.process(d) }
    }

    override fun add(processor: SingleProcessor): Boolean {
        log("add", "add")
        return _processors.add(processor)
    }

    override fun remove(processor: SingleProcessor): Boolean {
        log("remove", "remove")
        return _processors.remove(processor)
    }

    override fun getSize(): Int {
        log("getSize", "getSize")
        return _processors.size
    }
}

