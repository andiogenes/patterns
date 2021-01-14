package structural.flyweight

import common.logging.LoggableObject

/**
 * Разделяемые данные о шрифте.
 */
class SharedFontData(typeface: TypeFace, font: Font, paint: Paint) : FontData() {
    private val log_ = LoggableObject("SharedFontData", "ConcreteFlyweight")

    // Внутреннее состояние приспособленца
    private val intrinsicTypeFace = typeface
    private val intrinsicFont = font
    private val intrinsicPaint = paint

    override val typeface: TypeFace
        get() {
            log_("getTypeface", "DataAccessor")
           return intrinsicTypeFace
        }

    override val font: Font
        get() {
            log_("getFont", "DataAccessor")
            return intrinsicFont
        }

    override val paint: Paint
        get() {
            log_("getPaint", "DataAccessor")
            return intrinsicPaint
        }

    override fun toString(): String = "SharedFontData(typeface = $typeface, font = $font, paint = $paint)"
}