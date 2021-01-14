package behavioral.indirection

import behavioral.indirection.observable.Observable
import common.logging.LoggableObject

/**
 * Модель вычислительного узла.
 *
 * Для простоты реализации в лабораторной работе рассматривается только часть модели - внутренние параметры узла.
 */
class ModelNode(paramCount: Int) : Observable<Pair<Int, Float>>() {
    private val log_ = LoggableObject("ModelNode", "Model")

    private val parameters: FloatArray = FloatArray(paramCount)

    /**
     * Устанавливает параметр представления.
     */
    fun setParameter(index: Int, value: Float) {
        log_("setParameter", "Operation")
        parameters[index] = value
        sendMessages(index to value)
    }
}