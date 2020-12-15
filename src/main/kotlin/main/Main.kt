package main

import behavioral.memento.Caretaker
import behavioral.memento.ReverbCombine
import behavioral.observer.ObservableViewModel
import behavioral.observer.views.JavaFXViewMock
import behavioral.observer.views.SwingViewMock
import behavioral.state.MultiModeProcessor
import common.data.DummyAudioData
import common.logging.Logger
import common.logging.writers.FileLogWriter
import creational.prototype.components.Label
import creational.prototype.components.Slider
import creational.prototype.components.Switch

fun main() {
    Logger.wrap(FileLogWriter("state")) {
        entitle("State") { state() }
    }
    Logger.wrap(FileLogWriter("memento")) {
        entitle("Memento") { memento() }
    }
    Logger.wrap(FileLogWriter("observer")) {
        entitle("Observer") { observer() }
    }
}

fun state() {
    val dummy = DummyAudioData(byteArrayOf())

    with(MultiModeProcessor()) {
        process(dummy)
        freeze(5)
        repeat(7) {
            process(dummy)
        }
    }
}

fun memento() {
    val dummy = DummyAudioData(byteArrayOf())

    val combine = ReverbCombine(ReverbCombine.Settings(
            mode = ReverbCombine.WorkMode.Bloom,
            decay = 0.5,
            preDelay = 0.15,
            mix = 0.75,
            tone = 0.95,
            param1 = 0.0,
            param2 = 0.0,
            mod = 0.0
    )).apply { process(dummy) }

    val caretaker = Caretaker<ReverbCombine.Settings>()

    with(combine) {
        caretaker.save(createMemento())
        state.mode = ReverbCombine.WorkMode.Reflections
        process(dummy)

        caretaker.save(createMemento())
        state.param1 = 1.0
        process(dummy)

        setMemento(caretaker.restore(0))
        process(dummy)

        setMemento(caretaker.restore())
        process(dummy)
    }
}

fun observer() {
    val swingViewMock = SwingViewMock()
    val javaFXViewMock = JavaFXViewMock()

    val slider = Slider()
    with(ObservableViewModel(Label(), slider)) {
        subscribe(swingViewMock)
        subscribe(javaFXViewMock)

        x = 125
        y = 120

        removeComponent(slider)
        addComponent(Switch())

        unsubscribe(swingViewMock)
        x = 5
        y = 5
    }
}

fun entitle(name: String, block: () -> Unit) {
    println("$name\n${"-".repeat(name.length)}")
    block()
    println()
}