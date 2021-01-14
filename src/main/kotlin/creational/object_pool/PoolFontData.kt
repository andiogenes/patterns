package creational.object_pool

import common.logging.LoggableObject
import structural.flyweight.Font
import structural.flyweight.FontData
import structural.flyweight.Paint
import structural.flyweight.TypeFace

/**
 * Данные о шрифте, хранимые в пуле объектов.
 */
class PoolFontData(override val typeface: TypeFace, override val font: Font, override val paint: Paint) : FontData() {
    private val log = LoggableObject("PoolFontData", "Reusable")
}