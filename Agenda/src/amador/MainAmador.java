package amador;

//import java.util.Arrays;

import java.util.Calendar;

import edu.Configuracion;
import amador.Entrada;

public class MainAmador {

	public static void main(String[] args) {

		AssigCal cal = new AssigCal();
		Calendar calendario = Calendar.getInstance();
		Configuracion conf = new Configuracion("config.txt");
		
		cal.assignarDiaMes(calendario);
    	
		for (int i=0; i<Entrada.peticions.length; i++){
			for (int j=0; j<Entrada.peticions[0].length; j++){
				System.out.print(Entrada.peticions[i][j] + " ");
			}
			System.out.println();
		}
		
		int mes = conf.getMesConf();
		int any = conf.getAnyConf();

		System.out.println("Any: " + calendario.get(Calendar.YEAR) + "; Mes:  " + (calendario.get(Calendar.MONTH)+1));
		cal.establirMesAny(calendario, mes, any);
		System.out.println("Any: " + calendario.get(Calendar.YEAR) + "; Mes:  " + (calendario.get(Calendar.MONTH)+1));
			
	}

}
