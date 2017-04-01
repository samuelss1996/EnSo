# Links de interés
	* Explicación estandar 1008B:
		https://prezi.com/p1-x7ec5vs0z/ieee-1008-estandar-para-pruebas-de-unidad/

	* Explicación estándar 829:
	https://en.wikipedia.org/wiki/Software_test_documentation

# Plan de pruebas

	* Estructura fijada en el estándar:
	{Silvia}
		1. Identificador único del documento (para la gestión de configuración).
		2. Introducción y resumen de elementos y características a probar.
		3. Elementos software que se van a probar (por ejemplo, programas o módulos).
		4. Características que se van a probar.
		5. Características que no se prueban.
	{Cristofer}
		6. Enfoque general de la prueba (actividades, técnicas, herramientas, etc.).
		7. Criterios de paso/fallo para cada elemento.
		8. Criterios de suspensión y requisitos de reanudación.
		9. Documentos a entregar (como mínimo, los descritos en el estándar). {Los documentos a entregar son los distintos apartados: diseño de pruebas, etc.}
		10. Actividades de preparación y ejecución de pruebas.
			11. Necesidades de entorno.
		12. Responsabilidades en la organización y realización de las pruebas.
		13. Necesidades de personal y de formación.
	{Samuel}
		14. Esquema de tiempos (con tiempos estimados, hitos, etc.). ->	Aquí habrá un Gantt con una serie de actividades de prueba y responsables definidos. El Gantt debe incluir al menos 2 iteraciones para la construcción de las secciones del documento: diseño de pruebas, especificación de casos de prueba y especificación de procedimiento.
	{Silvia}
		15. Riesgos asumidos por el plan y planes de contingencias para cada riesgo. 
		16. Aprobaciones y firmas con nombre y puesto desempeñado. 


# Diseño de pruebas
	* Estructura fijada en el estándar:
		1. Identificador (único) para la especificación proporcionar también una referencia del plan asociado (si existe).
		2. Características a probar de los elementos software (y combinaciones de características).
		3. Detalles sobre el plan de pruebas del que surge este diseño, incluyendo las técnicas de prueba específica y los métodos de análisis de resultados.
		4. Identificación de cada prueba:
			• Identificador.
			• Casos que se van a utilizar.
			• Procedimientos que se van a seguir
		5. Criterios de paso/fallo de la prueba (criterios para determinar si una característica o combinación de características ha pasado con éxito la prueba o no). 

	* Tal y como lo planteamos, cada prueba es comprobar si funciona una interfaz a través de pruebas en sus métodos con clases de equivalencia o valores límite, menos en la interfaz de importación, que sería, también, a través de conejtura de errores. 
	
	{Samuel}
	* InterfazImportacion 
	
	{Cristofer}
	* InterfazDAO 

	{Silvia}
	* InterfazEstadistica 

	{Orqui}
	* InterfazControlador 


# Especificación de casos de prueba.
	* Cada caso de prueba deberá contener: 
		* Método de prueba
		* Datos exactos de entrada y salida
		* Contexto de ejecución (qué datos)
		* Cada caso de prueba debe tener una relación clara con la prueba y con JUnit.

	* Estructura fijada en el estándar
		1. Identificador único de la especificación.
		2. Elementos software (por ejemplo, módulos que se van a probar: definir dichos elementos y las características que ejercitará este caso
		3. Especificaciones de cada entrada requerida para ejecutar el caso (incluyendo las relaciones entre las diversas entradas; por ejemplo, la sincronización de las mismas).
		4. Especificaciones de todas las salidas y las características requeridas (por ejemplo, el tiempo de respuesta) para los elementos que se van a probar.
		5. Necesidades de entorno (hardware, software y otras como, por ejemplo, el personal).
		6. Requisitos especiales de procedimiento (o restricciones especiales en los procedimientos para ejecutar este caso).
		7. Dependencias entre casos (por ejemplo, listar los identificadores de los casos que se van a ejecutar antes de este caso de prueba). 

		* Tal y como lo planteamos, cada caso de prueba sería, si son clases de equivalencia, cada una de las posibilidades: id válido y no válido, por ejemplo.

	{Samuel}
	* InterfazImportacion 
	
	{Cristofer}
	* InterfazDAO 

	{Silvia}
	* InterfazEstadistica 

	{Orqui}
	* InterfazControlador 

# Especificación de procedimientos  {Orqui}
	* Se incluyen en los casos de pruebas en los que hay una clara dependencia entre casos. (P.E: muchos del controlador dependen de otras interfaces). El objetivo principal es especificar los pasos para la ejecución de un conjunto de casos de prueba o, más generalmente, los pasos utilizados pasa analizar un elemento software con el propósito de evaluar un conjunto de características del mismo. 

	* Estructura fijada en el estandar:

		1. Identificador único de la especificación y referencia a la correspondiente especificación de diseño de prueba.
		2. Objetivo del procedimiento y lista de casos que se ejecutan con él.
		3. Requisitos especiales para la ejecución (por ejemplo, entorno especial o personal especial).
		4. Pasos en el procedimiento. Además de la manera de registrar los resultados y los incidentes de la ejecución, se debe especificar:
			• La secuencia necesaria de acciones para preparar la ejecución
			• Acciones necesarias para empezar la ejecución.
			• Acciones necesarias durante la ejecución.
			• Cómo se realizarán las medidas (por ejemplo, el tiempo de respuesta>.
			• Acciones necesarias para suspender la prueba (cuando los acontecimientos no previstos lo obliguen).
			• Puntos para reinicio de la ejecución y acciones necesarias para el reinicio en estos puntos.
			• Acciones necesarias para detener ordenadamente la ejecución. 
			• Acciones necesarias para restaurar el entorno y dejarlo en la situación existente antes de as pruebas.
			• Acciones necesarias para tratar acontencimientos anómalos 