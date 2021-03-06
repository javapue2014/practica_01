package ferran;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import edu.Configuracion;
import edu.Internacional;
import edu.main;

public class Mesos_main {

	static Configuracion conf = new Configuracion("config.txt");

	// sortida
	private static int weekOfYear1 = 1;
	private static int semanasDelMes;;
	private static int ultimDiaMes;

	static ArrayList<boolean[]> diesMes = new ArrayList<boolean[]>();
	static boolean[] pertanyAlMes = new boolean[7];

	// private static int mes = conf.getMesConf();
	// private static int any = conf.getAnyConf();

	private static int mes = 6;
	private static int any = 2014;

	public static int diesMes(int mes, int any) {
		int qDies = 0;
		// this.mes = mes;
		// this.any = any;
		if ((mes == 2) && (any % 4 == 0)) {
			mes = 13;
		}
		switch (mes) {
		case 1:
			qDies = 31;
			break;
		case 2:
			qDies = 28;
			break;
		case 3:
			qDies = 31;
			break;
		case 4:
			qDies = 30;
			break;
		case 5:
			qDies = 31;
			break;
		case 6:
			qDies = 30;
			break;
		case 7:
			qDies = 31;
			break;
		case 8:
			qDies = 31;
			break;
		case 9:
			qDies = 30;
			break;
		case 10:
			qDies = 31;
			break;
		case 11:
			qDies = 30;
			break;
		case 12:
			qDies = 31;
			break;
		case 13:
			qDies = 29;
			break;
		}

		return qDies;
	}

	public static void main(String[] args) {

		Internacional cat = new Internacional("internacional."
				+ conf.getIdiomaEntr());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar dataAny = new GregorianCalendar(any, (mes - 1), 1, 00, 00, 00);
		Calendar dataAny2 = new GregorianCalendar(any, (mes - 1), 1, 00, 00, 00);

		int month = dataAny.get(Calendar.MONTH) + 1;

		// System.out.println("Primer dia del mes:  " + dataAny.getTime());
		Date date = new Date();
		// dataAny.setTime(date);
		dataAny.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		// System.out.println("MONDAY: " + dataAny.getTime());

		// dia de la setmana en n�mero. 0 = diumenge
		int primerDiaMes = dataAny.get((Calendar.DAY_OF_WEEK));
		// System.out.println("El primer dia del mes �s"+primerDiaMes);

		dataAny.setMinimalDaysInFirstWeek(0);

		dataAny.add(Calendar.DATE, -(dataAny.get(Calendar.DAY_OF_WEEK) - 2));

		int primerDiaSetmana = dataAny.get((Calendar.DAY_OF_MONTH));

		// /
		weekOfYear1 = dataAny.get(Calendar.WEEK_OF_YEAR);
		dataAny2.add(Calendar.DATE, +diesMes(mes, any) - 1);

		System.out.println("Ultim dia del mes:  " + dataAny2.getTime());//////////////////

		int weekOfYear2 = dataAny2.get(Calendar.WEEK_OF_YEAR);
		

		int semanasDelMes;

		if (mes == 2 && dataAny.get(Calendar.DAY_OF_WEEK) == 2 && any % 4 == 0) {
			// System.out.println(1);
			semanasDelMes = weekOfYear2 - weekOfYear1;
		} else if (mes == 2) {
			// System.out.println(2);
			semanasDelMes = weekOfYear2 - weekOfYear1 + 1;
		} else if (dataAny.get(Calendar.DAY_OF_WEEK) == 0) {
			// System.out.println(3);
			// System.out.println(sdf.format(dataAny.getTime()));
			dataAny.add(Calendar.DATE, -2);
			// System.out.println(sdf.format(dataAny.getTime()));
			semanasDelMes = weekOfYear2 - weekOfYear1 + 2;
		} else {
			// System.out.println(4);
			semanasDelMes = weekOfYear2 - weekOfYear1 + 1;
		}

		if (semanasDelMes < 0) {
			dataAny2.add(Calendar.DATE, -7);
			weekOfYear2 = dataAny2.get(Calendar.WEEK_OF_YEAR);
			semanasDelMes = weekOfYear2 - weekOfYear1 + 2;
		}

		
		if (primerDiaSetmana == 2) {
			dataAny.add(Calendar.DATE, -7);
			primerDiaSetmana = dataAny.get((Calendar.DAY_OF_MONTH));
			semanasDelMes = semanasDelMes + 1;
		}

		ultimDiaMes = dataAny2.get((Calendar.DAY_OF_MONTH));
		//System.out.println(ultimDiaSetmana);
		System.out.println(semanasDelMes);

		for (int j = 0; j < semanasDelMes; j++) {
			// System.out.println("bucle j");
			pertanyAlMes = new boolean[7];
			for (int i = 0; i < 7; i++) {
				pertanyAlMes[i] = false;

				int x = mes;
				x--;

				if (dataAny.get(Calendar.MONTH) == x) {
					pertanyAlMes[i] = true;
				}

				// imprimir-ho en pantalla
				// System.out.print(primerDiaSetmana + "\t");

				dataAny.add(Calendar.DATE, +1);
				primerDiaSetmana = dataAny.get((Calendar.DAY_OF_MONTH));

			}
			diesMes.add(pertanyAlMes);
			System.out.println("\n");
		}

		// imprimir l'ArraList
//		for (int i = 0; i < diesMes.size(); i++) {
//			System.out.println(Arrays.toString(diesMes.get(i)));
//		}
		
	

	}

}
