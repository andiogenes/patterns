Лабораторная работа 4
=====================
_Антон Завьялов, ПИ-72_
-----------------------

### 1. __Декораторы__
--------------------
Обработчикам звука можно было бы добавить новые свойства и функционал - например, добавить возможность регулировать уровень громкости, усиления звука, баланс каналов.

Наследуем от обработчика звука абстрактный класс "Декоратор обработчика звука", который включает в себя обработчик звука, выполняет его логику по запросу + дополнительный функционал.

Реализуем конкретные декораторы:
* Фильтр усиления звука. Увеличивает/уменьшает громкость __входного__ сигнала обработчика.
* Фильтр баланса каналов. Регулирует распределение __выходного__ сигнала между левым и правым каналом стереосистемы.
* Фильтр громкости. Увеличивает/уменьшает громкость __выходного_ сигнала обработчика.

Диаграмма классов:

![Decoratoor](https://raw.githubusercontent.com/andiogenes/patterns/media/structural-1/decorators.png)

### 2. __Итераторы__
--------------------
Когда дело дойдёт до пользовательского интерфейса, при наведении курсора на обработчик, можно выводить список всех вложенных обработчиков. Для обхода обработчиков можно использовать паттерн обработчик.

Спроектируем интерфейс "Итератор" в соответствии с его описанием в книге "Приёмы объектно-ориентированного проектирования. Паттерны проектирования" Гаммы, Хелма, Джонсона, Влиссидеса. Включим следующие методы:
* First() - перемещает итератор в начало обхода.
* CurrentItem() - текущий элемент при обходе.
* Next() - продвижение в обходе на один элемент.
* IsDone() - проверяет, закончился обход, или нет.

Метод создания итератора включим в нужные интерфейсы и классы. В соответствии с SOLID, вместо добавления метода `iterator()` в интерфейс `SoundProcessor`, пронаследуем от `SoundProcessor` интерфейс `IterableProcessor` с нужным методом.

Для нужных обработчиков (`LinearProcessor` - линейный набор обработчиков, `SingleProcessor` - один обработчик) реализуем наследников, которые соответствуют интерфейсу `IterableProcessor`.

В коде реализуем итераторы как экземпляры анонимных классов.

* Итератор `LinearIterableProcessor` обходит элементы "слево-направо" в порядке добавления элементов.
* Итератор `SingleIterableProcessor` после вызова `Next()` сразу переходит в состояние "обход завершен".

Диаграмма классов:

![Decorator](https://raw.githubusercontent.com/andiogenes/patterns/media/structural-1/iterators.png)

### 3. __Компоновщик__
----------------------
Есть виды обработчиков сигналов, которые позволяют смешивать сигнал с двух и более обработчиков. Микшеры и другие обработчики удобно представить как компоновщики и компоненты.

Отнаследуем от `SoundProcessor` интерфейс `ComposableProcessor`. Он будет представлять общий компонент древовидной структуры.

Реализуем `CompositeProcessor` - композит, в который можно добавлять и удалять компоненты. Если в наследниках не реализовано иное, он будет обрабатывать сигналы сначала во всех компонентах "в глубину", а дальше "слева-направо".

На основе `CompositeProcessor` реализуем микшер - компонент, который имеет двух "сыновей" - левый вход и правый вход, баланс звука между ними. Обработка сигнала будет состоять в получении и смешивании сигналов сыновей. Запретим `Mixer` добавлять и удалять элементы.

Диаграмма классов:

![Composite](https://raw.githubusercontent.com/andiogenes/patterns/media/structural-1/composites.png)

### 4. __Адаптер__
------------------
Удобно было бы любой `SoundProcessor` привести к `ComposableProcessor`, тогда любой не-композит будет являться листом дерева компонентов.

Для этого введем класс `SoundProcessorToComposable`, реализующий интерфейс `ComposableProcessor`, в который будем передавать `SoundProcessor` и выполнять его логику.

Полученный адаптер реализуется при помощи композиции.

Также реализован искусственный адаптер `IncompatibleProcessor` к `SoundProcessor` как пример реализации через наследование.

Диаграмма классов:

![Adapter](https://raw.githubusercontent.com/andiogenes/patterns/media/structural-1/adapter.png)