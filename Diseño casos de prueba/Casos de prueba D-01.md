# Caso de prueba D-01-P-01
## Dependencias
Valida la inserción correcta de un usuario.
## Definición
|ID Usuario | nombre | apellidos | fecha_alta | tipo |Clases que valida|
|--|--|--|--|--|--|
|U-abcdef-000 | Manuel | Soutoullo | 10-10-2010 | alumno |1,3,6,9,10|
## Resultado esperado
Inserción del usuario con id: U-abcdef-000 en la base de datos.

# Caso de prueba D-01-P-02
## Dependencias
Valida la inserción correcta de un usuario.
## Definición
|ID Usuario | nombre | apellidos | fecha_alta | tipo |Clases que valida|
|--|--|--|--|--|--|
|x | Manuel | Soutoullo | 10-10-2010 | alumno |2|
## Resultado esperado
Notificación de error por parte de la aplicación. Sin consecuencias en la base de datos.

# Caso de prueba D-01-P-03
## Dependencias
Valida la inserción correcta de un usuario.
## Definición
|ID Usuario | nombre | apellidos | fecha_alta | tipo |Clases que valida|
|--|--|--|--|--|--|
|U-abcde-000 | Manuel | Soutoullo | 10-10-2010 | alumno |4|
## Resultado esperadov
Notificación de error por parte de la aplicación. Sin consecuencias en la base de datos.

# Caso de prueba D-01-P-04
## Dependencias
Valida la inserción correcta de un usuario.
## Definición
|ID Usuario | nombre | apellidos | fecha_alta | tipo |Clases que valida|
|--|--|--|--|--|--|
|U-abcde-0000 | Manuel | Soutoullo | 10-10-2010 | alumno |8|
## Resultado esperado
Notificación de error por parte de la aplicación. Sin consecuencias en la base de datos.

# Caso de prueba D-01-P-05
## Dependencias
Valida la inserción correcta de un usuario.
## Definición
|ID Usuario | nombre | apellidos | fecha_alta | tipo |Clases que valida|
|--|--|--|--|--|--|
|U-abcde- | Manuel | Soutoullo | 10-10-2010 | alumno |10|
## Resultado esperado
Notificación de error por parte de la aplicación. Sin consecuencias en la base de datos.

# Caso de prueba D-01-P-06
## Dependencias
Valida la modificación correcta de un usuario.
Se supone que la base de datos solo cuenta con el usuario "U-aaaaaa-000", nombre Limón Novoa, fecha 10-10-2010 y tipo estudiante.
## Definición
|ID Usuario | nombre | apellidos | fecha_alta | tipo |Clases que valida|
|--|--|--|--|--|--|
|U-aaaaaa-000 | Manuel | Soutoullo | 10-10-2010 | alumno |12|
## Resultado esperado
En la base de datos el usuario cuyo id es U-aaaaaa-000 pasa a tener el nombre Manuel Soutoullo.

# Caso de prueba D-01-P-07
## Dependencias
Valida la modificación correcta de un usuario.
Se supone que la base de datos solo cuenta con el usuario "U-aaaaaa-000", nombre Limón Novoa, fecha 10-10-2010 y tipo estudiante.
## Definición
|ID Usuario | nombre | apellidos | fecha_alta | tipo |Clases que valida|
|--|--|--|--|--|--|
|U-dddddd-111 | Manuel | Soutoullo | 10-10-2010 | alumno |12|
## Resultado esperado
Se debe indicar que el usuario no existe y, por tanto, no se puede modificar.
Como alternativa puede decidir insertar el nuevo usuario en la base.