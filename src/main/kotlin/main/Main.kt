package main

import behavioral.command.Dataflow
import behavioral.command.Node
import behavioral.indirection.ModelNode
import behavioral.indirection.NodeBinding
import behavioral.indirection.ViewNode
import common.logging.Logger
import common.logging.writers.FileLogWriter

fun main() {
    Logger.wrap(FileLogWriter("indirection")) {
        entitle("Indirection") {
            indirection()
        }
    }
    Logger.wrap(FileLogWriter("command")) {
        entitle("Command") {
            command()
        }
    }
}

fun indirection() {
    val parameterHeaders = listOf(
            "Volume",
            "Tone",
            "Gain"
    )

    val model = ModelNode(parameterHeaders.size)
    val view = ViewNode(parameterHeaders)

    val binding = NodeBinding(model, view)

    model.setParameter(0, 0.45f)
    model.setParameter(1, 0.75f)
    model.setParameter(2, 0.9f)
}

fun command() {
    val dataFlow = Dataflow<String>()

    val input = Node<String>(0, 1) {
        "Input".also { println(it) }
    }.also { dataFlow.add(it) }

    val output = Node<String>(1, 0) {
        "Output".also { println(it) }
    }.also { dataFlow.add(it) }

    val distortion = Node<String>(1, 1) {
        "Distortion".also { println(it) }
    }.also { dataFlow.add(it) }

    val delay = Node<String>(1, 1) {
        "Delay".also { println(it) }
    }.also { dataFlow.add(it) }

    dataFlow.connect { connector ->
        connector(input, 0, distortion, 0)
        connector(distortion, 0, delay, 0)
        connector(delay, 0, output, 0)
    }

    dataFlow.makePipeline()(listOf())
}

fun entitle(name: String, block: () -> Unit) {
    println("$name\n${"-".repeat(name.length)}")
    block()
    println()
}