package com.lumos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.*;

import java.awt.event.KeyListener;

public class Game implements KeyListener {
	private char[][] frame;
	private Player player;
	
	private int charWidth;
	private int charHeight;
	private int windowWidth;
	private int windowHeight;
	
	private JFrame window;
	private JTextArea textarea;
	
	public Game(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		calculateCharBoundaries(true);
		frame = new char[charWidth][charHeight];
//		for (int i = 0; i < charWidth; i++) {
//			for (int j = 0; j < charHeight; j++) {
//				frame[i][j] = '.';
//			}
//		}
		
		player = new Player(10, "player1");
		player.setX((int) Math.floor(charWidth/2)); 
		player.setY((int) Math.floor(charHeight/2));

		textarea = new JTextArea(charWidth, charHeight);
		textarea.setEditable(false);
		textarea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		textarea.setForeground(Color.BLACK);
		textarea.setBackground(Color.LIGHT_GRAY);

		window = new JFrame("Lumos");
		window.setLayout(null);
		window.setLocation(0,0);
		window.setSize(new Dimension(windowWidth, windowHeight));
		window.setResizable(false);
		window.setVisible(true);
		window.getContentPane().setBackground(Color.LIGHT_GRAY);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.add(textarea);
		textarea.setBounds(10, 10, windowWidth-10, windowHeight-10);
		textarea.addKeyListener(this);
		textarea.setFocusable(true);
		
		renderFrame();
	}
	
	private void calculateCharBoundaries(boolean printToConsole) {
		//TODO conversion constants don't work for bigger resolutions
		charWidth = (int) Math.floor(windowWidth / 7.3);
		charHeight = (int) Math.floor(windowHeight / 19);
		
		if (printToConsole) {
			System.out.println(String.format("Window Resolution: %sx%s", windowWidth, windowHeight));
			System.out.println(String.format("Character Resolution: %sx%s", charWidth, charHeight));
		}
	}
	
	private void updatePositions() {
		for (int i = 0; i < charWidth; i++) {
			for (int j = 0; j < charHeight; j++) {
				if (i == player.getX() && j == player.getY()) {
					frame[i][j] = '.';
					frame[i+player.getDx()][j+player.getDy()] = '@';
				} else {
					frame[i][j] = '.';
				}
			}
		}
		player.setX(player.getDx() + player.getX());
		player.setY(player.getDy() + player.getY());
		player.setDx(0);
		player.setDy(0);
	}
	
	private void renderFrame() {
		resetWindow();
		updatePositions();
		for (int i = 0; i < charHeight; i++) {
			for (int j = 0; j < charWidth; j++) {
				addTextToWindow(frame[j][i]);
			}
			addTextToWindow("\n");
		}
		System.out.println(String.format("Player at (%s,%s)", player.getX(), player.getY()));
	}

	private void resetWindow() {
		textarea.setText("");
	}
	
	private void addTextToWindow(char text) {
		String old = textarea.getText();
		textarea.setText(old + text);
	}
	
	private void addTextToWindow(String text) {
		String old = textarea.getText();
		textarea.setText(old + text);
	}
	
	private void processKey(Key key) {
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
	
	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println(String.format("%s key pressed", e.getKeyCode()));
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
//		System.out.println(String.format("%s released", e.getKeyCode()));
		System.out.println(String.format("received %s", key));
		processKey(key);
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println(String.format("%s key typed", e.getKeyCode()));
	}
}
