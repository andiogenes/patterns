package structural.part.one.iterators

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Loggable
import delegation.and.proxy.processors.SingleProcessor
import delegation.and.proxy.processors.SoundProcessor
import delegation.and.proxy.processors.sequential.LinearSequentialProcessor

class LinearIterableProcessor(private val processors: List<SingleProcessor> = listOf()) :
    IterableProcessor, SoundProcessor, Loggable("LinearIterableProcessor", "aggregate (concrete)") {
    private val linearProcessor = LinearSequentialProcessor(processors)

    override fun iterator(): Iterator<SoundProcessor?> {
        log("iterator", "iterator")
        return object :
            Iterator<SoundProcessor?>,
            Loggable("LinearIterableProcessor\$Iterator<*>", "iterator (concrete)") {
            private var curPos = 0

            override fun first(): SoundProcessor? {
                log("first", "First")
                return processors.firstOrNull()
            }

            override fun currentItem(): SoundProcessor? {
                log("currentItem", "CurrentItem")
                return if (curPos < processors.size) processors[curPos] else processors.last()
            }

            override fun next(): SoundProcessor? {
                log("next", "Next")
                if (curPos < processors.size) ++curPos
                return currentItem()
            }

            override fun isDone(): Boolean {
                log("isDone", "IsDone")
                return curPos >= processors.size
            }
        }
    }

    override fun process(data: AudioData): AudioData {
        log("process", "process")
        return linearProcessor.process(data)
    }
}