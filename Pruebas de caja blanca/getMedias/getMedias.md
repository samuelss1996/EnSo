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
* q0: Código secuencial hasta el primer bucle
* q1: Condición del for
* q2: Condición del for interno y código del mismo
* q3: Contenido del for externo
* q4: Código secuencial hasta el siguiente bucle
* q5: Condición primer for 
* q6: Condición del for interno
* q7: Ejecución del if
* q8: 





