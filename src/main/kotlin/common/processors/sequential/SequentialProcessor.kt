package common.processors.sequential

import common.processors.ComposableProcessor
import common.processors.SingleProcessor

/**
 * Обработчик, который может объединять [SingleProcessor] в __какую-либо__ цепь обработки звука.
 */
interface SequentialProcessor : ComposableProcessor {
    /**
     * Получает количество обработчиков в цепи.
     */
    fun getSize(): Int

    /**
     * Добавляет [processor] в конец цепи.
     */
    fun add(processor: SingleProcessor): Boolean

    /**
     * Удаляет [processor] из цепи.
     */
    fun remove(processor: SingleProcessor): Boolean
}