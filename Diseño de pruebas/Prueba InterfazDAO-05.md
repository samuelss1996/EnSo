# Prueba D-05
## Objetivo
Comprobar que el historial de compra de los usuarios devuelto se corresponde con el de la base de datos.
## Técnicas de caja negra
### Generación de clases de equivalencia
Se comprobará el método getHistorialUsuario que devuelve una lista de compras.
* R3: ID válido de usuario e ID inválido.
* R3: ID de usuario existente e inexistente.
### Análisis por valores límite
* Usuario sin historial de compras
## Técnicas de caja blanca
## Criterio de paso/fallo
Siempre que se introduzca un usuario correcto se devuelve un historial correspondiente a dicho usuario. En caso de introducir un usuario incorrecto o cuyo historial de compras es vacío se debe informar de dichos errores.
## Resultado de aplicar las técnicas
|Información|Tipo de dato|Regla|Clase válida|Clase no válida|
|--|--|--|--|--|
|getHistorialUsuario|String|R3| {1} Id válido | {2} Id inválido|
|||R3| {3} Id de usuario existente | {4} Id de usuario no existente |
