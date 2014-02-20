package amador;

import java.util.*;

import edu.*;
//import eva.*;

public class AssigCal {
	
	boolean [] dia_mes = new boolean[31];
	String[][][] cal_pet = new String [2][31][24];
	
	private void ini_dia_mes (){
		for (int i=0; i<dia_mes.length; i++){
			dia_mes[i] = false;
		}
	}
	
	private void ini_cal_pet (){
		for (int i=0; i<cal_pet.length; i++){
			for (int j=0; j<cal_pet[0].length; j++){
				for (int k=0; k<cal_pet[0][0].length; k++){
					cal_pet[i][j][k] = "";
				}
			}
		}
	}

	public Calendar establirMesAny(Calendar calendario, int mes, int any){
        calendario.set(Calendar.YEAR,any);
        calendario.set(Calendar.MONTH,mes-1);
        calendario.set(Calendar.DAY_OF_MONTH,1);
        return calendario;
    }
    
    public Calendar establirDia(Calendar calendario, int dia){
        calendario.set(Calendar.DAY_OF_MONTH,dia);
        System.out.println("Dia mes: " + calendario.get(Calendar.DAY_OF_MONTH) + "Dia setmana: " + calendario.get(Calendar.DAY_OF_WEEK));
        return calendario;
    }
    
    public void assignarDiaMes(Calendar calendario){
		Entrada ent = new Entrada();

    	String [] dates = new String[3];
    	ini_dia_mes();
    	ini_cal_pet();
    	
    	
    
		for (int i=0; i<ent.peticions.length; i++){

			// Obtenim el dia inici i final del rang de dates
			// per línea de peticio
	    	dates = ent.peticions[i][2].split("/");
	    	int dia_ini = Integer.parseInt(dates[0]);
	    	dates = ent.peticions[i][3].split("/");
	    	int dia_fi = Integer.parseInt(dates[0]);

	    	for (int j=0; j<ent.dies.length; j++){
	    		// Obtenim els dies de la setmana
	    		if (ent.dies[i][j] == true){
	    			cercaDiaSetmana(calendario, j+1, dia_ini, dia_fi);
	    		}
	    		
	    		
			}

	    	System.out.println( Arrays.toString(dia_mes));
		}
    	
    }
    
    private void cercaDiaSetmana(Calendar calendario, int dia_set,
    		int dia_ini, int dia_fi){
    	for (int i=dia_ini; i <= dia_fi; i++){
    		calendario = establirDia(calendario, i);
            System.out.println("Dia set1: " + dia_set + " Dia setmana: " + calendario.get(Calendar.DAY_OF_WEEK));
    		if (calendario.get(Calendar.DAY_OF_WEEK) == dia_set){
    			dia_mes[i] = true;
    		}
    	}
    }
	
    
}
