package creational.builder

import common.logging.Loggable

/**
 * Строитель узлов потока данных.
 */
class NodeBuilder : Loggable("NodeBuiler", "Builder") {
    /**
     * Параметры строимого узла.
     */
    private val parameters = arrayListOf<Pair<String, Float>>()

    /**
     * Количество входящих портов.
     */
    private var inPortsCount = 0

    /**
     * Количество исходящих портов.
     */
    private var outPortsCount = 0

    /**
     * Вычислительное действие строимого узла.
     */
    private var action = {}

    /**
     * Устанавливает количество входящих портов.
     */
    fun setInPorts(count: Int): NodeBuilder {
        log("setInPorts", "BuildPart")
        inPortsCount = count
        return this
    }

    /**
     * Устанавливает количество исходящих портов.
     */
    fun setOutPorts(count: Int): NodeBuilder {
        log("setOutPorts", "BuildPart")
        outPortsCount = count
        return this
    }

    /**
     * Сбрасывает состояние строителя.
     */
    fun reset(): NodeBuilder {
        log("reset", "BuildPart")
        parameters.clear()
        inPortsCount = 0
        outPortsCount = 0
        action = {}
        return this
    }

    /**
     * Сбрасывает параметры строимого узла.
     */
    fun resetParameters(): NodeBuilder {
        log("resetParameters", "BuildPart")
        parameters.clear()
        return this
    }

    /**
     * Добавляет параметр узла.
     */
    fun addParameter(header: String, value: Float): NodeBuilder {
        log("addParameter", "BuildPart")
        parameters.add(header to value)
        return this
    }

    /**
     * Устанавливает вычислительное действие.
     */
    fun setAction(action: () -> Unit): NodeBuilder {
        log("setAction", "BuildPart")
        this.action = action
        return this
    }

    /**
     * Получает результат - узел потока данных.
     */
    fun getResult(): Node {
        log("getResult", "GetResult")
        return object : Node() {
            private val internalParameterHeaders = this@NodeBuilder.parameters.map { it.first }.toTypedArray()
            private val internalParameters = this@NodeBuilder.parameters.map { it.second }.toFloatArray()
            private val internalInPorts = Array<Node?>(this@NodeBuilder.inPortsCount) { null }
            private val internalOutPorts = Array<Node?>(this@NodeBuilder.outPortsCount) { null }

            override val parameters: FloatArray
                get() = internalParameters
            override val parameterHeaders: Array<String>
                get() = internalParameterHeaders
            override val inPorts: Array<Node?>
                get() = internalInPorts
            override val outPorts: Array<Node?>
                get() = internalOutPorts

            override fun action() {
                this@NodeBuilder.action()
            }
        }
    }
}