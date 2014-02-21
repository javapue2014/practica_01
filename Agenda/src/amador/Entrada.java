package amador;

public class Entrada {
	static String[][] peticions=
		{{"Tancat", "Sala1", "01/01/2008", "31/12/2008", "LMCJVSG", "00-07"},
		{"Tancat", "Sala1", "25/12/2008", "25/12/2008", "LMCJVSG", "00-24"},
		{"Tancat", "Sala2", "01/01/2008", "31/12/2008", "LMCJVSG", "00-07_21-24"},
		{"ReunioJava", "Sala1", "15/10/2008", "20/12/2008", "LMCJV", "12-21"},
		{"ReunioJava", "Sala1", "25/09/2008", "02/11/2008", "LMCJV", "14-18"},
		{"ReunioJava", "Sala1", "25/09/2008", "02/11/2008", "LMCJV", "12-14"},
		{"ReunioJava", "Sala2", "25/09/2008", "02/11/2008", "LMCJV", "08-10"},
		{"ReunioJava", "Sala2", "25/09/2008", "02/11/2008", "LMCJV", "19-21"},
		{"ReunioPerl", "Sala1", "01/05/2008", "31/05/2008", "LMJ", "12-13_17-18"},
		{"ReunioPerl", "Sala1", "01/07/2008", "20/12/2008", "LMJ", "13-14_17-18"}};
	
	static boolean[][] dies =
		{{true, true, true, true, true, true, true},
		{true, true, true, true, true, true, true},
		{true, true, true, true, true, true, true},
		{true, true, true, true, true, false, false},
		{true, true, true, true, true, false, false},
		{true, true, true, true, true, false, false},
		{true, true, true, true, true, false, false},
		{true, true, true, true, true, false, false},
		{true, true, false, true, false, false, false},
		{true, true, false, true, false, false, false}};
	
	static String[][] horaris =
		{{"00-07"},
		{"00-24"},
		{"00-07", "21-24"},
		{"12-21"},
		{"14-18"},
		{"12-14"},
		{"08-10"},
		{"19-21"},
		{"12-13", "17-18"},
		{"13-14", "17-18"}};
	

}
