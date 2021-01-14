package creational.object_pool

import common.logging.Loggable
import common.utils.Either
import structural.flyweight.Font
import structural.flyweight.Paint
import structural.flyweight.TypeFace

/**
 * Пул данных о шрифтах.
 *
 * @param capacity Вместимость пула
 */
class FontPool(private val capacity: Int = 100) : Loggable("FontPool", "ObjectPool") {
    private val pool = arrayListOf<PoolFontData>()

    /**
     * Получает экземпляр [PoolFontData] с заданным состоянием.
     */
    fun getFontData(typeface: TypeFace, font: Font, paint: Paint): Either<String, PoolFontData> {
        log("getFontData", "AcquireReusable")
        return pool.find {
            it.typeface == typeface && it.font == font && it.paint == paint
        }.let {
            if (it != null) {
                Either.Right(it)
            } else {
                if (pool.size < capacity) {
                    val instance = PoolFontData(typeface, font, paint)
                    pool.add(instance)
                    Either.Right(instance)
                } else {
                    Either.Left("Pool is full")
                }
            }
        }
    }

    /**
     * Удаляет экземпляр [PoolFontData] из пула.
     */
    fun releaseFontData(fontData: PoolFontData): Boolean {
        log("release", "ReleaseReusable")
        return pool.remove(fontData)
    }
}