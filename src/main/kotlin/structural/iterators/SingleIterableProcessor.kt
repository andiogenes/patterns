package structural.iterators

import common.data.AudioData
import common.logging.Loggable
import common.processors.SingleProcessor
import common.processors.SoundProcessor

/**
 * [SingleProcessor] с итератором.
 */
class SingleIterableProcessor(private val processor: SingleProcessor) :
    IterableProcessor, SoundProcessor, Loggable("SingleIterableProcessor", "aggregate (concrete)") {

    override fun iterator(): Iterator<SoundProcessor?> {
        log("iterator", "iterator")
        return object :
            Iterator<SoundProcessor?>,
            Loggable("SingleIterableProcessor\$Iterator<*>", "iterator (concrete)") {
            private var isTraversed = false

            override fun first(): SoundProcessor? {
                log("first", "First")
                isTraversed = false
                return processor
            }

            override fun currentItem(): SoundProcessor? {
                log("currentItem", "CurrentItem")
                return processor
            }

            override fun next(): SoundProcessor? {
                log("next", "Next")
                isTraversed = true
                return null
            }

            override fun isDone(): Boolean {
                log("isDone", "IsDone")
                return isTraversed
            }
        }
    }

    override fun process(data: AudioData): AudioData {
        log("process", "process")
        return processor.process(data)
    }
}