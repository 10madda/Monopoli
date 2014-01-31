package model;

import gui.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controller.IOController;

public class Play {
	
	final int NRMINPLAYERS = 2;
	final int NRMAXPLAYERS = 8;
	final int NRDICES = 2;
	final int MAXROUNDS = 20;
	final int NUMBOXS = 40;
	private int currRound = 1;
	
	ArrayList<Player> playerList = new ArrayList<Player>();
	
	public Play(){}


	public ArrayList<Player> getPlayerList() {
		return playerList;
	}


	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}


	public int getNRMINPLAYERS() {
		return NRMINPLAYERS;
	}


	public int getNRMAXPLAYERS() {
		return NRMAXPLAYERS;
	}


	public int getNRDICES() {
		return NRDICES;
	}


	public int getMAXROUNDS() {
		return MAXROUNDS;
	}


	public int getNUMBOXS() {
		return NUMBOXS;
	};
	
	public int getCurrRound() {
		return currRound;
	}


	public void setCurrRound(int currRound) {
		this.currRound = currRound;
	}


	public void createPlayerList(List<String> names){
		
		String name = "";
		
		for(int i=0; i<names.size(); i++){
			
			name = names.get(i);
			Player plr = new Player(name, 0, 0, 0);
			
			playerList.add(plr);
		}
		
		//ordina l'elenco dei giocatori in maniera randomica
		Collections.shuffle(playerList);
		
		int ord = 1;
		
		System.out.println("Ordine di gioco:");
		//imposta il nuovo valore di ordinamento nel gioco
		for(int i=0; i<playerList.size(); i++){
			playerList.get(i).setPlayOrder(i);
			
			System.out.println(ord +".\t " + playerList.get(i).getName());
			ord++;
		}
	}
	
	public static void loadGame(Play currPlay){
		
		//aggiunge i giocatori
		Player.addPlayers(currPlay);

	}

	
}
