package edu;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ejemplo {
	
	public static void main(String[] args) {
		
	
	
	String[]ej={"a", "b", "b", "c", "a"};
	String[]copy=new String[5];
	
	int cont=0;
	
	for (int i=0; i<ej.length;i++){
		if (ej[i]=="b"){
			copy[cont]=ej[i];
			System.out.println(cont);
			cont++;
		}
		}
	
		for (int i=0; i<ej.length;i++){
			if (ej[i]=="a"){
				copy[cont]=ej[i];
				System.out.println(cont);
				cont++;
			}
		}
		
		for (int i=0; i<ej.length;i++){
				if (ej[i]=="c"){
					copy[cont]=ej[i];
					System.out.println(cont);
					cont++;
				}	
			
				
	}
		System.out.println(Arrays.toString(copy));
		
		System.out.println((String)ej[1]==ej[3]);

}}
