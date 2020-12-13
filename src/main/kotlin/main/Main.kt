package main

import common.data.AudioData
import common.data.DummyAudioData
import common.logging.Logger
import common.logging.writers.FileLogWriter
import common.processors.ComposableProcessor
import common.processors.SoundProcessor
import common.processors.sequential.sequentialProcessorOf
import common.processors.single.Delay
import common.processors.single.Distortion
import common.processors.single.WahWah
import creational.factory_method.processors.Overdrive
import creational.factory_method.producers.BitCrusherProducer
import creational.factory_method.producers.FlangerProducer
import creational.factory_method.producers.OverdriveProducer
import structural.adapters.toComposable
import structural.adapters.IncompatibleProcessor
import structural.adapters.adaptIncompatibleProcessor
import structural.composites.CompositeProcessor
import structural.composites.Mixer
import structural.decorators.GainFilter
import structural.decorators.PanFilter
import structural.decorators.VolumeFilter
import structural.iterators.IterableProcessor
import structural.iterators.LinearIterableProcessor
import structural.iterators.SingleIterableProcessor

fun main() {
    Logger.wrap(FileLogWriter("factory_method")) {
        factoryMethod()
    }
}

fun factoryMethod() = listOf(BitCrusherProducer(), FlangerProducer(), OverdriveProducer())
        .map { it.produce() }
        .fold(DummyAudioData(byteArrayOf()) as AudioData) { acc, p -> p.process(acc) }