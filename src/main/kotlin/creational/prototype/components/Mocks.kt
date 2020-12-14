package creational.prototype.components

import common.logging.LoggableObject

/**
 * Заглушка для компонента "Ползунок".
 */
class Slider : Component {
    private val _log = LoggableObject("Slider", "Mock")
    override fun clone(): Component {
        _log("clone")
        return Slider()
    }
    override fun toString(): String = "Slider"
}

/**
 * Заглушка для компонента "Форма ввода".
 */
class InputBox : Component {
    private val _log = LoggableObject("InputBox", "Mock")
    override fun clone(): Component {
        _log("clone")
        return InputBox()
    }
    override fun toString(): String = "InputBox"
}

/**
 * Заглушка для компонента "Надпись".
 */
class Label : Component {
    private val _log = LoggableObject("Label", "Mock")
    override fun clone(): Component {
        _log("clone")
        return Label()
    }
    override fun toString(): String = "Label"
}

/**
 * Заглушка для компонента "Переключатель".
 */
class Switch : Component {
    private val _log = LoggableObject("Switch", "Mock")
    override fun clone(): Component {
        _log("clone")
        return Switch()
    }
    override fun toString(): String = "Switch"
}