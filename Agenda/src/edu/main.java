package edu;
import java.util.Arrays;
import java.io.*;




public class main {
	
	
	
	public static void main(String[] args) {
		

	
		
	
		Configuracion conf= new Configuracion("config.txt");		
		Lectura idiomaEntrada= new Lectura("internacional.CAT");	
		Lectura idiomaSalida= new Lectura("internacional.ENG");
		
		
		
		
		//instanciamos Lectura con el archivo de peticones
		Lectura peticiones = new Lectura("peticions.txt");	
		
		System.out.println(conf.getAnyConf());
		System.out.println(idiomaEntrada.lista.get(3)[0]);
		System.out.println( peticiones.lista.get(3)[2].split("/")[1]);
		
		System.out.println( peticiones.lista.get(3).length);
		System.out.println( Arrays.toString(idiomaSalida.lista.get(3)));
		
		
		Logger miLog = Logger.getLogger();
		miLog.addLog("Hola");
		
		
		
		Internacional cat = new Internacional("internacional."+conf.getIdiomaEntr());
		Internacional eng = new Internacional("internacional."+ conf.getIdiomaSort());
		System.out.println("hola");
		System.out.println(eng.getInterDoc().get("004")[1]);
		
		
		
		System.out.println(cat.getInterDoc().get("003")[1]);
		System.out.println( peticiones.lista.get(4)[4]);
		
		
		DiaSemana dias= new DiaSemana( cat,peticiones );
		System.out.println(dias.getDiasComp().get(4)[2]);		
		System.out.println(cat.getInterDoc().get("007")[1]);
		
		
		
	Prioridades prio=new Prioridades(conf);
	for(int i=0; i<prio.getPrioridad().size();i++)
		System.out.println(prio.getPrioridad().get(i));

	
	System.out.println(conf.getIdiomaEntrada().getInterDoc());
}}
