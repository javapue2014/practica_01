
package ferran;

import java.util.LinkedHashSet;

public class QuantesSales {

	public static void main(String[] args) {

		String[][] utils = new Utiles().sortRequest();
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		for (int j = 0; j < utils.length; j++) {
				set.add(utils[j][1]);		
		}
	}

}
