# Caso de prueba D-05-P-01
## Dependencias
Comprueba el correcto funcionamiento de la recuperación del historial de compra de un usuario.
El usuario U-abcdef-000 existe y tiene compras en su historial.
## Definición
| Id usuario |Clases que valida|
|--|--|
| U-abcdef-000 | 1,3 |
## Resultado esperado
Se recupera el historial de compras del usuario.

# Caso de prueba D-05-P-02
## Dependencias
Comprueba el correcto funcionamiento de la recuperación del historial de compra de un usuario.
El usuario U-abcdef-000 existe y tiene compras en su historial.
## Definición
| Id usuario |Clases que valida|
|--|--|
| U-a-000 | 2 |
## Resultado esperado
Se muestra un error indicando que el id proporcionado no es válido.

# Caso de prueba D-05-P-03
## Dependencias
Comprueba el correcto funcionamiento de la recuperación del historial de compra de un usuario.
El usuario U-abcdef-000 existe y tiene compras en su historial.
## Definición
| Id usuario |Clases que valida|
|--|--|
| U-abcdef-999 | 4 |
## Resultado esperado
Se muestra un error indicando que el usuario no existe.

# Caso de prueba D-05-P-04
## Dependencias
Comprueba el correcto funcionamiento de la recuperación del historial de compra de un usuario.
El usuario U-abcdef-123 existe y no tiene compras en su historial.
## Definición
| Id usuario |Clases que valida|
|--|--|
| U-abcdef-123 | 4 |
## Resultado esperado
Se devuelve una lista vacía de compras de forma que sea entendible por el usuario que el historial está vacío.
Si no se indica de ninguna forma que la operación ya ha acabado y que no hay resultados se considera que no pasa la prueba.