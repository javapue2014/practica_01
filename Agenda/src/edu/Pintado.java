package edu;

import java.io.File;
import java.util.Calendar;

public class Pintado {
	
	public Pintado (String[][][] objCalendario, Calendar calendario){
		
		//bucle generador de tantos ficheros html como num de salas
		for(int l=0;l<objCalendario.length;l++){
			
			//creamos un archivo html
			File sala= new File("Sala"+objCalendario[l]+".html");
			//escribimos la cabecera del documento
			
			/*int numSemanas=calendario.ge
			for (int i;i< calendario.MONTH.WEEK_OF_MONTH)*/
			
			
			//escribimos las etiquetas de cierre del html
		}
		
	}

}
