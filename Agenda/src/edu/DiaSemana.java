package edu;

import java.util.ArrayList;
import java.util.List;


public class DiaSemana {
	
	//inicializamos la array con todo false
	private List <boolean[]>diasComp=new ArrayList<>();
	
	public List<boolean[]> getDiasComp() {
		return diasComp;
	}

	
	
	public DiaSemana (Internacional x , Lectura peticiones){
		
			String mascaraGeneral= x.getInterDoc().get("003")[1];
	
			
			
		//for para cada linea de peticiones
		for (int j=0; j<peticiones.lista.size();j++){
			boolean[]a={false,false,false,false,false,false,false};
			diasComp.add(j,a);
			
			//recoge la mascara de dias en 5 posicion
			String mascaraPeticiones= peticiones.lista.get(j)[4];
		
		//for para comparar caracter por caracter de la mascaraGeneral cargada a traves de internacional.CAT
		
			for(int i=0; i<mascaraGeneral.length();i++){
				
				String dia = String.valueOf(mascaraGeneral.charAt(i));
//System.out.println("dia: " + dia + "i:" + i);
				if (mascaraPeticiones.contains(dia)) {
					diasComp.get(j)[i]=true;
				}else{
					diasComp.get(j)[i]=false;
				}
				
				
			}
		}
	}
	
}
