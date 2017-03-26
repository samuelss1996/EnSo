# Introducción

## Propósito del documento
En este documento se recoge la información vinculada al análisis de requisitos, diseño y planificación del primer incremento de la aplicación objeto del proyecto.
    
En lo que respecta a la fase de análisis, se recogen tanto los requisitos de información, como los funcionales y no funcionales necesarios para abordar este incremento. Por otra parte, la fase de análisis incluye también la pertinente identificación de actores y casos de uso, además de varias matrices de trazabilidad.
    
Por otra parte, en la fase de diseño se recogen una serie de diagramas necesarios para la implementación del software asociado a este incremento. Entre ellos estan incluidos un Modelo Entidad-Relación que modelará la base de datos de la aplicación, y uno o varios diagramas de clase y secuencia que modelarán toda la parte ejecutable del software.
    
Finalmente, en la parte del documento asociada a la planificación del proyecto, se incluyen una serie de diagramas que muestran las tareas a realizar y cuando se deben realizar para alcanzar la compleción del proyecto.

## Descripción general del proyecto
El proyecto que de desarrolla en este documento pretende generar como producto final una aplicación que permita la gestión de una central de compras para la Universidad de Santiago de Compostela (USC). Dicha aplicación deberá estar desarrollada como aplicación de escritorio en Java. 

Entrando más en detalle, la aplicación debe permitir la realización de compras sobre el inventario de la USC, así como servir de pasarela para acceder a productos de proveedores externos. Toda persona que pertenezca a la USC y, por tanto, posea una cuenta de la misma puede acceder a la aplicación, haciendo uso del sistema de identificación de la universidad. No obstante, no todos los usuarios podrán realizar las mismas operaciones sobre la aplicación, por lo que existirán una serie de roles (alumno, director, ...) asociados a los usuarios.

En definitiva, la aplicacion debe permitir a los usuarios la consulta de todos los productos en stock, la realización de compras o propuestas de compra, el seguimiento de pedidos, un sistema de facturación y la posibilidad de colocar una reclamación o queja formal, además de poder devolver productos. 

## Participantes
| Nombre | Rol |
|--|--|
| Canosa Domínguez, Cristofer | Gestor documental
| Rodríguez Alcaraz, Silvia | Aseguradora de calidad
| Seijas Salinas, Orquídea Manuela | Validadora de requisitos
| Soutullo Sobral, Samuel | Jefe de proyecto

## Términos utilizados
// De momento esto queda vacío basandome en este criterio sacado del doc del rabenso:
	
    Este apartado no es imprescindible sólo se utilizará si se usa algún concepto ambiguo en la descripción del programa o algún acrónimos. No se usará para meter conceptos de ingeniería como los que ya aparecen en el estándar 829. 

# Análisis. INCREMENTO 1

## Descripción general


### Descripción del alcance del INCREMENTO 1
Generar toda la documentación relativa al análisis y diseño del software que se busca construir. Esta documentación tiene por contenidos los requisitos exigidos, el diseño a realizar y la planificación que se llevó a cabo para recopilar la información citada. 

En el análisis se incluyen tanto los requisitos de información como los funcionales y no funcionales, identificándolos y especificándolos según corresponda. También en el análisis se ha incluido la matriz de trazabilidad (RQ-CU).

En cuanto al diseño, se llevó a cabo un modelo Entidad-Relación además de un diagrama de clases y varios diagramas de secuencia para mejorar la comprensión del desarollo de cada funcionalidad o caso de uso. 

Finalmente, para la planificación de realizó un diagrama Gantt y un EDT. Ambos diagramas permiten observar la descomposición del trabajo a realizar junto con la gestión del tiempo y la asignación de labores dentro del equipo.
### Diagrama de contexto
	Hecho

### Objetivo

	OBJ-0001 Mantener un registro del stock actual
	Fuente: REM de requisitos del sistema.
	Descripción: El sistema deberá tener un modelo de datos del stock coherente con el mundo real en todo momento. 
	Prueba de aceptación: El objetivo se considerará cumplido si cualquier transacción que afecte al stock modifica la base de datos de manera adecuada. 
	Importancia: vital
	Urgencia: inmediatamente
	Estado: pendiente de verificación
	Estabilidad: alta

	OBJ-0002 Soporte de compras
	Fuente: REM de requisitos del sistema.
	Descripción: El sistema deberá permitir realizar compras desde la aplicación además de proponer la realización de las mismas. El sistema deberá generar una factura en caso de realizar una compra.
	Prueba de aceptación: El objetivo se considerará cumplido si se puede realizar una compra correctamente obteniendo la factura asociada y si se puede realizar una solicitud de compra por parte de un alumno de un centro autorizado.
	Importancia: vital
	Urgencia: inmediatamente
	Estado: pendiente de verificación
	Estabilidad: alta

	OBJ-0003 Gestionar usuarios
	Fuente: Requisitos del cliente
	Descripción: El sistema deberá permitir dar de alta, consultar, actualizar y dar de baja usuarios.
	Prueba de aceptación: El objetivo se considerará cumplido si se pueden realizar correctamente las acciones relacionadas con los usuarios en la descripción.
	Importancia: vital
	Urgencia: inmediatamente
	Estado: pendiente de verificación
	Estabilidad: alta

## Requisitos

### Requisitos de información
    
* RI001 - Usuarios
	* Dependencias:
		* [RF-001]: Gestión de usuarios
	*  Descripción: El sistema deberá almacenar la información correspondiente a los propios usuarios que usarán la aplicación. En concreto:
	*  Datos específicos:
		* Nombre
		* Id
		* Tipo de usuario
		* Correo electrónico
	* Criterio de validación: tanto el sistema de identificación de usuarios como todos los procesos de gestión de información relacionados con ellos deben funcionar de manera apropiada para el correcto funcionamiento de la aplicación.
