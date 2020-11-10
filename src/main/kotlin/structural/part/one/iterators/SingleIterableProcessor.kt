package structural.part.one.iterators

import delegation.and.proxy.data.AudioData
import delegation.and.proxy.logging.Loggable
import delegation.and.proxy.processors.SingleProcessor
import delegation.and.proxy.processors.SoundProcessor

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