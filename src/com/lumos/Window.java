package com.lumos;

import java.awt.Color;
import java.awt.Font;

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
		jframe.getContentPane().setBackground(Color.LIGHT_GRAY);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setLayout(null);
		
		jtextarea = new JTextArea(charWidth, charHeight);
		jtextarea.setEditable(false);
		jtextarea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		jtextarea.setForeground(Color.BLACK);
		jtextarea.setBackground(Color.LIGHT_GRAY);
		jtextarea.setBounds(10, 10, windowWidth-10, windowHeight-10);
		jtextarea.setFocusable(true);
		jframe.add(jtextarea);
	}
	
	public void initUI() {
		if (!hasBeenInitalized) {
			jframe.setVisible(true);
			renderFrame();
			hasBeenInitalized = true;
		}
	}

	protected void setKeyListener(Window window) {
		jtextarea.addKeyListener(new InputMonitor(window));
	}

	public void processInput(Key key) {
		System.out.println("received " + key);
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
	
	protected void renderFrame() {
		resetWindow();
		for (int i = 0; i < charHeight; i++) {
			for (int j = 0; j < charWidth; j++) {
				addTextToWindow(charFrame[j][i]);
			}
			addTextToWindow("\n");
		}
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
