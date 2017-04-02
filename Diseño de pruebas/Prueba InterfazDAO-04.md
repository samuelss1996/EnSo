# Prueba D-04
## Objetivo
Comprobar la correcta validación de un pedido. Para la correcta validación de un pedido este se confirma como compra en la base de datos.
En base a la definición de la interfaz no tenemos forma de seleccionar el pedido a validar ni el usuario que realiza la validación (para comprobar la gestión de las autorizaciones). Por todo esto solo podremos realizar pruebas en función del estado introducido.
## Técnicas de caja negra
### Generación de clases de equivalencia
Solo el metodo validarPedido gestiona esta acción.
* R3: Cadena válida y cadena vacía.
* R4: Marcar pedido como aceptado, rechazado o una cadena inválida.
## Técnicas de caja blanca
## Criterio de paso/fallo
La prueba será satisfactoria en caso de que el pedido pase al estado declarado siempre que el usuario tenga los privilegios para ello.
En caso de que un usuario no esté autorizado deberá indicarse dicho error.
Ninguna entrada incorrecta debe reflejarse en la base de datos.
## Resultado de aplicar las técnicas
|Información|Tipo de dato|Regla|Clase válida|Clase no válida|
|--|--|--|--|--|
|validarPedido|String|R3| {1} Cadena válida | {2} Cadena vacía |
|||R4|{3} Pedido aceptado| {4} Cadena inválida |
||||{5} Pedido rechazado ||


