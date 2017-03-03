package com.lumos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Screen {
	private char[][] frame;
	
	private int width;
	private int height;
	
	private int playerx;
	private int playery;
	
	private JFrame window;
	private JTextArea textarea;
	
	public Screen(int width, int height) {
		//arguments are num chars wide, high
		
		frame = new char[height][width];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == Math.floor(height/2) && j == Math.floor(width/2)) {
					frame[i][j] = '@';
					playery = i;
					playerx = j;
				} else {
					frame[i][j] = '.';
				}
			}
		}
		
		this.width = width;
		this.height = height;
		
		textarea = new JTextArea(21, 7);
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
		window.add(textarea);
		textarea.setBounds(10, 10, 490, 490);
		
		renderFrame();
	}
	
	public boolean update(char[][] frame) {
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
	
	public void renderFrame() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(frame[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println(String.format("player at (%s,%s)", playerx, playery));
	}
}
