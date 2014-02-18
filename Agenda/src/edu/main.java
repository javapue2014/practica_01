package edu;
import java.util.Arrays;
import java.io.*;




public class main {
	
	
	
	public static void main(String[] args) {
		

	
		
		
		
		Configuracion conf= new Configuracion("config.txt");		
		Lectura idioma= new Lectura("internacional.CAT");	
		
		//instanciamos Lectura con el archivo de peticones
		Lectura peticiones = new Lectura("peticions.txt");	
		
		System.out.println(conf.getIdiomaEntr());
		System.out.println(idioma.lista.get(3)[0]);
		System.out.println( Arrays.toString(peticiones.lista.get(3)));
		
		System.out.println( peticiones.lista.get(3).length);
		
		
		
		
	}}


