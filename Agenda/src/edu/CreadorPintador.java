package edu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CreadorPintador {
	
	
	public CreadorPintador(String doc) throws IOException{
		File sala= new File(doc+".html");
		
		Writer cont = new BufferedWriter(new FileWriter(doc+".html"));
		
		cont.write("<html>"
				+ "<head>"
				+ "<title>title</title>"
				+ "<link rel='stylesheet' type='text/css' href='styles.css'>"
				+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />"
				+ "</head>"
				+ "<body>"
				+"<h1>Esto funciona!!!</h1>"
				+"</body></html>");
		cont.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		CreadorPintador hola =new CreadorPintador("numSala");
		System.out.println("documento generado");
	}

}
