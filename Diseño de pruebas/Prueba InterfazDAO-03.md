# Prueba D-03
## Objetivo
Comprobar que la gestión del login de usuario es correcta.
## Técnicas de caja negra
### Generación de clases de equivalencia
Solo se proporciona el método isLoged para la gestión del estado de la sesión de usuario.
* **isLoged**
    * R3: Id de un usuario existente y un ID de un usuario no existente.
    * R5: En base al tipo de ID
        * R3: Introducir un ID de un usuario, un ID válido diferente (item o venta) y un ID inválido.
## Técnicas de caja blanca
## Criterio de paso/fallo
Cuando se introduzca un usuario correcto debe indicarse adecuadamente su estado de sesión. En caso de introducir dátos erróneos debe notificarse sobre ello.
## Resultado de aplicar las técnicas
|Información|Tipo de dato|Regla|Clase válida|Clase no válida|
|--|--|--|--|--|
|isLoged|String|R3| {1} Id de usuario existente | {2} Id de usuario no existente |
|||R5,R3| {3} Id válido | {4} Id inválido |
|

