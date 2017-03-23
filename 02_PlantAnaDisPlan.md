# Introducción

## Propósito del documento

## Descripción general del proyecto

## Participantes

## Términos utilizados

# Análisis. INCREMENTO 1

## Descripción general

### Descripción del alcance del INCREMENTO 1

### Diagrama de contexto

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
Descripción: El sistema deberá permitir dar de alta, consultar, actualizar y dar de baja.
Prueba de aceptación: El objetivo se considerará cumplido si se pueden realizar correctamente las acciones relacionadas con los usuarios en la descripción.
Importancia: vital
Urgencia: inmediatamente
Estado: pendiente de verificación
Estabilidad: alta

## Requisitos

### Requisitos de información
	Este apartado debe incluir sólo las entidades necesarias para abordar este		 incremento y ser consistente con el modelo entidad-relación que se aporte en el diseño.
    
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
* Identificación de usuarios por sistema USC
* Documentación completa y clara

## Matriz de trazabilidad

# Diseño del INCREMENTO 1

# Plan del proyecto. INCREMENTO 1

## EDT
<img src="anexos/diagramaEDT.png" />

## Gantt

## Restricciones del proyecto

# Anexo 1