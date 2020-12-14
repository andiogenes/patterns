package main

import common.data.AudioData
import common.data.DummyAudioData
import common.logging.Logger
import common.logging.writers.FileLogWriter
import common.processors.single.Delay
import common.processors.single.Distortion
import common.processors.single.WahWah
import creational.abstract_factory.ModularProcessor
import creational.abstract_factory.providers.FenderProvider
import creational.abstract_factory.providers.ModuleProvider
import creational.abstract_factory.providers.VoxProvider
import creational.factory_method.producers.BitCrusherProducer
import creational.factory_method.producers.FlangerProducer
import creational.factory_method.producers.OverdriveProducer
import creational.prototype.components.InputBox
import creational.prototype.components.Label
import creational.prototype.components.Slider
import creational.prototype.components.Switch
import creational.prototype.view_models.InputViewModel
import creational.prototype.view_models.NodeViewModel
import creational.prototype.view_models.OutputViewModel

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
    Logger.wrap(FileLogWriter("prototype")) {
        prototype()
    }
}

fun factoryMethod() = listOf(BitCrusherProducer(), FlangerProducer(), OverdriveProducer())
        .map { it.produce() }
        .fold(DummyAudioData(byteArrayOf()) as AudioData) { acc, p -> p.process(acc) }

fun abstractFactory(provider: ModuleProvider) = ModularProcessor(provider).process(DummyAudioData(byteArrayOf()))

fun prototype() {
    val input = InputViewModel(Label(), Slider()).apply {
        x = 10
        y = 120
    }
    val node1 = NodeViewModel(arrayOf(input), InputBox(), Slider()).apply {
        x = 50
        y = 120
    }
    val node2 = (node1.clone() as NodeViewModel).apply {
        x += 40
        inputs[0] = node1
    }
    val output = OutputViewModel(node2, Slider(), Switch()).apply {
        x = 240
        y = 120
    }

    println("input: $input")
    println("node1: $node1")
    println("node2: $node2")
    println("output: $output")
}