| UC-0001 | - Solicitar un pedido |
|--|--|
|**Descripción**| Tras aprobar una compra se debe asegurar la coherencia de los datos con la base de datos así como generar los documentos pertinentes y notificar adecuadamente a los interesados. |
|**Precondición**| - Tener una lista de productos en el carrito.|
|**Secuencia normal**| **1.** El sistema registra en la base de datos la información del/los solicitantes junto a los productos perdidos cuando el usuario aprueba la lista y formaliza la solicitud. Se marca como pendiente de aprobación. <br> **2.** El actor *Director (ACT-0004)* es notificado de una nueva solicitud y accede al registro creado anteriormente para poder aprobarlo. |
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

| UC-0005| Pagar producto |
|--|--|
|**Descripción**| Gestiona el pago de los productos que un usuario haya añadido previamente a su carrito de compra.|
|**Precondición**| - Estar correctamente identificado en la aplicación (sesión iniciada). <br> - El usuario debe tener al menos un producto en su carrido.|
|**Secuencia normal**| **1.** El actor *Usuario (ACT-0001)* selecciona la opción *Pagar producto* una vez ha quedado satisfecho con su carrito de compra. <br> **2.** El sistema muestra por pantalla una descripción de los productos que el usuario va a comprar, así como su precio. El precio se mostrará tanto desglosado producto a producto, como la suma total de todos ellos, que supondrá el gasto total por parte del usuario. <br> **3.** El actor *Usuario (ACT-0001)* accede a una pasarela de cobro seguro donde introduce sus datos de pago. <br> **4.** El sistema recibe la confirmación de cobro y el subsistema de BBDD actualiza los datos de stock, así como todos aquellos relacionados con la compra. <br> **5.** Se envía un correo electrónico de confirmación al usuario y se le muestra un resumen de la transacción. |
| **Postcondición**| - El cliente adquiere el producto. <br> - La base de datos se modifica para actualizar el stock de productos y asignar la compra realizada al usuario. |
|**Excepciones**| **4.** Si el cobro es imposible de determinar, el sistema muestra un mensaje de error y se devuelve al paso 2. |

<br>

|UC-0006| Modificar carrito |
|--|--|
|**Descripción**| Gestiona la modificación de los productos del carrito antes de proceder a su compra. |
|**Precondición**| - Estar correctamente identificado en la aplicación (sesión iniciada). <br> - El usuario debe tener al menos un producto en su carrito. |
| **Secuencia normal** | **1.** <br> **2.** |
| **Postcondición** | |
| **Excepciones** | |