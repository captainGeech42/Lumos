package com.lumos;

public enum Key {
	LEFT_ARROW (37),
	RIGHT_ARROW (39),
	UP_ARROW (38),
	DOWN_ARROW (40),
	INVALID (-1);
	
	private int keyCode;
	
	private Key(int keyCode) {
		this.keyCode = keyCode;
	}
	
	public int getKeyCode() {
		return keyCode;
	}
}
