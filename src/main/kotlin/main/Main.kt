package main

import delegation.and.proxy.io.FileAudioInput
import delegation.and.proxy.io.FileAudioOutput
import delegation.and.proxy.logging.Logger
import delegation.and.proxy.logging.writers.ConsoleLogWriter
import delegation.and.proxy.processors.boundedProcessorFrom
import delegation.and.proxy.processors.sequentialProcessorOf
import delegation.and.proxy.processors.single.*

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

    // Обработка звука
    val delay = Delay()
    val processor = sequentialProcessorOf(
        Distortion(),
        delay,
        WahWah(),
    ).apply {
        // Удаляет delay из середины цепи и добавляет его в конец.
        remove(delay)
        add(delay)
    }
    val processedData = processor.process(data)

    // Пример работы Proxy - ограниченного по вместимости обработчика
    val boundedProcessor = boundedProcessorFrom(processor, 4).apply {
        add(Distortion())
        add(Distortion())
        add(Distortion())
    }
    println("boundedProcessor.getSize(): ${boundedProcessor.getSize()}")

    // Запись обработанного звукового сигнала в файл
    with(FileAudioOutput(destinationPath)) {
        write(processedData)
        close()
    }
}