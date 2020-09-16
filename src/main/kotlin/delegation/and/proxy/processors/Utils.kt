package delegation.and.proxy.processors

import delegation.and.proxy.processors.sequential.BoundedSequentialProcessor
import delegation.and.proxy.processors.sequential.LinearSequentialProcessor
import delegation.and.proxy.processors.sequential.SequentialProcessor

/**
 * Создает последовательный обработчик с указанными обработчиками в цепи.
 */
fun sequentialProcessorOf(vararg chain: SingleProcessor): SequentialProcessor =
    LinearSequentialProcessor(chain.toList())

/**
 * Создает ограниченный по количеству объектов в цепи обработчик с указанной [вместимостью][capacity].
 */
fun boundedProcessorFrom(processor: SequentialProcessor, capacity: Int = -1): SequentialProcessor =
    BoundedSequentialProcessor(processor, capacity)