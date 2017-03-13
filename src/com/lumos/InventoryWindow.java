package com.lumos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Zander Work on 3/6/2017.
 */
public class InventoryWindow extends Window implements Runnable {
	private Inventory inventory;
	private Iterator<Item> itemsIterator;
	private List<char[][]> itemFrames;
	private int frameToRender = 0;

	private Thread myThread;
	private boolean running = false;

	public InventoryWindow(int windowWidth, int windowHeight, int charWidth, int charHeight, int locationX, int locationY) {
		super("Inventory", windowWidth, windowHeight, charWidth, charHeight, locationX, locationY);
		setKeyListener(this);
		myThread = new Thread(this);
		itemFrames = new ArrayList<>();
	}

	public void setInventory(Player player) {
		this.inventory = player.getInventory();
	}

	@Override
	public void initUI() {
		super.initUI();
		inventory = Game.getInstance().getPlayer().getInventory();
		myThread.start();
	}

	@Override
	public void renderFrame() {
		if (itemFrames.size() != 0) {
			charFrame = itemFrames.get(frameToRender);
		}
		super.renderFrame();
	}

	@Override
	public void run() {
		running = true;
		while (running) {
			inventory.hasNewItemsLock.lock();
			if (inventory.hasNewItems) {
				inventory.hasNewItems = false;
				inventory.hasNewItemsLock.unlock();
				itemsIterator = inventory.getIterator();
				while (itemsIterator.hasNext()) {
					Item item = itemsIterator.next();
					char[][] frame = getItemFrame();

					String name = item.getName();
					for (int i = 0; i < name.length(); i++) {
						frame[i+8][1] = name.charAt(i);
					}

					String durability = String.valueOf(item.getDurability());
					for (int i = 0; i < durability.length(); i++) {
						frame[i+14][2] = durability.charAt(i);
					}

					String strength = String.valueOf(item.getStrength());
					for (int i = 0; i < strength.length(); i++) {
						frame[i+12][3] = strength.charAt(i);
					}

					String type = item.getType().toString();
					type = type.substring(0, 1) + type.substring(1).toLowerCase();
					for (int i = 0; i < type.length(); i++) {
						frame[i+8][4] = type.charAt(i);
					}
					itemFrames.add(frame);
					charFrame = frame;
					renderFrame();
				}
			} else {
				inventory.hasNewItemsLock.unlock();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				//intentionally empty catch
			}
		}
	}

	public void processInput(Key key) {
		super.processInput(key);
		switch (key) {
			case LEFT_ARROW:
				if (frameToRender == 0) {
					frameToRender = itemFrames.size() - 1;
				} else {
					frameToRender--;
				}
				break;
			case RIGHT_ARROW:
				if (frameToRender == (itemFrames.size() - 1)) {
					frameToRender = 0;
				} else {
					frameToRender++;
				}
				break;
			default:
				//intentionally empty case
				break;
		}
		renderFrame();
	}

	private char[][] getItemFrame() {
		char[][] frame = new char[charWidth][charHeight];
		for (int i = 0; i < charWidth; i++) {
			for (int j = 0; j < charHeight; j++) {
				frame[i][j] = ' ';
			}
		}
		for (int i = 0; i < charWidth; i++) {
			frame[i][0] = '#';
			frame[i][charHeight - 1] = '#';
		}
		for (int i = 1; i < (charHeight - 1); i++) {
			frame[0][i] = '#';
			frame[charWidth - 1][i] = '#';
		}
		String label = "Name:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][1] = label.charAt(i - 2);
		}
		label = "Durability:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][2] = label.charAt(i - 2);
		}
		label = "Strength:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][3] = label.charAt(i - 2);
		}
		label = "Type:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][4] = label.charAt(i - 2);
		}
		return frame;
	}

	public void stop() {
		running = false;
	}
}
