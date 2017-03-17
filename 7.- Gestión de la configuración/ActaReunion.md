# Reunión Gestión de la Configuración
## Asunto

Generar un documento con nuestra visión del proceso de gestión de la configuración.

## Datos de convocatoria

**Duración:** 120 min.<br>
**Convocados:** 

- Orquidea Seijas.
- Silvia Rodríguez.
- Samuel Soutullo.
- Cristofer Canosa.

## Objetivos
Partiendo de los documentos resumen de la visión de cada uno de los autores asignados sobre el proceso de gestión de la configuración, debemos llegar a una visión conjunta y desarrollar un documento que la defina.

## Agenda

### Prerrequisitos
- Resumen de cada uno de los autores.

### Inicio (25min)
Cada asistente dispondrá de 5 minutos para exponer de forma breve los puntos clave del proceso tal y como fue definido por el autor correspondiente.

### Desarrollo (75min)

#### Planificación del documento (40min)
Se especificará en conjunto los puntos clave de un buen proceso de gestión de la configuración.
En caso de desacuerdo, se debe tener como prioridad las consecuencias que tendría el hecho de no realizar una actividad. De esta forma, se mantendrán las actividades más importantes en cuanto aa consecuencias negativas por su no desarrollo.

#### Desarrollo del documento (20min)

Plasmar en un documento el resultado de la discusión.

#### Desarrollar mapa mental y glosario definitivos (15min)

Se llevará a cabo una reedición de los mapas mentales y del glosario.

### Cierre (20min)
El gestor documental de la reunión debe definir brevemente todo el proceso, destacando los puntos clave. Si alguien no está de acuerdo con alguno de los puntos, se anotará una incidencia pendiente para la próxima reunión.

## Resumen de los acuerdos
Dada la naturaleza de la reunión, los acuerdos están relacionados con las actividades que han sido seleccionadas para la definición definitiva del proceso de control de cambios. A continuación se exponen en detalle los argumentos usados en las decisiones principales. 
Para un resumen completo se detallará una tabla al final del documento.

---

Como primera actividad se acordó realizar una planificación sobre el propio proceso, de acuerdo con la mayoría de autores. INTECO define como actividad inicial la asignación de roles y jerarquías al personal. Esta actividad se descarta de nuestro proceso por su poca relación con el proceso de cambios. En concreto, la jerarquía de personal y sus responsabilidades es algo que se debe especificar a nivel de gestión del proyecto, pero que no tiene relevancia directa para la gestión del cambio. Se acordó que las responsabilidades se asignarán a nivel de cambio realizado, de esta forma se mantiene la capacidad de identificar la responsabilidad de los cambios.

---

Con respecto a esta primera actividad de planificación, se decide incluir la definición de las herramientas a usar en la posterior implementación del proceso. Esto permite evitar problemas posteriores debidos a incompatibilidades entre versiones de software o programas completamente distintos.

---

Siguiendo el modelo establecido por INTECO, decidimos realizar la identificación de los ECS antes de establecer la línea base. En concreto, los elementos de configuración de software, se decide establecerlos siguiendo las pautas de Pressman. La organización orientada a objetos de los ECS permite una mayor trazabilidad de responsabilidades y posibles efectos secundarios por dependencias. Además de ser más sencillo llevar un control automatizado de los mismos gracias a la información identificativa debidamente indicada en campos concretos.

---

Se decide seguir el proceso de control de cambio de Pressman, por ser sencillo y suficientemente completo. Se le da importancia a la correcta documentación en esta actividad, de forma que la posterior auditoría se pueda realizar correctamente y permita el mínimo número de errores en el proceso.

---

Una vez aprobado el cambio, dado que utilizamos las OCI en el proceso de control, es conveniente hacer uso de ellos, junto con la trazabilidad del modelo de ECS, para auditar la corrección de la implementación del cambio concreto.

Además de asegurar la correcta implementación del cambio con respecto a su definición, CMMI muestra la relevancia de mantener una adecuada corrección en las líneas base, por lo que se decide añadir una actividad *Establecer la integridad*, para asegurar esto mismo.

---

Como bien establece INTECO, el cambio no finaliza en la implementación, si no en el despliegue. Por lo tanto tiene la misma o mayor importancia mantener la integridad y corrección a la hora de enviar los elementos adecuados al cliente. Por ello, se decide realizar como última actividad la *Gestión de liberación de software*, para documentar el despliegue y asegurar que se realiza correctamente.



