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

public class Calendario {

	Configuracion conf = new Configuracion("config.txt");
	private int mes;
	private int any;
	
	// opcions de prova del config
	//private int mes = conf.getMesConf();
	//private int any = conf.getAnyConf();

	// sortida
	private int semana1 = 1;
	private int semanasDelMes;
	private int ultimDiaMes;
	public int nSemanas;

	public int getUltimDiaMes() {
		return ultimDiaMes;
	}

	public int getSemana1() {
		return semana1;
	}

	public void setSemana1(int semana1) {
		this.semana1 = semana1;
	}

		
	private int primerDiaMes = 1;
	private int primerDiaSetmana;

	// private static int mes = 2;
	// private static int any = 2014;

	private int diesMes(int mes, int any) {
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

	public ArrayList<boolean[]> trueOFalse(int mes, int any) throws CalendarioMesNoValidoException {
		
		
		ArrayList<boolean[]> diesMes = new ArrayList<boolean[]>();
		
		diesMes.clear();
		
		boolean[] pertanyAlMes = new boolean[7];
		
		this.mes = mes;
		this.any = any;
		
		if (mes < 1 || mes > 12) {
			throw new CalendarioMesNoValidoException ();
			}
		
		
		//*Internacional cat = new Internacional("internacional."+ conf.getIdiomaEntr());

		//*SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar dataAny = new GregorianCalendar(any, (mes - 1), 1, 00, 00, 00);
		Calendar dataAny2 = new GregorianCalendar(any, (mes - 1), 1, 00, 00, 00);

		//* int month = dataAny.get(Calendar.MONTH) + 1;

		//* System.out.println("Primer dia del mes:  " + dataAny.getTime());
		//*Date date = new Date();
		// dataAny.setTime(date);
		dataAny.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		// System.out.println("MONDAY: " + dataAny.getTime());

		// dia de la setmana en número. 0 = diumenge
		primerDiaMes = dataAny.get((Calendar.DAY_OF_WEEK));
		// System.out.println("El primer dia del mes és"+primerDiaMes);

		dataAny.setMinimalDaysInFirstWeek(0);

		dataAny.add(Calendar.DATE, -(dataAny.get(Calendar.DAY_OF_WEEK) - 2));

		primerDiaSetmana = dataAny.get((Calendar.DAY_OF_MONTH));

		// /
		semana1 = dataAny.get(Calendar.WEEK_OF_YEAR);
		dataAny2.add(Calendar.DATE, +diesMes(mes, any) - 1);

		// System.out.println("Ultim dia del mes:  " + dataAny2.getTime());

		int weekOfYear2 = dataAny2.get(Calendar.WEEK_OF_YEAR);

		int semanasDelMes;

		if (mes == 2 && dataAny.get(Calendar.DAY_OF_WEEK) == 2 && any % 4 == 0) {
			// System.out.println(1);
			semanasDelMes = weekOfYear2 - semana1;
		} else if (mes == 2) {
			// System.out.println(2);
			semanasDelMes = weekOfYear2 - semana1 + 1;
		} else if (dataAny.get(Calendar.DAY_OF_WEEK) == 0) {
			// System.out.println(3);
			// System.out.println(sdf.format(dataAny.getTime()));
			dataAny.add(Calendar.DATE, -2);
			// System.out.println(sdf.format(dataAny.getTime()));
			semanasDelMes = weekOfYear2 - semana1 + 2;
		} else {
			// System.out.println(4);
			semanasDelMes = weekOfYear2 - semana1 + 1;
		}

		if (semanasDelMes < 0) {
			dataAny2.add(Calendar.DATE, -7);
			weekOfYear2 = dataAny2.get(Calendar.WEEK_OF_YEAR);
			semanasDelMes = weekOfYear2 - semana1 + 2;
		}

		if (primerDiaSetmana == 2) {
			dataAny.add(Calendar.DATE, -7);
			primerDiaSetmana = dataAny.get((Calendar.DAY_OF_MONTH));
			semanasDelMes = semanasDelMes + 1;
		}

		nSemanas = semanasDelMes;

		ultimDiaMes = dataAny2.get((Calendar.DAY_OF_MONTH));

		for (int j = 0; j < semanasDelMes; j++) {
			
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
			// System.out.println("\n");
		}

		// imprimir l'ArraList
		// for (int i = 0; i < diesMes.size(); i++) {
		// System.out.println(Arrays.toString(diesMes.get(i)));
		// }

		return diesMes;

	}

	public int getSemanasDelMes() {
		return semanasDelMes;
	}

}
