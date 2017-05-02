# Método *getAllUsers()*
## Código

```java
public ArrayList<User> getAllUsers() {
		
		ArrayList<User> usuarios = new ArrayList<>();
		
        try {
            openConection();
            String selectSQL = "SELECT * FROM Usuario";
            stm = connection.prepareStatement(selectSQL);
            rs = stm.executeQuery();
            while(rs.next()){
            	usuarios.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6)));
            }
            closeConnection();
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return usuarios;
	}

```
## Definición de nodos
* q0: Sentencias previas al *try*.
* q1: Desde abrir la conexión, acción susceptible de lanzar una excepción, hasta la ejecución de la consulta.
* q2: Condición del while.
* q3: Código dentro del while.
* q4: Cuando se deja de cumplir la condición del while.
* q5: Cierre de la conexión.
* q6: return usuarios.
* q7: Manejo de la excepción

## Complejidad ciclomática

V(G) = a - n + 2 = 10 - 8 + 2 = 4

## Selección de caminos

* Camino 1 (base): 0 - 1 - 2 - 3 - 4 - 5 - 6
	* Camino común con al menos una iteración del bucle while (2 - 3)
* Camino 2 : 0 - 1 - 7 - 6
	* Error al abrir la conexión.
* Camino 3 : 0 - 1 - 2 - 4 - 5 - 6
	* No se obtiene nada de la ejecución de la sentencia SQL y por tanto no se ejecuta el código interno del bucle while.

## Definición de casos de prueba

* Camino 1:
	* Prerrequisitos: Como mínimo debe existir un usuario en la tabla Usuario de la base de datos.
	* Salida esperada: El método devuelve un ArrayList no vacio.
* Camino 2:
	* Prerrequsitos: El servidor de base de datos está desconectado.
	* Salida esperada: El método devuelve un ArrayList vacio.

* Camino 3:
	* Prerrequisitos: La tabla Usuario de la base de datos debe estar vacía.
	*Salina esperada: El método devuelve un ArrayList vacio.