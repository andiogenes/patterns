package common.utils

/**
 * Контейнер, который хранит значение одного из двух типов - "левого" и "правого".
 */
sealed class Either<L, R> {
    /**
     * "Левое" значение контейнера.
     */
    class Left<L, R>(val value: L): Either<L, R>()

    /**
     * "Правое значение контейнера".
     */
    class Right<L, R>(val value: R): Either<L, R>()
}