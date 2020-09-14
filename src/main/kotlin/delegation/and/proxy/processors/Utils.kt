package delegation.and.proxy.processors

/**
 * Создает последовательный обработчик с указанными обработчиками в цепи.
 */
fun sequentialProcessorOf(vararg chain: SingleProcessor) =
    SequentialProcessor(chain.toList())