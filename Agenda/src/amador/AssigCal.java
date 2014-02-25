package amador;

import java.util.*;

import edu.Configuracion;
import edu.DiaSemana;
import edu.Internacional;
import edu.Lectura;
import ferran.Utiles;
import ferran.Utiles_v0;

public class AssigCal {

	String[][][] cal_pet = new String[5][32][24];

	private void ini_cal_pet() {
		for (int i = 0; i < cal_pet.length; i++) {
			for (int j = 0; j < cal_pet[0].length; j++) {
				for (int k = 0; k < cal_pet[0][0].length; k++) {
					cal_pet[i][j][k] = "";
				}
			}
		}
	}

	public Calendar establirMesAny(Calendar calendario, int mes, int any) {
		calendario.set(Calendar.YEAR, any);
		calendario.set(Calendar.MONTH, mes - 1);
		calendario.set(Calendar.DAY_OF_MONTH, 1);
		return calendario;
	}

	private Calendar establirDia(Calendar calendario, int dia) {
		calendario.set(Calendar.DAY_OF_MONTH, dia);
		return calendario;
	}
	
	private int assignarDiaInici(int any_conf, int mes_conf, int any_pet, int mes_pet, int dia_pet){
		
		GregorianCalendar cal_conf = new GregorianCalendar(any_conf, mes_conf, 1);
		GregorianCalendar cal_peti = new GregorianCalendar(any_pet, mes_pet, dia_pet);
		
		if (cal_conf.compareTo(cal_peti)>0){
			// Data del conf és superior a la data de la petició
			return cal_conf.get(GregorianCalendar.DAY_OF_MONTH);
		} else {
			// Data del conf és inferior a la data de la petició
			return cal_peti.get(GregorianCalendar.DAY_OF_MONTH);
		}
		
//		int a = cal_conf.getFirstDayOfWeek();
//		cal_conf.setFirstDayOfWeek(GregorianCalendar.MONDAY);
	}

