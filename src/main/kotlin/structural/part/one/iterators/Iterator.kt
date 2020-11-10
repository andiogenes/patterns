package structural.part.one.iterators

interface Iterator<T> {
    fun first(): T
    fun currentItem(): T
    fun next(): T
    fun isDone(): Boolean
}