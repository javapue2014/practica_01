package edu;

import java.io.*;




public class main {
	
	
	
	public static void main(String[] args) {
		

	
		
		
		
		Configuracion conf= new Configuracion("config.txt");		
		Lectura idioma= new Lectura("internacional.CAT");	
		Lectura peticiones = new Lectura("peticions.txt");	
		
		System.out.println(conf.getIdiomaEntr());
		System.out.println(idioma.lista.get(1)[1].split(",")[3]);
		
		
		
		
	}}


