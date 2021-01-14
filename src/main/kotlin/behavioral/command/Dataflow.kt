package behavioral.command

import common.logging.Loggable

/**
 * Поток данных.
 */
class Dataflow<T> : Loggable("Dataflow", "Facade, Invoker") {
    /**
     * Узлы потока данных.
     */
    private val nodes: ArrayList<Node<T>> = arrayListOf()

    /**
     * Добавляет узел в поток данных.
     */
    fun add(node: Node<T>): Boolean {
        log("add", "FacadeEndpoint")
        return nodes.add(node)
    }

    /**
     * Удаляет узел из потока данных.
     */
    fun remove(node: Node<T>): Boolean {
        log("remove", "FacadeEndpoint")
        // Удаляем связи с узлом
        node.`in`.forEach { it?.out?.forEachIndexed { index, v -> if (v == node) it.out[index] = null  } }
        node.`out`.forEach { it?.`in`?.forEachIndexed { index, v -> if (v == node) it.`in`[index] = null  } }
        return nodes.remove(node)
    }

    /**
     * Ищет источник потока - узел без входящих портов.
     */
    fun findSource(): Node<T> {
        log("findSource", "FacadeEndpoint")
        return nodes.first { it.`in`.isEmpty() }
    }

    /**
     * Ищет сток потока - узел без выходящих портов.
     */
    fun findSink(): Node<T> {
        log("findSink", "FacadeEndpoint")
        return nodes.first { it.out.isEmpty() }
    }

    /**
     * Соединяет узлы по заданной стратегии.
     */
    fun connect(strategy: ((Node<T>, Int, Node<T>, Int) -> Unit) -> Unit) {
        log("connect", "FacadeEndpoint")
        strategy { src: Node<T>, outPort: Int, dst: Node<T>, inPort: Int ->
            src.connectRight(outPort, dst, inPort)
        }
    }

    /**
     * Строит цепь обработки данных - функцию, которая принимает данные из источника потока,
     * последовательно обрабатывает данные во всех узлах и возвращает обработанные данные.
     */
    fun makePipeline(): (List<T>) -> T {
        log("makePipeline", "FacadeEndpoint")

        val pipeline = arrayListOf<(List<T>) -> T>()

        var curNode: Node<T>? = findSource()
        while (curNode != null) {
            pipeline.add(curNode.operation)
            if (curNode.out.isEmpty()) break
            curNode = curNode.out.first()
        }

        return pipeline.reduce { acc, function -> { v: List<T> -> function(listOf(acc(v))) } }
    }
}