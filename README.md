Лабораторные работы 10-11 (Порождающие шаблоны. Часть 2)
=====================
_Антон Завьялов, ПИ-72_
-----------------------

### 1. Пул объектов
--------------------
Краткое описание назначения классов в системе:
* __FontPool_ - пул данных о шрифтах. (Объектный пул)
* __PoolFontData__ - данные о шрифте, хранимые в пуле объектов. (Переиспользуемый объект)

Диаграмма классов:

![Object Pool](https://raw.githubusercontent.com/andiogenes/patterns/media/creational-2/object_pool.png)

### 2. Строитель
--------------------
Краткое описание назначения классов в системе:
* __Node__ - узел потока данных. (Продукт строителя).
* __NodeBuilder__ - строитель узлов потока данных.

Диаграмма классов:

![Builder](https://raw.githubusercontent.com/andiogenes/patterns/media/creational-2/builder.png)


### __Скриншот, демонстрирующий работу программы__
--------------------------------------------------
![Screenshot](https://raw.githubusercontent.com/andiogenes/patterns/media/creational-2/screen.png)

### __Логи__
------------
#### Пул объектов.
```
FontPool_ObjectPool_08:23:02.830287:<init>
TypeFace_DomainObject_08:23:02.833287:<init>
Font_DomainObject_08:23:02.834286:<init>
Paint_DomainObject_08:23:02.834286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
FontData_Flyweight_08:23:02.835287:<init>
PoolFontData_Reusable_08:23:02.836287:<init>
TypeFace_DomainObject_08:23:02.837287:<init>
Font_DomainObject_08:23:02.837287:<init>
Paint_DomainObject_08:23:02.837287:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
TypeFace_DomainObject_08:23:02.838286:<init>
Font_DomainObject_08:23:02.838286:<init>
Paint_DomainObject_08:23:02.838286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
TypeFace_DomainObject_08:23:02.838286:<init>
Font_DomainObject_08:23:02.838286:<init>
Paint_DomainObject_08:23:02.838286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
TypeFace_DomainObject_08:23:02.838286:<init>
Font_DomainObject_08:23:02.838286:<init>
Paint_DomainObject_08:23:02.838286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
TypeFace_DomainObject_08:23:02.838286:<init>
Font_DomainObject_08:23:02.838286:<init>
Paint_DomainObject_08:23:02.839286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
TypeFace_DomainObject_08:23:02.839286:<init>
Font_DomainObject_08:23:02.839286:<init>
Paint_DomainObject_08:23:02.839286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
TypeFace_DomainObject_08:23:02.839286:<init>
Font_DomainObject_08:23:02.839286:<init>
Paint_DomainObject_08:23:02.839286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
TypeFace_DomainObject_08:23:02.839286:<init>
Font_DomainObject_08:23:02.839286:<init>
Paint_DomainObject_08:23:02.839286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
TypeFace_DomainObject_08:23:02.839286:<init>
Font_DomainObject_08:23:02.839286:<init>
Paint_DomainObject_08:23:02.839286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
TypeFace_DomainObject_08:23:02.839286:<init>
Font_DomainObject_08:23:02.839286:<init>
Paint_DomainObject_08:23:02.839286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
FontPool_ObjectPool_08:23:02.830287:release_ReleaseReusable
TypeFace_DomainObject_08:23:02.840286:<init>
Font_DomainObject_08:23:02.840286:<init>
Paint_DomainObject_08:23:02.840286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
FontData_Flyweight_08:23:02.841286:<init>
PoolFontData_Reusable_08:23:02.841286:<init>
TypeFace_DomainObject_08:23:02.841286:<init>
Font_DomainObject_08:23:02.841286:<init>
Paint_DomainObject_08:23:02.841286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
FontData_Flyweight_08:23:02.841286:<init>
PoolFontData_Reusable_08:23:02.841286:<init>
TypeFace_DomainObject_08:23:02.841286:<init>
Font_DomainObject_08:23:02.841286:<init>
Paint_DomainObject_08:23:02.841286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
FontData_Flyweight_08:23:02.841286:<init>
PoolFontData_Reusable_08:23:02.841286:<init>
TypeFace_DomainObject_08:23:02.841286:<init>
Font_DomainObject_08:23:02.841286:<init>
Paint_DomainObject_08:23:02.841286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
FontData_Flyweight_08:23:02.842285:<init>
PoolFontData_Reusable_08:23:02.842285:<init>
TypeFace_DomainObject_08:23:02.842285:<init>
Font_DomainObject_08:23:02.842285:<init>
Paint_DomainObject_08:23:02.842285:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
FontData_Flyweight_08:23:02.842285:<init>
PoolFontData_Reusable_08:23:02.842285:<init>
TypeFace_DomainObject_08:23:02.842285:<init>
Font_DomainObject_08:23:02.842285:<init>
Paint_DomainObject_08:23:02.842285:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
FontPool_ObjectPool_08:23:02.830287:release_ReleaseReusable
TypeFace_DomainObject_08:23:02.843286:<init>
Font_DomainObject_08:23:02.843286:<init>
Paint_DomainObject_08:23:02.843286:<init>
FontPool_ObjectPool_08:23:02.830287:getFontData_AcquireReusable
FontData_Flyweight_08:23:02.843286:<init>
PoolFontData_Reusable_08:23:02.843286:<init>
FontPool_ObjectPool_08:23:02.830287:release_ReleaseReusable
```

#### Строитель.
```
NodeBuiler_Builder_08:23:02.846287:<init>
NodeBuiler_Builder_08:23:02.846287:setInPorts_BuildPart
NodeBuiler_Builder_08:23:02.846287:setOutPorts_BuildPart
NodeBuiler_Builder_08:23:02.846287:reset_BuildPart
NodeBuiler_Builder_08:23:02.846287:addParameter_BuildPart
NodeBuiler_Builder_08:23:02.846287:resetParameters_BuildPart
NodeBuiler_Builder_08:23:02.846287:setInPorts_BuildPart
NodeBuiler_Builder_08:23:02.846287:setOutPorts_BuildPart
NodeBuiler_Builder_08:23:02.846287:addParameter_BuildPart
NodeBuiler_Builder_08:23:02.846287:addParameter_BuildPart
NodeBuiler_Builder_08:23:02.846287:addParameter_BuildPart
NodeBuiler_Builder_08:23:02.846287:setAction_BuildPart
NodeBuiler_Builder_08:23:02.846287:getResult_GetResult
Node_Product_08:23:02.852286:<init>
```