package com.lumos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputMonitor implements KeyListener {

	private Window window;

	private static boolean log = true;
	
	public InputMonitor(Window window) {
		this.window = window;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
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
		if (log) {
			System.out.println(String.format("received %s from %s", key, window));
		}
		window.processInput(key);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//intentionally empty
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//intentionally empty
	}
}
