package edu;
import ferran.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

public class Pintado {
	
	public Pintado (String[][][] objCalendario, Mesos obj) throws IOException{
		
		//bucle generador de tantos ficheros html como num de salas
		for(int l=0;l<objCalendario.length;l++){
			
			//creamos un archivo html
			File sala= new File("Sala"+objCalendario[l]+".html");
			Writer cont = new BufferedWriter(new FileWriter("Sala"+objCalendario[l]+".html"));
			//escribimos la cabecera del documento
			cont.write("<html>"
					+ "<head>"
					+ "<title>title</title>"
					+ "<link rel='stylesheet' type='text/css' href='styles.css'>"
					+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />"
					+ "</head>"
					+ "<body>");
			
				//escribe tantas filas como cantidad de semanas tiene el mes
				for(int i=0;i<obj.getnumSemanas();i++){
				cont.write("<div class='contenedor'>"
						+ "<header>"
						+ "<h1 id='enun'> NumDe Sala </h1>"
						+ "<h2> Texto mes y año conf </h2>"
						+ "</header>"
						+ "<!-- Contenedor de la semana -->"
						+ "<div class='semanaCont'>"
						+ "<!-- primera fila con mascara de dias aportado por internaciona.ENG -->"
						+ "<div class='filaMascara'>"
						+ "<div class='setm'><h3> Setm: +numSamana </h3> </div>"
						+ "<div class='lunes'><h3> Masc.split.[0] </h3></div>"
						+ "<div class='martes'><h3> Masc.split.[1] </h3></div>"
						+ "<div class='miercoles'><h3> Masc.split.[2] </h3></div>"
						+ "<div class='jueves'><h3> Masc.split.[3] </h3></div>"
						+ "<div class='viernes'><h3> Masc.split.[4] </h3></div>"
						+ "<div class='sabado'><h3> Masc.split.[5] </h3></div>"
						+ "<div class='domingo'><h3> Masc.split.[6] </h3></div>"
						+ "</div>"
						+ "<!-- segunda fila con num de dias por semana -->"
						+ "<div class='diaSemanaNum'>");
				
				//escribe 8 columnas, 1 de info y 7 de los dias por semana.
				for (int j=0;j<7;j++){
					do {//pinta la primera col
						
					}while(z!=1);
					
				}
			
			
					
				
				cont.write("</div>");
				}
			
					
					
			cont.write("</body></html>");
			cont.close();
			
			
			/*int numSemanas=calendario.ge
			for (int i;i< calendario.MONTH.WEEK_OF_MONTH)*/
			
			
			//escribimos las etiquetas de cierre del html
		}
		
	}

}
