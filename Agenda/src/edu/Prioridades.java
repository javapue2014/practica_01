package edu;

import java.util.LinkedList;

public class Prioridades {

	private LinkedList<String>prioridad=new LinkedList<>();
	private int longitudLista=0;
	
	
	
	public int getLongitudLista() {
		return longitudLista;
	}


	public LinkedList<String> getPrioridad() {
		return prioridad;
	}


	public Prioridades(Configuracion conf){
		Internacional cat = new Internacional("internacional."+conf.getIdiomaEntr());
		Lectura listaDePrioridades= new Lectura("priority."+conf.getIdiomaEntr());
		
		
		//prioridad 1 en la primera posicion de lista prioridad	
		String prioridadMaxima=cat.getInterDoc().get("007")[1];
		System.out.println(prioridadMaxima);
		prioridad.add(prioridadMaxima);
		
		//rellenamos el resto de la lista
		longitudLista=listaDePrioridades.lista.size()+1;
		for(int i=0;i<listaDePrioridades.lista.size();i++){
			prioridad.add(listaDePrioridades.lista.get(i)[1]);
		}
		
	}
	
}
