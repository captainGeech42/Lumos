package com.lumos;

public class Game{
	private Player player;
	
	private Window mainWindow;
	
	public Game() {
		mainWindow = new Window("Lumos", 640, 480, 87, 25, 0, 0);
		
		player = new Player(10, "player1");
		player.setX((int) Math.floor(mainWindow.getCharWidth()/2)); 
		player.setY((int) Math.floor(mainWindow.getCharHeight()/2));
		
		mainWindow.addPlayer(player);
		mainWindow.initUI();
	}
}
