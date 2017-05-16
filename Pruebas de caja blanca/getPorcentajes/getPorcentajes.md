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
* q2: Condición bucle 1 (case 1).
* q3: Código que contiene el bucle 1.
* q4: Inicialización del array de floats.
* q5: Condición bucle 2 (case 1).
* q6: Código del bucle 2 (case 1).
* q7: Return en caso de que no se cumpla la condición del bucle 2 (case 1).
* q8: Si mode=2.
* q9: Condición bucle 1 (case 2).
* q10: Código que contiene el bucle 1 (case 2).
* q11: Inicialización del array de floats.
* q12: Condición bucle 2 (case 2).
* q13: Código del bucle 2 (case 2).
* q14: Return en caso de que no se cumpla la condición del bucle 2 (case 2).
* q15: Si mode no es ni 1, ni 2 (default).

## Complejidad ciclomática
r: nº regiones cerradas del grafo

V(G) = r = 5

## Selección de caminos
Según la complejidad ciclomática de McCabe hay 5 caminos independientes.

* Camino 1: 0-1-2-3-2-4-5-6
	* Modo = 1, ejecución siguiendo el flujo normal.
* Camino 2: 0-1-2-3-2-4-5-7
	* Modo = 1, ejecución con condición no cumplida en el segundo bucle.
* Camino 3: 0-8-9-10-9-11-12-13
	* Modo=2, ejecución siguiendo el flujo normal.
* Camino 4: 0-8-9-10-9-11-12-14
	* Modo = 2, ejecución con condición no cumplida en el segundo bucle.    
* Camino 5: 0-15
	* Modo!=1 && Modo!=2

## Definición de casos de prueba
* Camino 1:
	* Prerrequisitos: debe haber por lo menos 1 venta un día.
	* Entrada: mode=1
	* Salida: porcentajes correspondientes a cada día en forma de array de floats no vacío y con algún valor != 0.0 (mínimo 1).
* Camino 2:
	* Prerrequisitos: no debe haber compras ningún día
	* Entrada: mode=1
	* Salida: array vacío
* Camino 3:
	* Prerrequisitos: debe haber por lo menos 1 venta esa semana.
	* Entrada: mode=2
	* Salida: porcentajes correspondientes a cada semana en forma de array de floats no vacío y con algún valor != 0.0 (mínimo 1).
* Camino 4:
	* Prerrequisitos: no debe haber compras ninguna semana
	* Entrada: mode=2
	* Salida: array vacío
* Camino 5:
	* Prerrequisitos: ninguno.
	* Entrada: mode!=1 && mode!=2
	* Salida: null
	  	

