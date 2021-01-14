package creational.builder

import common.logging.Loggable

/**
 * Узел потока данных.
 */
abstract class Node : Loggable("Node", "Product") {
    /**
     * Внутренние параметры узла.
     */
    abstract val parameters: FloatArray

    /**
     * Заголовки параметров.
     */
    abstract val parameterHeaders: Array<String>

    /**
     * Входящие порты.
     */
    abstract val inPorts: Array<Node?>

    /**
     * Исходящие порты.
     */
    abstract val outPorts: Array<Node?>

    /**
     * Вычислительная работа узла.
     */
    abstract fun action()
}