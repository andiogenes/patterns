package structural.bridge

import common.data.AudioData
import common.logging.LoggableObject

/**
 * Реализация обработчика с помощью библиотеки [libsoundio](https://github.com/andrewrk/libsoundio).
 */
class LibsoundioProcessorImpl : NativeProcessorImpl() {
    private val log = LoggableObject("LibsoundioProcessorImpl", "ConcreteImplementor")

    /*
    В "реальном мире" должно быть что-то вроде:

    ```
    init {
        System.loadLibrary("LibsoundioWrapper")
    }
    external override fun processImpl(data: AudioData): AudioData
    ```

    Но для работы писать JNI-биндинги (в которых будет аналогичный заглушечный код), к.м.к., избыточно.
    */

    override fun processImpl(data: AudioData): AudioData {
        log("processImpl", "operationImpl")
        println("Hello from libsoundio! (not yet)")
        return data
    }
}