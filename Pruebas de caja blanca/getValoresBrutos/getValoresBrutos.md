# Método *getValoresBrutos(int dias)*
## Código

```java
	public int[] getValoresBrutos(int dias) {
		
		ArrayList<Purchase> purchases = new ArrayList<>();
		int[] valores = new int[dias];
				
		for(User u:DAO.getAllUsers()){
			for(Purchase p:DAO.getPurchaseHistorial(u)){
				purchases.add(p);
			}
		}
				
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);

	    int numVentas = 0;
	    
	    for(int i=0; i<dias; i++){
	    	cal.add(Calendar.DATE, -i);
	    	for(Purchase p:purchases){
	    		Date fecha= new Date(cal.getTimeInMillis());
	    		if(fecha.toString().equals(p.getDate().toString())){
	    			numVentas++;
	    			System.out.println("COINCIDE");
	    		}
	    	}
	    	valores[i] = numVentas;
	    	numVentas = 0;
	    }
	    
		return valores;
	}

```
## Definición de nodos
* q0: Sentencias previas al for.
* q1: Condición del primer for.
* q2: Código interno del primer for y condición del for interno.
* q3: Código interno del for interno.
* q4: Código secuencial.
* q5: Condición del segundo for.
* q6: Código interno del segundo for
* q7: Condición del for interno.
* q6: Código interno del for interno.
* q9: Ejecución del if.
* q10: Condición verdadera y código asociado a la misma.
* q11: return valores.

## Complejidad ciclomática

V(G) = a - n + 2 = 16 - 12 + 2 = 6

## Selección de caminos

* Camino 1 (base): 0 - 1 - 2 - 3 - 2 - 1 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 7 - 5 - 11
	* Camino común con al menos una iteración de cada bucle y la condición verdadera.
* Camino 2 : 0 - 1 - 4 - 5 - 6 - 7 - 5 - 11
	* La tabla de usuarios está vacia por lo que el primer conjunto de bucles no se ejecuta y el for interno del segundo tampoco.
* Camino 3 : 0 - 1 - 2 - 3 - 2 - 1 - 4 - 5 - 11
	*  Se introduce 0 como valor de dias.
* Camino 4: 0 - 1 - 2 - 1 - 4 - 5 - 6 - 7 - 5 - 11
	* La tabla de purchases está vacía, por lo que no se ejecuta el primer for interno ni el segundo.
* Camino 5: 0 - 1 - 2 - 3 - 2 - 1 - 4 - 5 - 6 - 7 - 8 - 9 - 10 - 7 - 5 - 11
	* La tabla de purchases tiene más de un valor, la de usuarios tiene más de un valor y se introduce más de un día al método.
* Camino 6: 0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 9 - 10
	* El if nunca se cumple.

## Definición de casos de prueba

* Camino 1:
	* Prerrequisitos: Como mínimo debe existir un usuario en la tabla Usuario de la base de datos y una compra asociada a este en la tabla Compra.
	* Entrada: ``` dias = 1 ```.
	* Salida esperada: El método devuelve un int[] no vacio.
* Camino 2:
 	* Prerrequsitos: La tabla Usuario de la base de datos debe estar vacía.
	* Entrada: ``` dias = 1 ```.
	* Salida esperada: El método devuelve un int[] no vacio con todos los valores iguales a cero 0.

* Camino 3:
 	* Prerrequsitos: Debe existir un usuario en la tabla Usuario de la base de datos y una compra asociada a este en la tabla Compra.
	* Entrada: ``` dias = 0 ```.
	* Salida esperada: El método devuelve un int[] vacio.

* Camino 4:
	* Prerrequisitos: Debe existir un usuario en la tabla Usuario de la base de datos y la tabla Compra debe estar vacia.
	* Entrada: ``` dias = 1 ```.
	* Salida esperada: El método devuelve un int[] vacio.

* Camino 5:
	* Prerrequisitos: Deben existir como mínimo cinco usuarios y cero, una o varias compras asociadas a ellos en los últimos 5 días.
	* Entrada: ``` dias = 5 ```.
	* Salida esperada: El método devuelve un int[] no vacio con valores que pueden ser iguales o distintos a cero.
* Camino 6:
	* Entrada: ```dias = 1```
	* Prerrequisitos: Como mínimo debe existir un usuario en la tabla Usuario de la base de datos y una compra asociada a este en la tabla Compra, pero esta compra debe haber sido realizada previamente al día en que se realice la prueba.
	* Salida esperada: El método devuelve un int[] no vacio con todos los valores iguales a 0.