* RI002 - Facturas
	* Dependencias:
		* [RF-0003] Gestión de ventas
	*  Descripción: El sistema deberá almacenar la información correspondiente a todas las compras que ya han sido tramitadas, gestionadas y finalizadas. En concreto:
	*  Datos específicos:
		* Id
		* precio total
		* fecha
		* lineas de compra
	*  Criterio de validación: la factura debe poseer los datos correctos en relación a la factura con la que esté vinculada. Es decir, deberá mostrar la correcta suma de precios de los productos comprados, la fecha de compra correcta, el nombre de los productos, etc.
* RI003 - Productos
	* Dependencias:
		* [RF-002] Gestionar Ítems, [RF-0003] Gestión de ventas
	*  Descripción: El sistema deberá almacenar la información correspondiente a los productos disponibles en la tienda. En concreto:
	*  Datos específicos:
		* Nombre
		* Id
		* Disponibilidad
		* Precio
		* Unidades disponibles
	*  Criterio de validación: los datos relativos a los productos deben ser consistentes con el mundo real.

* RI004 - Líneas de compra
	* Dependencias:
		* [RF-002] Gestionar Ítems, [RF-0003] Gestión de ventas
	*  Descripción: El sistema deberá almacenar la información correspondiente a los productos que estén en la factura, junto con la cantidad que ha sido solicitada. En concreto:
	*  Datos específicos:
		* Número de línea
		* Precio
		* Cantidad
		* Id de la factura
	*  Criterio de validación: dada una línea de compra será posible saber a qué factura pertenece y qué productos están relacionados con ella.
	
* Reglas de negocio:
	* Usuarios
		* Dependencias: 
			* [RF-001] Gestión de usuarios
		*  Descripción: la información almacenada por el sistema deberá satisfacer la siguiente restricción: los usuarios deben ser personas vinculadas a la USC para poder entrar al sistema.
	 * Facturas
		* Dependencias: 
			* [RF-003] Gestión de ventas
		*  Descripción: la información almacenada por el sistema deber´´a satisfacer la siguiente restricción: los importes de los productos que aparecen en las facturas deben corresponderse con el precio de dichos productos en el momento de la compra.
	* Productos
		* Dependencias:
			* [RF-002] Gestionar Ítems
		*  Descripción: la información almacenada por el sistema deberá satisfacer la siguiente restricción: los productos deben tener un identificador único y el número de unidades disponibles debe coincidir con las unidades en stock.

### Requisitos funcionales

#### Requisitos del cliente
* RF-001 
	* Título: Gestión de usuarios 
	* Descripción: La aplicación deberá permitir gestionar usuarios. Esta gestión consistirá en la creación, consulta, actualización y dada de baja de los usuarios.
	* Importancia: vital.
	* Criterio de validación: se considera que el requisito se cumple si permite crear nuevos usuarios, actualizarlos y leer sus datos además de darlos de baja.
* RF-002
	* Título: Gestionar ítems 
	* Descripción: La aplicación deberá permitir gestionar los ítems del catálogo. Esta gestión consiste en la creación, consulta, actualización de productos. Además, será necesario actualizar cuando sea necesario la disponibilidad de un producto. Será imprescindible poder importar información acerca de los ítems de un archivo csv.
	* Importancia: vital.
	* Criterio de validación: se considera que el requisito se cumple si permite crear nuevos Ítems en el catálogo, actualizarlos y leer sus datos.
* RF-003
	* Título: Gestión de ventas 
	* Descripción: La aplicación deberá permitir que se creen y se consulten facturas de las ventas realizadas. Se deberá poder realizar estadísticas sobre las ventas.
	* Importancia: vital.
	* Criterio de validación: se considera que el requisito se cumple si las estadísticas sobre ventas poseen correlación con los datos reales de ventas.

#### Actores
* Usuario
* Administrador
#### Casos de uso
* Solicitar un pedido
* Tramitar factura
* Identificar usuarios
* Pagar producto
* Modificar carrito
* Añadir uno o varios productos al carrito
* Borrar uno o varios productos del carrito
* Buscar productos por características
* Cerrar sesión
* Obtener valores de ventas en bruto de la última semana, mes  y año
* Obtener número medio de ventas al día en el último mes y ventas por semana en el último año
* Cálculo de histogramas de ventas diarias en el último mes y ventas semanales en el último año
* Cálculo de porcentajes de ventas diarias sobre el total del mes y ventas semanales sobre el total del año
* Importar todos los usuarios, ítems y ventas dado un archivo CSV, o solo aquellos cuya fecha de de alta, disponibilidad o venta sean posteriores a una fecha determinada

### Requisitos no funcionales
* RNF-001
	* Título: Tiempo de envío de notificaciones de compra en menos de 1 minuto.
	* Descripción: El sistema deberá enviar las notificaciones en el menor tiempo posible, para que el usuario no tenga dudas de que se realizó adecuadamente su compra. 
	* Importancia: quedaría bien.
	* Criterio de validación: Cronometrar el tiempo que tarda en llegar el correo de validación a la bandeja de entrada de un cliente después de realizar una compra en la aplicación. Este tiempo debe ser menor que 60 segundos.


## Matriz de trazabilidad

# Diseño del INCREMENTO 1
	Hecho

# Plan del proyecto. INCREMENTO 1

## EDT
	Hecho
## Gantt
	Hecho

## Restricciones del proyecto
	Hecho

# Anexo 1