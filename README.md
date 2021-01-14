Лабораторные работы 6-7 (Структурные шаблоны. Часть 2)
=====================
_Антон Завьялов, ПИ-72_
-----------------------

### 1. Мост
--------------------
Краткое описание назначения классов в системе:
* __NativeProcessor__ - абстракция над платформо-зависимыми реализациями обработчиков. (Абстракция)
* __NativeProcessorImpl__ - интерфейс реализации платформо-зависимого обработчика. (Интерфейс реализации)
* __AsioProcessorImpl__ - реализация обработчика с помощью библиотеки [asio4all](http://www.asio4all.org/). (Конкретная реализация)
* __LibsoundioProcessorImpl__ - реализация обработчика с помощью библиотеки [libsoundio](https://github.com/andrewrk/libsoundio). (Конкретная реализация)
* __TraceableNativeProcessor__ - трассируемый нативный обработчик. (Модифицированная абстракция)

Диаграмма классов:

![State](https://raw.githubusercontent.com/andiogenes/patterns/media/structural-2/bridge.png)

### 2. Фасад и информационный эксперт
--------------------
Краткое описание назначения классов в системе:
* __Dataflow__ - поток данных. (Фасад для работы с узлами).
* __Node__ - узел потока данных. (Элемент подсистемы).

Node работает со своим состоянием, Dataflow использует методы агрегированных узлов для обеспечения работы подсистемы, т.е. выполняется условие наличия информационного эксперта.

Диаграмма классов:

![Memento](https://raw.githubusercontent.com/andiogenes/patterns/media/structural-2/facade.png)

### 3. Приспособленец
----------------------
Краткое описание назначения классов в системе:
* __FontData__ - данные шрифта. (Приспособленец)
* __SharedFontData__ - разделяемые данные шрифта. (Конкретный приспособленец)
* __UniqueFontData__ - уникальные данные шрифта. (Конкретный неразделяемый приспособленец)
* __FontFactory__ - фабрика данных о шрифтах. (Фабрика приспособленцев)

Диаграмма классов:

![Observer](https://raw.githubusercontent.com/andiogenes/patterns/media/structural-2/flyweight.png)


### __Скриншот, демонстрирующий работу программы__
--------------------------------------------------
![Screenshot](https://raw.githubusercontent.com/andiogenes/patterns/media/structural-2/screen.png)

### __Логи__
------------
#### Мост 1.
```
NativeProcessorImpl_Implementor_06:11:02.512059:<init>
LibsoundioProcessorImpl_ConcreteImplementor_06:11:02.514979:<init>
NativeProcessor_Abstraction_06:11:02.514979:<init>
NativeProcessor_Abstraction_06:11:02.514979:process_operation
NativeProcessorImpl_Implementor_06:11:02.512059:process_operationImpl
LibsoundioProcessorImpl_ConcreteImplementor_06:11:02.514979:processImpl_operationImpl
NativeProcessorImpl_Implementor_06:11:02.519975:<init>
LibsoundioProcessorImpl_ConcreteImplementor_06:11:02.520979:<init>
NativeProcessor_Abstraction_06:11:02.520979:<init>
TraceableNativeProcessor_RefinedAbstraction_06:11:02.521976:<init>
TraceableNativeProcessor_RefinedAbstraction_06:11:02.521976:process_operation
NativeProcessor_Abstraction_06:11:02.520979:process_operation
NativeProcessorImpl_Implementor_06:11:02.519975:process_operationImpl
LibsoundioProcessorImpl_ConcreteImplementor_06:11:02.520979:processImpl_operationImpl
```

#### Мост 2.
```
NativeProcessorImpl_Implementor_06:11:02.529975:<init>
AsioProcessorImpl_ConcreteImplementor_06:11:02.530974:<init>
NativeProcessor_Abstraction_06:11:02.530974:<init>
NativeProcessor_Abstraction_06:11:02.530974:process_operation
NativeProcessorImpl_Implementor_06:11:02.529975:process_operationImpl
AsioProcessorImpl_ConcreteImplementor_06:11:02.530974:processImpl_operationImpl
NativeProcessorImpl_Implementor_06:11:02.531974:<init>
AsioProcessorImpl_ConcreteImplementor_06:11:02.531974:<init>
NativeProcessor_Abstraction_06:11:02.531974:<init>
TraceableNativeProcessor_RefinedAbstraction_06:11:02.531974:<init>
TraceableNativeProcessor_RefinedAbstraction_06:11:02.531974:process_operation
NativeProcessor_Abstraction_06:11:02.531974:process_operation
NativeProcessorImpl_Implementor_06:11:02.531974:process_operationImpl
AsioProcessorImpl_ConcreteImplementor_06:11:02.531974:processImpl_operationImpl
```

#### Фасад.
```
Dataflow_Facade_06:11:02.537976:<init>
Node_Subsystem Class_06:11:02.541975:<init>
Dataflow_Facade_06:11:02.537976:add_FacadeEndpoint
Node_Subsystem Class_06:11:02.543974:<init>
Dataflow_Facade_06:11:02.537976:add_FacadeEndpoint
Node_Subsystem Class_06:11:02.545975:<init>
Dataflow_Facade_06:11:02.537976:add_FacadeEndpoint
Node_Subsystem Class_06:11:02.546974:<init>
Dataflow_Facade_06:11:02.537976:add_FacadeEndpoint
Dataflow_Facade_06:11:02.537976:connect_FacadeEndpoint
Node_Subsystem Class_06:11:02.541975:connectRight_operation
Node_Subsystem Class_06:11:02.545975:connectRight_operation
Node_Subsystem Class_06:11:02.546974:connectRight_operation
Dataflow_Facade_06:11:02.537976:makePipeline_FacadeEndpoint
Dataflow_Facade_06:11:02.537976:findSource_FacadeEndpoint
```

#### Легковес.
```
FontDataFactory_FlyweightFactory_06:11:02.573975:<init>
TypeFace_DomainObject_06:11:02.576004:<init>
Font_DomainObject_06:11:02.578974:<init>
Paint_DomainObject_06:11:02.580019:<init>
FontDataFactory_FlyweightFactory_06:11:02.573975:getFontData_GetFlyweight
FontData_Flyweight_06:11:02.583974:<init>
SharedFontData_ConcreteFlyweight_06:11:02.583974:<init>
TypeFace_DomainObject_06:11:02.585003:<init>
Font_DomainObject_06:11:02.585003:<init>
Paint_DomainObject_06:11:02.585003:<init>
FontDataFactory_FlyweightFactory_06:11:02.573975:getFontData_GetFlyweight
SharedFontData_ConcreteFlyweight_06:11:02.583974:getTypeface_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.583974:getFont_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.583974:getPaint_DataAccessor
TypeFace_DomainObject_06:11:02.585975:<init>
Font_DomainObject_06:11:02.585975:<init>
Paint_DomainObject_06:11:02.585975:<init>
FontDataFactory_FlyweightFactory_06:11:02.573975:getFontData_GetFlyweight
SharedFontData_ConcreteFlyweight_06:11:02.583974:getTypeface_DataAccessor
FontData_Flyweight_06:11:02.585975:<init>
SharedFontData_ConcreteFlyweight_06:11:02.586975:<init>
TypeFace_DomainObject_06:11:02.586975:<init>
Font_DomainObject_06:11:02.586975:<init>
Paint_DomainObject_06:11:02.586975:<init>
FontDataFactory_FlyweightFactory_06:11:02.573975:getFontData_GetFlyweight
SharedFontData_ConcreteFlyweight_06:11:02.583974:getTypeface_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.586975:getTypeface_DataAccessor
FontData_Flyweight_06:11:02.587976:<init>
SharedFontData_ConcreteFlyweight_06:11:02.587976:<init>
SharedFontData_ConcreteFlyweight_06:11:02.583974:getTypeface_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.583974:getFont_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.583974:getPaint_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.583974:getTypeface_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.583974:getFont_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.583974:getPaint_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.586975:getTypeface_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.586975:getFont_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.586975:getPaint_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.587976:getTypeface_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.587976:getFont_DataAccessor
SharedFontData_ConcreteFlyweight_06:11:02.587976:getPaint_DataAccessor
```