package edu;

public class Pruebasplit {

	public static void main(String[] args) {
		boolean[] verdaderOfalso= {false, false, true,true,true,true,true};
		
		for(int j=0; j<7;j++){
			if(!verdaderOfalso[j]){
				System.out.println("Si");
			}else{System.out.println("No");}
			
		}
	}

}
