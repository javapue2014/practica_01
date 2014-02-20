package ferran;

import edu.*;

public class Prioritats {

	Lectura idioma = new Lectura("internacional.CAT");
	private String tancatIdioma = (idioma.lista.get(6)[1]);

	// prioritat 1 : Tancat
	public boolean tancatIdioma(String tancat) {
		//tancat = tancat;
		boolean prioritat1 = false;
		if (tancat == tancatIdioma) {
			prioritat1 = true;
		}
		return prioritat1;

	}

	// prioritat 2 : Java

	private String paraulaClau = "Java";

	public boolean identificaParaulaClau(String text) {
		paraulaClau = paraulaClau.toUpperCase();
		text = text.toUpperCase();
		boolean prioritat2 = false;
		boolean presencia = text.contains(paraulaClau);
		if (presencia) {
			prioritat2 = true;
		}
		return prioritat2;

	}

}
