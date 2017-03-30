Estamos aplicando reglas de partición o clases de equivalencia.

* InterfazImportacion

	Aplicando R5 se subdividen las siguientes clases:
	*  Análisis por líneas
		* R1: incluir una línea completa incompleta y luego una línea con campos de más y de menos (deben ser líneas correctas).
		* R4: para cada método introducir una línea correcta y una incorrecta. Por ejemplo, en el método de importarUsuarios introducir U y I.
	
	* Análisis por campos
		* R3: que una fecha no tenga el formato adecuado. 
		* R4: introducir una correcta, una incorrecta y otra fuera de rango (ej.: *) en el primer campo (identificador de la tabla).
	
	* Análisis por método
		* R3: que se introduzca el path o una línea diferente.

	* Análisis por valores límite
		* Archivo vacío


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

		* **Validar pedido** Ni puta idea de lo que hace esto.

		* **Historial usuario**
			* R3: ID válido de usuario e ID inválido.
			* R3: ID de usuario existente e inexistente.
	

	* Análisis por valores límite
		* Usuario sin historial de compras.

			



* InterfazEstadistica

	Aplicando R5 se subdividen las siguientes clases:
	* Análisis por métodos 
		* R1: 
			* Introducir un valor válido (>0) y dos inválidos (negativos y 0) ya que todas las entradas son int.			
		* R2: no hay listas de tam variable, asique nada (creo)
		* R3: introducir otro tipo de datos que no sean int.
		* R4: la única varianza posible se completa con R3 introduciendo datos no esperados y viendo qué provocan (no introducir un int).

		En este módulo tienen una errata en el segundo método: flaot en vez de float(?).

* InterfazControlador

	Aplicando R5 se subdividen las siguientes clases:
	* Análisis campos 