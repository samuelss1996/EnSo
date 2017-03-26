| UC-0001 | - Solicitar un pedido |
|--|--|
|**Descripción**| Tras aprobar una compra se debe asegurar la coherencia de los datos con la base de datos así como generar los documentos pertinentes. |
|**Precondición**| - Tener una lista de productos en el carrito.|
|**Secuencia normal**| **1.** El sistema registra en la base de datos la información del/los solicitantes junto a los productos perdidos cuando el usuario aprueba la lista y formaliza la solicitud. Se marca como pendiente de aprobación. |
|**Postcondición**|  - La solicitud es registrada en el sistema. |
|**Excepciones**| **1.** Si el usuario solicitante es el director, el sistema marca el registro de solicitud automáticamente como aprobado, a continuación este caso de uso continúa. |

<br>

| UC-0002 | Tramitar factura |
|--|--|
|**Descripción**| Tras la confirmación de un pago, se genera un documento con los datos de la transacción (usuario destinatario, información de pago, productos, etc). Se debe actualizar el stock de los productos afectados en la base de datos. |
|**Precondición**| - Tener una solicitud aprobada pendiente de pago. |
|**Secuencia normal**| **1.** El actor *Gestor de compras (ACT-0005)* recibe una solicitud de compra aprobada por el director.<br> **2.** El actor *Gestor de compras (ACT-0005)* consulta que los fondos necesarios están disponibles. <br> **3.** El sistema genera una factura y la carga en la partida presupuestaria adecuada. <br> **4.** El sistema remite la información pertinente al vendedor.|
|**Postcondición**|Realizar el pago correctamente al vendedor y registrarlo adecuadamente. |
| **Excepciones**| **2.** Si los fondos necesarios no están disponibles, el sistema registra la aprobación como inválidad y se notifica a los solicitantes, a continuación este caso de uso queda sin efecto. |


<br>

| UC-0003 | Identificar usuarios |
|--|--|
|**Descripción**| Se deben identificar correctamente a los usuarios del servicio, haciendo uso de los datos y credenciales de la universidad y teniendo en cuenta su autorización de cara a la tienda. |
|**Precondición**| |
|**Secuencia normal**| **1.** El actor *Usuario (ACT-0001)* accede a la aplicación con sus credenciales de la universidad. <br> **2.** El sistema se conecta con el servicio de identificación de la universidad, que nos devolverá los datos de usuario. <br> **3.** El sistema consulta en la baase de datos local si existe información adicional sobre ese usuario. |
|**Postcondición**| Se obtiene correctamente la información del usuario, tanto guardada localmente como obtenida a través de la universidad. Además, se reconoce correctamente su autorización.|

<br>

| UC-0004 | Pagar producto |
|--|--|
|**Descripción**| Gestiona el pago de los productos que un usuario haya añadido previamente a su carrito de compra.|
|**Precondición**| - Estar correctamente identificado en la aplicación (sesión iniciada). <br> - El usuario debe tener al menos un producto en su carrido.|
|**Secuencia normal**| **1.** El actor *Usuario (ACT-0001)* selecciona la opción *Pagar producto* una vez ha quedado satisfecho con su carrito de compra. <br> **2.** El sistema muestra por pantalla una descripción de los productos que el usuario va a comprar, así como su precio. El precio se mostrará tanto desglosado producto a producto, como la suma total de todos ellos, que supondrá el gasto total por parte del usuario. <br> **3.** El actor *Usuario (ACT-0001)* accede a una pasarela de cobro seguro donde introduce sus datos de pago. <br> **4.** El sistema recibe la confirmación de cobro y el subsistema de BBDD actualiza los datos de stock, así como todos aquellos relacionados con la compra. <br> **5.** Se envía un correo electrónico de confirmación al usuario y se le muestra un resumen de la transacción. |
| **Postcondición**| - El cliente adquiere el producto. <br> - La base de datos se modifica para actualizar el stock de productos y asignar la compra realizada al usuario. |
|**Excepciones**| **4.** Si el cobro es imposible de determinar, el sistema muestra un mensaje de error y se devuelve al paso 2. |

<br>

