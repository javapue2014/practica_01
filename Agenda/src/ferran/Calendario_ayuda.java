package ferran;

import java.util.ArrayList;
import java.util.Arrays;

import edu.Configuracion;
import edu.Prioridades;

public class Calendario_ayuda {

	public static void main(String[] args) {
		Configuracion conf = new Configuracion("config.txt");
		Prioridades prio = new Prioridades(conf);

		ArrayList<boolean[]> calen = Calendario.trueOFalse();

		for (int i = 0; i < calen.size(); i++) {
			System.out.println(Arrays.toString(calen.get(0)));

		}

		// semana del año
		System.out.println(Calendario.getSemana1());
		// semanas que tiene el mes
		System.out.println(calen.size());

	}
}
