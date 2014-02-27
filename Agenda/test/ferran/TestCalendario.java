package ferran;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalendario {
	
	private static int mes = 2;
	private static int any = 2014;
	
	static ArrayList<boolean[]> diesFebrer;
	static ArrayList<boolean[]> calendario;
	
	@BeforeClass
	public static void creaArrayList () throws CalendarioMesNoValidoException {
		diesFebrer = new ArrayList<boolean[]>();
		calendario = new Calendario().trueOFalse(mes, any);
	}

	// definir l'ArrayList que contindrà l'array de les setmanes
	//ArrayList<boolean[]> diesFebrer = new ArrayList<boolean[]>();
	

	@Test
	public void testTrueOFalse() throws CalendarioMesNoValidoException {
		//ArrayList<boolean[]> calendario = new Calendario().trueOFalse(mes, any);

		boolean[][] arrayFebrer = {
				{ false, false, false, false, false, true, true },
				{ true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true },
				{ true, true, true, true, true, false, false } };

		// introduir les setmanes al mes
		for (int i = 0; i < 5; i++) {
			diesFebrer.add(arrayFebrer[i]);
		}

//		for (int i = 0; i < diesFebrer.size(); i++) {
//			System.out.println(Arrays.toString(diesFebrer.get(i)));
//		}
//		System.out.println("-------------------------------");
//
//		for (int i = 0; i < calendario.size(); i++) {
//			System.out.println(Arrays.toString(calendario.get(i)));
//		}

		for (int i = 0; i < calendario.size(); i++) {
			for (int j = 0; j < diesFebrer.get(i).length; j++) {
				assertEquals(diesFebrer.get(i)[j], calendario.get(i)[j]);
			}

		}

	}
	
	@Test(expected=CalendarioMesNoValidoException.class) 
	public void testTrueOFalseException() throws CalendarioMesNoValidoException {
	
		Calendario calendario = new Calendario();
			calendario.trueOFalse(15, any);
		
	}
}