|UC-0005| Modificar carrito |
|--|--|
|**Descripción**| Gestiona la modificación de los productos del carrito antes de proceder a su compra. |
|**Precondición**| - Estar correctamente identificado en la aplicación (sesión iniciada). <br> - El usuario debe tener al menos un producto en su carrito. |
| **Secuencia normal** | **1.** El actor *Usuario (ACT-0001)* accede a su carrito personal. <br> **2.** El actor *Usuario (ACT-0001) modifica un campo dentro de cada producto, que representa la cantidad de ese tipo concreto de producto que desea. <br> **3.** Si el usuario está satisfecho con su carrito, el sistema avanza al caso de uso *Pagar un producto*. |
| **Postcondición** | - El carrito del cliente se ve modificado. |


<br>

|UC-0006| Añadir uno o varios productos al carrito |
|--|--|
|**Descripción**| Gestiona las acciones a realizar cuando se añade un producto al carrito. |
|**Precondición**| - Estar correctamente identificado en la aplicación (sesión iniciada). |
|**Secuencia normal** | **1.** El actor *Usuario (ACT-0001) selecciona un producto (la cantidad puede ser uno o más, siempre limitado por el stock actual). Añade estos productos al carrito. <br> **2.** El sistema añade los productos a una lista temporal e informa al usuario de que los productos se añadieron exitosamente al carrito. |
|**Postcondición**| - Existencia de elementos en el carrito. |
|**Excepciones**| **1.** Si no hay stock en el momento de añadir al carrito, el sistema informa de la situación a través de un mensaje de error. A continuación este caso de uso queda sin efecto. |

<br>

|UC-0007| Borrar uno o varios productos del carrito |
|--|--|
|**Descripción**| Gestiona las acciones a realizar cuando se elimina un producto del carrito. |
|**Precondición**| - Estar correctamente identificado en la aplicación (sesión iniciada). <br> - Existencia de elementos en el carrito. |
|**Secuencia normal**| **1.** El actor *Usuario (ACT-0001)* desde la vista de su carrito, selecciona un producto y lo elimina. <br> **2.** Se confirma el borrado y se le muestra la lista del carrito actualizada al usuario. |

<br>

|UC-0008| Buscar productos por características |
|--|--|
|**Descripción**| Gestiona las acciones a realizar cuando el usuario realice una consulta sobre los productos en stock en base a una serie de características seleccionadas. |
|**Precondición**| |
|**Secuencia normal**| **1.** El actor *Usuario (ACT-0001)* realiza una consulta de productos en función de unos campos predefinidos. <br> **2.** El sistema procesa la petición y devuelve una lista de productos que se ajusten a los solicitados. |
|**Postcondición**| - El usuario recibe una lista de productos que existen en stock en función del filtro seleccionado.

#### A partir de aquí son los casos de uso impuestos por Rabenso, por lo que de momento no tienen ID

|UC-0009| Obtener valores de ventas en bruto de la última semana, mes y año |
|--|--|
|**Descripción**| Usando el módulo estadístico, será posible obtener valores de ventas totales de ciertos períodos, en concreto: última semana, último mes y último año. |
|**Precondición**| - Estar identificado en la aplicación como usuario con permisos para obtener datos del módulo estadístico. |
|**Secuencia normal**| **1.** El actor *Usuario (ACT-001)* accede al panel del módulo estadístico. <br> **2.** El actor *Usuario (ACT-001)* selecciona la opción para obtener datos de ventas en bruto. <br> **3.** El actor *Usuario (ACT-001)* selecciona el período sobre la cual desea obtener las estadísticas (última semana, último mes o último año) y realiza la consulta. |
|**Postcondición**| Se presentan al usuario los datos de ventas solicitados. |

<br>

