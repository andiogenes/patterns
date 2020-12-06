package structural.composites

import common.data.AudioData
import common.logging.LoggableObject
import common.processors.ComposableProcessor
import java.lang.IllegalArgumentException

/**
 * Обработчик-компоновщик.
 *
 * Все компоновщики [ComposableProcessor] должны наследоваться от этого класса.
 */
open class CompositeProcessor : ComposableProcessor {
    private val log = LoggableObject("CompositeProcessor", "composite (base)")

    /**
     * Список компонентов обработчика.
     */
    private val children = mutableListOf<ComposableProcessor>()

    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        // Обрабатывает звук в последовательности input -> c1 -> c2 -> ... -> cn -> output.
        // В отличие от SequentialProcessor, умеет работать с вложенными компоновщиками.
        return children.fold(data) { d, p -> p.process(d) }
    }

    /**
     * Добавляет компонент-обработчик [child] в компоновщик.
     */
    open fun addChild(child: ComposableProcessor): ComposableProcessor {
        log("addChild", "add")
        if (child == this) throw IllegalArgumentException("composite must not contain itself")
        children.add(child)
        return child
    }

    /**
     * Удаляет [child] из компонентов.
     */
    open fun removeChild(child: ComposableProcessor): ComposableProcessor {
        log("removeChild", "remove")
        children.remove(child)
        return child
    }
}