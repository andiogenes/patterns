package main

import prepatterns.delegation.FileAudioInput
import prepatterns.delegation.FileAudioOutput
import common.logging.Logger
import common.logging.writers.ConsoleLogWriter
import common.processors.single.Delay
import common.processors.single.Distortion
import common.processors.single.WahWah
import structural.decorators.GainFilter
import structural.decorators.PanFilter
import structural.decorators.VolumeFilter
import structural.iterators.LinearIterableProcessor

fun main() {
    // Инициализация логгера
    Logger.setWriters(
        ConsoleLogWriter(),
    )

    // Путь до файла со входными данными
    val sourcePath = "data/test.music"
    // Путь до файла, в который будут помещены выходные данные
    val destinationPath = "data/processed.test.music"

    // Получение звукового сигнала
    val data = with(FileAudioInput(sourcePath)) {
        val data = read()
        close()
        data
    }

    // Пример работы итератора
    val iterableProcessor = LinearIterableProcessor(
        listOf(
            Distortion(),
            Delay(),
            WahWah(),
        )
    ).apply {
        val it = iterator()
        println("first item: ${it.first()}")

        while (!it.isDone()) {
            println("current item: ${it.next()}")
        }

        println("last item: ${it.currentItem()}")
    }

    // Пример декорирования объектов
    val decoratedProcessor = PanFilter(
        GainFilter(
            VolumeFilter(iterableProcessor).apply {
                volume = 10
            }
        ).apply {
            gain = 20
        }
    ).apply {
        balance = 75
    }
    val processedData = decoratedProcessor.process(data)

    // Запись обработанного звукового сигнала в файл
    with(FileAudioOutput(destinationPath)) {
        write(processedData)
        close()
    }
}