package structural.iterators

import common.data.AudioData
import common.logging.Loggable
import common.processors.SingleProcessor
import common.processors.SoundProcessor
import common.processors.sequential.LinearSequentialProcessor

/**
 * [LinearSequentialProcessor] с итератором.
 */
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
                curPos = 0
                return processors.getOrNull(curPos) ?: processors.last()
            }

            override fun currentItem(): SoundProcessor? {
                log("currentItem", "CurrentItem")
                return processors.getOrNull(curPos) ?: processors.last()
            }

            override fun next(): SoundProcessor? {
                log("next", "Next")
                if (curPos < processors.size) ++curPos
                return processors.getOrNull(curPos)
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