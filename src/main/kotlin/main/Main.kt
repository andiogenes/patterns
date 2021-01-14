package main

import common.data.DummyAudioData
import common.logging.Logger
import common.logging.writers.FileLogWriter
import common.utils.Either
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

fun entitle(name: String, block: () -> Unit) {
    println("$name\n${"-".repeat(name.length)}")
    block()
    println()
}