	private int assignarDiaFinal(int any_conf, int mes_conf, int any_pet, int mes_pet, int dia_pet){
		
		GregorianCalendar cal_conf = new GregorianCalendar(any_conf, mes_conf, 1);
		GregorianCalendar cal_peti = new GregorianCalendar(any_pet, mes_pet, dia_pet);
		
		if (cal_conf.compareTo(cal_peti)<0){
			// Data del conf és inferior a la data de la petició
			return cal_conf.get(GregorianCalendar.DAY_OF_MONTH);
		} else {
			// Data del conf és inferior a la data de la petició
			return cal_peti.get(GregorianCalendar.DAY_OF_MONTH);
		}
	}

	
	public void assignarDiaMes(Calendar calendario) {
		// Entrada ent = new Entrada();

		Configuracion conf = new Configuracion("config.txt");
		Internacional cat = new Internacional("internacional."
				+ conf.getIdiomaEntr());
		Lectura peticiones = new Lectura("peticions.txt");
		DiaSemana dias = new DiaSemana(cat, peticiones);

		String[][] peticionsOrdenades = Utiles.sortRequest();
		String[] dates = new String[3];

		ini_cal_pet();

		for (int i = 0; i < peticionsOrdenades.length; i++) {

			// Obtenim el dia inici i final del rang de dates
			// per línea de peticio
			dates = peticionsOrdenades[i][2].split("/");
			int dia_ini = assignarDiaInici((int)conf.getAnyConf(), (int)conf.getMesConf(), Integer.parseInt(dates[2]), Integer.parseInt(dates[1]), Integer.parseInt(dates[0]));
			dates = peticionsOrdenades[i][3].split("/");
			int dia_fi =  assignarDiaInici((int)conf.getAnyConf(), (int)conf.getMesConf(), Integer.parseInt(dates[2]), Integer.parseInt(dates[1]), Integer.parseInt(dates[0]));

			// Obtenir numero de sala
			int sala = Integer.parseInt(peticionsOrdenades[i][1].substring(4));

			// Peticio
			String activitat = peticionsOrdenades[i][0];
			int dia_set;

			// Dividim les diferents franjes horaries
			String[] franja = peticionsOrdenades[i][5].split("_");

			for (int j = dia_ini; j <= dia_fi; j++) {

				String[] hores = new String[2];

				calendario = establirDia(calendario, j);
				dia_set = diaSetmana(calendario);

				System.out.println("Dia mes: "
						+ calendario.get(Calendar.DAY_OF_MONTH)
						+ "Dia setmana: "
						+ calendario.get(Calendar.DAY_OF_WEEK) + " Dia set1: "
						+ dia_set);

				// Verifiquem si el dia de la setmana es troba actiu dins la
				// taula de mascara setmana
				if (dias.getDiasComp().get(i)[dia_set - 1] == true) {

					int dia_mes = calendario.get(Calendar.DAY_OF_MONTH);

					// Estudiem les diferents franjes horaries
					for (int k = 0; k < franja.length; k++) {
						hores = franja[k].split("-");
						int hora_ini = Integer.parseInt(hores[0]);
						int hora_fi = Integer.parseInt(hores[1]);

						// Verifiquem si es es pot assignar la petició

						if (disponibleSalaDiaFranja(sala, dia_mes, hora_ini,
								hora_fi)) {

							// Assignem la petició
							for (int m = hora_ini; m < hora_fi; m++) {
								cal_pet[sala][dia_mes][m] = activitat;
							}
						} else {
							// no disponibilitat

						}
					}
				}

			}

			// cercaDiaSetmana(calendario, dias, dia_ini, dia_fi,
			// franja, sala, activitat);

			// Obtenim els dies de la setmana
			// if (dias.getDiasComp().get(i)[j] == true){
			// cercaDiaSetmana(calendario, j+1, dia_ini, dia_fi,
			// franja, sala, activitat);
			// }
			// }

		}
		for (int y = 0; y < cal_pet.length; y++) {
			System.out.println("SALA" + y);
			for (int z = 0; z < cal_pet[0].length; z++) {
				System.out.println("Dia: " + z);
				System.out.println(Arrays.toString(cal_pet[y][z]));
			}
		}

	}

	private int diaSetmana(Calendar calendario) {
		int dia = calendario.get(Calendar.DAY_OF_WEEK) - 1;
		if (dia == 0)
			dia = 7;
		return dia;
	}

	private boolean disponibleSalaDiaFranja(int sala, int dia, int hora_ini,
			int hora_fi) {
		for (int i = hora_ini; i < hora_fi; i++) {
			if (cal_pet[sala][dia][i] != "")
				return false;
		}
		return true;
	}

	// private void cercaDiaSetmana(Calendar calendario, int dia_set,
	// int dia_ini, int dia_fi, String[] franja, int sala, String activitat){
	//
	// String[] hores = new String[2];
	//
	// for (int i=dia_ini; i <= dia_fi; i++){
	// calendario = establirDia(calendario, i);
	// System.out.println("Dia mes: " + calendario.get(Calendar.DAY_OF_MONTH) +
	// "Dia setmana: " + calendario.get(Calendar.DAY_OF_WEEK) + " Dia set1: " +
	// dia_set);
	// if (calendario.get(Calendar.DAY_OF_WEEK) == dia_set){
	//
	// int dia_mes = calendario.get(Calendar.DAY_OF_MONTH);
	//
	// // Estudiem les diferents franjes horaries
	// for (int k=0; k<franja.length; k++){
	// hores = franja[k].split("-");
	// int hora_ini = Integer.parseInt(hores[0]);
	// int hora_fi = Integer.parseInt(hores[1]);
	//
	// //Verifiquem si es es pot assignar la petició
	//
	// if (disponibleSalaDiaFranja(sala, dia_mes,
	// hora_ini, hora_fi)){
	//
	// // Assignem la petició
	// for (int m=hora_ini; m<hora_fi; m++){
	// cal_pet[sala][dia_mes][m] = activitat;
	// }
	// }
	// else {
	// // no disponibilitat
	//
	// }
	// }
	// }
	// }
	// }

}
