package behavioral.observer

import common.logging.Loggable
import common.processors.SoundProcessor
import creational.prototype.components.Component
import kotlin.math.absoluteValue
import kotlin.properties.Delegates

/**
 * Модель представления обработчика в программе.
 */
class ObservableViewModel(
        vararg components: Component
) : Loggable("ProcessorViewModel", "Subject") {
    /**
     * Сообщение, которое наблюдаемый объект посылает наблюдателям.
     */
    sealed class Message : Loggable("Message") {
        /**
         * Сообщение о том, что позиция окна обработчика поменялась.
         */
        data class PositionChanged(val x: Int, val y: Int) : Message()

        /**
         * Сообщение о том, что к модели представления добавлен новый компонент.
         */
        data class ComponentAdded(val component: Component) : Message()

        /**
         * Сообщение о том, что из модели представления удален компонент.
         */
        data class ComponentRemoved(val component: Component) : Message()
    }

    /**
     * Наблюдатель модели представления.
     */
    interface Observer {
        /**
         * Совершает действие в соответствии с полученным сообщением.
         */
        fun update(message: Message)
    }

    /**
     * Подписанные наблюдатели.
     */
    private val observers = mutableListOf<Observer>()

    /**
     * Координата X представления обработчика в рабочей области.
     */
    var x: Int by Delegates.observable(0) { _, oldValue, newValue ->
        log("x=", "Operation")
        if (oldValue != newValue) {
            val message = Message.PositionChanged(newValue, y)
            notify(message)
        }
    }

    /**
     * Координата Y представления обработчика в рабочей области.
     */
    var y: Int by Delegates.observable(0) { _, oldValue, newValue ->
        log("y=", "Operation")
        if (oldValue != newValue) {
            val message = Message.PositionChanged(x, newValue)
            notify(message)
        }
    }

    /**
     * Графические компоненты представления обработчика.
     */
    private val components = mutableListOf(*components)

    /**
     * Оповещает наблюдателей о событии сообщением.
     */
    private fun notify(message: Message) {
        log("notify", "Notify")
        observers.forEach { it.update(message) }
    }

    /**
     * Подписывает наблюдателя на события от объекта.
     */
    fun subscribe(observer: Observer) {
        log("subscribe", "Attach")
        observers.add(observer)
    }

    /**
     * Отписывает наблюдателя от событий объекта.
     */
    fun unsubscribe(observer: Observer) {
        log("unsubscribe", "Detach")
        observers.remove(observer)
    }

    /**
     * Добавляет графический компонент к представлению обработчика.
     */
    fun addComponent(component: Component) {
        log("addComponent", "Operation")
        components.add(component)
        notify(Message.ComponentAdded(component))
    }

    /**
     * Удаляет графический компонент из представления обработчика.
     */
    fun removeComponent(component: Component) {
        log("removeComponent", "Operation")
        components.remove(component)
        notify(Message.ComponentRemoved(component))
    }
}