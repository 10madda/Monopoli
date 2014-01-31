package model;

import java.util.List;

import controller.IOController;

public class Player {

	private String name;
	private int playOrder;
	private int indexPosition;
	private int passFromStart;
	
	public Player()
	{
	}
	
	public Player(String name, int playOrder, int indexPosition, int passFromStart)
	{
	    this.name = name;
	    this.playOrder = playOrder;
	    this.indexPosition = indexPosition;
	    this.passFromStart = passFromStart;
	}
	
	public String getName()
	{
	    return name;
	}
	
	public void setName(String name)
	{
	    this.name = name;
	}
	
	public int getPlayOrder()
	{
	    return playOrder;
	}
	
	public void setPlayOrder(int playOrder)
	{
	    this.playOrder = playOrder;
	}
	
	public int getIndexPosition()
	{
	    return indexPosition;
	}
	
	public void setIndexPosition(int indexPosition)
	{
	    this.indexPosition = indexPosition;
	}
	
	public int getPassFromStart()
	{
	    return passFromStart;
	}
	
	public void setPassFromStart(int passFromStart)
	{
	    this.passFromStart = passFromStart;
	}
	
	public static void addPlayers(Play currPlay)
	{
	    List<String> names = IOController.readArrayInput(currPlay);
	    currPlay.createPlayerList(names);
	}
	
	

}
