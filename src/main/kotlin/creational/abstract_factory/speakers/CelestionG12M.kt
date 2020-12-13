package creational.abstract_factory.speakers

import common.data.AudioData
import common.logging.Loggable

/**
 * Импульс кабинета с динамиками Celestion G12M.
 */
class CelestionG12M : Speaker, Loggable("CelestionG12M", "ConcreteProduct3") {
    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return data
    }
}