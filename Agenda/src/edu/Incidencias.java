package edu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Incidencias {
	//patrón Singleton
	//propiedad privada y estatica en la clase
	private static Incidencias incidencia;
	private static List<String> listaIncidencias;
	
	//constructor de incidencias privado
	private Incidencias() {
		listaIncidencias = new ArrayList<String>();
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

	
	
	public void volcado() {
		
		
		// logica para volcar la lista en un fichero
		try {
			File inci= new File("incidencias.log");
				if (!inci.exists())
					inci.createNewFile();				
				
			
				Writer incidencia = new BufferedWriter(
						new FileWriter("incidencias.log"));
				//
				//
				//repasar y convertir a singelton configuracion
				Configuracion conf= new Configuracion("config.txt");
				incidencia.write("#Resum Activitats "+conf.getMesConf()+"/"+conf.getAnyConf()+ "#Activitat ReunioC");
				
				
				for(int i=0; i< listaIncidencias.size();i++){	
					
						incidencia.write(listaIncidencias.get(i));
					
					}
				
				incidencia.close();
				
				
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
	
	
}



	
	
	
	


