package statistics;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import DAO.DAOInterface;
import DAO.DAOModule;
import model.Purchase;
import model.User;

public class StatisticsModule implements StatisticsInterface{

	private final DAOInterface DAO;
	
	public StatisticsModule(String sCHEMA, String dB_URL, String uSER, String pASS) {
		this.DAO = new DAOModule(sCHEMA,dB_URL,uSER,pASS);
	}
	
	@Override
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

	@Override
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
	    
	}

	@Override
	public int[] getHistogramas(int mode) {
		ArrayList<Purchase> purchases = new ArrayList<>();
		
		for(User u:DAO.getAllUsers()){
			for(Purchase p:DAO.getPurchaseHistorial(u)){
				purchases.add(p);
			}
		}
		
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    
	    switch (mode) {
		case 1:
			while (cal.get(Calendar.DATE) > 1) {
			    cal.add(Calendar.DATE, -1);
			}
		    int numVentasDia = 0;
		    int numDiasMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		    int[] ventasDia = new int[numDiasMes];
		    
			for(int i=0; i<numDiasMes; i++){
		    	for(Purchase p:purchases){
		    		Date fecha= new Date(cal.getTimeInMillis());
		    		if(fecha.toString().equals(p.getDate().toString())){
		    			numVentasDia++;
		    		}
		    	}
		    	ventasDia[i] = numVentasDia;
		    	numVentasDia=0;
		    	cal.add(Calendar.DATE, 1);
		    }
		
			return ventasDia;
			
		case 2:
			while (cal.get(Calendar.DAY_OF_YEAR) > 1) {
			    cal.add(Calendar.DATE, -1);
			}
		    
		    int semanal = 0;
		    int semanaAnterior = 1;
		    int numSemanas = cal.getActualMaximum(Calendar.WEEK_OF_YEAR);
		    int[] ventasSemana = new int[numSemanas];
		    int anhoActual = cal.get(Calendar.YEAR);
		    
			while(cal.get(Calendar.DAY_OF_YEAR) <= cal.getActualMaximum(Calendar.DAY_OF_YEAR) && cal.get(Calendar.YEAR)==anhoActual){
		    	if(semanaAnterior!=cal.get(Calendar.WEEK_OF_YEAR)){
		    		ventasSemana[semanaAnterior-1] = semanal;
		    		semanal = 0;
		    		semanaAnterior = cal.get(Calendar.WEEK_OF_YEAR);
		    	}
		    	for(Purchase p:purchases){
		    		Date fecha= new Date(cal.getTimeInMillis());
		    		if(fecha.toString().equals(p.getDate().toString())){
		    			semanal++;
		    		}
		    	}
		    	cal.add(Calendar.DATE, 1);
		    }
			
			return ventasSemana;
		
		default:
			return null;
		}
	}

	@Override
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
	
}
