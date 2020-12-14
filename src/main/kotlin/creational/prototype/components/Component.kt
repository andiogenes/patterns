package creational.prototype.components

import creational.prototype.Cloneable

/**
 * Модель представления компонента (одного из элементов управления) обработчика.
 */
interface Component: Cloneable<Component>