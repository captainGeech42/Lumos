package com.lumos;

public class StatWindow extends Window {
	
	
	public StatWindow(int windowWidth, int windowHeight, int charWidth, int charHeight, int locationX, int locationY) {
		super("Stats", windowWidth, windowHeight, charWidth, charHeight, locationX, locationY);
	}

	public char[][] getDefaultFrame() {
		char[][] frame = new char[charWidth][charHeight];
		for (int i = 0; i < charWidth; i++) {
			for (int j = 0; j < charHeight; j++) {
				frame[i][j] = ' ';
			}
		}
		for (int i = 0; i < charHeight; i++) {
			frame[0][i] = '#';
			frame[charWidth-1][i] = '#';
		}
		for (int i = 1; i < charWidth - 1; i++) {
			frame[i][0] = '#';
			frame[i][5] = '#';
			frame[i][10] = '#';
			frame[i][charHeight - 1] = '#';
		}
		String label = "TEMP_NAME" + " STATS";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][1] = label.charAt(i - 2);
		}
		label = "Health:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][2] = label.charAt(i - 2);
		}
		label = "Strength:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][3] = label.charAt(i - 2);
		}
		label = "Armor:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][4] = label.charAt(i - 2);
		}
		label = "SELECTED INVENTORY ITEM STATS:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][6] = label.charAt(i - 2);
		}
		label = "Name:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][7] = label.charAt(i - 2);
		}
		label = "Durability:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][8] = label.charAt(i - 2);
		}
		label = "Strength:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][9] = label.charAt(i - 2);
		}
		label = "ENEMY STATS";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][11] = label.charAt(i - 2);
		}
		label = "Health:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][12] = label.charAt(i - 2);
		}
		label = "Strength:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][13] = label.charAt(i - 2);
		}
		label = "Armor:";
		for (int i = 2; i < label.length() + 2; i++) {
			frame[i][14] = label.charAt(i - 2);
		}
		return frame;
	}

	@Override
	public void initUI() {
		charFrame = getDefaultFrame();
		super.initUI();
	}
}

/*
########################################0
#       PLAYER NAME                    #1
#  Health:                             #2
#  Strength:                           #3
#  Armor:                              #4
########################################5
#  Name:                               #6
#  Durability:                         #7
#  Strength:                           #8
#  Type:                               #9
########################################10
#     ENEMY STATS                      #11
#  Health:                             #12
#  Strength:                           #13
#  Armor:                              #14
########################################15
 */
