package main

import common.data.DummyAudioData
import common.logging.Logger
import common.logging.writers.FileLogWriter
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
    Logger.wrap(FileLogWriter("bridge_1")) {
        entitle("Bridge #1") {
            bridge(NativeProcessor())
            bridge(TraceableNativeProcessor())
        }
    }
    Logger.wrap(FileLogWriter("bridge_2")) {
        entitle("Bridge #2") {
            bridge(NativeProcessor(AsioProcessorImpl()))
            bridge(TraceableNativeProcessor(AsioProcessorImpl()))
        }
    }
    Logger.wrap(FileLogWriter("facade")) {
        entitle("Facade") {
            facade()
        }
    }
    Logger.wrap(FileLogWriter("flyweight")) {
        entitle("Flyweight") {
            flyweight()
        }
    }
}

fun bridge(abstraction: NativeProcessor) {
    try {
        abstraction.process(DummyAudioData(byteArrayOf()))
    } catch (e: SecurityException) {
        System.err.println(e.message)
    } catch (e: NativeVendorException) {
        System.err.println("A JNI error has occurred, please check your installation and try again")
    }
}

fun facade() {
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

fun flyweight() {
   val fontDataFactory = FontDataFactory()

    val font1 = fontDataFactory.getFontData(TypeFace("Tahoma", 16f), Font(), Paint())
    val font2 = fontDataFactory.getFontData(TypeFace("Tahoma", 16f), Font(), Paint())
    val font3 = fontDataFactory.getFontData(TypeFace("Tahoma", 14f), Font(), Paint())
    val font4 = fontDataFactory.getFontData(TypeFace("Verdana", 16f), Font(), Paint())

    println("font 1: $font1")
    println("font 2: $font2")
    println("font 3: $font3")
    println("font 4: $font4")
    println()

    println("font1 == font2: ${font1 == font2}")
    println("font2 == font3: ${font2 == font3}")
    println("font1 == font4: ${font1 == font4}")
}

fun entitle(name: String, block: () -> Unit) {
    println("$name\n${"-".repeat(name.length)}")
    block()
    println()
}