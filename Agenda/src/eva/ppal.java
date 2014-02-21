package eva;

import java.util.GregorianCalendar;

import edu.Configuracion;


public class ppal {
	
	

	

	public static void main(String[] args) {
		
	
		GregorianCalendar mical =
	            (GregorianCalendar) GregorianCalendar.getInstance();
		Configuracion conf= new Configuracion("config.txt");
		setearcalendario sc =new setearcalendario();
		int mimes=sc.mesconf;
	
		int miany=sc.anyconf;
		
		System.out.println(mimes);
		System.out.println(miany);
		
	}
			

}
