# Proceso de control de cambios estándar

## Estructura del repositorio para las entregas

Se creará una rama para cada entrega. En dicha rama se meterán todos los documentos fuente necesarios para el desarrollo de la práctica. De esta forma, podremos aislar los elementos asociados a una entrega de todos los demás. Cuando ya estén todos los documentos hechos, se hará una fusión con el tronco con todos ellos. Finalmente se creará un TAG con el entregable (no todos los archivos fuente usados, solo aquellos que se entreguen en el CV, normalmente un archivo ``.zip`` o ``.pdf``). 

## Trabajar con la documentación

Una de las ventajas de usar **GitHub**, es que podremos ver quien es el responsable de cada cosa. Los cambios que se realicen en los documentos estarán totalmente registrados. Además, podremos editar elementos al mismo tiempo. No obstante, esto no se puede hacer de manera directa con los archivos ``.docx`` de **Microsoft Word**. Para solventar este problema, a partir de ahora, los documentos que normalmente hacíamos en Word, ahora los haremos en arhivos ``.md`` (Markdown). Como ya sabréis, los archivos ``.md`` no son otra cosa que archivos de texto plano, en los que fácilmente se pueden introducir títulos, esquemas, código, etc. Tienen como ventaja que nunca van a petar como el Word, por ser archivos de texto plano. Además, se pueden redactar mucho más rapido, pues no hay que lidiar con temas de estructura del documento.

Usando archivos ``.md`` para la documentación, podremos, en definitiva, editar el mismo documento varias personas a la vez. Luego tan solo habría que resolver los posibles conflictos, una tarea muy trivial en la que básicamente decides con lo que te quedas y lo que descartas. El GitKraken ofrece una interfaz muy bonita para realizar esta tarea. Además, podremos saber quien redactó qué párrafos o hizo cuáles cambios en un momento determinado, quedará todo absolutamente registrado.

Cuando el archivo ``.md`` esté completo simplemente se fusionaría la rama con el tronco. En el tronco se añadiría un archivo ``.docx`` que el gestor documental (normalmente Samuel) elaboraría en base al ``.md``. Se haría un **commit** del tronco, y se crearía un TAG con los archivos entregables finales. En resumen, para entenderlo mejor, suponiendo que la entrega constante de un único documento la estructura sería la siguiente:

- Se crea una **rama** para gestionar las diferentes versiones del archivo ``.md``.
- Una vez finalizado el archivo ``.md`` se fusiona con el tronco y se genera el ``.docx``, de tal forma que ambos archivos queden en el tronco.
- Finalmente se crea un **tag** en el que estaría el archivo ``.pdf`` a entregar, sin ningún otro archivo a mayores, pues es sólo este el entregable.

## Recomendaciones
- Usar **GitKraken** como cliente para gestionar el directorio de trabajo local. [GitKraken](https://www.gitkraken.com/)
- Usar **Fcus** como editor de archivos ``.md``. Se encuentra en la tienda de Windows. [Fcus](https://www.microsoft.com/es-es/store/p/fcus/9nblggh4trr4)
- Si no sabéis **Markdown** (archivos ``.md``), esta chuleta en forma de imagen está genial. [Chuleta](https://media.cheatography.com/storage/thumb/cheatography_markdown.750.jpg)