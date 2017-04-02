# Prueba D-01
## Objetivo
Comprobar que las inserciones o modificaciones de usuarios se reflejan correctamente en la base de datos.
Además, se busca que, en caso de error, este sea correctamente gestionado.
## Técnicas de caja negra
### Generación de clases de equivalencia
Centrándose en los métodos de inserción y modificación de usuarios y haciendo uso de las reglas especificadas, se definen las siguientes clases:
* **Insertar usuario**
    * R3: Probar un usuario con ID válido y otro sin ID.
    * R5: Los Id de usuario de forma N-XXXXXX-000.
        * R1: Cadena de letras con 5 y 7 caracteres (incorrecto) y una correcta. Clase equivalente para la cadena numérica.
        * R3: Eliminar uno de los campos del ID.
        * R3: Que N sea U u otro caracter.

* **Modificar usuario**
    * Se supone que la introducción del usuario modificado en la base de datos será equivalente a la usada en el método anterior y, por tanto, ya está probada.
    * R3: Insertar datos modificados de un usuario existente (caso correcto) e insertar datos de un usuario que no existe.
## Técnicas de caja blanca
## Criterio de paso/fallo
Los usuarios introducidos o modificados usando datos correctos deben verse reflejados en la base de datos.
En los casos de incluir usuarios de forma errónea debe notificarse del error y en ningún caso reflejarse en la base de datos.
## Resultado de aplicar las técnicas
|Información|Tipo de dato|Regla|Clase válida|Clase no válida|
|--|--|--|--|--|
|insertUser|Usuario|R3| {1} Id válido | {2} Id inválido|
|||R5,R1| {3} Cadena de 6 letras en el ID | {4} Cadena de 5 letras |
|||||{5} Cadena de 7 letras |
|||R5,R1| {6} Cadena de 3 dígitos en el ID | {7} Cadena de 2 dígitos |
||||| {8} Cadena de 4 dígitos |
|||R5,R3| {9} Uno de los campos del ID existe | {10} Uno de los campos del ID no existe |
|||R5,R3| {10} El valor N del ID es U | {11} Otro valor |
|modUsuario| Usuario | R3 | {12} Usuario existente modificado | {13} Usuario correcto no existente |

