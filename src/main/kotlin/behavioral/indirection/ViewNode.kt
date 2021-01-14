package behavioral.indirection

import common.logging.Loggable

/**
 * Представление вычислительного узла.
 *
 * Для простоты реализации в лабораторной работе рассматривается только часть представления - внутренние параметры узла.
 */
class ViewNode(private val parameterHeaders: List<String>) : Loggable("ViewNode", "View") {
    private val parameters: FloatArray = FloatArray(parameterHeaders.size)

    /**
     * Устанавливает параметр представления.
     */
    fun setParameter(index: Int, value: Float) {
        log("setParameter", "Operation")
        parameters[index] = value
    }

    /**
     * "Отображает" узел.
     */
    fun display() {
        log("display", "Operation")
        parameterHeaders.forEachIndexed { i, s -> println("Parameter $s = ${parameters[i]}") }
        println()
    }
}