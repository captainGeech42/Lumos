package com.lumos;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Window {
	protected JFrame jframe;
	protected JTextArea jtextarea;
	protected char[][] charFrame;
	protected int charWidth;
	protected int charHeight;
	protected int windowWidth;
	protected int windowHeight;
	protected List<Character> characters;
	protected Player player;
	protected boolean hasBeenInitalized = false;
	
	public Window(String title, int windowWidth, int windowHeight, int charWidth, int charHeight, int locationX, int locationY) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.charWidth = charWidth;
		this.charHeight = charHeight;
		
		charFrame = new char[charWidth][charHeight];
		
		jframe = new JFrame(title);
		jframe.setResizable(false);
		jframe.setLocation(locationX, locationY);
		jframe.setSize(windowWidth, windowHeight);
		jframe.setVisible(true);
		jframe.getContentPane().setBackground(Color.LIGHT_GRAY);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setLayout(null);
		
		jtextarea = new JTextArea(charWidth, charHeight);
		jtextarea.setEditable(false);
		jtextarea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		jtextarea.setForeground(Color.BLACK);
		jtextarea.setBackground(Color.LIGHT_GRAY);
		jtextarea.setBounds(10, 10, windowWidth-10, windowHeight-10);
		jtextarea.addKeyListener(new InputMonitor(this));
		jtextarea.setFocusable(true);
		jframe.add(jtextarea);
		
		characters = new ArrayList<Character>();
	}
	
	public void initUI() {
		if (!hasBeenInitalized) {
			renderFrame();
			hasBeenInitalized = true;
		}
	}
	
	private void resetWindow() {
		jtextarea.setText("");
	}
	
	private void addTextToWindow(char text) {
		String old = jtextarea.getText();
		jtextarea.setText(old + text);
	}
	
	private void addTextToWindow(String text) {
		String old = jtextarea.getText();
		jtextarea.setText(old + text);
	}
	
	private void renderFrame() {
		resetWindow();
		updatePositions();
		for (int i = 0; i < charHeight; i++) {
			for (int j = 0; j < charWidth; j++) {
				addTextToWindow(charFrame[j][i]);
			}
			addTextToWindow("\n");
		}
	}
	
	private void updatePositions() {
		if (!characters.isEmpty()) {
			Iterator<Character> iterator = characters.iterator();
			while (iterator.hasNext()) {
				Character character = iterator.next();
				for (int i = 0; i < charWidth; i++) {
					for (int j = 0; j < charHeight; j++) {
						charFrame[i][j] = '.';
						if (i == character.getX() && j == character.getY()) {
							charFrame[i+character.getDx()][j+character.getDy()] = '@';
						}
					}
				}
				character.moveX();
				character.moveY();
			}
		}
	}
	
	public void processInput(Key key) {
		switch (key) {
		case LEFT_ARROW:
			player.setDx(-1);
			break;
		case RIGHT_ARROW:
			player.setDx(1);
			break;
		case UP_ARROW:
			player.setDy(-1);
			break;
		case DOWN_ARROW:
			player.setDy(1);
			break;
		case INVALID:
			//intentionally empty case
			break;
		}
		updatePositions();
		renderFrame();
	}
	
	public void addCharacter(Character character) {
		characters.add(character);
	}
	
	public void addPlayer(Player player) {
		this.player = player;
		addCharacter(player);
	}
	
	public int getCharWidth() {
		return charWidth;
	}
	
	public int getCharHeight() {
		return charHeight;
	}
	
	public int getWindowWidth() {
		return windowWidth;
	}
	
	public int getWindowHeight() {
		return windowHeight;
	}
}
