package main

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
    Logger.wrap(FileLogWriter("object_pool")) {
        entitle("Object pool") {
            objectPool()
        }
    }
    Logger.wrap(FileLogWriter("builder")) {
        entitle("Builder") {
            builder()
        }
    }
}

fun objectPool() {
    val pool = FontPool(5)

    fun ensurePoolIsFull(v: Either<String, PoolFontData>) {
        when (v) {
            is Either.Left -> println(v.value)
            is Either.Right -> {
                println("Pool isn't full, object: ${v.value}")
                pool.releaseFontData(v.value)
            }
        }
    }

    // Пробуем переполнить пул одним объектом
    repeat(10) {
        pool.getFontData(TypeFace("Tahoma", 16f), Font(), Paint())
    }

    // Проверяем, заполнен ли пул, пробуя получить доступ к шрифту
    ensurePoolIsFull(pool.getFontData(TypeFace("Tahoma", 16f), Font(), Paint()))

    // Пробуем переполнить пул уникальными объектами
    val fonts = listOf("a", "b", "c", "d", "e").map {
        pool.getFontData(TypeFace(it, 16f), Font(), Paint())
    }

    // Проверяем, заполнен ли пул, пробуя получить доступ к шрифту
    ensurePoolIsFull(pool.getFontData(TypeFace("Tahoma", 16f), Font(), Paint()))

    // Пробуем удалить объект из пула
    fonts.find {
        it is Either.Right && it.value.typeface.family == "e"
    }.let {
        if (it is Either.Right) pool.releaseFontData(it.value)
    }

    // Проверяем, заполнен ли пул, пробуя получить доступ к шрифту
    ensurePoolIsFull(pool.getFontData(TypeFace("Tahoma", 16f), Font(), Paint()))
}

fun builder() {
    val node = NodeBuilder()
            .setInPorts(100)
            .setOutPorts(200)
            .reset()
            .addParameter("Test", 0.5f)
            .resetParameters()
            .setInPorts(1)
            .setOutPorts(1)
            .addParameter("Volume", 0.5f)
            .addParameter("Gain", 0.6f)
            .addParameter("Tone", 0.7f)
            .setAction { println("Hello, builder!") }
            .getResult()

    node.action()
    println()

    println("In ports count: ${node.inPorts.size}")
    println("Out ports count: ${node.outPorts.size}")
    println()

    println("Parameter headers:")
    node.parameterHeaders.forEach { println(it) }
    println()

    println("Parameters:")
    node.parameters.forEach { println(it) }
}

fun entitle(name: String, block: () -> Unit) {
    println("$name\n${"-".repeat(name.length)}")
    block()
    println()
}