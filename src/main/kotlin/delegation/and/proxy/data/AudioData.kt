package delegation.and.proxy.data

/**
 * Контейнер для звуковой информации.
 */
sealed class AudioData(open val content: Any) {
    /**
     * Конвертирует данные в массив байтов.
     */
    abstract fun toByteArray(): ByteArray
}

/**
 * "Фальшивые" звуковые данные, содержащие готовый массив байтов [content].
 */
data class DummyAudioData(override val content: ByteArray) : AudioData(content) {
    override fun toByteArray(): ByteArray = content

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DummyAudioData

        if (!content.contentEquals(other.content)) return false

        return true
    }

    override fun hashCode(): Int {
        return content.contentHashCode()
    }
}