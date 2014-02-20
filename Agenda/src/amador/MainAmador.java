package amador;

//import java.util.Arrays;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import edu.Configuracion;
import ferran.Principal;
import ferran.Utiles;
import amador.Entrada;

public class MainAmador {

	public static void main(String[] args) {

		Configuracion conf = new Configuracion("config.txt");
		Principal princ = new Principal();
		
		
		String[][] peticionsOrdenades = Utiles.sortRequest();

		for (int i = 0; i < 16; i++) {
			System.out.println(Arrays.toString(peticionsOrdenades[i]));
		}
		
		
		Calendar calendario = Calendar.getInstance(Locale.FRANCE);
		
		AssigCal cal = new AssigCal();

		int mes = conf.getMesConf();
		int any = conf.getAnyConf();

		calendario = cal.establirMesAny(calendario, mes, any);
		cal.assignarDiaMes(calendario);
    	
		for (int i=0; i<Entrada.peticions.length; i++){
			for (int j=0; j<Entrada.peticions[0].length; j++){
				System.out.print(Entrada.peticions[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Any: " + calendario.get(Calendar.YEAR) + "; Mes:  " + (calendario.get(Calendar.MONTH)+1));
		cal.establirMesAny(calendario, mes, any);
		System.out.println("Any: " + calendario.get(Calendar.YEAR) + "; Mes:  " + (calendario.get(Calendar.MONTH)+1));
			
	}

}
