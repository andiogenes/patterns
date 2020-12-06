package main

import common.data.DummyAudioData
import common.logging.Logger
import common.logging.writers.FileLogWriter
import common.processors.ComposableProcessor
import common.processors.SoundProcessor
import common.processors.sequential.sequentialProcessorOf
import common.processors.single.Delay
import common.processors.single.Distortion
import common.processors.single.WahWah
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
    Logger.wrap(FileLogWriter("decorators_1")) {
        decorators(Distortion())
    }
    Logger.wrap(FileLogWriter("decorators_2")) {
        decorators(
            sequentialProcessorOf(
                Distortion(),
                Delay(),
                WahWah()
            )
        )
    }

    Logger.wrap(FileLogWriter("iterators_1")) {
        iterators(
            LinearIterableProcessor(
                listOf(
                    Distortion(),
                    Delay(),
                    WahWah(),
                )
            )
        )
    }
    Logger.wrap(FileLogWriter("iterators_2")) {
        iterators(SingleIterableProcessor(Distortion()))
    }

    Logger.wrap(FileLogWriter("composites")) {
        composites(CompositeProcessor().apply {
            addChild(
                Mixer(
                    CompositeProcessor().apply {
                        addChild(Distortion().toComposable())
                        addChild(Delay().toComposable())
                    },
                    CompositeProcessor().apply {
                        addChild(WahWah().toComposable())
                        addChild(Delay().toComposable())
                    },
                    0.6
                )
            )
            addChild(Distortion().toComposable())
        })
    }

    Logger.wrap(FileLogWriter("adapters")) {
        adapters()
    }
}

/**
 * Пример декорирования объектов.
 *
 * [processor] последовательно декорируется [VolumeFilter], [GainFilter], [PanFilter].
 */
fun decorators(processor: SoundProcessor) {
    val decoratedProcessor = PanFilter(
        GainFilter(
            VolumeFilter(processor).apply {
                volume = 10
            }
        ).apply {
            gain = 20
        }
    ).apply {
        balance = 75
    }
    decoratedProcessor.process(DummyAudioData(byteArrayOf()))

}

/**
 * Пример работы итератора.
 *
 * Форматированный вывод всех обработчиков, которые содержит один обработчик.
 */
fun iterators(iterableProcessor: IterableProcessor) {
    val representation = mutableListOf<String>()

    iterableProcessor.apply {
        val it = iterator()

        while (!it.isDone()) {
            representation.add(it.currentItem()?.javaClass?.simpleName ?: "")
            it.next()
        }
    }

    println("Обработчик типа ${iterableProcessor.javaClass.simpleName} содержит следующие обработчики:")
    println(representation.joinToString("\n") { "* $it" })
}

/**
 * Пример работы итератора.
 *
 * Обрабатывает "звук" через цепь обработчиков [composableProcessor].
 */
fun composites(composableProcessor: ComposableProcessor) {
    composableProcessor.process(DummyAudioData(byteArrayOf()))
}

/**
 * Пример работы адаптера.
 *
 * Пример приведения [SoundProcessor] к [CompositeProcessor];
 * Пример приведения [IncompatibleProcessor] к [SoundProcessor].
 */
fun adapters() {
    with(CompositeProcessor()) {
        addChild(Distortion().toComposable())
        addChild(adaptIncompatibleProcessor().toComposable())
        process(DummyAudioData(byteArrayOf()))
    }
}