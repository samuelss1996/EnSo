# Método *validateOrder(Purchase purchase, boolean decision)*
## Código
```java
public boolean validateOrder(Purchase purchase, boolean decision) {
        int r = 0;
        PreparedStatement prOrder;
        PreparedStatement prPurchase;
        try {
            
            openConection();
            String updateOrderSQL = "UPDATE Pedido SET estado = ? where ID_Pedido = ?";
            
            String insertPurchaseSQL = " INSERT INTO Compra (ID_Compra, ID_Pedido, fecha, descuento) values (? ,? , ?, ?)";
            
            
            prPurchase = connection.prepareStatement(insertPurchaseSQL);
            prPurchase.setString(1, purchase.getID_Purchase());
            prPurchase.setInt(2, purchase.getOrder().getID_Order());
            prPurchase.setDate(3, purchase.getDate());
            prPurchase.setFloat(4, purchase.getDiscount());
            
            r += prPurchase.executeUpdate();
            
            prOrder = connection.prepareStatement(updateOrderSQL);
            String state = Order.DENEGATED;
            if(decision){
                state = Order.ACCEPTED;
            }
            prOrder.setString(1, state);
            prOrder.setInt(2, purchase.getOrder().getID_Order());

            System.out.println("---"+prOrder);
            r += prOrder.executeUpdate();
            
            
            
            
            closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
           System.out.println(ex.getMessage());
        }
        if(  r > 0){
            return true;
        }else{
            return false;
        }       
    }
```
## Definición de nodos
* q0: Declaraciones previas al try.
* q1: Apertura de la conexión.
* q2: Declaraciones de sql y ejecución de la inserción.
* q3: Condición para la variable decision.
* q4: Asignación para la anterior condición si es correcta.
* q5: Sentencia vacía para q3 si es false. Implica que state = Order.DENEGATED.
* q6: Ejecución de la actualización y cierre de conexión.
* q7: Último if.
* q8: Return true;
* q9: Return false;
* q10: Ejecución del código de control de excepciones.
## Complejidad ciclomática

V(G) = a - n + 2 = 13 - 11 + 2 = 4;

## Selección de caminos 

* Camino 1 (base): 0 - 1 - 2 - 3 - 4 - 6 - 7 - 8
	* Camino común aceptando el order.
* Camino 2: 0 - 1 - 2 - 3 - 5 - 6 - 7 - 8
	* Camino común rechazando el order.
* Camino 3: 0 - 1 - 10 - 7 - 9
	* Error al abrir la conexión.
* Camino 4: 0 - 1 - 2 - 10 - 7 - 9
	* Error en la inserción
* Camino 5: 0 - 1 - 2 - 3 - 4 - 6 - 10 - 7 - 9
	* Error en la actualización del estado o al cerrar la conexión.

## Definición de casos de prueba

* Camino 1: 
    * Entrada: 
    ```cs 
        new Purchase() {
            ID_Purchase = "V-AAAAA-000",
            order = new Order() {
                ID_Order = "O-AAAAA-000",
                state = Order.WAITTING,
                user = new User() {
                    ID_User = "U-AAAAA-000",
                    name = "Usuario",
                    surname = "Usuario1",
                    NIF = "12213428H",
                    date = "24-04-2017",
                    tipe = User.PID
                },
                validator = "U-EFTGK-234",
                lines = new[] {
                    new Line() {
                        quantity = 2,
                        price = 19.99,
                        item = new Item() {
                            itemRef = "I-AAAAA-000",
                            name = "producto",
                            description = "Descripción del producto",
                            category = "Cosas",
                            stock = 50,
                            availableDate = "01-01-1970"
                        }
                    }
                }
            }
            date = "04-05-2017",
            discount = 0.2
        },
        decision = true;
    ```
    * Salida esperada: El método devuelve true e inserta lo anterior en la base, marcando el pedido O-AAAAA-000 como aceptado.

