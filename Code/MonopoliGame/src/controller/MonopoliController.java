package controller;

import gui.Console;

import java.util.ArrayList;

import model.Dice;
import model.Play;
import model.Player;

public class MonopoliController {

	public static boolean manageChoice(int choice){
		
		switch(choice){
		
			//esci dal gioco
			case 0:
				
				if(IOController.checkEnd()){
					return true;
				}else{
					return false;
				}
			
			//inizia una nuova partita
			case 1: 
				
				Play currPlay = new Play();
	
				Play.loadGame(currPlay);
			
				//mostra il menù di gioco
				Console.showMenuGame();
				int input = IOController.readInputOption();
				MonopoliController.manageGame(input, currPlay);
				
				break;
				
			default:
				break;
		}
		
		return false;
		
	}
	
	public static boolean manageGame(int choice, Play currPlay){
		
		switch(choice){
		
			case 0:
				
				if(IOController.checkEnd()){
					return false;
				}else{
					return true;
				}
				
			case 1:
				
				ArrayList<Player> players = currPlay.getPlayerList();
				int input = 0;
				int endPlay = 1;
				int currRound = currPlay.getCurrRound();
								
				for(int r = 0; r<currPlay.getMAXROUNDS(); r++){
					
					System.out.println("\nROUND CORRENTE : " + currRound +(" (numero massimo di round " + currPlay.getMAXROUNDS() +")"));
					
					for(int i=0; i<players.size(); i++){
						
						System.out.println("\n\nGiocatore : " + players.get(i).getName());
						
						Console.showMenuGame();
						
						input = IOController.readInputOption();
						endPlay = MonopoliController.playGame(input, players.get(i), currPlay.getNRDICES(), currPlay);
						
						if(endPlay == 0){
							
							if(IOController.checkEnd()){
								return true;
							}else{
								i--;
							}
						}else if(endPlay == -1){
							i--;
						}
					}
					
					if(currRound == currPlay.getMAXROUNDS()){
						System.out.println("\n**************************************************************");
						System.out.println("PARTITA TERMINATA!");
						for(int i=0; i<players.size(); i++){
							
							System.out.println("Giocatore : " + players.get(i).getName());
							System.out.println("Posizione finale : " + players.get(i).getIndexPosition());
							System.out.println("Num. giri completati : " + players.get(i).getPassFromStart());
							System.out.print("\n");
						}
						
						System.out.println("**************************************************************");
					}
					
					currRound++;
					
				}
				

			break;
			
			default:
				System.out.println("Opzione inserita non valida! Ripetere l'inserimento >");
				break;
		}
		return true;
	}
	
	public static int playGame(int choice, Player currPlayer, int nrDice, Play currPlay){
		
		switch(choice){
		
			//0 --> uscita 
			case 0:
				return 0;			
			
			//1 --> lancia i dadi
			case 1:
				
				//giocatore
				System.out.println("Giocatore : " + currPlayer.getName() +", \nPosizione corrente: "+currPlayer.getIndexPosition());
				
				int[] shotTotal = Dice.rollDice(nrDice);
				
				makeMove(shotTotal, currPlayer, currPlay);
			
				break;
			
			default:
				System.out.println("L'opzione inserita non rientra tra quelle disponibili!\nRipetere l'inserimento >");
				return -1;
		}
		
		return 1;
	}
	
	private static void makeMove(int[] moves, Player currPlayer, Play currPlay){
		
		int move = 0;
		int newIndexPosition = 0;
		
		System.out.println("Punteggio ottenuto: ");
		for(int i=0; i<moves.length; i++){
			
			System.out.println("Dado " + (i+1) + " --> "+ moves[i]);
			move = move + moves[i];
		}
		System.out.println("Spostamento : " + move);
		newIndexPosition = currPlayer.getIndexPosition() + move;
		
		int nrBoxs = currPlay.getNUMBOXS();
		
		if(newIndexPosition > nrBoxs){
			newIndexPosition = newIndexPosition - nrBoxs;
			System.out.println("CONGRATULAZIONI HAI RAGGIUNTO LA FINE DEL PERCORSO! \nORA RIPARTI DAL VIA!");
			currPlayer.setPassFromStart((currPlayer.getPassFromStart() + 1));
		}
		
		currPlayer.setIndexPosition(newIndexPosition);
		System.out.println("Giocatore : " + currPlayer.getName() +", \nPosizione aggiornata: "+currPlayer.getIndexPosition());

	}
	
}
