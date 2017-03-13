package com.lumos;

import java.util.ArrayList;

public class Game {
	private static Game instance;

	private Player player;
	
	private MainWindow mainWindow;
	private InventoryWindow inventoryWindow;
	private StatWindow statWindow;

	private ArrayList<Window> windows;

	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}

	private Game() {
		mainWindow = new MainWindow(640, 480, 87, 25, 0, 0);
		inventoryWindow = new InventoryWindow(300, 150, 39, 6, 645, 0);
		statWindow = new StatWindow(300, 325,39,16, 645, 155);

		windows = new ArrayList<Window>();
		windows.add(mainWindow);
		windows.add(inventoryWindow);
		windows.add(statWindow);
		
		player = new Player(10, "Player 1");
		player.setX((int) Math.floor(mainWindow.getCharWidth()/2)); 
		player.setY((int) Math.floor(mainWindow.getCharHeight()/2));
	}

	public void initWindows() {
		for (Window window : windows) {
			window.initUI();
		}
		mainWindow.toFront();
	}

	public Player getPlayer() {
		return player;
	}
}