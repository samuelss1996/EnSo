# Método *getMedias(int dias)
## Código
```java
		public float getMedias(int dias) {
		ArrayList<Purchase> purchases = new ArrayList<>();
		
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
	    		}
	    	}
	    }
	    	    
	    return (float) numVentas/dias;

```

## Definición de nodos
* q0: Código hasta el primer bucle.
* q1: Condición del for 1.
* q2: Código del for 1 + condición del for interno 1.1
* q3: Contenido del for interno 1.1.
* q4: Código hasta for 2 + condición for 2.
* q5: Código del for 2 + condición for interno 2.1. 
* q6: Código del for interno 2.1.
* q7: Ejecución del if.
* q8: Condición true + código de dicha condición.
* q9: return de la media calculada.

## Complejidad ciclomática
r: nº regiones cerradas del grafo

V(G) = r = 7

## Selección de caminos
Según la complejidad ciclomática de McCabe hay 7 caminos independientes.

* Camino 1: 0-1-2-3-4-5-6-7-8-9
	* Al menos una iteración por bucle + condición verdadera en el if.
* Camino 2: 0-1-2-3-4-5-6-7-9
	* Al menos una iteración por bucle + condición falsa en el if.
* Camino 3: 0
	* Se introduce un valor negativo para los días como argumento. Sólo se ejecutaría el nodo 0.
* Camino 4: 0-1-2-3-4-9
	* El nº de días introducidos es 0 por lo que no se ejecuta el segundo bucle ni su contenido.
* Camino 5: 0-1-4-5-9
	* No hay usuarios, por tanto no se ejecuta el primer bucle ni su bucle interno ni el bucle interno y la condición del segundo bucle externo.
* Camino 6: 0-1-2-3-4-5-9
	* No hay compras, por lo que no se ejecuta el contenido del for 1.1 ni del 2.1 (es decir, no se ejecutan los bucles internos).
* Camino 7:  ?

## Definición de casos de prueba
* Camino 1:
	* Prerrequisitos: tiene que haber usuarios (mínimo 1) con compras realizadas (mínimo 1) almacenado en la BBDD.
	* Entrada: días>=1
	* Salida esperada: float con valor >0.
* Camino 2: 
	* Prerrequisitos: tiene que haber usuarios (mínimo 1) con compras realizadas (mínimo 1) almacenado en la BBDD.
	* Entrada: días>=1
	* Salida esperada: float con valor = 0.
* Camino 3: 
	* Prerrequisitos: ninguno, ya que la ejecución se termina en el nodo 0.
	* Entrada: días < 0.
	* Salida esperada: un mensaje de error o, en su defecto, una excepción.
* Camino 4:
	* Prerrequisitos: tiene que haber usuarios (mínimo 1) con compras realizadas (mínimo 1) almacenado en la BBDD.
	* Entrada: días=0
	* Salida esperada: float con valor=0.0.
* Camino 5: 
	* Prerrequisitos: no hay usuarios almacenados en la BBDD.
	* Entrada: días>=1.
	* Salida esperada: float con valor=0.0.
* Camino 6: 
	* Prerrequisitos: tiene que haber usuarios (mínimo 1) sin compras realizadas almacenado en la BBDD. Es decir, la tabla Compras debe estar vacía.
	* Entrada: días>=1
	* Salida esperada: float con valor=0.0.
* Camino 7: ? 

 






