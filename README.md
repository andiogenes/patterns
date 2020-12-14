Лабораторные работы 4-5 (Структурные паттерны. Часть 1)
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


### __Скриншот, демонстрирующий работу программы__
--------------------------------------------------
![Screenshot](https://raw.githubusercontent.com/andiogenes/patterns/media/structural-1/screen.png)

### __Логи__
------------
#### Декораторы. Функциональный тест 1.
```
Distortion_Distortion_13:36:48.179000:<init>
SoundProcessorDecorator_decorator (base)_13:36:48.190000:<init>
VolumeFilter_decorator (derived)_13:36:48.191000:<init>
SoundProcessorDecorator_decorator (base)_13:36:48.191000:<init>
GainFilter_decorator (derived)_13:36:48.192000:<init>
SoundProcessorDecorator_decorator (base)_13:36:48.192000:<init>
PanFilter_decorator (derived)_13:36:48.193000:<init>
PanFilter_decorator (derived)_13:36:48.193000:process_operation
SoundProcessorDecorator_decorator (base)_13:36:48.192000:process_operation
GainFilter_decorator (derived)_13:36:48.192000:process_operation
SoundProcessorDecorator_decorator (base)_13:36:48.191000:process_operation
VolumeFilter_decorator (derived)_13:36:48.191000:process_operation
SoundProcessorDecorator_decorator (base)_13:36:48.190000:process_operation
Distortion_Distortion_13:36:48.179000:process_process
```

#### Декораторы. Функциональный тест 2.
```
Distortion_Distortion_13:36:48.198000:<init>
Delay_Delay_13:36:48.199000:<init>
WahWah_WahWah_13:36:48.200000:<init>
SequentialProcessor_SequentialProcessor_13:36:48.234000:<init>
SoundProcessorDecorator_decorator (base)_13:36:48.239000:<init>
VolumeFilter_decorator (derived)_13:36:48.239000:<init>
SoundProcessorDecorator_decorator (base)_13:36:48.240000:<init>
GainFilter_decorator (derived)_13:36:48.240000:<init>
SoundProcessorDecorator_decorator (base)_13:36:48.240000:<init>
PanFilter_decorator (derived)_13:36:48.240000:<init>
PanFilter_decorator (derived)_13:36:48.240000:process_operation
SoundProcessorDecorator_decorator (base)_13:36:48.240000:process_operation
GainFilter_decorator (derived)_13:36:48.240000:process_operation
SoundProcessorDecorator_decorator (base)_13:36:48.240000:process_operation
VolumeFilter_decorator (derived)_13:36:48.239000:process_operation
SoundProcessorDecorator_decorator (base)_13:36:48.239000:process_operation
SequentialProcessor_SequentialProcessor_13:36:48.234000:process_process
Distortion_Distortion_13:36:48.198000:process_process
Delay_Delay_13:36:48.199000:process_process
WahWah_WahWah_13:36:48.200000:process_process
```

#### Итераторы. Функциональный тест 1.
```
Distortion_Distortion_13:36:48.243000:<init>
Delay_Delay_13:36:48.243000:<init>
WahWah_WahWah_13:36:48.243000:<init>
LinearIterableProcessor_aggregate (concrete)_13:36:48.243000:<init>
SequentialProcessor_SequentialProcessor_13:36:48.243000:<init>
LinearIterableProcessor_aggregate (concrete)_13:36:48.243000:iterator_iterator
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:<init>
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:isDone_IsDone
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:currentItem_CurrentItem
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:next_Next
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:isDone_IsDone
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:currentItem_CurrentItem
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:next_Next
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:isDone_IsDone
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:currentItem_CurrentItem
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:next_Next
LinearIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.245000:isDone_IsDone
```

#### Итераторы. Функциональный тест 2.
```
Distortion_Distortion_13:36:48.278000:<init>
SingleIterableProcessor_aggregate (concrete)_13:36:48.278000:<init>
SingleIterableProcessor_aggregate (concrete)_13:36:48.278000:iterator_iterator
SingleIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.279000:<init>
SingleIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.279000:isDone_IsDone
SingleIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.279000:currentItem_CurrentItem
SingleIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.279000:next_Next
SingleIterableProcessor$Iterator<*>_iterator (concrete)_13:36:48.279000:isDone_IsDone
```

#### Компоновщики.
```
CompositeProcessor_composite (base)_13:36:48.281000:<init>
CompositeProcessor_composite (base)_13:36:48.282000:<init>
Distortion_Distortion_13:36:48.282000:<init>
SoundProcessorToComposable_adapter_13:36:48.284000:<init>
CompositeProcessor_composite (base)_13:36:48.282000:addChild_add
Delay_Delay_13:36:48.285000:<init>
SoundProcessorToComposable_adapter_13:36:48.285000:<init>
CompositeProcessor_composite (base)_13:36:48.282000:addChild_add
CompositeProcessor_composite (base)_13:36:48.285000:<init>
WahWah_WahWah_13:36:48.285000:<init>
SoundProcessorToComposable_adapter_13:36:48.286000:<init>
CompositeProcessor_composite (base)_13:36:48.285000:addChild_add
Delay_Delay_13:36:48.286000:<init>
SoundProcessorToComposable_adapter_13:36:48.286000:<init>
CompositeProcessor_composite (base)_13:36:48.285000:addChild_add
CompositeProcessor_composite (base)_13:36:48.287000:<init>
Mixer_composite (derived)_13:36:48.288000:<init>
CompositeProcessor_composite (base)_13:36:48.287000:addChild_add
CompositeProcessor_composite (base)_13:36:48.287000:addChild_add
CompositeProcessor_composite (base)_13:36:48.281000:addChild_add
Distortion_Distortion_13:36:48.288000:<init>
SoundProcessorToComposable_adapter_13:36:48.288000:<init>
CompositeProcessor_composite (base)_13:36:48.281000:addChild_add
CompositeProcessor_composite (base)_13:36:48.281000:process_operation
Mixer_composite (derived)_13:36:48.288000:process_operation
CompositeProcessor_composite (base)_13:36:48.287000:process_operation
CompositeProcessor_composite (base)_13:36:48.282000:process_operation
SoundProcessorToComposable_adapter_13:36:48.284000:process_request
Distortion_Distortion_13:36:48.282000:process_process
SoundProcessorToComposable_adapter_13:36:48.285000:process_request
Delay_Delay_13:36:48.285000:process_process
CompositeProcessor_composite (base)_13:36:48.285000:process_operation
SoundProcessorToComposable_adapter_13:36:48.286000:process_request
WahWah_WahWah_13:36:48.285000:process_process
SoundProcessorToComposable_adapter_13:36:48.286000:process_request
Delay_Delay_13:36:48.286000:process_process
SoundProcessorToComposable_adapter_13:36:48.288000:process_request
Distortion_Distortion_13:36:48.288000:process_process
```

#### Адаптеры.
```
CompositeProcessor_composite (base)_13:36:48.295000:<init>
Distortion_Distortion_13:36:48.295000:<init>
SoundProcessorToComposable_adapter_13:36:48.295000:<init>
CompositeProcessor_composite (base)_13:36:48.295000:addChild_add
IncompatibleProcessor_adaptee_13:36:48.297000:<init>
IncompatibleProcessorAdapter_adapter_13:36:48.297000:<init>
SoundProcessorToComposable_adapter_13:36:48.297000:<init>
CompositeProcessor_composite (base)_13:36:48.295000:addChild_add
CompositeProcessor_composite (base)_13:36:48.295000:process_operation
SoundProcessorToComposable_adapter_13:36:48.295000:process_request
Distortion_Distortion_13:36:48.295000:process_process
SoundProcessorToComposable_adapter_13:36:48.297000:process_request
IncompatibleProcessorAdapter_adapter_13:36:48.297000:process_request
IncompatibleProcessor_adaptee_13:36:48.297000:process_specificRequest
```
