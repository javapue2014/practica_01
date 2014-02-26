package edu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class CreadorPintador {
	
	String mascara= "LMKJVSD";
	boolean[] verdaderOfalso= {false, false, true,true,true,true,true};

	int primeraSeman= 44;
	
	
	public CreadorPintador(String doc) throws IOException{
		File sala= new File(doc+".html");
		
		Writer cont = new BufferedWriter(new FileWriter(doc+".html"));
		
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
				+ "<h1 id='enun'> Sala 1 </h1>"
				+ "<h2> Noviembre 2008 </h2>"
				+ "</header>"
				);

				for(int l=0; l<4;l++){
					cont.write(
				//<!-- Contenedor de la semana -->
				  "<div class='semanaCont'>"
				//"<!-- primera fila con mascara de dias aportado por idioma de salida -->"
				+ "<div class='fila'>"
				
				+ "<div class='enuCol'><h3> Setm:" + (primeraSeman+l) +"</h3> </div>");
					//primera fila- mascara de semana	
					for(int m=0; m<7;m++){
						cont.write("<div class='cel'><h3>"+ mascara.charAt(m) + "</h3></div>");
					}
				cont.write("</div>"
						
				+"<div class='fila'>");
					//segunda fila- dias de la semana	
				cont.write("<div class='enuCol'><h3>Dia: </h3></div>");
					for(int j=0; j<7;j++){
						if(!verdaderOfalso[j]){
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
	
	public static void main(String[] args) throws IOException {
		CreadorPintador hola =new CreadorPintador("petronilo");
		
	}

}
