package edu;

import java.util.*;

public class HashMapDemo {

	
	public static void main(String[] args) {
		
	
	HashMap<Integer, String>pepe=new HashMap<>();	
	HashMap<String, HashMap<Integer, String>> mapa = new HashMap<>();	
	
	mapa.put("fulanito",pepe);
	
	mapa.get("fulanito").put(34, "eso");
	
	Map m1 = new HashMap();
	m1.put("map", "HashMap");
	m1.put("schildt", "java2");
	m1.put("mathew", "Hyden");
	m1.put("schildt", "java2s");
	System.out.println(m1.keySet());
	System.out.println(m1.values());
	

	SortedMap sm = new TreeMap();
	sm.put("map", "TreeMap");
	sm.put("schildt", "java2");
	sm.put("mathew", "Hyden");
	sm.put("schildt", "java2s");
	System.out.println(sm.keySet());
	System.out.println(sm.values());


	LinkedHashMap lm = new LinkedHashMap();
	lm .put("map", "LinkedHashMap");
	lm .put("schildt", "java2");
	lm .put("mathew", "Hyden");
	lm .put("schildt", "java2s");
	System.out.println(lm .keySet());
	System.out.println(lm .values());

}


	
}
