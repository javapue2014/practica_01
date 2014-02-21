package ferran;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.Configuracion;

public class Mesos {

	Configuracion conf = new Configuracion("config.txt");

	//private int mes = conf.getMesConf();
	//private int any = conf.getAnyConf();
	
	private int mes = 2;
	private int any = 2014;
	
	
	public int diesMes (int mes, int any) {
		int qDies = 0;
		this.mes = mes;
		this.any = any;
		if ((mes == 2) && (any % 4 == 0)){
			mes = 13;
		}
		switch (mes) {
		case 1:
			qDies = 30;
			break;
		case 2:
			qDies = 30;
			break;
		case 3:
			qDies = 30;
			break;
		case 4:
			qDies = 30;
			break;
		case 5:
			qDies = 30;
			break;
		case 6:
			qDies = 30;
			break;
		case 7:
			qDies = 30;
			break;
		case 8:
			qDies = 30;
			break;
		case 9:
			qDies = 30;
			break;
		case 10:
			qDies = 30;
			break;
		case 11:
			qDies = 30;
			break;
		case 12:
			qDies = 30;
			break;
		case 13:
			qDies = 30;
			break;
			}
			
		return qDies;
	}
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
	Calendar calendar = new GregorianCalendar(2014,02,21,00,00,00);
	
	int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
	
	

}
