Лабораторные работы 10-11 (Порождающие шаблоны. Часть 2)
=====================
_Антон Завьялов, ПИ-72_
-----------------------

### 1. Команда
--------------------
Краткое описание назначения классов в системе:
* __Node__ - узел потока данных. (Команда)
* __Dataflow__ - поток данных. (Объект, вызывающий команду)

Команда задается в Node при помощи анонимной функции, что избавляет от необходимости построения иерархии команд.

Диаграмма классов:

![Command](https://raw.githubusercontent.com/andiogenes/patterns/media/behavioral-2/command.png)

### 2. Перенаправление
--------------------
Краткое описание назначения классов в системе:
* __ModelNode__ - модель вычислительного узла.
* __ModelView__ - представление вычислительного узла.
* __NodeBinding__ - связка модели и представления узла.

Диаграмма классов:

![Indirection](https://raw.githubusercontent.com/andiogenes/patterns/media/behavioral-2/indirection.png)

### 3. Посетитель
--------------------
Краткое описание назначения классов в системе:
* __SoundEndpoint__ - точка обработки звука. (Элемент, обрабатываемый посетителем.) Имеет наследников - конкретные элементы __Input__, __Regular__, __Endpoint__.
* __Visitor__ - посетитель SoundEndpoint.
* __CountByTypeVisitor__ --  конкретный посетитель SoundEndpoint, который считает разные типы элементов.
* __FormattedPrintVisitor__ --  конкретный посетитель SoundEndpoint, который печатает информацию о элементе.

Диаграмма классов:

![Visitor](https://raw.githubusercontent.com/andiogenes/patterns/media/behavioral-2/visitor.png)


### __Скриншот, демонстрирующий работу программы__
--------------------------------------------------
![Screenshot](https://raw.githubusercontent.com/andiogenes/patterns/media/behavioral-2/screen.png)

### __Логи__
------------
#### Команда.
```
Dataflow_Facade, Invoker_10:51:06.064910:<init>
Node_Command_10:51:06.066910:<init>
Dataflow_Facade, Invoker_10:51:06.064910:add_FacadeEndpoint
Node_Command_10:51:06.067909:<init>
Dataflow_Facade, Invoker_10:51:06.064910:add_FacadeEndpoint
Node_Command_10:51:06.068909:<init>
Dataflow_Facade, Invoker_10:51:06.064910:add_FacadeEndpoint
Node_Command_10:51:06.069909:<init>
Dataflow_Facade, Invoker_10:51:06.064910:add_FacadeEndpoint
Dataflow_Facade, Invoker_10:51:06.064910:connect_FacadeEndpoint
Node_Command_10:51:06.066910:connectRight_operation
Node_Command_10:51:06.068909:connectRight_operation
Node_Command_10:51:06.069909:connectRight_operation
Dataflow_Facade, Invoker_10:51:06.064910:makePipeline_FacadeEndpoint
Dataflow_Facade, Invoker_10:51:06.064910:findSource_FacadeEndpoint
Node_Command_10:51:06.066910:operation_execute
Node_Command_10:51:06.068909:operation_execute
Node_Command_10:51:06.069909:operation_execute
Node_Command_10:51:06.067909:operation_execute
```

#### Перенаправление.
```
Observable<T>_Observable_10:51:06.057909:<init>
ModelNode_Model_10:51:06.058907:<init>
ViewNode_View_10:51:06.059908:<init>
NodeBinding_Indirection_10:51:06.059908:<init>
Observable<T>_Observable_10:51:06.057909:subscribe_subscribe
ModelNode_Model_10:51:06.058907:setParameter_Operation
Observable<T>_Observable_10:51:06.057909:sendMessages_sendMessages
NodeBinding_Indirection_10:51:06.059908:onMessage_onMessage
ViewNode_View_10:51:06.059908:setParameter_Operation
ViewNode_View_10:51:06.059908:display_Operation
ModelNode_Model_10:51:06.058907:setParameter_Operation
Observable<T>_Observable_10:51:06.057909:sendMessages_sendMessages
NodeBinding_Indirection_10:51:06.059908:onMessage_onMessage
ViewNode_View_10:51:06.059908:setParameter_Operation
ViewNode_View_10:51:06.059908:display_Operation
ModelNode_Model_10:51:06.058907:setParameter_Operation
Observable<T>_Observable_10:51:06.057909:sendMessages_sendMessages
NodeBinding_Indirection_10:51:06.059908:onMessage_onMessage
ViewNode_View_10:51:06.059908:setParameter_Operation
ViewNode_View_10:51:06.059908:display_Operation
```

#### Посетитель.
```
SoundEndpoint_Element_10:51:06.085462:<init>
Input_ConcreteElement_10:51:06.085462:<init>
SoundEndpoint_Element_10:51:06.085462:<init>
Input_ConcreteElement_10:51:06.085462:<init>
SoundEndpoint_Element_10:51:06.085908:<init>
Output_ConcreteElement_10:51:06.085908:<init>
SoundEndpoint_Element_10:51:06.085908:<init>
Output_ConcreteElement_10:51:06.085908:<init>
SoundEndpoint_Element_10:51:06.086909:<init>
Regular_ConcreteElement_10:51:06.086909:<init>
SoundEndpoint_Element_10:51:06.086909:<init>
Regular_ConcreteElement_10:51:06.086909:<init>
SoundEndpoint_Element_10:51:06.087908:<init>
Regular_ConcreteElement_10:51:06.087908:<init>
SoundEndpoint_Element_10:51:06.087908:<init>
Regular_ConcreteElement_10:51:06.087908:<init>
SoundEndpoint_Element_10:51:06.087908:<init>
Regular_ConcreteElement_10:51:06.087908:<init>
SoundEndpoint_Element_10:51:06.088909:<init>
Regular_ConcreteElement_10:51:06.088909:<init>
SoundEndpoint_Element_10:51:06.088909:<init>
Regular_ConcreteElement_10:51:06.088909:<init>
SoundEndpoint_Element_10:51:06.088909:<init>
Regular_ConcreteElement_10:51:06.088909:<init>
SoundEndpoint_Element_10:51:06.088909:<init>
Regular_ConcreteElement_10:51:06.088909:<init>
SoundEndpoint_Element_10:51:06.089910:<init>
Regular_ConcreteElement_10:51:06.089910:<init>
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:<init>
Input_ConcreteElement_10:51:06.085462:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Input_ConcreteElement_10:51:06.085462:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Output_ConcreteElement_10:51:06.085908:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Output_ConcreteElement_10:51:06.085908:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Regular_ConcreteElement_10:51:06.086909:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Regular_ConcreteElement_10:51:06.086909:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Regular_ConcreteElement_10:51:06.087908:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Regular_ConcreteElement_10:51:06.087908:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Regular_ConcreteElement_10:51:06.087908:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Regular_ConcreteElement_10:51:06.088909:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Regular_ConcreteElement_10:51:06.088909:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Regular_ConcreteElement_10:51:06.088909:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Regular_ConcreteElement_10:51:06.088909:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
Regular_ConcreteElement_10:51:06.089910:accept_accept
CountByTypeVisitor_ConcreteVisitor_10:51:06.090909:visit_visit
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:<init>
Input_ConcreteElement_10:51:06.085462:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Input_ConcreteElement_10:51:06.085462:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Output_ConcreteElement_10:51:06.085908:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Output_ConcreteElement_10:51:06.085908:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Regular_ConcreteElement_10:51:06.086909:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Regular_ConcreteElement_10:51:06.086909:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Regular_ConcreteElement_10:51:06.087908:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Regular_ConcreteElement_10:51:06.087908:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Regular_ConcreteElement_10:51:06.087908:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Regular_ConcreteElement_10:51:06.088909:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Regular_ConcreteElement_10:51:06.088909:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Regular_ConcreteElement_10:51:06.088909:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Regular_ConcreteElement_10:51:06.088909:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
Regular_ConcreteElement_10:51:06.089910:accept_accept
FormattedPrintVisitor_ConcreteVisitor_10:51:06.095909:visit_visit
```