package structural.flyweight

import common.logging.LoggableObject

/**
 * Уникальные (неразделяемые) данные шрифта.
 */
class UniqueFontData(
        override val typeface: TypeFace,
        override val font: Font,
        override val paint: Paint
) : FontData() {
    private val log = LoggableObject("UniqueFontData", "UnsharedConcreteFlyweight")
}