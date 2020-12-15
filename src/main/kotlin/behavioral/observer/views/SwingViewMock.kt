package behavioral.observer.views

import behavioral.observer.ObservableViewModel
import common.logging.Loggable

/**
 * Заглушка для представления программы с использованием библиотеки Swing.
 */
class SwingViewMock : ObservableViewModel.Observer, Loggable("SwingViewMock", "ConcreteObserver") {
    override fun update(message: ObservableViewModel.Message) {
        log("update", "Update")
        print("[SwingViewMock]: ")
        println(when (message) {
            is ObservableViewModel.Message.PositionChanged -> "Processor moved to: (${message.x}, ${message.y})"
            is ObservableViewModel.Message.ComponentAdded -> "Added new component: ${message.component}"
            is ObservableViewModel.Message.ComponentRemoved -> "Component replaced: ${message.component}"
        })
    }
}