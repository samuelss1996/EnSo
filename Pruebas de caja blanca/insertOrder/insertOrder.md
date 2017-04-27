# Método *insertOrder(Order order)*
## Código
```java
public boolean insertOrder(Order order) {
		int r = 0;
		String insertOrderSQL = " INSERT INTO Pedido (ID_Pedido, estado, ID_autor) values (? ,?, ?)";
        String insertLineSQL = " INSERT INTO LineaCompra (ID_Item, ID_Pedido, precio, cantidad) values (? ,?, ? ,?)";
        try {
            openConection();
            
            stm = connection.prepareStatement(insertOrderSQL);
            stm.setInt(1, order.getID_Order());
            stm.setString(2, Order.WAITTING);
            stm.setString(3, order.getUser().getID_User());
            
            r += stm.executeUpdate();
            
            for(Line l: order.getLines()) {
            	stm = connection.prepareStatement(insertLineSQL);
                stm.setString(1, l.getItem().getItemRef());
                stm.setInt(2, order.getID_Order());
                stm.setFloat(3, l.getPrice());
                stm.setInt(4, l.getQuantity());
                
                r += stm.executeUpdate(); 
            }
            
           
            
            
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
* q0: Sentencias previas al *try*.
* q1: Desde abrir la conexión (susceptible de lanzar una excepción) hasta la ejecución de la primera inserción.
* q2: Condición del for.
* q3: Código interno del for.
* q4: Cierre de la conexión.
* q5: Último if.
* q6: return true.
* q7: return false.
* q8: Manejo de la excepción.
## Complejidad ciclomática

V(G) = a - n + 2 = 11 - 9 + 2 = 4;

## Selección de caminos 

* Camino 1 (base): 0 - 1 - 2 - 3 - 2 - 3 - 4 - 5 - 6
	* Camino común con al menos una iteración del for (2-3).
* Camino 2: 0 - 1 - 8 - 5 - 7
	* Error al abrir la conexión o en la primera sentencia.
* Camino 3: 0 - 1 - 2 - 4 - 5 - 6
	* La venta no contiene líneas
* Camino 4: 0 - 1 - 2 - 3 - 8 - 5 - 7
	* Error en la inserción de alguna de las líneas.

## Definición de casos de prueba

* Camino 1: 
    * Entrada: 
    ```cs 
        new Order() {
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
    ```
    * Salida esperada: El método devuelve true e inserta lo anterior en la base.
* Camino 2:
    * Prerrequisitos: El usuario U-AAAAA-000 no existe en la base de datos.
    * Entrada: 
    ```cs 
        new Order() {
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
    ```
    * Salida esperada: El método devuelve false y no se inserta nada en la base de datos.
* Camino 3: 
    * Entrada:
    ```cs 
        new Order() {
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
            lines = new[] { }
        }
    ```
    * Salida esperada: El método devuelve false y no se inserta nada en la base de datos.
* Camino 4: 
    * Prerrequisitos: El producto I-AAAAA-000 no existe en la base de datos.
    * Entrada: 
    ```cs 
        new Order() {
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
    ```
    * Salida esperada: El método devuelve false y no se inserta nada en la base de datos.