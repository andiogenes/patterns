package structural.flyweight

import common.logging.Loggable

/**
 * Данные шрифта.
 */
abstract class FontData : Loggable("FontData", "Flyweight") {
    /**
     * Гарнитура.
     */
    abstract val typeface: TypeFace

    /**
     * Шрифт.
     */
    abstract val font: Font

    /**
     * Стиль отрисовки.
     */
    abstract val paint: Paint
}

/**
 * Гарнитура шрифта.
 */
data class TypeFace(val family: String, val size: Float) : Loggable("TypeFace", "DomainObject")

/**
 * Шрифт.
 */
class Font : Loggable("Font", "DomainObject") {
    override fun equals(other: Any?): Boolean {
        return other is Font
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}

/**
 * Стиль отрисовки шрифта.
 */
class Paint : Loggable("Paint", "DomainObject") {
    override fun equals(other: Any?): Boolean {
        return other is Paint
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}