package main

import behavioral.indirection.ModelNode
import behavioral.indirection.NodeBinding
import behavioral.indirection.ViewNode
import common.data.DummyAudioData
import common.logging.Logger
import common.logging.writers.FileLogWriter
import common.utils.Either
import creational.builder.NodeBuilder
import creational.object_pool.FontPool
import creational.object_pool.PoolFontData
import structural.bridge.AsioProcessorImpl
import structural.bridge.NativeProcessor
import structural.bridge.NativeVendorException
import structural.bridge.TraceableNativeProcessor
import structural.facade.Dataflow
import structural.facade.Node
import structural.flyweight.Font
import structural.flyweight.FontDataFactory
import structural.flyweight.Paint
import structural.flyweight.TypeFace

fun main() {
    Logger.wrap(FileLogWriter("indirection")) {
        entitle("Indirection") {
            indirection()
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

fun entitle(name: String, block: () -> Unit) {
    println("$name\n${"-".repeat(name.length)}")
    block()
    println()
}