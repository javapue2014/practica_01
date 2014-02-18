package eva;

import java.util.*;

public class Fecha {
	
	
	 public static Calendar calendario=Calendar.getInstance();
	    // *********
	 private static int a�oSel,mesSel,diaSel,diaSemanaSel;
	 public static boolean fechaDisponible=false;
	 
	// *********
//	    public static String strMeses[]={"Enero","Febrero","Marzo","Abril","Mayo",
//	    "Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
//	    public static String strDiasSemana[]={"Domingo","Lunes","Martes","Miercoles",
//	        "Jueves","Viernes","S�bado"}; 	
//	    
	    
	    
	    
	    public static String toStringFecha(){
	        return calendario.get(Calendar.DAY_OF_MONTH)+"/"+(calendario.get(Calendar.MONTH)+1)+"/"+
	                calendario.get(Calendar.YEAR);
	    }
	    
//	    public void incrementarMes(){
//	        calendario.set(Calendar.MONTH,calendario.get(Calendar.MONTH)+1);
//	        calendario.set(Calendar.DAY_OF_MONTH,1);
//	    }
//	    
//	    public void decrementarMes(){
//	        calendario.set(Calendar.MONTH,calendario.get(Calendar.MONTH)-1);
//	        calendario.set(Calendar.DAY_OF_MONTH,1);
//	    }
	    
	    public void establecerDia(int dia){
	        calendario.set(Calendar.DAY_OF_MONTH,dia);
	    }
	    
	    public void establecerMes(int mes){
	        calendario.set(Calendar.MONTH,mes-1);
	        calendario.set(Calendar.DAY_OF_MONTH,1);
	    }
	    
	    public void establecerA�o(int a�o){
	        calendario.set(Calendar.YEAR,a�o);
	        calendario.set(Calendar.DAY_OF_MONTH,1);
	        
	    }
	    
	    
	        public int obtenerDiaSemana(){
	            return calendario.get(Calendar.DAY_OF_WEEK)-1;
	        } 	
	        
	        public int obtenerMes(){
	            return calendario.get(Calendar.MONTH)+1;
	        }
	        
	        public int obtenerA�o(){
	            return calendario.get(Calendar.YEAR);
	        }
	        
	        
	        
//	        public String toStrintMesA�o(){
//	            String mensaje=strMeses[obtenerMes()-1]+" "+Integer.toString(obtenerA�o());
//	            return mensaje;
//	        }
//	        
	        
	        
	        public int calcularDiaSemanaPrimero(){
	            int a�o=calendario.get(Calendar.YEAR);
	            int mes=calendario.get(Calendar.MONTH)+1;
	            int dia=1;
	            int a,y,m,d;
	            a=(14-mes)/12;
	            y=a�o-a;
	            m=mes+(12*a)-2;
	            d=(dia+y+(y/4)-(y/100)+(y/400)+(31*m)/12)%7;       
	            return d;
	        }
	        
	        
	        public boolean esBisiesto(){
	            int a�o=calendario.get(Calendar.YEAR);
	            return (a�o%4==0)||((a�o%100!=0)&&(a�o%400==0));
	        }
	        
	        public int getDiasMes(){
	            int ano=calendario.get(Calendar.YEAR);
	            int mes=calendario.get(Calendar.MONTH)+1;
	            int diasMes=31;
	            switch(mes){
	                case 2:
	                    if(esBisiesto())diasMes=29;
	                    else diasMes=28;
	                    break;
	                case 4:case 6:case 9:case 11:
	                    diasMes=30;
	            }
	            return diasMes;
	        }
	        
	        
	     // ************
	        public static int _getA�o(){
	           return a�oSel;
	        }
	        public static int _getMes(){
	           return mesSel;
	        }
	        public static int _getDia(){
	           return diaSel;
	        }
	        public static int _getDiaSemana(){
	            return diaSemanaSel;
	        }
	        public static void _setA�o(int a�o){
	            a�oSel=a�o;
	        }
	        public static void _setMes(int mes){
	            mesSel=mes;
	        }
	        public static void _setDia(int dia){
	            diaSel=dia;
	        }
	        public static void _setDiaSemanaSel(int dia){
	            diaSemanaSel=dia;
	        }  
	    }
	    


