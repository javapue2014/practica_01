package edu;
import java.io.*;

public class Configuracion {
	private int anyConf, mesConf;
	private String idiomaEntr, idiomaSort;

	//getters
	public int getAnyConf() {
		return anyConf;
	}
	public int getMesConf() {
		return mesConf;
	}	
	public String getIdiomaEntr() {
		return idiomaEntr;
	}	
	public String getIdiomaSort() {
		return idiomaSort;
	}
/*	//setters
	public void setAnyConf(int anyConf) {
		this.anyConf = anyConf;
	}
	public void setMesConf(int mesConf) {
		this.mesConf = mesConf;
	}
	public void setIdiomaEntr(String idiomaEntr) {
		this.idiomaEntr = idiomaEntr;
	}
	public void setIdiomaSort(String idiomaSort) {
		this.idiomaSort = idiomaSort;
	}*/
	
	public Configuracion(){};
	
	public Configuracion (String x){
		
		try {
			BufferedReader lecturaConf = new BufferedReader(
											new InputStreamReader(
													new FileInputStream(x)));
			String [] matrizConf;			
			int i = 0;
			matrizConf=lecturaConf.readLine().split(" ");
			anyConf=Integer.parseInt(matrizConf[0]);
			mesConf=Integer.parseInt(matrizConf[1]);
			matrizConf=lecturaConf.readLine().split(" ");
			idiomaEntr=matrizConf[0];
			idiomaSort=matrizConf[1];
			
		} catch (FileNotFoundException e) {
			//recupero el objeto incidencia con getIncidencia() y le añado la incidencia
			Incidencias miIncidencia = Incidencias.getIncidencia();
			miIncidencia.addIncidencia("El fichero "+ x +  " no ha sido encontrado");	
			
		} catch (IOException e) {		
			//recupero el objeto incidencia con getIncidencia() y le añado la incidencia
			Incidencias miIncidencia = Incidencias.getIncidencia();
			miIncidencia.addIncidencia("Ha ocurrido un error en la carga de: "+x);
			
		}
	           
			

	}

	
}
