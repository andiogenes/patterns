package structural.bridge

import java.lang.RuntimeException

/**
 * Исключение поставщика платформы.
 *
 * Все ошибки на уровне JNI должны оборачиваться в это исключение.
 */
class NativeVendorException(val error: Any) : RuntimeException()