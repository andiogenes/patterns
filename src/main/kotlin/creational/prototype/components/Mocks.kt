package creational.prototype.components

import common.logging.LoggableObject

class Slider : Component() {
    private val _log = LoggableObject("Slider", "Mock")
    override fun clone(): Component {
        _log("clone")
        return Slider()
    }
}

class InputBox : Component() {
    private val _log = LoggableObject("InputBox", "Mock")
    override fun clone(): Component {
        _log("clone")
        return Slider()
    }
}

class Label : Component() {
    private val _log = LoggableObject("Label", "Mock")
    override fun clone(): Component {
        _log("clone")
        return Slider()
    }
}

class Switch : Component() {
    private val _log = LoggableObject("Switch", "Mock")
    override fun clone(): Component {
        _log("clone")
        return Slider()
    }
}