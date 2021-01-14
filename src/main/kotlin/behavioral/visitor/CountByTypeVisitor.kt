package behavioral.visitor

import common.logging.Loggable

/**
 * Посетитель [SoundEndpoint], который считает разные типы элементов.
 */
class CountByTypeVisitor : SoundEndpoint.Visitor, Loggable("CountByTypeVisitor", "ConcreteVisitor") {
    private val internalCounts = mutableMapOf(
            "input" to 0,
            "regular" to 0,
            "output" to 0
    )

    /**
     * Количество элементов по типам.
     */
    val counts: Map<String, Int> get() = internalCounts

    override fun visit(point: SoundEndpoint.Input) {
        log("visit", "visit")
        internalCounts["input"] = internalCounts["input"]!! + 1
    }

    override fun visit(point: SoundEndpoint.Regular) {
        log("visit", "visit")
        internalCounts["regular"] = internalCounts["regular"]!! + 1
    }

    override fun visit(point: SoundEndpoint.Output) {
        log("visit", "visit")
        internalCounts["output"] = internalCounts["output"]!! + 1
    }
}