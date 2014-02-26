package edu;
import ferran.*;
import amador.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

public class Pintado {
	
	public Pintado (AssigCal obj1, Calendario obj2, Configuracion conf) throws IOException{
		
		//bucle generador de tantos ficheros html como num de salas
		for(int k=0;k<obj1.getCal_pet().length;k++){
			
			//creamos un archivo html
			File sala= new File("Sala"+(k+1)+".html");
			Writer cont = new BufferedWriter(new FileWriter("Sala"+ (k+1) +".html"));
			//escribimos la cabecera del documento
			
			int dia=0;
			
			cont.write("<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<meta charset='ISO-8859-1'>"
					+ "<title>Agenda - Sala x </title>"
					+ "<link rel='stylesheet' href='style.css' /> "
					+ "</head>"
					+ "<body>"
					+ "<section>"
					+ "<!-- contenedor general -->"
					+ "<div id='contenedor'>"
					+ "<header>"
					+ "<h1 id='enun'> Sala "+ (k+1) + " </h1>"
					+ "<h2> "+ conf.getIdiomaSalida().getInterDoc().get("004")[1].split(",")[(conf.getMesConf()-1)]  + conf.getAnyConf()+"</h2>"
					+ "</header>"
					);

					for(int l=0; l<obj2.getSemanasDelMes() ;l++){
						cont.write(
					//<!-- Contenedor de la semana -->
					  "<div class='semanaCont'>"
					//"<!-- primera fila con mascara de dias aportado por idioma de salida -->"
					+ "<div class='fila'>"
					
					+ "<div class='enuCol'><h3> Setm:" + (obj2.getSemana1()+l) +"</h3> </div>");
						//primera fila- mascara de semana	
						for(int m=0; m<7;m++){
							cont.write("<div class='cel'><h3>"+ conf.getIdiomaSalida().getInterDoc().get("003")[1].charAt(m) + "</h3></div>");
						}
					cont.write("</div>"
							
					+"<div class='fila'>");
						//segunda fila- dias de la semana	
					cont.write("<div class='enuCol'><h3>Dia: </h3></div>");
						for(int j=0; j<7;j++){
							if(!obj2.trueOFalse().get(l)[j]){
							cont.write("<div class='diaNo'><h3>  </h3></div>");
							}else{
							dia++;
							cont.write("<div class='cel'><h3>"+ dia +"</h3></div>");
								} 	
							}
					
					cont.write("</div></div>");//cierre de semanaCont
							

					}
					
			cont.write( "</div>"
					+ "</section>"
					+ "</body>"
					+ "</html>");
			cont.close();
			
		}
}
	
	public static void main(String[] args) {
		Configuracion conf= new Configuracion("config.txt");
		
		System.out.println(conf.getIdiomaEntrada().getInterDoc().get("004")[1]);
		
		AssigCal obj1= new AssigCal ();
		Calendario obj2= new Calendario();
		try {
			Pintado j= new Pintado (obj1, obj2, conf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

