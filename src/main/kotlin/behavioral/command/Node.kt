package behavioral.command

import common.logging.Loggable

/**
 * Узел потока данных.
 */
class Node<A>(
        /**
         * Мощность входящих портов.
         */
        inCapacity: Int,
        /**
         * Мощность выходящих портов.
         */
        outCapacity: Int = 1,
        /**
         * Вычислительная работа узла.
         */
        operation: (List<A>) -> A,
) : Loggable("Node", "Command") {

    /**
     * Вычислительная работа узла.
     */
    val operation: (List<A>) -> A = {
        log("operation", "execute")
        operation(it)
    }

    /**
     * Входящие порты.
     */
    val `in`: Array<Node<A>?> = Array(inCapacity) { null }

    /**
     * Выходящие порты.
     */
    val out: Array<Node<A>?> = Array(outCapacity) { null }

    /**
     * Соединяет входящий порт [inPort] узла с выходящим портом [outPort] узла [source].
     */
    fun connectLeft(inPort: Int, source: Node<A>, outPort: Int) {
        log("connectLeft", "operation")
        `in`[inPort] = source
        source.out[outPort] = this
    }

    /**
     * Соединяет выходящий порт [outPort] узла с входящим портом [inPort] узла [destination].
     */
    fun connectRight(outPort: Int, destination: Node<A>, inPort: Int) {
        log("connectRight", "operation")
        out[outPort] = destination
        destination.`in`[inPort] = this
    }
}