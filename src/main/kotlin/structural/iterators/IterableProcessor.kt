package structural.iterators

import common.processors.SoundProcessor

/**
 * [SoundProcessor] с итератором.
 */
interface IterableProcessor : SoundProcessor {
    /**
     * Возвращает итератор по [SoundProcessor].
     */
    fun iterator(): Iterator<SoundProcessor?>
}