* Camino 2:
    * Entrada: 
    ```cs 
        new Purchase() {
            ID_Purchase = "V-AAAAA-000",
            order = new Order() {
                ID_Order = "O-AAAAA-000",
                state = Order.WAITTING,
                user = new User() {
                    ID_User = "U-AAAAA-000",
                    name = "Usuario",
                    surname = "Usuario1",
                    NIF = "12213428H",
                    date = "24-04-2017",
                    tipe = User.PID
                },
                validator = "U-EFTGK-234",
                lines = new[] {
                    new Line() {
                        quantity = 2,
                        price = 19.99,
                        item = new Item() {
                            itemRef = "I-AAAAA-000",
                            name = "producto",
                            description = "Descripción del producto",
                            category = "Cosas",
                            stock = 50,
                            availableDate = "01-01-1970"
                        }
                    }
                }
            }
            date = "04-05-2017",
            discount = 0.2
        },
        decision = false;
    ```
    * Salida esperada: El método devuelve false e inserta lo anterior en la base, marcando el pedido O-AAAAA-000 como rechazado.

* Camino 3:
    * Prerrequisitos: El servidor de base de datos está desconectado.
    * Entrada: 
    ```cs 
        new Purchase() {
            ID_Purchase = "V-AAAAA-000",
            order = new Order() {
                ID_Order = "O-AAAAA-000",
                state = Order.WAITTING,
                user = new User() {
                    ID_User = "U-AAAAA-000",
                    name = "Usuario",
                    surname = "Usuario1",
                    NIF = "12213428H",
                    date = "24-04-2017",
                    tipe = User.PID
                },
                validator = "U-EFTGK-234",
                lines = new[] {
                    new Line() {
                        quantity = 2,
                        price = 19.99,
                        item = new Item() {
                            itemRef = "I-AAAAA-000",
                            name = "producto",
                            description = "Descripción del producto",
                            category = "Cosas",
                            stock = 50,
                            availableDate = "01-01-1970"
                        }
                    }
                }
            }
            date = "04-05-2017",
            discount = 0.2
        },
        decision = true;
    ```
    * Salida esperada: El método devuelve false sin modificar la base de datos.

* Camino 4: 
    * Prerrequisitos: La compra V-AAAAA-000 ya existe en la base de datos.
    * Entrada: 
    ```cs 
        new Purchase() {
            ID_Purchase = "V-AAAAA-000",
            order = new Order() {
                ID_Order = "O-AAAAA-000",
                state = Order.WAITTING,
                user = new User() {
                    ID_User = "U-AAAAA-000",
                    name = "Usuario",
                    surname = "Usuario1",
                    NIF = "12213428H",
                    date = "24-04-2017",
                    tipe = User.PID
                },
                validator = "U-EFTGK-234",
                lines = new[] {
                    new Line() {
                        quantity = 2,
                        price = 19.99,
                        item = new Item() {
                            itemRef = "I-AAAAA-000",
                            name = "producto",
                            description = "Descripción del producto",
                            category = "Cosas",
                            stock = 50,
                            availableDate = "01-01-1970"
                        }
                    }
                }
            }
            date = "04-05-2017",
            discount = 0.2
        },
        decision = true;
    ```
    * Salida esperada: El método devuelve false y no modifica la base.

* Camino 5: 
    * Prerrequisito: El pedido O-AAAAA-000 no existe en la base de datos.
    * Entrada: 
    ```cs 
        new Purchase() {
            ID_Purchase = "V-AAAAA-000",
            order = new Order() {
                ID_Order = "O-AAAAA-000",
                state = Order.WAITTING,
                user = new User() {
                    ID_User = "U-AAAAA-000",
                    name = "Usuario",
                    surname = "Usuario1",
                    NIF = "12213428H",
                    date = "24-04-2017",
                    tipe = User.PID
                },
                validator = "U-EFTGK-234",
                lines = new[] {
                    new Line() {
                        quantity = 2,
                        price = 19.99,
                        item = new Item() {
                            itemRef = "I-AAAAA-000",
                            name = "producto",
                            description = "Descripción del producto",
                            category = "Cosas",
                            stock = 50,
                            availableDate = "01-01-1970"
                        }
                    }
                }
            }
            date = "04-05-2017",
            discount = 0.2
        },
        decision = true;
    ```
    * Salida esperada: El método devuelve false sin modificar la base de datos.