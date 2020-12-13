package main

import common.data.AudioData
import common.data.DummyAudioData
import common.logging.Logger
import common.logging.writers.FileLogWriter
import creational.abstract_factory.ModularProcessor
import creational.abstract_factory.providers.FenderProvider
import creational.abstract_factory.providers.ModuleProvider
import creational.abstract_factory.providers.VoxProvider
import creational.factory_method.producers.BitCrusherProducer
import creational.factory_method.producers.FlangerProducer
import creational.factory_method.producers.OverdriveProducer

fun main() {
    Logger.wrap(FileLogWriter("factory_method")) {
        factoryMethod()
    }
    Logger.wrap(FileLogWriter("abstract_factory_1")) {
        abstractFactory(FenderProvider())
    }
    Logger.wrap(FileLogWriter("abstract_factory_2")) {
        abstractFactory(VoxProvider())
    }
}

fun factoryMethod() = listOf(BitCrusherProducer(), FlangerProducer(), OverdriveProducer())
        .map { it.produce() }
        .fold(DummyAudioData(byteArrayOf()) as AudioData) { acc, p -> p.process(acc) }

fun abstractFactory(provider: ModuleProvider) = ModularProcessor(provider).process(DummyAudioData(byteArrayOf()))