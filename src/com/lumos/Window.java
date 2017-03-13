package com.lumos;

import java.awt.*;

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
	protected String title;
	
	protected Window(String title, int windowWidth, int windowHeight, int charWidth, int charHeight, int locationX, int locationY) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.charWidth = charWidth;
		this.charHeight = charHeight;
		this.title = title;

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

	public void toFront() {
		jframe.toFront();
		jframe.setState(Frame.NORMAL);
	}

	protected void setKeyListener(Window window) {
		jtextarea.addKeyListener(new InputMonitor(window));
	}

	public void processInput(Key key) {
		//intentionally empty
	}
	
	private void resetWindow() {
		jtextarea.setText("");
	}
	
	private void addTextToWindow(char text) {
		jtextarea.append(String.valueOf(text));
	}
	
	private void addTextToWindow(String text) {
		jtextarea.append(text);
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

	@Override
	public String toString() {
		return title;
	}
}
