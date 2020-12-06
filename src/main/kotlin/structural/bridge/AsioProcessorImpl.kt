package structural.bridge

import common.data.AudioData
import common.logging.LoggableObject

/**
 * Реализация обработчика с помощью библиотеки [asio4all](http://www.asio4all.org/).
 */
class AsioProcessorImpl : NativeProcessorImpl() {
    private val log = LoggableObject("AsioProcessorImpl", "ConcreteImplementor")

    /*
    В "реальном мире" должно быть что-то вроде:

    ```
    init {
        System.loadLibrary("AsioWrapper")
    }

    external override fun processImpl(data: AudioData): AudioData
    ```
     */

    override fun processImpl(data: AudioData): AudioData {
        log("processImpl", "operationImpl")
        println("Hello from asio4all! (not yet)")
        val osName = System.getProperty("os.name")
        if (!osName.startsWith("Windows")) {
            throw NativeVendorException("asio4all isn't supported on $osName")
        }
        return data
    }
}