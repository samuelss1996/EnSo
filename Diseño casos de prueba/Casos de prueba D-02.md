# Caso de prueba D-02-P-01
## Dependencias
Valida la inserción correcta de un item.
## Definición
|ItemRef | nombre | descripcion | categoria | stock | fecha_disp |Clases que valida|
|--|--|--|--|--|--|--|
|I-abcdef-000 | Robot limpiapiscinas | Limpia piscinas | Exteriores | 50 |10/10/2010| 1 |
## Resultado esperado
Inserción del item con id: I-abcdef-000 en la base de datos.

# Caso de prueba D-02-P-02
## Dependencias
Valida la inserción correcta de una venta.
## Definición
|ID_compra | fecha | descuento |Clases que valida|
|--|--|--|--|
|V-abcdef-000 | 10/10/2010 | 20 | 3 |
## Resultado esperado
Inserción de la venta con id: V-abcdef-000 en la base de datos.

# Caso de prueba D-02-P-03
## Dependencias
Valida la actualización correcta de un item.
Suponemos que el único item que existe en la base de datos es |I-abcdef-000 | Robot limpiapiscinas | Limpia piscinas | Exteriores | 50 |10/10/2010|
## Definición
|ItemRef | nombre | descripcion | categoria | stock | fecha_disp |Clases que valida|
|--|--|--|--|--|--|--|
|I-abcdef-000 | Robot limpiapiscinas | Limpia piscinas de forma eficiente | Exteriores | 50 |10-10-2010| 5 |
## Resultado esperado
Actualización correcta del item anterior con la descripción actualizada.

# Caso de prueba D-02-P-04
## Dependencias
Valida la inserción correcta de un item.
## Definición
|ItemRef | nombre | descripcion | categoria | stock | fecha_disp |Clases que valida|
|--|--|--|--|--|--|--|
| x | Robot limpiapiscinas | Limpia piscinas | Exteriores | 50 |10/10/2010| 2 |
## Resultado esperado
Muestra un error y no se pierde la consistencia de la base de datos.

# Caso de prueba D-02-P-05
## Dependencias
Valida la inserción correcta de una venta.
## Definición
|ID_compra | fecha | descuento |Clases que valida|
|--|--|--|--|
| x | 10/10/2010 | 20 | 4 |
## Resultado esperado
Muestra un error y no se pierde la consistencia de la base de datos.

# Caso de prueba D-02-P-06
## Dependencias
Valida la actualización correcta de un item.
Suponemos que el único item que existe en la base de datos es |I-abcdef-000 | Robot limpiapiscinas | Limpia piscinas | Exteriores | 50 |10/10/2010|
## Definición
|ItemRef | nombre | descripcion | categoria | stock | fecha_disp |Clases que valida|
|--|--|--|--|--|--|--|
|I-abcdef-999 | Maletín de cuero | Maletín de portátil | Accesorios | 50 |10-10-2010| 5 |
## Resultado esperado
Muestra un error indicando que el elemento a editar no existe o, alternativamente, inserta en la base el elemento nuevo.