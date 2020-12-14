Лабораторные работы 8-9 (Порождающие шаблоны. Часть 1)
=====================
_Антон Завьялов, ПИ-72_
-----------------------

### 1. Фабричный метод
--------------------
Краткое описание назначения классов в системе:
* __BitCrusher__ - обработчик типа "бит-крашер".
* __Flanger__ - обработчик типа "флэнджер".
* __Overdrive__ - обработчик типа "перегруз".
* __Producer__ - создаёт некоторый обработчик звука (держатель фабричного метода).
* __BitcrusherProducer__ - создаёт конкретный обработчик типа "бит-крашер" (держатель конкретного фабричного метода).
* __FlangerProducer__ - создаёт конкретный обработчик типа "флэнджер" (держатель конкретного фабричного метода).
* __OverdriveProducer__ - создаёт конкретный обработчик типа "перегруз" (держатель конкретного фабричного метода).

Диаграмма классов:

![Factory method](https://raw.githubusercontent.com/andiogenes/patterns/media/creational-1/factory_method.png)

### 2. Абстрактная фабрика
--------------------
Краткое описание назначения классов в системе:
* __ModularProcessor__ - собирает обработчики на основе выдаваемых поставщиками (клиент абстрактной фабрики).
* __Preamplifier__ - первый продукт фабрики, __AC30__ и __TwinReverb__ - конкретные продукты.
* __PowerAmplifier__ - второй продукт фабрики. __SmallAmplifier__ и __MediumAmplifier__ - конкретные продукты.
* __Speaker__ - третий продукт фабрики. __Celestion__ и __Jensen__ - конкретные продукты.
* __ModuleProvider__ - поставщик обработчиков модульному процессору (абстрактная фабрика). __FenderProvider__ и __VoxProvider__ - конкретные фабрики.

Диаграмма классов:

![Abstract factory](https://raw.githubusercontent.com/andiogenes/patterns/media/creational-1/abstract_factory.png)

### 3. Синглтон
----------------------
Синглтон уже присутствует в системе - с использованием этого паттерна реализовано логгирование. Язык Kotlin поддерживает синглтоны
на уровне языка в виде `object declaration`. Язык обеспечивает ленивую инициализацию объектов и единственность экземпляра. В этом
можно убедиться, посмотрев сгенерированный компилятором JVM-байткод.

Диаграмма классов:

![Singleton](https://raw.githubusercontent.com/andiogenes/patterns/media/creational-1/singleton.png)

### 4. Прототип
------------------
Краткое описание назначения классов в системе:
* __Cloneable<T>__ - обобщенный интерфейс для копируемых объектов.
* __ProcessorViewModel__ - модель представления обработчика в рабочей области (прототип).
* __InputViewModel__ - модель представления звукового входа в рабочей области (конкретный прототип).
* __OutputViewModel__ - модель представления звукового выхода в рабочей области (конкретный прототип).
* __NodeViewModel__ - модель представления узла обработки звука в рабочей области (конкретный прототип).
* __Component__ и наследники - элементы управления, располагаемые на узлах в рабочей области.

Диаграмма классов:

![Prototype](https://raw.githubusercontent.com/andiogenes/patterns/media/creational-1/prototype.png)


### __Скриншот, демонстрирующий работу программы__
--------------------------------------------------
![Screenshot](https://raw.githubusercontent.com/andiogenes/patterns/media/creational-1/screen.png)

### __Логи__
------------
#### Фабричный метод.
```
BitCrusherProducer_ConcreteCreator_06:14:37.503260:<init>
FlangerProducer_ConcreteCreator_06:14:37.505260:<init>
OverdriveProducer_ConcreteCreator_06:14:37.505260:<init>
BitCrusherProducer_ConcreteCreator_06:14:37.503260:produce_FactoryMethod
BitCrusher_ConcreteProduct_06:14:37.507259:<init>
FlangerProducer_ConcreteCreator_06:14:37.505260:produce_FactoryMethod
Flanger_ConcreteProduct_06:14:37.507259:<init>
OverdriveProducer_ConcreteCreator_06:14:37.505260:produce_FactoryMethod
Overdrive_ConcreteProduct_06:14:37.508260:<init>
BitCrusher_ConcreteProduct_06:14:37.507259:process_operation
Flanger_ConcreteProduct_06:14:37.507259:process_operation
Overdrive_ConcreteProduct_06:14:37.508260:process_operation
```

#### Абстрактная фабрика. Функциональный тест 1.
```
FenderProvider_ConcreteFactory_06:14:37.511260:<init>
ModuleProcessor_Client_06:14:37.512260:<init>
FenderProvider_ConcreteFactory_06:14:37.511260:createPreamplifier_CreateProduct1
TwinReverb_ConcreteProduct1_06:14:37.513261:<init>
FenderProvider_ConcreteFactory_06:14:37.511260:createAmplifier_CreateProduct2
MediumPowerAmplifier_ConcreteProduct2_06:14:37.514260:<init>
FenderProvider_ConcreteFactory_06:14:37.511260:createEffectsLoop
Delay_Delay_06:14:37.515259:<init>
FenderProvider_ConcreteFactory_06:14:37.511260:createSpeaker_CreateProduct3
JensenC12N_ConcreteProduct3_06:14:37.516260:<init>
ModuleProcessor_Client_06:14:37.512260:process_operation
TwinReverb_ConcreteProduct1_06:14:37.513261:process_operation
MediumPowerAmplifier_ConcreteProduct2_06:14:37.514260:process_operation
Delay_Delay_06:14:37.515259:process_process
JensenC12N_ConcreteProduct3_06:14:37.516260:process_operation
```

#### Абстрактная фабрика. Функциональный тест 2.
```
VoxProvider_ConcreteFactory_06:14:37.518260:<init>
ModuleProcessor_Client_06:14:37.518260:<init>
VoxProvider_ConcreteFactory_06:14:37.518260:createPreamplifier_CreateProduct1
AC30_ConcreteProduct1_06:14:37.519259:<init>
VoxProvider_ConcreteFactory_06:14:37.518260:createAmplifier_CreateProduct2
SmallPowerAmplifier_ConcreteProduct2_06:14:37.519259:<init>
VoxProvider_ConcreteFactory_06:14:37.518260:createEffectsLoop
Distortion_Distortion_06:14:37.520288:<init>
VoxProvider_ConcreteFactory_06:14:37.518260:createSpeaker_CreateProduct3
CelestionG12M_ConcreteProduct3_06:14:37.521260:<init>
ModuleProcessor_Client_06:14:37.518260:process_operation
AC30_ConcreteProduct1_06:14:37.519259:process_operation
SmallPowerAmplifier_ConcreteProduct2_06:14:37.519259:process_operation
Distortion_Distortion_06:14:37.520288:process_process
CelestionG12M_ConcreteProduct3_06:14:37.521260:process_operation
```

#### Прототип.
```
Label_Mock_06:14:37.524262:<init>
Slider_Mock_06:14:37.525260:<init>
ProcessorViewModel_Prototype_06:14:37.525260:<init>
InputViewModel_ConcretePrototype_06:14:37.526259:<init>
InputBox_Mock_06:14:37.527258:<init>
Slider_Mock_06:14:37.527258:<init>
ProcessorViewModel_Prototype_06:14:37.527258:<init>
NodeViewModel_ConcretePrototype_06:14:37.527258:<init>
NodeViewModel_ConcretePrototype_06:14:37.527258:clone_Clone
InputBox_Mock_06:14:37.527258:clone
InputBox_Mock_06:14:37.528259:<init>
Slider_Mock_06:14:37.527258:clone
Slider_Mock_06:14:37.528259:<init>
ProcessorViewModel_Prototype_06:14:37.528259:<init>
NodeViewModel_ConcretePrototype_06:14:37.528259:<init>
Slider_Mock_06:14:37.529260:<init>
Switch_Mock_06:14:37.529260:<init>
ProcessorViewModel_Prototype_06:14:37.529260:<init>
OutputViewModel_ConcretePrototype_06:14:37.529260:<init>
```