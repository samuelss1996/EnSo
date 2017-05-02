# getPorcentajes ()

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