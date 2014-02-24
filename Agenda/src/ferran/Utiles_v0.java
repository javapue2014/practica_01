package ferran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import edu.Lectura;

public class Utiles_v0 {
	
	static Lectura idioma = new Lectura("internacional.CAT");
	static String tancatIdioma = (idioma.lista.get(6)[1]).toUpperCase();

	// prioritat 1 : Tancat
		public static boolean tancatIdioma(String tancat) {
			tancat = tancat.toUpperCase();
			boolean prioritat1 = false;
			if (tancat.equals(tancatIdioma)) {
				prioritat1 = true;
			}
			return prioritat1;
		}

		// prioritat 2 : Java

		static String paraulaClau = "Java";

		public static boolean identificaParaulaClau(String text) {
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
		// Lectura idioma = new Lectura("internacional.CAT");
				int compt = 0;

				// instanciamos Lectura con el archivo de peticiones
				Lectura peticiones = new Lectura("peticions.txt");
				ArrayList<Peticions> peticionsSales = new ArrayList<Peticions>();
				String[][] arrayPeticions = new String[peticiones.lista.size()][peticiones.lista
						.get(0).length];

				// creat ArrayList de peticions

				for (int i = compt; i < peticiones.lista.size(); i++) {
					if (tancatIdioma(peticiones.lista.get(i)[0])) {

						peticionsSales.add(new Peticions(peticiones.lista.get(i)[0],
								peticiones.lista.get(i)[1], peticiones.lista.get(i)[2],
								peticiones.lista.get(i)[3], peticiones.lista.get(i)[4],
								peticiones.lista.get(i)[5]));
						compt++;
					}
				}

				for (int j = 0; j < peticiones.lista.size(); j++) {

					if (identificaParaulaClau(peticiones.lista.get(j)[0])) {

						peticionsSales.add(new Peticions(peticiones.lista.get(j)[0],
								peticiones.lista.get(j)[1], peticiones.lista.get(j)[2],
								peticiones.lista.get(j)[3], peticiones.lista.get(j)[4],
								peticiones.lista.get(j)[5]));

						compt++;
					}
				}

				for (int j = 0; j < peticiones.lista.size(); j++) {

					if (!tancatIdioma(peticiones.lista.get(j)[0])
							& !identificaParaulaClau(peticiones.lista.get(j)[0])) {

						peticionsSales.add(new Peticions(peticiones.lista.get(j)[0],
								peticiones.lista.get(j)[1], peticiones.lista.get(j)[2],
								peticiones.lista.get(j)[3], peticiones.lista.get(j)[4],
								peticiones.lista.get(j)[5]));

						compt++;
					}
				}

				for (int i = 0; i < peticionsSales.size(); i++) {
					arrayPeticions[i][0] = peticionsSales.get(i).getActivitat();
					arrayPeticions[i][1] = peticionsSales.get(i).getEspai();
					arrayPeticions[i][2] = peticionsSales.get(i).getDataInici();
					arrayPeticions[i][3] = peticionsSales.get(i).getDataFi();
					arrayPeticions[i][4] = peticionsSales.get(i).getMascaraDies();
					arrayPeticions[i][5] = peticionsSales.get(i).getMascaraHores();
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

				return arrayPeticions;
	}
	
}
