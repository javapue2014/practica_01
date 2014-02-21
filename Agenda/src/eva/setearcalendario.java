package eva;

import java.util.GregorianCalendar;

import edu.Configuracion;

	
		
public class setearcalendario{
			
			
				Configuracion conf= new Configuracion("config.txt");
				int mesconf=conf.getMesConf();
				int anyconf=conf.getAnyConf();
				
				GregorianCalendar mical =
			              (GregorianCalendar) GregorianCalendar.getInstance();
	
				
			
				
				public  int getmes(GregorianCalendar mical,int mesconf){
					
					int mimes=mical.MONTH;		
										
					return mimes;
						
					}
				
					public  int getany(GregorianCalendar mical,int anyconf){
					
					int miany=mical.YEAR;		
										
					return miany;
						
					}
				
}





//				
//				public void setearcalendario(GregorianCalendar mical,int mesconf,int anyconf){
//						
//					mical.set(GregorianCalendar.YEAR,mesconf);	
//				
//					mical.set(GregorianCalendar.MONTH,mesconf);	
//						
//					}
					
			
					
					
			
					
					
					
				
		
	
						
						
////						mical.setFirstDayOfWeek( Calendar.MONDAY);
//						mical.setMinimalDaysInFirstWeek( 4 );
																
				
						
				
					
					
					
//					public 
//						mical.set(anyconf, mesconf);
//						int micalmes=mical.get(mesconf);
//						int micalany=mical.get(anyconf);
//						
//		//				int date = calendar.set(Calendar.DATE);
//		//				System.out.println("AÑO ACTUAL: " + year);
//		//				System.out.println("MES ACTUAL: " + month);
//		//				System.out.println("DÍA ACTUAL: " + date);
//						
//					}
//					
										
//					
				
					
				
					
					
					
					
					
//					//primer dia del mes
//					public  String  getfirstday(GregorianCalendar mical){
//						
//						String firstday=mical.getFirstDayOfWeek();
//						return firstday;
//					}
//					
//					
//					
//					public  int set firstday(GregorianCalendar mical){
//						
//						int firstday=mical.getFirstDayOfWeek();
//						return firstday;
//					}
					
//					 public void establecerDia(mical. ){
//					     String dia;
//							mical.set(Calendar.DAY_OF_MONTH,dia);
//					    }
//					    
//					
//					public int quediadelasemana(mical d) {
//												
//							GregorianCalendar mical = new GregorianCalendar();
//							
//							mical.setTime(d);
//							return mical.get(Calendar.DAY_OF_WEEK);		
//						}
						//saber dia de la semana
//
//							int d,anyconf,m,M,D; 
//							D=Integer.parseInt( )); //dia
//							m=Integer.parseInt( )); //mes
//
//							anyconf=Integer.parseInt()); //año
//							M=modulo(m,(bisiesto(A))); 
//
//							d=((A-1)%7+(((A-1)/4)-3*((((A-1)/100)+1)/4) )%7+M+D%7)%7; 
//							System.out.println(dia(d)); 
//							} 
//
//
//							public static String dia(int d){ 
//							switch(d){ 
//							case 0: 
//							return "domingo"; 
//							case 1: 
//							return "lunes"; 
//							case 2: 
//							return "martes"; 
//							case 3: 
//							return "miercoles"; 
//							case 4: 
//							return "jueves"; 
//							case 5: 
//							return "viernes"; 
//							case 6: 
//							return "sabado"; 
//							} 
//							return "no encontre el dia"; 
//							} 
//							public static boolean bisiesto(int a){ 
//							if((a/4==0)&&(a/100!=0))||(a/400==0)){ 
//							return true; 
//							} 
//							return false; 
//							} 
//
//
//						}

					
					
				
					
				
			

			
	



	

