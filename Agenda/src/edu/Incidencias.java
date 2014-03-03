package edu;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Incidencias {
	//patrón Singleton
	//propiedad privada y estatica en la clase
	private static Incidencias incidencia;
	private static List<String> listaIncidencias;
	private static Map<String,ArrayList<String>> mapaColisiones;
	private Configuracion conf= new Configuracion("config.txt");
	
	
	//constructor de incidencias privado
	private Incidencias() {
		listaIncidencias = new ArrayList<String>();
		mapaColisiones= new HashMap<>();
	}
	
	//getter para incidencia que se instancia una vez si no esta instanciado
	public synchronized static Incidencias getIncidencia() {
		if (incidencia == null) {
			incidencia = new Incidencias();				
		}	
		return incidencia;
	}
	
	//especie de setter que añade una nueva linea a la lista
	public void addIncidencia(String x) {
		listaIncidencias.add(x);
	}

	public void putColision(String k, String v) {
		ArrayList<String> temp = mapaColisiones.get(k);
		if(temp==null){//si el valor es nulo crea una arraylist para esa clave
			mapaColisiones.put(k, new ArrayList<String>());	
			mapaColisiones.get(k).add(v);
		}else{
			mapaColisiones.get(k).add(v);
		}
		
		
		

		
	}
	
	public void volcado() {
		
		
		// logica para volcar la lista en un fichero
		try {
			File inci= new File("incidencias.log");
				if (!inci.exists())
					inci.createNewFile();				
				
			
				Writer incidencia = new BufferedWriter(
						new FileWriter("incidencias.log"));
				
				
				for(int i=0; i< listaIncidencias.size();i++){	
					
						incidencia.write(listaIncidencias.get(i));
					
					}
				
				incidencia.write("#Resum Activitats" + conf.getMesConf()+"/"+ conf.getAnyConf() + "/n");
				
				
				for (Entry<String, ArrayList<String>> s : mapaColisiones.entrySet()) {
					
					
					incidencia.write("#Activitat "+s.getKey());
					for(int l=0; l< mapaColisiones.get(s.getKey()).size();l++){
					incidencia.write(s.getValue().get(l));
					}
					
					
					
				}
				
				incidencia.close();
				
						
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
	
	
}



	
	
	
	


