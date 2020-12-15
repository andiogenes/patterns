package behavioral.observer.views

import behavioral.observer.ObservableViewModel
import common.logging.Loggable

/**
 * Заглушка для представления программы с использованием платформы JavaFX.
 */
class JavaFXViewMock : ObservableViewModel.Observer, Loggable("JavaFXViewMock", "ConcreteObserver") {
    override fun update(message: ObservableViewModel.Message) {
        log("update", "Update")
        print("[JavaFXViewMock]: ")
        println(when (message) {
            is ObservableViewModel.Message.PositionChanged -> "New processor position: (${message.x}, ${message.y})"
            is ObservableViewModel.Message.ComponentAdded -> "Component added: ${message.component}"
            is ObservableViewModel.Message.ComponentRemoved -> "Component removed: ${message.component}"
        })
    }
}