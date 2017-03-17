package com.lumos;

/**
 * Created by zande on 3/17/2017.
 */
public class InventoryFrame {
	private char[][] frame;
	private int frameWidth;
	private int frameHeight;

	public InventoryFrame(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		initFrame();
	}

	private void initFrame() {
		for (int i = 0; i < frameWidth; i++) {
			for (int j = 0; j < frameHeight; j++) {
				frame[i][j] = '#';
			}
		}
	}

	public char[][] getFrame() {
		return frame;
	}
}
