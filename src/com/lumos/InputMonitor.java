package com.lumos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputMonitor implements KeyListener {

	private Window window;
	
	public InputMonitor(Window window) {
		this.window = window;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//intentionally empty
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Key key = Key.INVALID;
		switch (e.getKeyCode()) {
		case 37:
			key = Key.LEFT_ARROW;
			break;
		case 39:
			key = Key.RIGHT_ARROW;
			break;
		case 38:
			key = Key.UP_ARROW;
			break;
		case 40:
			key = Key.DOWN_ARROW;
			break;
		default:
			break;
		}
		window.processInput(key);
//		System.out.println(String.format("%s released", e.getKeyCode()));
		System.out.println(String.format("received %s", key));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//intentionally empty
	}
}
