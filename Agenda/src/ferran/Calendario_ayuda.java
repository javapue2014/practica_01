package ferran;

import java.util.ArrayList;
import java.util.Arrays;

import edu.Configuracion;

public class Calendario_ayuda {
	private static int numSemanas;

	public static int getNumSemanas() {
		return numSemanas;
	}

	public static void main(String[] args) {

		Configuracion conf = new Configuracion("config.txt");
		int mes = conf.getMesConf();
		int any = conf.getAnyConf();

		// for (int i = 0; i < calen.size(); i++) {
		// System.out.println(Arrays.toString(calen.get(0)));
		//
		// }

		// semana del año
		// System.out.println("Semana del año :" + Calendario.getSemana1());
		// semanas que tiene el mes
		//

		ArrayList<boolean[]> calen = new Calendario().trueOFalse(mes, any);

		int numSemanas = calen.size();
		System.out.println(calen.size());

	}
}
