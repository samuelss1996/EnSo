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


* InterfazDAO

	* Análisis por campos 


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