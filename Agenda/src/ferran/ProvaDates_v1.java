package ferran;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ProvaDates_v1 {

	public static void main(String[] args) throws ParseException {

		ProvaDates_v1 prog = new ProvaDates_v1();
		prog.inici();
	}

	public void inici() throws ParseException {
		// diaHoyFormateada_1();
		// diaHoyFormateada_2();
		// diaHoyFormateada_3();
		// DateFormatConversion();
		// dateFormatShortDates();
		// TestFechas();
		// TestGetTime();
		// TestCalendar();
		// prova();
		// diferenciaFechas("07/10/2008","08/11/2008",1);
		//provaDiess2();
		//getDayOfTheWeek(2014);

	}

	public void diaHoyFormateada_1() {

		Date fechaHoy = new Date(); // Obtenemos la fecha de hoy
		System.out.println("Fecha de hoy sin formatear: " + fechaHoy);

		// Utilizamos la clase DateFormat para formaterar Fechas y horas
		// El método getInstance() obtiene una instancia para formatos
		// Fecha/Hora, se emplea la configuracion regional del ordenador
		// (Locale),
		// ademas, el formato es el corto (SHORT): dd/MM/yy HH:mm
		String cadenaFecha = DateFormat.getInstance().format(fechaHoy);

		System.out
				.println("Fecha/Hora formateada con la configuracion regional (formato corto por defecto): "
						+ cadenaFecha);
	}

	public void diaHoyFormateada_2() {

		Date fechaHoy = new Date(); // Obtenemos la fecha de hoy

		// El método getDateInstance() obtiene una instancia para formatos
		// Fecha (sin hora). Por defecto se emplea la configuracion
		// regional del ordenador (Locale), ademas, el formato es
		// el mediano (MEDIUM): dd-mes-yyyy
		String cadenaFecha = DateFormat.getDateInstance().format(fechaHoy);

		System.out
				.println("Fecha formateada con la configuracion regional (formato mediano por defecto): "
						+ cadenaFecha);

		// Mostramos la fecha formateada pero forzando el formato corto (SHORT)
		cadenaFecha = DateFormat.getDateInstance(DateFormat.SHORT).format(
				fechaHoy);

		System.out
				.println("Fecha formateada con la conf. reg. forzando formato corto: "
						+ cadenaFecha);
		// Mostramos la fecha formateada pero forzando el formato LONG
		cadenaFecha = DateFormat.getDateInstance(DateFormat.LONG).format(
				fechaHoy);

		System.out
				.println("Fecha formateada con la conf. reg. forzando formato largo: "
						+ cadenaFecha);

		// Mostramos la fecha formateada pero forzando el formato FULL
		cadenaFecha = DateFormat.getDateInstance(DateFormat.FULL).format(
				fechaHoy);

		System.out
				.println("Fecha formateada con la conf. reg. forzando formato completo: "
						+ cadenaFecha);

	}

	public void diaHoyFormateada_3() {

		Date fechaHoy = new Date(); // Obtenemos la fecha de hoy

		// Comprobamos cual es la configuración regional
		Locale miConfRegional = Locale.getDefault();
		System.out.println("Configuracion regional: " + miConfRegional);

		System.out
				.println("Fecha formateada con la conf reg. inglesa (formato mediano por defecto):"
						+ DateFormat.getDateInstance(DateFormat.MEDIUM,
								Locale.ENGLISH).format(fechaHoy));

	} // veure locale Iso Codes

	public void DateFormatConversion() {

		String cadenaFecha = "31/12/01";
		// Obtenemos un formateador. Ya que la cadena emplea el formato
		// corto, debemos indicar lo mismo al formateador

		// DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		Date fecha = null;
		try {
			// Mediante el formateador podemos convetir la cadena que representa
			// una fecha en un objeto java.util.Date
			fecha = df.parse(cadenaFecha);

			// Ahora ya tenemos una fecha valida
			// La imprimimos sin formato
			System.out.println("Sin aplicar formato: " + fecha);
			// Mostramos la fecha con el formato corto
			System.out.println("Aplicando formato: " + df.format(fecha));
		} catch (ParseException e) {
			e.printStackTrace();

		}
	}

	public void dateFormatShortDates() {

		Date d = new Date(); // Fecha de hoy

		DateFormat sd = new SimpleDateFormat("dd-MM-yyyy");

		// EEE és el codi del dia de la setmana
		// DateFormat sd = new SimpleDateFormat("dd-MM-yyyy, EEEE");
		// DateFormat sd = new SimpleDateFormat("EEE");

		// La convertimos en texto
		String strFechaDeHoy = sd.format(d);
		System.out.println(strFechaDeHoy);
		try {
			// Obtenemos una fecha a partir de texto
			d = sd.parse("25-08-2008");
			System.out.println(sd.format(d));
		} catch (ParseException e) {
			e.printStackTrace();

		}
	}

	public void TestFechas() throws ParseException {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = df.parse("15/06/2008");
		Date d2 = df.parse("04/04/2009");
		String relacion = "";
		if (d1.equals(d2))
			relacion = "es la misma fecha";
		else if (d1.before(d2))
			relacion = "anterior";
		else if (d1.after(d2))
			relacion = "posterior";
		System.out.println(df.format(d1) + " es " + relacion + " "
				+ df.format(d2));
	}

	public void TestGetTime() {

		Date fechaActual = new Date();

		long mseg = fechaActual.getTime();

		long dias = mseg / (24 * 60 * 60 * 1000);

		System.out.println("Dias transcurridos desde el 01/01/1970: " + dias);

	}

	public void TestSetTime() {

		Date fecha = new Date();

		long mseg = fecha.getTime();
		mseg += 100 * 24 * 60 * 60 * 1000L;

		fecha.setTime(mseg);

		System.out.println("Dentro de 100 dias estaremos a:" + fecha);

	}

	public void TestCalendar() {

		Calendar hoy = Calendar.getInstance();
		hoy.add(Calendar.YEAR, -5);
		hoy.add(Calendar.DATE, -50);
		System.out.println(hoy.getTime());

	}

	public void prova() {
		Calendar ahoraCal = Calendar.getInstance();
		System.out.println(ahoraCal.getClass());
		ahoraCal.set(2004, 1, 7);
		System.out.println(ahoraCal.getTime());
		ahoraCal.set(2004, 1, 7, 7, 13, 0);
		System.out.println(ahoraCal.getTime());

		System.out.println("ANYO: " + ahoraCal.get(Calendar.YEAR));
		System.out.println("MES: " + ahoraCal.get(Calendar.MONTH));
		System.out.println("DIA: " + ahoraCal.get(Calendar.DATE));
		System.out.println("HORA: " + ahoraCal.get(Calendar.HOUR));
		if (ahoraCal.get(Calendar.MONTH) == Calendar.JUNE) {
			System.out.println("ES JUNIO");
		} else {
			System.out.println("NO ES JUNIO");
		}
	}

	// funciona?
	public int diferenciaFechas(String fec1, String fec2, int valor) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		int retorno = 0;
		java.util.Date date1 = null;
		java.util.Date date2 = null;
		try {
			Calendar cal1 = null;
			date1 = df.parse(fec1);
			cal1 = Calendar.getInstance();

			Calendar cal2 = null;
			date2 = df.parse(fec2);
			cal2 = Calendar.getInstance();

			// different date might have different offset
			cal1.setTime(date1);
			long ldate1 = date1.getTime() + cal1.get(Calendar.ZONE_OFFSET)
					+ cal1.get(Calendar.DST_OFFSET);

			cal2.setTime(date2);
			long ldate2 = date2.getTime() + cal2.get(Calendar.ZONE_OFFSET)
					+ cal2.get(Calendar.DST_OFFSET);

			// Use integer calculation, truncate the decimals
			int hr1 = (int) (ldate1 / 3600000); // 60*60*1000
			int hr2 = (int) (ldate2 / 3600000);

			int days1 = (int) hr1 / 24;
			int days2 = (int) hr2 / 24;

			int dateDiff = days2 - days1;
			int yearDiff = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
			int monthDiff = yearDiff * 12 + cal2.get(Calendar.MONTH)
					- cal1.get(Calendar.MONTH);

			if (valor == 1) {
				if (dateDiff < 0)
					dateDiff = dateDiff * (-1);
				retorno = dateDiff;
			} else if (valor == 2) {
				if (monthDiff < 0)
					monthDiff = monthDiff * (-1);
				retorno = monthDiff;
			} else if (valor == 3) {
				if (yearDiff < 0)
					yearDiff = yearDiff * (-1);
				retorno = yearDiff;
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		return retorno;
	}

	public void provaDiess2() {

		// creo unas fechas para ejemplo
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		// pongo una fecha de comparacion
		date1.set(2008, 11, 8);
		date2.set(2008, 10, 7);
		Calendar aux = Calendar.getInstance();
		// resto las fechas(la mayor de la menor o como sea tu caso)
		aux.setTimeInMillis(date2.getTimeInMillis() - date1.getTimeInMillis());
		// imprimo los datos
		System.out.println("" + date1.get(Calendar.YEAR) + " "
				+ date1.get(Calendar.MONTH) + " "
				+ date1.get(Calendar.DAY_OF_MONTH));
		System.out.println("" + date2.get(Calendar.YEAR) + " "
				+ date2.get(Calendar.MONTH) + " "
				+ date2.get(Calendar.DAY_OF_MONTH));
		// A tomar en cuenta que el año minimo es 1970 por eso le resto esa
		// cantidad
		System.out.println("" + (aux.get(Calendar.YEAR) - 1970) + " "
				+ aux.get(Calendar.MONTH) + " "
				+ aux.get(Calendar.DAY_OF_MONTH));

	}

	public static int getDayOfTheWeek(Date d) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_WEEK);

	}

}
