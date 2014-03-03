package main;

import java.io.IOException;

import edu.Configuracion;
import edu.Pintado;
import ferran.Calendario;
import ferran.CalendarioMesNoValidoException;

public class Main {

	public static void main(String[] args) throws CalendarioMesNoValidoException {
		Configuracion conf= new Configuracion("config.txt");

		Calendario obj2= new Calendario();
				
		try {
			Pintado j= new Pintado ( obj2, conf);
			System.out.println("Peticiones procesadas!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