|UC-0010| Obtener número medio de ventas al día en el último mes y ventas por semana en el último año |
|--|--|
|**Descripción**| Usando el módulo estadístico, será posible obtener el número medio de ventas para determinados períodos durante cierto tiempo. En concreto, se deben poder obtener el número promedio de ventas diarias durante el último mes, y el número promedio de ventas semanales durante el último año. |
|**Precondición**| - Estar identificado en la aplicación como usuario con permisos para obtener datos del módulo estadístico. |
|**Secuencia normal**| **1.** El actor *Usuario (ACT-001)* accede al panel del módulo estadístico. <br> **2.** El actor *Usuario (ACT-001)* selecciona la opción para obtener datos relativos a la media de ventas durante ciertos períodos. <br> **3.** El actor *Usuario (ACT-001)* selecciona el período sobre la cual desea obtener las estadísticas (ventas diarias durante el último mes o ventas semanales durante el último año) y realiza la consulta. |
|**Postcondición**| Se presentan al usuario los datos de ventas solicitados. |

<br>

|UC-0011| Cálculo de histogramas de ventas diarias en el último mes y ventas semanales en el último año |
|--|--|
|**Descripción**| Usando el módulo estadístico, será posible obtener datos sobre el número de ventas durante cada uno de los días del último mes, o cada una de las semanas del último año. Estos datos deben ser representados en forma de histograma, para facilitar su visualización. |
|**Precondición**| - Estar identificado en la aplicación como usuario con permisos para obtener datos del módulo estadístico. |
|**Secuencia normal**| **1.** El actor *Usuario (ACT-001)* accede al panel del módulo estadístico. <br> **2.** El actor *Usuario (ACT-001)* selecciona la opción para obtener un histograma de ventas sobre un período de tiempo determinado. <br> **3.** El actor *Usuario (ACT-001)* selecciona el período sobre la cual desea obtener las estadísticas (ventas diarias durante el último mes o ventas semanales durante el último año) y realiza la consulta. |
|**Postcondición**| Se presentan al usuario los datos de ventas solicitados. |

<br>

|UC-0012| Cálculo de porcentajes de ventas diarias sobre el total del mes y ventas semanales sobre el total del año |
|--|--|
|**Descripción**| Usando el módulo estadístico, será posible obtener obtener datos relativos al porcentaje de ventas de todos los días del mes con respecto al total del mes, o de todas las semanas del año con respecto al total del año.  |
|**Precondición**| - Estar identificado en la aplicación como usuario con permisos para obtener datos del módulo estadístico. |
|**Secuencia normal**| **1.** El actor *Usuario (ACT-001)* accede al panel del módulo estadístico. <br> **2.** El actor *Usuario (ACT-001)* selecciona la opción para obtener el porcentaje de ventas de un período de tiempo determinado, con respecto a otro período de tiempo superior. <br> **3.** El actor *Usuario (ACT-001)* selecciona el período sobre la cual desea obtener las estadísticas (ventas diarias sobre el total del mes o ventas semanales sobre el total del año) y realiza la consulta. |
|**Postcondición**| Se presentan al usuario los datos de ventas solicitados. |

<br>

|UC-0013| Importar todos los usuarios, ítems o ventas dado un archivo CSV, o solo aquellos cuya fecha de de alta, disponibilidad o venta sean posteriores a una fecha determinada |
|--|--|
|**Descripción**| Usando el módulo de importación, será posible importar los datos de usuarios, ítems o productos, de forma que queden guardados de forma persistente en la base de datos. Será posible seleccionar si se desean importar solo los usuarios, solo los ítems, solo los productos, todos los elementos, o cualquier combinación de ellos. Estos datos estarán contenidos en un archivo con extensión *CSV*, cuyo formato está especificado en el *Anexo 1* de este mismo documento. No solo se podrán importar todos los datos contenidos en el fichero, sino que se podrá especificar que se importen solo aquellos cuya fecha de alta, disponibilidad o venta sean posteriores a una fecha determinada.  |
|**Precondición**| - Estar identificado en la aplicación como usuario con permisos para usar el módulo de importación. |
|**Secuencia normal**| **1.** El actor *Usuario (ACT-001)* accede al panel del módulo de importación. <br> **2.** El actor *Usuario (ACT-001)* selecciona el fichero del cual desea importar los datos. <br> **3.** Opcionalmente, el actor *Usuario (ACT-001)* selecciona que solo desea importar los datos a partir de una fecha determinada, y especifica dicha fecha. |
|**Postcondición**| Se guarda de manera persistente en la base de datos el contenido seleccionado del fichero *CSV* |