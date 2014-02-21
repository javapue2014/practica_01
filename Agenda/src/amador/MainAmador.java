package amador;

//import java.util.Arrays;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import edu.Configuracion;
import ferran.Utiles;

public class MainAmador {

	public static void main(String[] args) {

		Configuracion conf = new Configuracion("config.txt");
		
		String[][] peticionsOrdenades = Utiles.sortRequest();

		Calendar calendario = Calendar.getInstance(Locale.FRANCE);
		
		AssigCal cal = new AssigCal();

		int mes = conf.getMesConf();
		int any = conf.getAnyConf();

		calendario = cal.establirMesAny(calendario, mes, any);
		cal.assignarDiaMes(calendario);
    	
		for (int i = 0; i < peticionsOrdenades.length; i++) {
			System.out.println(Arrays.toString(peticionsOrdenades[i]));
		}

/*		for (int i=0; i<peticionsOrdenades.length; i++){
			for (int j=0; j<peticionsOrdenades[0].length; j++){
				System.out.print(peticionsOrdenades[i][j] + " ");
			}
			System.out.println();
		}
*/		
		System.out.println("Any: " + calendario.get(Calendar.YEAR) + "; Mes:  " + (calendario.get(Calendar.MONTH)+1));
		cal.establirMesAny(calendario, mes, any);
		System.out.println("Any: " + calendario.get(Calendar.YEAR) + "; Mes:  " + (calendario.get(Calendar.MONTH)+1));
			
	}

}
