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
* q1: Condición del for.
* q2: Condición del for interno y código interno del mismo.
* q3: Código interno del primer for.
* q4: Código secuencial hasta el siguiente bucle.
* q5: Condición del for.
* q6: Condición del for interno.
* q7: Ejecución del if.
* q8: Condición verdadera y código asociado a la misma-
* q9: Condición falsa.
* q10: Código interno del for externo.
* q11: return valores.

## Complejidad ciclomática

V(G) = a - n + 2 = 17 - 12 + 2 = 7

## Selección de caminos

* Camino 1 (base): 0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 10 - 11
	* Camino común con al menos una iteración de cada bucle y la condición verdadera.
* Camino 2 : 0 - 1 - 4 - 5 - 6 - 10 - 11
	* La tabla de usuarios está vacia por lo que el primer conjunto de bucles no se ejecuta y el for interno del segundo tampoco.
* Camino 3 : 0 - 1 - 2 - 3 - 4 - 11
	*  Se introduce 0 como valor de dias.
* Camino 4: 0 - 1 - 2 - 3 - 4 - 5 - 6 - 10 - 11
	* La tabla de purchases está vacía, por lo que no se ejecuta el primer for interno ni el segundo.
* Camino 5: 0 
	* Se introduce un valor menor que 0 como valor de dias.

## Definición de casos de prueba

* Camino 1:
	* Entrada: ``` dias = 1 ``` como mínimo.
	* Prerrequisitos: Como mínimo debe existir un usuario en la tabla Usuario de la base de datos y una compra asociada a este en la tabla Purchase.
	* Salida esperada: El método devuelve un int[] no vacio.
* Camino 2:
	* Entrada: ``` dias = 1 ``` como mínimo.
	* Prerrequsitos: La tabla Usuario de la base de datos debe estar vacía.
	* Salida esperada: El método devuelve un int[] vacio.

* Camino 3:
	* Entrada: ``` dias = 0 ```.
	* Prerrequsitos: Como mínimo debe existir un usuario en la tabla Usuario de la base de datos y una compra asociada a este en la tabla Purchase.
	* Salida esperada: El método devuelve un int[] vacio.

* Camino 4:
	* Entrada: ``` dias = 1 ``` como mínimo.
	* Prerrequisitos: Como mínimo debe existir un usuario en la tabla Usuario de la base de datos y la tabla Purchase debe estar vacia.
	*Salina esperada: El método devuelve un ArrayList vacio.

* Camino 3:
	* Entrada: ``` dias = -1 ```.
	* Salida esperada: El método devuelve(?) una excepción no controlada.