package main

import common.data.DummyAudioData
import common.logging.Logger
import common.logging.writers.FileLogWriter
import structural.bridge.AsioProcessorImpl
import structural.bridge.NativeProcessor
import structural.bridge.NativeVendorException
import structural.bridge.TraceableNativeProcessor

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

fun entitle(name: String, block: () -> Unit) {
    println("$name\n${"-".repeat(name.length)}")
    block()
    println()
}