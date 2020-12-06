package common.processors.sequential

import common.processors.SingleProcessor

/**
 * Создает последовательный обработчик с указанными обработчиками в цепи.
 */
fun sequentialProcessorOf(vararg chain: SingleProcessor): SequentialProcessor =
    LinearSequentialProcessor(chain.toList())