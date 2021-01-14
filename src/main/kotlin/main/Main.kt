package main

import behavioral.command.Dataflow
import behavioral.command.Node
import behavioral.indirection.ModelNode
import behavioral.indirection.NodeBinding
import behavioral.indirection.ViewNode
import behavioral.visitor.CountByTypeVisitor
import behavioral.visitor.FormattedPrintVisitor
import behavioral.visitor.SoundEndpoint
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
    Logger.wrap(FileLogWriter("visitor")) {
        entitle("visitor") {
            visitor()
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

fun visitor() {
    val input1 = SoundEndpoint.Input("Input 1")
    val input2 = SoundEndpoint.Input("Input 2", 0.5f)

    val output1 = SoundEndpoint.Output("Output 1")
    val output2 = SoundEndpoint.Output("Output 2", 2f)

    val regularNames = listOf("Distortion", "WahWah", "Delay", "Reverb", "Flanger")

    val regular1 = regularNames.map { SoundEndpoint.Regular(it) }.also {
        it.first().from = input1
        it.last().to = output1
    }
    regular1.zipWithNext().forEach { (l, r) ->
        l.to = r
        r.from = r
    }

    val regular2 = regularNames.map { SoundEndpoint.Regular(it) }.also {
        it.first().from = input2
        it.last().to = output2
    }
    regular2.zipWithNext().forEach { (l, r) ->
        l.to = r
        r.from = r
    }

    // Список с элементами для обхода
    val traverseList = listOf(input1, input2, output1, output2) + regular1 + regular2

    // Посетитель, подсчитывающий количество элементов определенного типа
    val countByTypeVisitor = CountByTypeVisitor()

    traverseList.forEach { it.accept(countByTypeVisitor) }

    println("Endpoints by type:")
    countByTypeVisitor.counts.forEach { (k, v) -> println("$k\t$v") }
    println()

    // Посетитель, выводящий информацию об элементах
    val formattedPrintVisitor = FormattedPrintVisitor()

    traverseList.forEach { it.accept(formattedPrintVisitor) }
}

fun entitle(name: String, block: () -> Unit) {
    println("$name\n${"-".repeat(name.length)}")
    block()
    println()
}