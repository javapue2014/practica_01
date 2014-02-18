package amador;

//import java.util.Arrays;

import amador.Entrada;

public class MainAmador {

	public static void main(String[] args) {
		for (int i=0; i<Entrada.peticions.length; i++){
			for (int j=0; j<Entrada.peticions[0].length; j++){
				System.out.print(Entrada.peticions[i][j] + " ");
			}
			System.out.println();
		}
			
	}

}
