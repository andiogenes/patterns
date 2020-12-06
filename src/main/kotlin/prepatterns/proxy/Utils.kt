package prepatterns.proxy

import common.processors.sequential.SequentialProcessor

/**
 * Создает ограниченный по количеству объектов в цепи обработчик с указанной [вместимостью][capacity].
 */
fun boundedProcessorFrom(processor: SequentialProcessor, capacity: Int = -1): SequentialProcessor =
    BoundedSequentialProcessor(processor, capacity)