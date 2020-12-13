package creational.factory_method.processors

import common.data.AudioData
import common.logging.Loggable
import common.processors.SingleProcessor

/**
 * Овердрайв — звуковой эффект, достигаемый искажением сигнала путём его «мягкого» ограничения по амплитуде.
 */
class Overdrive : SingleProcessor, Loggable("Overdrive", "ConcreteProduct") {
    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return data
    }
}