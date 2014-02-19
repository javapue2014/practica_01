package edu;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logger {
	
	private static Logger logger;
	private static List<String> lineas;
	
	private Logger() {
		lineas = new ArrayList<String>();
	}
	
	public synchronized static Logger getLogger() {
		if (logger == null) {
			logger = new Logger();				
		}
		
		return logger;
	}
	
	public void addLog(String linea) {
		lineas.add(linea);
	}
	
	public void volcado() {
		// logica para volcar la lista en un fichero
		try {
			File inci= new File("incidencias.log");
				if (!inci.exists())
					inci.createNewFile();				
				
			
				BufferedOutputStream incidencia = new BufferedOutputStream(
						new FileOutputStream("incidencias.log"));
			
				for(int i=0; i< lineas.size();i++){	
					
						incidencia.write(lineas.get(i).getBytes());
					
					}
				
				incidencia.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				
				
				
				
		
	}

}
