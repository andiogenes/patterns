Лабораторные работы 12-13 (Поведенческие шаблоны. Часть 1)
=====================
_Антон Завьялов, ПИ-72_
-----------------------

### 1. Состояние
--------------------
Краткое описание назначения классов в системе:
* __MultiModeProcessor__ - обработчик, который может на время переключаться в другой режим работы (контекст состояния).
* __Mode__ - режим работы обработчика (состояние). Есть два режима работы: __Standard__ и __Freeze__. Freeze определенное количество раз обрабатывает звук особым образом, потом происходит переключение в режим Standard.

Диаграмма классов:

![State](https://raw.githubusercontent.com/andiogenes/patterns/media/behavioral-1/state.png)

### 2. Хранитель (Мементо)
--------------------
Краткое описание назначения классов в системе:
* __ReverbCombine__ - Обработчик-"комбайн". Имеет множество настроек и режимов работы (Создатель мементо).
* __Setings__ - состояние обработчика (хранимое в мементо).
* __Memento__ - образ состояния, который создаёт обработчик, и может восстанавливать его. Иными словами, это пресет. (Мементо/хранитель)
* __Caretaker__ - хранит образы состояний и выдает их по запросу. (Опекун)

Диаграмма классов:

![Memento](https://raw.githubusercontent.com/andiogenes/patterns/media/behavioral-1/memento.png)

### 3. Наблюдатель
----------------------
Краткое описание назначения классов в системе:
* __ObservableViewModel__ - модель представления обработчика в программе, которая может информировать представление об изменении своего состояния. (Наблюдаемый объект)
* __Observer__ - интерфейс наблюдателя.
* __JavaFXViewMock__, __SwingViewMock__ - заглушки для представления обработчика. (Конкретные наблюдатели)
* __Message__ - сообщение, которое наблюдаемый объект посылает всем наблюдателям; которое все наблюдатели получают от наблюдаемого объекта.

Диаграмма классов:

![Observer](https://raw.githubusercontent.com/andiogenes/patterns/media/behavioral-1/observer.png)


### __Скриншот, демонстрирующий работу программы__
--------------------------------------------------
![Screenshot](https://raw.githubusercontent.com/andiogenes/patterns/media/behavioral-1/screen.png)

### __Логи__
------------
#### Состояние.
```
MultiModeProcessor_Context_13:49:42.810884:<init>
Mode_State_13:49:42.817502:<init>
Standard_ConcreteState_13:49:42.819041:<init>
MultiModeProcessor_Context_13:49:42.810884:process_Operation
Standard_ConcreteState_13:49:42.819041:process_Operation
Mode_State_13:49:42.817502:process_Operation
MultiModeProcessor_Context_13:49:42.810884:freeze_ChangeState(Freeze)
Mode_State_13:49:42.821024:<init>
Freeze_ConcreteState_13:49:42.822024:<init>
MultiModeProcessor_Context_13:49:42.810884:process_Operation
Freeze_ConcreteState_13:49:42.822024:process_Operation
Mode_State_13:49:42.821024:process_Operation
MultiModeProcessor_Context_13:49:42.810884:process_Operation
Freeze_ConcreteState_13:49:42.822024:process_Operation
Mode_State_13:49:42.821024:process_Operation
MultiModeProcessor_Context_13:49:42.810884:process_Operation
Freeze_ConcreteState_13:49:42.822024:process_Operation
Mode_State_13:49:42.821024:process_Operation
MultiModeProcessor_Context_13:49:42.810884:process_Operation
Freeze_ConcreteState_13:49:42.822024:process_Operation
Mode_State_13:49:42.821024:process_Operation
MultiModeProcessor_Context_13:49:42.810884:process_Operation
Freeze_ConcreteState_13:49:42.822024:process_Operation
Mode_State_13:49:42.821024:process_Operation
MultiModeProcessor_Context_13:49:42.810884:process_Operation
Freeze_ConcreteState_13:49:42.822024:process_Operation
Mode_State_13:49:42.823023:<init>
Standard_ConcreteState_13:49:42.824024:<init>
Mode_State_13:49:42.821024:changeMode_ChangeState
Standard_ConcreteState_13:49:42.824024:process_Operation
Mode_State_13:49:42.823023:process_Operation
MultiModeProcessor_Context_13:49:42.810884:process_Operation
Standard_ConcreteState_13:49:42.824024:process_Operation
Mode_State_13:49:42.823023:process_Operation
```

#### Хранитель.
```
Settings_State (Memento)_13:49:42.834145:<init>
ReverbCombine_Originator_13:49:42.835145:<init>
ReverbCombine_Originator_13:49:42.835145:process_Operation
Caretaker_Caretaker_13:49:42.840146:<init>
ReverbCombine_Originator_13:49:42.835145:createMemento_CreateMemento
Settings_State (Memento)_13:49:42.842148:<init>
Memento_Memento_13:49:42.843147:<init>
Caretaker_Caretaker_13:49:42.840146:save_SaveMemento
ReverbCombine_Originator_13:49:42.835145:process_Operation
ReverbCombine_Originator_13:49:42.835145:createMemento_CreateMemento
Settings_State (Memento)_13:49:42.843200:<init>
Memento_Memento_13:49:42.844215:<init>
Caretaker_Caretaker_13:49:42.840146:save_SaveMemento
ReverbCombine_Originator_13:49:42.835145:process_Operation
Caretaker_Caretaker_13:49:42.840146:restore(I)_RestoreMemento
ReverbCombine_Originator_13:49:42.835145:setMemento_SetMemento
ReverbCombine_Originator_13:49:42.835145:process_Operation
Caretaker_Caretaker_13:49:42.840146:restore_RestoreMemento
ReverbCombine_Originator_13:49:42.835145:setMemento_SetMemento
ReverbCombine_Originator_13:49:42.835145:process_Operation
```

#### Наблюдатель.
```
SwingViewMock_ConcreteObserver_13:49:42.854212:<init>
JavaFXViewMock_ConcreteObserver_13:49:42.856213:<init>
Slider_Mock_13:49:42.860254:<init>
Label_Mock_13:49:42.956213:<init>
ProcessorViewModel_Subject_13:49:42.956213:<init>
ProcessorViewModel_Subject_13:49:42.956213:subscribe_Attach
ProcessorViewModel_Subject_13:49:42.956213:subscribe_Attach
ProcessorViewModel_Subject_13:49:42.956213:x=_Operation
Message_Message_13:49:42.969214:<init>
ProcessorViewModel_Subject_13:49:42.956213:notify_Notify
SwingViewMock_ConcreteObserver_13:49:42.854212:update_Update
JavaFXViewMock_ConcreteObserver_13:49:42.856213:update_Update
ProcessorViewModel_Subject_13:49:42.956213:y=_Operation
Message_Message_13:49:42.971212:<init>
ProcessorViewModel_Subject_13:49:42.956213:notify_Notify
SwingViewMock_ConcreteObserver_13:49:42.854212:update_Update
JavaFXViewMock_ConcreteObserver_13:49:42.856213:update_Update
ProcessorViewModel_Subject_13:49:42.956213:removeComponent_Operation
Message_Message_13:49:42.973214:<init>
ProcessorViewModel_Subject_13:49:42.956213:notify_Notify
SwingViewMock_ConcreteObserver_13:49:42.854212:update_Update
JavaFXViewMock_ConcreteObserver_13:49:42.856213:update_Update
Switch_Mock_13:49:42.977214:<init>
ProcessorViewModel_Subject_13:49:42.956213:addComponent_Operation
Message_Message_13:49:42.977214:<init>
ProcessorViewModel_Subject_13:49:42.956213:notify_Notify
SwingViewMock_ConcreteObserver_13:49:42.854212:update_Update
JavaFXViewMock_ConcreteObserver_13:49:42.856213:update_Update
ProcessorViewModel_Subject_13:49:42.956213:unsubscribe_Detach
ProcessorViewModel_Subject_13:49:42.956213:x=_Operation
Message_Message_13:49:42.978285:<init>
ProcessorViewModel_Subject_13:49:42.956213:notify_Notify
JavaFXViewMock_ConcreteObserver_13:49:42.856213:update_Update
ProcessorViewModel_Subject_13:49:42.956213:y=_Operation
Message_Message_13:49:42.978285:<init>
ProcessorViewModel_Subject_13:49:42.956213:notify_Notify
JavaFXViewMock_ConcreteObserver_13:49:42.856213:update_Update
```