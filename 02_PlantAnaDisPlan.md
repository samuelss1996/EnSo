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
	Este apartado debe incluir sólo las entidades necesarias para abordar este incremento y ser consistente con el modelo entidad-relación que se aporte en el diseño.
    
* Usuarios
* Facturas
* Productos
* Reglas de negocio:
	* Usuarios
	* Facturas
	* Productos

### Requisitos funcionales

#### Requisitos del cliente
* Requisito 1: La aplicación deberá permitir Gestionar usuarios. (CRU. Borrado NO => Dado de Baja).
* Requisito 2: La aplicación deberá permitir gestionar los Ítems del catálogo (CRU, Borrado no => No disponible). Incluir importación y búsquedas según se detalle en los CUs correspondientes. 
* Requisito 3: Gestión de ventas (CR. Actualización y Borrado NO). Se realizarán estadísticas sobre las ventas según se detalle en los CUs.
* Solicitar pedido
* Pagar un producto
* Añadir, modificar y borrar productos del carrito
* Tramitar factura
* Añadir, modificar, eliminar y consultar stock de la BBDD
* Identificar usuarios
* Buscar productos por características o nombre

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

### Requisitos no funcionales
	Identificador: Requisito RF1
	Título: Tiempo de envío de notificaciones de compra en menos de 1 minuto.
	Descripción: El sistema deberá enviar las notificaciones en el menor tiempo posible, para que el usuario no tenga dudas de que se realizó adecuadamente su compra. 
	Importancia: quedaría bien.
	Criterio de validación: Cronometrar el tiempo que tarda en llegar el correo de validación a la bandeja de entrada de un cliente después de realizar una compra en la aplicación. Este tiempo debe ser menor que 60 segundos.

## Matriz de trazabilidad

# Diseño del INCREMENTO 1

# Plan del proyecto. INCREMENTO 1

## EDT
<img src="anexos/diagramaEDT.png" />

## Gantt

## Restricciones del proyecto

# Anexo 1