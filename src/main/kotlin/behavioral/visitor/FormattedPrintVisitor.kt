package behavioral.visitor

import common.logging.Loggable

/**
 * Посетитель [SoundEndpoint], который выводит информацию об элементе.
 */
class FormattedPrintVisitor : SoundEndpoint.Visitor, Loggable("FormattedPrintVisitor", "ConcreteVisitor") {
    override fun visit(point: SoundEndpoint.Input) {
        log("visit", "visit")
        println("Input: ${point.name}, input volume: ${point.inputVolume}")
    }

    override fun visit(point: SoundEndpoint.Regular) {
        log("visit", "visit")

        println("Regular: ${point.name}, from: ${point.from?.name ?: ""}, to: ${point.to?.name ?: ""}")
    }

    override fun visit(point: SoundEndpoint.Output) {
        log("visit", "visit")
        println("Output: ${point.name}, output volume: ${point.outputVolume}")
    }
}