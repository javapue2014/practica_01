package ferran;

import java.util.ArrayList;
import java.util.Arrays;

//import edu.Configuracion;

public class Calendario_ayuda {

	public static void main(String[] args)
			throws CalendarioMesNoValidoException {
		
		
		int mes = 2;
		int any = 2014;

		// La classe Calendario genera un ArrayList amb les
		// setmanes que corresponen a un mes en concret, posant
		// a fals els dies d'aquella setmana que no corresponen
		// al mes.
		ArrayList<boolean[]> calen = new Calendario().trueOFalse(mes, any);

		// imprimir l'ArraList
		for (int i = 0; i < calen.size(); i++) {
			System.out.println(Arrays.toString(calen.get(i)));
		}
	}
}
