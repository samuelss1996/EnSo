# Propuesta casos de prueba a descartar:
	* La estructura de getMedias y de getValores brutos es básicamente la misma, únicamente cambia el return, es por ello que deberíamos analizar una de ellas con caja blanca y la otra con caja negra. (Prueba E-02)
	* getPorcentajes está cubierta por caja blanca, por lo que se deberían descartar las pruebas de caja negra. (Prueba E-01)
	* importarUsuarios e importarCompra están cubiertos por caja blanca. importarProductos NO, hay que hacerle pruebas de caja negra. (Prueba I-01)
	* validateOrder está cubierto por caja blanca. (Prueba D-03)
	* getHistorialUser está cubierto por caja blanca. (Prueba D-04)

