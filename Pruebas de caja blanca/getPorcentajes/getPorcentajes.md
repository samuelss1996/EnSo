# Método *getPorcentajes(int mode)
## Código
```java
public float[] getPorcentajes(int mode) {

		switch (mode) {
		case 1:
			int[] ventasDia = getHistogramas(1);
			int totalVentas = 0;
			
			for(int i=0; i<ventasDia.length; i++){
				totalVentas+=ventasDia[i];
			}
			
			float[] porcentajesDia = new float[ventasDia.length];
			
			for(int i=0; i<ventasDia.length; i++){
				porcentajesDia[i] = (float) (ventasDia[i]/totalVentas)*100;
			}
			
			return porcentajesDia;
			
		case 2:
			int[] ventasSemana = getHistogramas(2);
			int total = 0;
			
			for(int i=0; i<ventasSemana.length; i++){
				total+=ventasSemana[i];
			}
			
			float[] porcentajesSemana = new float[ventasSemana.length];
			
			for(int i=0; i<ventasSemana.length; i++){
				porcentajesSemana[i] = (float) (ventasSemana[i]/total)*100;
			}
			
			return porcentajesSemana;
		
		default:
			return null;
		}
	}
```

## Definición de nodos
Sus bucles se tratan como concatenados ya que los valores del segundo dependen del primero en ambos case.

* q0: condición switch case.
* q1: Si mode=1.
* q2: Condición bucle 1 (case1) y código que contiene.
* q3: Condición bucle 2 (case1) y código que contiene.
* q4: Si mode=2.
* q5: Condición bucle 1 (case2) y código que contiene.
* q6: Condición bucle 2 (case2) y código que contiene.
* q7: retorno de los porcentajes (array de floats).
* q8: Si mode no es ni 1 ni 2.
* q9: retorno de un valor nulo.

## Complejidad ciclomática
r: nº regiones cerradas del grafo

V(G) = r = 6

## Selección de caminos
Según la complejidad ciclomática de McCabe hay 6 caminos independientes.

* Camino 1: 0-1-2-3-7
	* Modo = 1, ejecución siguiendo el flujo normal.
* Camino 2: 0-4-5-6-7
	* Modo = 2, ejecución siguiendo el flujo normal.
* Camino 3: 0-8-9
	* Modo!=1 && Modo!=2, se devuelve un nulo.
* Camino 4: 0-1-7
	* Modo = 1, el array de ventas diario está vacío.       
* Camino 5: 0-5-7
	* Modo = 2, el array de ventas está vacío.
* Camino 6:   	

## Definición de casos de prueba
* Camino 1:
	* Prerrequisitos: debe haber por lo menos 1 venta un día.
	* Entrada: mode=1
	* Salida: porcentajes correspondientes a cada día en forma de array de floats no vacío y con algún valor != 0.0 (mínimo 1).
* Camino 2:
	* Prerrequisitos: debe haber por lo menos 1 venta esa semana.
	* Entrada: mode=2
	* Salida: porcentajes correspondientes a cada semana en forma de array de floats no vacío y con algún valor != 0.0 (mínimo 1).
* Camino 3:
	* Prerrequisitos: ninguno.
	* Entrada: mode!=1 && mode!=2
	* Salida: null
* Camino 4:
	* Prerrequisitos: no debe haber compras ningún día
	* Entrada: mode=1
	* Salida: array vacío
* Camino 5:
	* Prerrequisitos: no debe haber compras ninguna semana
	* Entrada: mode=2
	* Salida: array vacío
* Camino 6: ? 
	* Prerrequisitos: ? 
	* Entrada: ? 
	* Salida: ?
	  	

