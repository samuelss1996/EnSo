# Prueba D-02
## Objetivo
Comprobar que las inserciones o modificaciones de items y ventas se reflejan correctamente en la base de datos.
Además, se busca que, en caso de error, este sea correctamente gestionado.
Dada su similitud con las pruebas para usuariosnose hará una prueba exhaustiva excepto en el caso de que se encuentren fallos en las pruebas anteriores.
## Técnicas de caja negra
### Generación de clases de equivalencia
Centrándose en los métodos de inserción y modificación de items y ventas y haciendo uso de las reglas especificadas, se definen las siguientes clases:
* **Insertar item / venta** / **Modificar item**
    * R3: Id válido para la inserción y uno inválido.
    * R3: Id existente y no existente para la modificación.
## Técnicas de caja blanca
## Criterio de paso/fallo
Los items o ventas introducidos o modificados usando datos correctos deben verse reflejados en la base de datos.
En los casos de incluir items o ventas de forma errónea debe notificarse del error y en ningún caso reflejarse en la base de datos.
## Resultado de aplicar las técnicas
|Información|Tipo de dato|Regla|Clase válida|Clase no válida|
|--|--|--|--|--|
|insertItem|Item|R3| {1} Id válido | {2} Id inválido|
|insertVenta|Venta|R3| {3} Id válido | {4} Id inválido|
|updateItem|Item|R3| {5} Id de item existente | {6} Id de item no existente |

