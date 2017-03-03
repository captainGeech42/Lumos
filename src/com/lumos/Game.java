package com.lumos;

import java.awt.event.KeyEvent;

public class Game {
	private Screen window;
	private Player player;
	
	public Game(int width, int height) {
		//width and height are num chars wide, high
		window = new Screen(width, height);
		player = new Player(10, "Player1");
	}
	
	public void keyPressed(KeyEvent e) {
		
	}
}
