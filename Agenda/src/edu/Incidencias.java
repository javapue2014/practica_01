package edu;

import java.io.*;

public class Incidencias {
	
	File inci= new File("incidencias.log");	
	
	public Incidencias(String x){	
	
		try {
			if (!inci.exists())
				inci.createNewFile();				
				
				
				BufferedOutputStream incidencia = new BufferedOutputStream(
						new FileOutputStream("incidencias.log"));
			
				incidencia.write(x.getBytes());
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



	
	
	
	


