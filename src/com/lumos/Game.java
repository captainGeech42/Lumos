package com.lumos;

public class Game{
	private Player player;
	
	private MainWindow mainWindow;
	private InventoryWindow inventoryWindow;
	
	public Game() {
		mainWindow = new MainWindow(640, 480, 87, 25, 0, 0);
		inventoryWindow = new InventoryWindow(300, 150, 39, 6, 645, 0);
		
		player = new Player(10, "player1");
		player.setX((int) Math.floor(mainWindow.getCharWidth()/2)); 
		player.setY((int) Math.floor(mainWindow.getCharHeight()/2));
		
		mainWindow.addPlayer(player);
		mainWindow.initUI();

		inventoryWindow.setInventory(player);
		inventoryWindow.initUI();
	}
}
