package model;

import java.util.Random;

public class Dice {

	final static int MINVALUE = 1;
	final static int MAXVALUE = 6;
	
	Dice(){};
	
	public static int getMinvalue() {
		return MINVALUE;
	}
	public static int getMaxvalue() {
		return MAXVALUE;
	}
	
	public static int[] rollDice(int nrDices){
		
		int[] dicesValue = new int[nrDices];
		
		for(int i=0; i<nrDices; i++){
			
			Random randomVal = new Random();
			dicesValue[i] = randomVal.nextInt(MAXVALUE) + MINVALUE;
		}
		
		return dicesValue;
	}
	
}
