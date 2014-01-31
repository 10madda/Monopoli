package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Play;

public class IOController {
	
	private static String readInputString(){
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			return input.readLine();
		}catch(java.io.IOException e){
			System.out.print("Errore in lettura. \n Ripetere l'inserimento >");
		}
		
		return "";
	}
	
	public static int readInputOption(){
		System.out.println("Inserire il numero dell'opzione desiderata >");
		
		int option = 0;
		String command = "";
		
		do{
			command = readInputString();
			
			try{
				option = Integer.parseInt(command);
			}catch(NumberFormatException e){
				System.out.print("Errore nell'inserimento dell'opzione. Ripetere l'inserimento >");
				command = "";
			}
		}while(command.length() == 0);
			
		System.out.println();
		return option;
	}
	
	public static List<String> readArrayInput(Play currPlay){

		List<String> list = new ArrayList<String>();
		Scanner stdin = new Scanner(System.in);
		
		//se nella partita sono già stati inseriti dei giocatori
		if(currPlay.getPlayerList().size() > 0){
			for(int i=0; i<currPlay.getPlayerList().size(); i++){
				list.add(currPlay.getPlayerList().get(i).getName());
			}
		}
		
		//si inserisce il primo giocatore
		if(list.size() == 0){
			System.out.println("Aggiungi giocatori");
			System.out.println("Numero massimo di giocatori: " + currPlay.getNRMAXPLAYERS());
			System.out.println("Giocatore: ");
			list.add(stdin.next());
		}
		
		do {
			
			System.out.println("Elenco giocatori: " + list);
			System.out.println("Numero massimo di giocatori: " + currPlay.getNRMAXPLAYERS());
			System.out.println("Aggiungere nuovi giocatori? (y/n)");
			
			String inp = stdin.next();
			if (inp.equalsIgnoreCase("y")) {
				
				System.out.println("Elenco giocatori: " + list);
				
				if(list.size() ==  currPlay.getNRMAXPLAYERS() - 1){
	
					System.out.println("Ultimo Giocatore: ");
				}
				else{
					System.out.println("Giocatore: ");
				}
				
				list.add(stdin.next());
				
			} else if(inp.equalsIgnoreCase("n")){
				
				//se il numero di giocatori inseriti non è sufficiente
				if(list.size() < currPlay.getNRMINPLAYERS()){
					
					int diff = currPlay.getNRMINPLAYERS() - list.size();
					System.out.println("ATTENZIONE, numero di giocatori insufficiente.");
					System.out.println("Il numero minimo di giocatori è: " +currPlay.getNRMINPLAYERS() +".");
					System.out.println("Inserire almeno: " + diff +" giocatori.");
					//System.out.println("Aggiungere nuovi giocatori? (y/n)");
				}else{
					
					return list;
				}
				
			}else{
				System.out.println("Opzione non consentita.");
			}
			
		} while (list.size() < currPlay.getNRMAXPLAYERS());

		return list;
	}

	public static boolean checkEnd(){
		
		String endPlay = "";
		
		System.out.println("Si è scelto di concludere la partita.");
		System.out.println("Terminare? (y/n)");
		endPlay = readInputString();
		
		if(endPlay.equalsIgnoreCase("y")){

			System.out.println("PARTITA TERMINATA!");
			System.out.println("ARRIVEDERCI!");
			System.out.println();
			return true;
		}
		
		return false;
	}
}
