package structural.flyweight

import common.logging.Loggable

/**
 * Фабрика данных о шрифтах.
 */
class FontDataFactory : Loggable("FontDataFactory", "FlyweightFactory") {
    private val pool = mutableSetOf<FontData>()

    /**
     * Получает экземпляр [FontData] с заданным состоянием.
     */
    fun getFontData(typeface: TypeFace, font: Font, paint: Paint): FontData {
        log("getFontData", "GetFlyweight")
        return pool.find {
            it.typeface == typeface && it.font == font && it.paint == paint
        }.let {
            if (it != null) {
                it
            } else {
                val instance = SharedFontData(typeface, font, paint)
                pool.add(instance)
                instance
            }
        }
    }
}