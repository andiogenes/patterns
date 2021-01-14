package behavioral.indirection.observable

import common.logging.Loggable

/**
 * Обозреваемый объект.
 */
abstract class Observable<T> : Loggable("Observable<T>", "Observable") {
    private val observers = arrayListOf<Observer<T>>()

    /**
     * Подписать обозревателя на этот объект.
     */
    fun subscribe(observer: Observer<T>) {
        log("subscribe", "subscribe")
        observers.add(observer)
    }

    /**
     * Отписать обозревателя от объекта.
     */
    fun unsubscribe(observer: Observer<T>) {
        log("unsubscribe", "unsubscribe")
        observers.remove(observer)
    }

    /**
     * Разослать сообщения подписанным обозревателям.
     */
    fun sendMessages(message: T) {
        log("sendMessages", "sendMessages")
        observers.forEach { it.onMessage(message) }
    }
}

/**
 * Интерфейс обозревателя.
 */
interface Observer<T> {
    fun onMessage(message: T)
}