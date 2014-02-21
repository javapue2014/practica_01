package edu;

import java.util.HashMap;
import java.util.Map;

public class Internacional {
	private Map<String,String[]>interDoc;
	
	public Map<String, String[]> getInterDoc() {
		return interDoc;
	}

	public Internacional(String x){
		Lectura inter=new Lectura(x);
		interDoc= new HashMap<>();
		for(int i=0;i<inter.lista.size();i++){
			String k=inter.lista.get(i)[0];
			String[] valor= inter.lista.get(i);		
			
		interDoc.put(k,valor);
		}
	}


	
}
