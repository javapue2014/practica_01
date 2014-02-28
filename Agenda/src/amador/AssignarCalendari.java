package amador;

//import java.util.Arrays;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import edu.Configuracion;
import edu.DiaSemana;
import edu.Internacional;
import edu.Lectura;
import ferran.Utiles;
import ferran.Utiles_v0;

public class AssignarCalendari {
	
	public static int numeroSalas() {
		AssigCal cal = new AssigCal();
		return cal.getNumSalas();		
	}
	

	public static String[][][] assignarCal() {

		Configuracion conf = new Configuracion("config.txt");

		String[][] peticionsOrdenades = Utiles.sortRequest();

		Calendar calendario = Calendar.getInstance();
		
		Internacional cat = new Internacional("internacional."
				+ conf.getIdiomaEntr());
		Lectura peticiones = new Lectura("peticions.txt");
		DiaSemana dias = new DiaSemana(cat, peticiones);

		AssigCal cal = new AssigCal();

		int mes = conf.getMesConf();
		int any = conf.getAnyConf();
		
		String [][][] cal_peticions = cal.getCal_pet();
		
		calendario = cal.establirDiaMesAny(calendario, 1, mes, any);

		cal.assignarDiaMes(calendario);

		return cal_peticions;
	}
	

}
