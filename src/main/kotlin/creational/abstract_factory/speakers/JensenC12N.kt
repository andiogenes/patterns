package creational.abstract_factory.speakers

import common.data.AudioData
import common.logging.Loggable

/**
 * Импульс кабинета с динамиками Jennsen C12N.
 */
class JensenC12N : Speaker, Loggable("JensenC12N", "ConcreteProduct3") {
    override fun process(data: AudioData): AudioData {
        log("process", "operation")
        return data
    }
}