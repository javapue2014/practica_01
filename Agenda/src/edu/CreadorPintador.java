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
		
		cont.write("<html>"
				+ "<head>"
				+ "<title>title</title>"
				+ "<link rel='stylesheet' type='text/css' href='estilo.css'>"
				+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />"
				+ "</head>"
				+ "<body><div id='contenedor'>");

				for(int l=0; l<4;l++){
					cont.write("<div class='semanaCont'>");
					//primera fila- mascara de semana	
					cont.write("<div class='setm'><h3> Setm:" + (primeraSeman+l) +"</h3> </div>");
					for(int m=0; m<7;m++){
						cont.write("<div class='setm'><h3>"+ mascara.charAt(m) + "</h3></div>");
					}
					cont.write("</div>");
					cont.write("<div class='diaSemanaNum'>");
					//segunda fila- mascara de semana	
					cont.write("<div class='dia'><h3> Dia: </h3></div>");
					for(int j=0; j<7;j++){
						if(!verdaderOfalso[j]){
						cont.write("<div class='diaNo'><h3> null</h3></div>");
						}else{
						dia++;
						cont.write("<div class='diaSi'><h3>"+ dia +"</h3></div>");
							} 	
						}
					cont.write("</div>");

					}
							
					
					
				
				
				
				
				
		cont.write("</div></body></html>");
		cont.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		CreadorPintador hola =new CreadorPintador("numSala");
		
	}

}
