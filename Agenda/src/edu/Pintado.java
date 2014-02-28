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
	
	public Pintado ( Calendario obj2, Configuracion conf) throws IOException, CalendarioMesNoValidoException{
		
		Calendar calendar= Calendar.getInstance();
		calendar.set(conf.getAnyConf(), (conf.getMesConf()-1), 1);
		
		AssignarCalendari calen=new AssignarCalendari();
		
		String cal[][][]=calen.assignarCal();
		
		
		
		
		int numSalas = calen.numeroSalas();
		
		//bucle generador de tantos ficheros html como num de salas
		for(int k=1;k<numSalas;k++){
			
			//creamos un archivo html
			File sala= new File("Sala"+k+".html");
			Writer cont = new BufferedWriter(new FileWriter("Sala"+ k +".html"));
			//escribimos la cabecera del documento
			
			int dia=0;
			int rDia=0;
			
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
					+ "<h1 id='enun'> Sala "+ k + " </h1>"
					+ "<h2> "+ conf.getIdiomaSalida().getInterDoc().get("004")[1].split(",")[(conf.getMesConf()-1)]  + conf.getAnyConf()+"</h2>"
					+ "</header>"
					);
			
			
					int totalSemanasMes = obj2.trueOFalse(conf.getMesConf(), conf.getAnyConf()).size();
			
					for(int l=0; l<totalSemanasMes ;l++){
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
							if(!obj2.trueOFalse(conf.getMesConf(), conf.getAnyConf()).get(l)[j]){
							cont.write("<div class='diaNo'><h3>  </h3></div>");
							}else{
							dia++;
							cont.write("<div class='cel'><h3>"+ dia +"</h3></div>");
								} 	
							}
					//
						cont.write("</div>"); //cierre fila
						
						for(int h=0; h<24;h++){//filas por num horas
							cont.write("<div class='fila'>"
									+ "<div class='enuCol'><h3>"+h+" - "+ (h+1) +"</h3></div>");
							
						for(int d=0;d<7;d++){ //dias por semana 
							if(!obj2.trueOFalse(conf.getMesConf(), conf.getAnyConf()).get(l)[d]){
							cont.write("<div class='diaNo'><h3>  </h3></div>");
							}else{
							
							cont.write("<div class='cel'><h3>"+ cal[k][rDia][h] +"</h3></div>");
							if (rDia < calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
								rDia++;
							}	
							
							
							} 	
									
						}
						cont.write("</div>");//cierre de fila por hora
							
					}	
					
					cont.write("</div>"); //cierre contenedor semana
					}

					//
							

					
					
			cont.write( "</div>"
					+ "</section>"
					+ "</body>"
					+ "</html>");
			
			cont.close();
			
		}
	}
	
	
	public static void main(String[] args) throws CalendarioMesNoValidoException {
		Configuracion conf= new Configuracion("config.txt");
		
		
		
		AssigCal obj1= new AssigCal ();
		Calendario obj2= new Calendario();
				
		try {
			Pintado j= new Pintado ( obj2, conf);
			System.out.println("Fin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

