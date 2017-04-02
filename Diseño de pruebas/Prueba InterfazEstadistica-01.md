# Prueba E-01
## Objetivo
Comprobar que para entradas incorrectas en los métodos de la interfaz no se producen situaciones no controladas o inesperadas.
## Técnicas de caja negra
### Generación de clases de equivalencia
Se ha aplicado la siguiente regla a todos los métodos de la interfaz ya que todos reciben la misma entrada: un entero en el rango [1,3] para referenciar respectivamente a días, semanas y meses. 
* **getValoresBrutos / getMedias / getHistos / getPorcentajes**
	* R4: Introducir cada uno de los modos correctos {1,2,3} y uno incorrecto.
## Técnicas de caja blanca
## Criterio de paso/fallo
Dada una entrada no esperada en un método, ésta no puede provocar un comportamiento no controlado. De ocurrir esto, la consulta realizada se omitirá, devolviendo un mensaje de error indicando que el método no se ha utilizado de manera apropiada.
## Resultado de aplicar las técnicas
|Información|Tipo de dato|Regla|Clase válida|Clase no válida|
|--|--|--|--|--|
|getValoresBrutos / getMedias / getHistos / getPorcentajes|int|R4| {1} Nº en el rango [1,3] | {2} Nº fuera del rango [1,3] |