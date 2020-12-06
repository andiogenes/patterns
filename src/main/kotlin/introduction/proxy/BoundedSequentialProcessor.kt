package introduction.proxy

import common.data.AudioData
import common.logging.Loggable
import common.processors.SingleProcessor
import common.processors.sequential.SequentialProcessor

/**
 * Последовательный обработчик, который имеет [ограничение][capacity] на количество обработчиков в цепи.
 *
 * Если [capacity] < 0, обработчик считается не ограниченным по вместимости.
 */
class BoundedSequentialProcessor(private val subject: SequentialProcessor, private val capacity: Int = -1) :
    SequentialProcessor, Loggable("BoundedSequentialProcessor") {
    override fun getSize(): Int {
        log("getSize", "getSize")
        return subject.getSize()
    }

    override fun process(data: AudioData): AudioData {
        log("process", "process")
        return subject.process(data)
    }

    /**
     * Добавляет [processor] в цепь, если в цепи меньше [capacity] обработчиков.
     */
    override fun add(processor: SingleProcessor): Boolean {
        log("add", "add")
        if (capacity < 0 || subject.getSize() < capacity) {
            return subject.add(processor)
        }
        return false
    }

    override fun remove(processor: SingleProcessor): Boolean {
        log("remove", "remove")
        return subject.remove(processor)
    }
}