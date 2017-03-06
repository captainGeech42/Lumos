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
		frame = new char[charHeight][charWidth];
		player = new Player(10, "player1");
		
		for (int i = 0; i < charHeight; i++) {
			for (int j = 0; j < charWidth; j++) {
				if (i == Math.floor(charHeight/2) && j == Math.floor(charWidth/2)) {
					frame[i][j] = '@';
					player.setY(i);
					player.setX(j);
				} else {
					frame[i][j] = '.';
				}
			}
		}
		
		textarea = new JTextArea(8, 7);
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

	private boolean update(char[][] frame) {
		if (frame.length != charHeight && frame[0].length != charWidth) {
			//make sure that new frame is valid dimensions
			return false;
		}

		for (int i = 0; i < charHeight; i++) {
			for (int j = 0; j < charWidth; j++) {
				this.frame[i][j] = frame[i][j];
			}
		}
		
		renderFrame();
		return true;
	}
	
	private void renderFrame() {
		resetWindow();
		for (int i = 0; i < charHeight; i++) {
			for (int j = 0; j < charWidth; j++) {
				addTextToWindow(frame[i][j]);
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
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(String.format("%s key pressed", e.getKeyCode()));
		wait(250);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(String.format("%s key released", e.getKeyCode()));
		wait(250);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(String.format("%s key typed", e.getKeyCode()));
		wait(250);
	}
	
	private void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			System.err.println(e1.toString());
		}
	}
}
