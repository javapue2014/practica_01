package ferran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import edu.Configuracion;
import edu.Lectura;
import edu.Prioridades;

public class Utiles {

	private static int nSales = 0;

	private static boolean hiHaPrioritats = false;
	static String[] paraulesClau;

	public static String[] prioritatsSenseRepeticions() {

		Configuracion conf = new Configuracion("config.txt");
		Prioridades prio = new Prioridades(conf);

		// crearem un LinkedHashSet per a evitar repeticions
		LinkedHashSet<String> set = new LinkedHashSet<String>();

		// es treballa amb valor major que 1 a causa de 'tancat'
		if (prio.getPrioridad().size() > 1) {
			hiHaPrioritats = true;

			// introdueix les prioritats sense repeticions
			for (int i = 0; i < prio.getPrioridad().size(); i++) {
				set.add(prio.getPrioridad().get(i));
			}

			// System.out.println(set.size());
			paraulesClau = new String[set.size()];

			int comptador = 0;
			// sortida per pantalla
			for (Iterator iterator = set.iterator(); iterator.hasNext();) {
				String name = (String) iterator.next();
				paraulesClau[comptador++] = name;
			}
		}
		return paraulesClau;
	}

	// identifica la paraula clau
	// entra primer l'activitat i després la prioritat
	public static boolean identificaParaulaClau(String text, String paraulaClau) {
		paraulaClau = paraulaClau.toUpperCase();
		text = text.toUpperCase();
		boolean prioritat2 = false;
		boolean presencia = text.contains(paraulaClau);
		if (presencia) {
			prioritat2 = true;
		}
		return prioritat2;
	}

	public static String[][] sortRequest() {

		Lectura peticiones = new Lectura("peticions.txt");

		// // ArrayList original
		// ArrayList<Peticions> peticionsOri = new ArrayList<Peticions>();
		// for (int i = 0; i < (peticiones.lista.size()); i++) {
		// peticionsOri.add(new Peticions(peticiones.lista.get(i)[0],
		// peticiones.lista.get(i)[1], peticiones.lista.get(i)[2],
		// peticiones.lista.get(i)[3], peticiones.lista.get(i)[4],
		// peticiones.lista.get(i)[5]));
		// }

		// ArrayList intermig per a ser ordenat
		ArrayList<Peticions> peticionsSales = new ArrayList<Peticions>();
		// Array bidimensional de sortida
		String[][] arrayPeticions = new String[peticiones.lista.size()][peticiones.lista
				.get(0).length];

		// crea l'array 'paraulesClau'
		prioritatsSenseRepeticions();

		// array de filtrat
		boolean[] filtrat = new boolean[peticiones.lista.size()];
		for (int i = 0; i < filtrat.length; i++) {
			filtrat[i] = false;
		}

		if (hiHaPrioritats) {

			// recòrrer les paraules clau
			for (int j = 0; j < paraulesClau.length; j++) {
				// recòrrer peticions
				for (int i = 0; i < peticiones.lista.size(); i++) {

					// reconeix la paraula clau
					if (identificaParaulaClau(peticiones.lista.get(i)[0],
							paraulesClau[j])) {

						peticionsSales.add(new Peticions(peticiones.lista
								.get(i)[0], peticiones.lista.get(i)[1],
								peticiones.lista.get(i)[2], peticiones.lista
										.get(i)[3], peticiones.lista.get(i)[4],
								peticiones.lista.get(i)[5]));

						// System.out.println("Al bucle condicional  "
						// + peticionsSales.get(compt).getActivitat() + ", "
						// + peticionsSales.get(compt).getEspai());

						filtrat[i] = true;
						// peticionsOri.get(i).setFiltrat("si");

					}
				}
			} // acaba el primer for de peticions
		} // acaba if de hiHaPrioritats

		for (int i = 0; i < (peticiones.lista.size()); i++) {

			if (!filtrat[i])

				peticionsSales.add(new Peticions(peticiones.lista.get(i)[0],
						peticiones.lista.get(i)[1], peticiones.lista.get(i)[2],
						peticiones.lista.get(i)[3], peticiones.lista.get(i)[4],
						peticiones.lista.get(i)[5]));

			// compt++;

		} // acaba el segon for de peticions

		// System.out.println("Total peticions : " + peticionsSales.size());
		// for (int i = 0; i < peticionsSales.size(); i++) {
		// System.out.println("El contingut és "
		// + peticionsSales.get(i).getActivitat() + ", "
		// + peticionsSales.get(i).getEspai());
		// }

		for (int i = 0; i < peticionsSales.size(); i++) {
			arrayPeticions[i][0] = peticionsSales.get(i).getActivitat();
			arrayPeticions[i][1] = peticionsSales.get(i).getEspai();
			arrayPeticions[i][2] = peticionsSales.get(i).getDataInici();
			arrayPeticions[i][3] = peticionsSales.get(i).getDataFi();
			arrayPeticions[i][4] = peticionsSales.get(i).getMascaraDies();
			arrayPeticions[i][5] = peticionsSales.get(i).getMascaraHores();
			// imprimeix abans d'ordenar
			// System.out.println(Arrays.toString(arrayPeticions[i]));
		}

		Arrays.sort(arrayPeticions, new Comparator<String[]>() {
			@Override
			public int compare(String[] entry1, String[] entry2) {
				String time1 = entry1[1];
				String time2 = entry2[1];
				return time1.compareTo(time2);
			}
		});

		// imprimeix després d'ordenar
		// System.out.println("------------------------------------");
		//
		// for (int i = 0; i < peticionsSales.size(); i++) {
		// System.out.println(Arrays.toString(arrayPeticions[i]));
		// }

		return arrayPeticions;

	} // acaba el main

//	public static int numSales(String[][] peticionsOrdenades) {
//		int k = 0;
//		String sala = "";
//		for (int i = 0; i < peticionsOrdenades.length; i++) {
//			if (!peticionsOrdenades[i][1].equals(sala)) {
//				k++;
//				sala = peticionsOrdenades[i][1];
//			}
//		}
//		return k + 1;
//	}

	public static int numSales() {
		Lectura peticiones = new Lectura("peticions.txt");
		int k = 0;
		String sala = "";
		for (int i = 0; i < peticiones.lista.size(); i++) {
			if (!peticiones.lista.get(i)[0].equals(sala)) {
				k++;
				sala = peticiones.lista.get(i)[0];
			}
		}
		return k + 1;
	}

}
