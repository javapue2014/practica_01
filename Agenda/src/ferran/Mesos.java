package ferran;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import edu.Configuracion;
import edu.Internacional;
import edu.main;

public class Mesos {

	static Configuracion conf = new Configuracion("config.txt");
	
	// private int mes = conf.getMesConf();
	// private int any = conf.getAnyConf();

	private static int mes = 8;
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
		
		Internacional cat = new Internacional("internacional."+conf.getIdiomaEntr());
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar dataAny = new GregorianCalendar(any, (mes - 1), 1, 00, 00, 00);
		Calendar dataAny2 = new GregorianCalendar(any, (mes - 1), 1, 00, 00, 00);

		// dia de la setmana en n�mero. 0 = diumenge
		int primerDiaMes = dataAny.get((Calendar.DAY_OF_WEEK));
		dataAny.setMinimalDaysInFirstWeek(1);

		dataAny.add(Calendar.DATE, -(dataAny.get(Calendar.DAY_OF_WEEK) - 2));

		int primerDiaSetmana = dataAny.get((Calendar.DAY_OF_MONTH));

		int weekOfYear1 = dataAny.get(Calendar.WEEK_OF_YEAR);
		dataAny2.add(Calendar.DATE, +diesMes(mes, any));
		
		int weekOfYear2 = dataAny2.get(Calendar.WEEK_OF_YEAR);

		int setmanesMes;

		if (mes == 2 && dataAny.get(Calendar.DAY_OF_WEEK) == 2 && any % 4 == 0) {
			System.out.println(1);
			setmanesMes = weekOfYear2 - weekOfYear1;
		} else if (mes == 2) {
			System.out.println(2);
			setmanesMes = weekOfYear2 - weekOfYear1 +1;
		} else if (dataAny.get(Calendar.DAY_OF_WEEK) == 0) {
			System.out.println(3);
			System.out.println(sdf.format(dataAny.getTime()));
			dataAny.add(Calendar.DATE, -2);
			System.out.println(sdf.format(dataAny.getTime()));
			setmanesMes = weekOfYear2 - weekOfYear1 + 2;
		} else {
			System.out.println(4);
			setmanesMes = weekOfYear2 - weekOfYear1 +1;
		}

		int diaMes = dataAny.get(Calendar.DAY_OF_WEEK);
		System.out.println(diaMes);
		System.out.println(sdf.format(dataAny.getTime()));
		
		System.out.println(cat.getInterDoc().get("004")[1].split(",")[mes-1]+ "\n");
		
		
		for (int j = 0; j < setmanesMes; j++) {
			for (int i = 0; i < 7; i++) {
				System.out.print(primerDiaSetmana + "\t");
				dataAny.add(Calendar.DATE, +1);
				primerDiaSetmana = dataAny.get((Calendar.DAY_OF_MONTH));

			}
			System.out.println("\n");
		}
	}

}
