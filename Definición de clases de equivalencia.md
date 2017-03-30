Estamos aplicando reglas de partición o clases de equivalencia.

* InterfazImportacion

	Aplicando R5 se subdividen las siguientes clases:
	*  Análisis por líneas
		* R1: incluir una línea completa incompleta y luego una línea con campos de más y de menos (deben ser líneas correctas).
		* R4: para cada método introducir una línea correcta y una incorrecta. Por ejemplo, en el método de importarUsuarios introducir U y I.
	
	* Análisis por campos
		* R1: 
		 	* Nombre apellidos y categoría: una clase con longitudes entre 1 y 255, otra con longitudes 0 y otra con longitudes > 255
		 	* Descripción: una clase con longitud entre 1 y 1024, otra con 0 y otra con > 1024

		* R3:
			* Que una fecha no tenga el formato adecuado. 
			* Que unidades, cantidad y precio unidad sean enteros
			* Que unidades, cantidad y precio unidad sean positivos
			* Identificador de usuario, item o venta existe/no existe
			* Identificador de usuario, item o venta previamente leído/no previamente leído
			* Venta referencia a ítem o usuario que no existe (booleano porque existe/no existe)
	
	* Análisis por método
		* R3: que se introduzca el path o una línea diferente.

	* Análisis por valores límite
		* A nivel de archivo:
			* Archivo vacío
			* Archivo con un número de registros tan elevado que cargarlo entero en memoria pete

		* A nivel de campos:
			* Nombre, apellidos, categoría: 0, 1, 255 y 256 caracteres
			* Descripción: 0, 1, 1024 y 1025 caracteres

	* Conjetura de errores
		* Si hay varias lineas con un mismo vref, deben añadirse a la misma venta


* InterfazDAO

	* Análisis por métodos
		* **Insertar usuario**
			* R3: Probar un usuario con ID válido y otro sin ID.
			* R4: Crear un usuario de cada tipo admitido y uno que no lo sea.
			* R5: Los Id de usuario de forma N-XXXXXX-000.
				* R1: Cadena de letras con 5 y 7 caracteres (incorrecto) y una correcta. Clase equivalente para la cadena numérica.
				* R3: Eliminar uno de los campos del ID.
				* R4: Que N sea {U,I,D} u otro caracter.

		* **Modificar usuario**
			* Se supone que la introducción del usuario modificado en la base de datos será equivalente a la usada en el método anterior y, por tanto, ya está probada.
			* R3: Insertar datos modificados de un usuario existente (caso correcto) e insertar datos de un usuario que no existe.
			
		* **isLoged**
			* R3: Id de un usuario existente y un ID de un usuario no existente.
			* R5: En base al tipo de ID
				* R4: Introducir un ID de un usuario, un ID válido diferente (item o venta) y un ID inválido.

		* Los métodos de insertar items y ventas y el de actualizar items serán similares a sus análogos para los usuarios, por lo que no se hará una prueba exhaustiva excepto en el caso de que se encuentren fallos en las pruebas anteriores.
			* R3: Id válido para la inserción y uno inválido.
			* R3: Id existente y no existente para la modificación.

		* **Validar pedido** *No se gestiona el usuario que hace la validación ni se marca qué pedido validar, pero ok.*
			* R3: Cadena válida y cadena vacía.
			* R4: Marcar pedido como aceptado, rechazado o una cadena inválida.

		* **Historial usuario**
			* R3: ID válido de usuario e ID inválido.
			* R3: ID de usuario existente e inexistente.
	

	* Análisis por valores límite
		* Usuario sin historial de compras.


* InterfazEstadistica

	* Análisis por métodos 
		* **getValoresBrutos** / **getMedias**
			* R1: Introducir un valor válido (>0) y dos inválidos (negativos y 0) ya que toma un número de días como entrada.			
		* **getHistos** / **getPorcentajes**
			* R4: Introducir cada uno de los modos correctos y uno incorrecto.

* InterfazControlador

	Aplicando R5 se subdividen las siguientes clases:
	* Análisis campos 