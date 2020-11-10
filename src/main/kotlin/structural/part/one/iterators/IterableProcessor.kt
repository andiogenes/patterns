package structural.part.one.iterators

import delegation.and.proxy.processors.SoundProcessor

interface IterableProcessor : SoundProcessor {
    fun iterator() : Iterator<SoundProcessor?>
}