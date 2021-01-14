package behavioral.indirection

import behavioral.indirection.observable.Observer
import common.logging.Loggable

/**
 * Связывает модель узла с его представлением.
 */
class NodeBinding(
        model: ModelNode,
        private val view: ViewNode
) : Loggable("NodeBinding", "Indirection"), Observer<Pair<Int, Float>> {
    init {
        // Подписываем связывание на события модели
        model.subscribe(this)
    }

    override fun onMessage(message: Pair<Int, Float>) {
        log("onMessage", "onMessage")
        // Когда узел получит событие от модели, обновим представление
        view.setParameter(message.first, message.second)
        view.display()
    }
}