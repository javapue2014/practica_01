package amador;

import java.util.*;

import edu.*;
//import eva.*;

public class AssigCal {
	

    public void establirMesAny(Calendar calendario, int mes, int any){
        calendario.set(Calendar.YEAR,any);
        calendario.set(Calendar.MONTH,mes-1);
        calendario.set(Calendar.DAY_OF_MONTH,1);
    }
    
    public void establirDia(Calendar calendario, int dia){
        calendario.set(Calendar.DAY_OF_MONTH,dia);
    }
    
    public void assignarDiaMes(Calendar calendario){
		Entrada ent = new Entrada();

    	String [] dates = new String[3];
    	boolean [] dia_mes = new boolean[31];

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
	    			cercaDiaSetmana(calendario, dia_mes, j+1, dia_ini, dia_fi);
	    		}
			}

	    	System.out.println( Arrays.toString(dia_mes));
		}
    	
    }
    
    private void cercaDiaSetmana(Calendar calendario, boolean[] dia_mes, int dia_set,
    		int dia_ini, int dia_fi){
    	for (int i=dia_ini; i <= dia_fi; i++){
    		establirDia(calendario, i);
    		if (calendario.DAY_OF_WEEK == dia_set){
    			dia_mes[i] = true;
    		}
    	}
    }
	
    
}
