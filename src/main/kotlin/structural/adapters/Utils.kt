package structural.adapters

import common.data.AudioData
import common.logging.Loggable
import common.logging.LoggableObject
import common.processors.ComposableProcessor
import common.processors.SoundProcessor

/**
 * Адаптирует [SoundProcessor] к [ComposableProcessor]. (Через композицию)
 */
fun SoundProcessor.toComposable(): ComposableProcessor =
    object : ComposableProcessor, Loggable("SoundProcessorToComposable", "adapter") {
        override fun process(data: AudioData): AudioData {
            log("process", "request")
            return this@toComposable.process(data)
        }
    }

/**
 * Адаптирует [IncompatibleProcessor] к [SoundProcessor]. (Через наследование)
 */
fun adaptIncompatibleProcessor(): SoundProcessor =
    object: IncompatibleProcessor(), SoundProcessor {
        private val log_ = LoggableObject("IncompatibleProcessorAdapter", "adapter")

        override fun process(data: AudioData): AudioData {
            log_("process", "request")
            return super.process(data)
        }
    }