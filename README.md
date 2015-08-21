#Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-model)
  - [Entidad CartItem](#entidad-cartitem)
  - [Entidad CellPhone](#entidad-cellphone)
  - [Entidad Client](#entidad-client)
  - [Entidad Product](#entidad-product)
  - [Entidad Provider](#entidad-provider)

#API Rest
##Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /model.web/webresources/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

###CRUD Básico
Para los servicios de CRUD Básico, Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
{
    totalRecords: 0, //cantidad de registros en la base de datos
    records: [] //collección con los datos solicitados. cada objeto tiene la estructura de la entidad.
}
```

##API de la aplicación model
###Entidad CartItem
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad CartItem, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto CartItem
```javascript
{
    product: '' /*Objeto que representa instancia de Product*/,
    quantity: '' /*Tipo Integer*/,
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/cartItems|Obtener todos los objetos JSON de CartItem (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON CartItem y el total de registros en la base de datos en el header X-Total-Count
**GET**|/cartItems/:id|Obtener los atributos de una instancia de CartItem en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de CartItem
**POST**|/cartItems|Crear una nueva instancia de la entidad CartItem (CREATE)||Objeto JSON de CartItem a crear|Objeto JSON de CartItem creado
**PUT**|/cartItems/:id|Actualiza una instancia de la entidad CartItem (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de CartItem|Objeto JSON de CartItem actualizado
**DELETE**|/cartItems/:id|Borra instancia de CartItem en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad CellPhone
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad CellPhone, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto CellPhone
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    description: '' /*Tipo String*/,
    model: '' /*Tipo String*/,
    imei: '' /*Tipo String*/,
    brand: '' /*Tipo String*/,
    image: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/cellPhones|Obtener todos los objetos JSON de CellPhone (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON CellPhone y el total de registros en la base de datos en el header X-Total-Count
**GET**|/cellPhones/:id|Obtener los atributos de una instancia de CellPhone en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de CellPhone
**POST**|/cellPhones|Crear una nueva instancia de la entidad CellPhone (CREATE)||Objeto JSON de CellPhone a crear|Objeto JSON de CellPhone creado
**PUT**|/cellPhones/:id|Actualiza una instancia de la entidad CellPhone (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de CellPhone|Objeto JSON de CellPhone actualizado
**DELETE**|/cellPhones/:id|Borra instancia de CellPhone en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Client
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Client, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Client
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    userId: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/clients|Obtener todos los objetos JSON de Client (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Client y el total de registros en la base de datos en el header X-Total-Count
**GET**|/clients/:id|Obtener los atributos de una instancia de Client en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Client
**POST**|/clients|Crear una nueva instancia de la entidad Client (CREATE)||Objeto JSON de Client a crear|Objeto JSON de Client creado
**PUT**|/clients/:id|Actualiza una instancia de la entidad Client (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Client|Objeto JSON de Client actualizado
**DELETE**|/clients/:id|Borra instancia de Client en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Client
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Client son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|clients/:id/shoppingCart|Obtener Objetos JSON de shoppingCart(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client||Colección de objetos JSON de shoppingCart(CartItem)
**POST**|clients/:id/shoppingCart|Creación de instancias de shoppingCart(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de objetos JSON de shoppingCart(CartItem) a crear|Colección de objetos JSON de shoppingCart(CartItem) creados con sus respectivos ID
**PUT**|clients/:id/shoppingCart|Actualización de instancias de shoppingCart(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de objetos JSON de shoppingCart(CartItem) a actualizar|Colección de objetos JSON de shoppingCart(CartItem) actualizados
**DELETE**|clients/:id/shoppingCart|Eliminación de instancias de shoppingCart(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de atributo `id` de shoppingCart(CartItem) a eliminar|

[Volver arriba](#tabla-de-contenidos)

###Entidad Product
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Product, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Product
```javascript
{
    cellPhone: '' /*Objeto que representa instancia de CellPhone*/,
    name: '' /*Tipo String*/,
    price: '' /*Tipo Integer*/,
    id: '' /*Tipo Long*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/products|Obtener todos los objetos JSON de Product (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Product y el total de registros en la base de datos en el header X-Total-Count
**GET**|/products/:id|Obtener los atributos de una instancia de Product en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Product
**POST**|/products|Crear una nueva instancia de la entidad Product (CREATE)||Objeto JSON de Product a crear|Objeto JSON de Product creado
**PUT**|/products/:id|Actualiza una instancia de la entidad Product (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Product|Objeto JSON de Product actualizado
**DELETE**|/products/:id|Borra instancia de Product en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Provider
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Provider, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Provider
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    userId: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/providers|Obtener todos los objetos JSON de Provider (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Provider y el total de registros en la base de datos en el header X-Total-Count
**GET**|/providers/:id|Obtener los atributos de una instancia de Provider en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Provider
**POST**|/providers|Crear una nueva instancia de la entidad Provider (CREATE)||Objeto JSON de Provider a crear|Objeto JSON de Provider creado
**PUT**|/providers/:id|Actualiza una instancia de la entidad Provider (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Provider|Objeto JSON de Provider actualizado
**DELETE**|/providers/:id|Borra instancia de Provider en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Provider
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Provider son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|providers/:id/products|Obtener Objetos JSON de products(Product) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider||Colección de objetos JSON de products(Product)
**POST**|providers/:id/products|Creación de instancias de products(Product) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider|Colección de objetos JSON de products(Product) a crear|Colección de objetos JSON de products(Product) creados con sus respectivos ID
**PUT**|providers/:id/products|Actualización de instancias de products(Product) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider|Colección de objetos JSON de products(Product) a actualizar|Colección de objetos JSON de products(Product) actualizados
**DELETE**|providers/:id/products|Eliminación de instancias de products(Product) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider|Colección de atributo `id` de products(Product) a eliminar|

[Volver arriba](#tabla-de-contenidos)

