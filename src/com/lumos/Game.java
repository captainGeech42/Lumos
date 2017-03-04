package com.lumos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.*;

import java.awt.event.KeyListener;

public class Game implements KeyListener{
	private char[][] frame;
	private Player player;
	
	private int width;
	private int height;
	
	private JFrame window;
	private JTextArea textarea;
	
	public Game(int width, int height) {
		//arguments are num chars wide, high
		
		frame = new char[height][width];
		player = new Player(10, "player1");
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == Math.floor(height/2) && j == Math.floor(width/2)) {
					frame[i][j] = '@';
					player.setY(i);
					player.setX(j);
				} else {
					frame[i][j] = '.';
				}
			}
		}
		
		this.width = width;
		this.height = height;
		
		textarea = new JTextArea(8, 7);
		textarea.setEditable(false);
		textarea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		textarea.setForeground(Color.BLACK);
		textarea.setBackground(Color.LIGHT_GRAY);

		window = new JFrame("Lumos");
		window.setLayout(null);
		window.setLocation(0,0);
		window.setSize(new Dimension(500,500));
		window.setResizable(false);
		window.setVisible(true);
		window.getContentPane().setBackground(Color.LIGHT_GRAY);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.add(textarea);
		textarea.setBounds(10, 10, 490, 490);
		textarea.addKeyListener(this);
		textarea.setFocusable(true);
		
		renderFrame();
	}

	private boolean update(char[][] frame) {
		if (frame.length != height && frame[0].length != width) {
			//make sure that new frame is valid dimensions
			return false;
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				this.frame[i][j] = frame[i][j];
			}
		}
		
		renderFrame();
		return true;
	}
	
	private void renderFrame() {
		resetWindow();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				addTextToWindow(frame[i][j]);
			}
			addTextToWindow("\n");
		}
		System.out.println(String.format("player at (%s,%s)", player.getX(), player.getY()));
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
