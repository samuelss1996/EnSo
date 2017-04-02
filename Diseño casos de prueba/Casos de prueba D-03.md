# Caso de prueba D-03-P-01
## Dependencias
Valida si el usuario introducido está logeado en el sistema.
Suponemos que el único usuario existente en la base tiene el id: I-abcdef-000.
## Definición
|ID usuario |Clases que valida|
|--|--|
| I-abcdef-000 | 1,3 |
## Resultado esperado
Indica el correcto estado de login del usuario.

# Caso de prueba D-03-P-02
## Dependencias
Valida si el usuario introducido está logeado en el sistema.
Suponemos que el único usuario existente en la base tiene el id: I-abcdef-000.
## Definición
|ID usuario |Clases que valida|
|--|--|
| I-abcdef-999 | 2 |
## Resultado esperado
Muestra un error indicando que el usuario no existe. Si simplemente indica que no está logueado se considerará que no pasa la prueba.

# Caso de prueba D-03-P-03
## Dependencias
Valida si el usuario introducido está logeado en el sistema.
Suponemos que el único usuario existente en la base tiene el id: I-abcdef-000.
## Definición
|ID usuario |Clases que valida|
|--|--|
| x | 4 |
## Resultado esperado
Muestra un error indicando que id es incorrecto. Si simplemente indica que no está logueado se considerará que no pasa la prueba.