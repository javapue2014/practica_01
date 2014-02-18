package edu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lectura {

		public List <String[]> lista = new ArrayList<String[]>();
		
/*		public String[] getArrayIni() {
			return arrayIni;
		}
*/
		public Lectura(String x){
			try {
				BufferedReader doc = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(x)));
				
				String sep="[ ;]";
				int i=0;
				String a = "";
				
				while ((a = doc.readLine())!=null){				
					lista.add(a.split(sep));
					i++;
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
}
