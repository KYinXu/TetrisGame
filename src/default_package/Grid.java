package default_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Grid {
	public final static int UnitSize = 30;
	public int width;
	public int height;
	public boolean[][] grid;
	public boolean full;
	public int counter;
	public int counterx;

	Grid(int w, int h) {
		grid = new boolean[w][h];
		this.width = w;
		this.height = h;
	}

	public void end(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, MainClass.framewidth, MainClass.frameheight);

	}

	public void update(Graphics g, String Hold, String Next, Font font, int Score, int Level, int Lines) {
		counter = 0;
		counterx = 0;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, MainClass.framewidth, MainClass.frameheight);
		for (int i = 0; i < width; i++) {
			for (int z = 0; z < height; z++) {
				g.setColor(Color.BLUE);
				g.drawRect(i * 30, z * 30 - 30, UnitSize, UnitSize);
			}
			g.setColor(Color.BLUE);
			g.setFont(font);
			g.drawString("Hold", 330, 70);
			g.drawRect(330, 80, UnitSize * 4 + 40, UnitSize * 3 + 40);
			g.drawString("Next", 330, 280);
			g.drawRect(330, 290, UnitSize * 4 + 40, UnitSize * 3 + 40);
			g.drawString("Score", 330, 530);
			g.drawRect(330, 540, UnitSize * 4 + 40, 30);
			g.drawString("" + Score, 340, 565);
			g.drawString("Level", 330, 600);
			g.drawRect(330, 610, UnitSize * 4 + 40, 30);
			g.drawString("" + Level, 340, 635);
			g.drawString("Lines Left", 330, 670);
			g.drawRect(330, 680, UnitSize * 4 + 40, 30);
			g.drawString("" + Lines, 340, 705);
			// 160 by 130
			// 330-490, 80-210
		}
		for (int i = 0; i < width; i++) {
			for (int z = 0; z < height; z++) {
				if (grid[i][z]) {
					g.setColor(Color.CYAN);
					g.fillRect(i * 30 + 2, z * 30 + 2 - 30, UnitSize - 2, UnitSize - 2);
				}
			}
		}
		if (Hold.equalsIgnoreCase("line")) {
			for (int i = 0; i < 4; i++) {
				g.setColor(Color.CYAN);
				g.fillRect(i * 30 + 351, counter * 30 + 131, UnitSize - 2, UnitSize - 2);
			}
		}
		if (Hold.equalsIgnoreCase("square")) {
			for (int i = 0; i < 4; i++) {
				if (i == 2) {
					counterx = 1;
					counter = 0;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 381, counter * 30 + 116, UnitSize - 2, UnitSize - 2);
				counter++;
			}
		}
		if (Hold.equalsIgnoreCase("j")) {
			for (int i = 0; i < 4; i++) {
				if (i == 3) {
					counterx = -1;
					counter = 2;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 411, counter * 30 + 102, UnitSize - 2, UnitSize - 2);
				counter++;
			}
		}
		if (Hold.equalsIgnoreCase("l")) {
			for (int i = 0; i < 4; i++) {
				if (i == 3) {
					counterx = 1;
					counter = 2;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 381, counter * 30 + 102, UnitSize - 2, UnitSize - 2);
				counter++;
			}
		}
		if (Hold.equalsIgnoreCase("s")) {
			for (int i = 0; i < 4; i++) {
				if (i == 2) {
					counterx = 1;
					counter = -1;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 368, counter * 30 + 146, UnitSize - 2, UnitSize - 2);
				counterx++;
			}
		}
		if (Hold.equalsIgnoreCase("z")) {
			for (int i = 0; i < 4; i++) {
				if (i == 2) {
					counterx = 1;
					counter = 1;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 368, counter * 30 + 116, UnitSize - 2, UnitSize - 2);
				counterx++;
			}
		}
		if (Hold.equalsIgnoreCase("t")) {
			for (int i = 0; i < 4; i++) {
				if (i == 3) {
					counterx = 1;
					counter = -1;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 368, counter * 30 + 146, UnitSize - 2, UnitSize - 2);
				counterx++;
			}
		}
		if (Next.equalsIgnoreCase("line")) {
			for (int i = 0; i < 4; i++) {
				g.setColor(Color.CYAN);
				g.fillRect(i * 30 + 351, counter * 30 + 341, UnitSize - 2, UnitSize - 2);
			}
		}
		if (Next.equalsIgnoreCase("square")) {
			for (int i = 0; i < 4; i++) {
				if (i == 2) {
					counterx = 0;
					counter = 1;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 381, counter * 30 + 326, UnitSize - 2, UnitSize - 2);
				counterx++;
			}
		}
		counter = 0;
		counterx = 0;
		if (Next.equalsIgnoreCase("j")) {
			for (int i = 0; i < 4; i++) {
				if (i == 3) {
					counterx = -1;
					counter = 2;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 411, counter * 30 + 312, UnitSize - 2, UnitSize - 2);
				counter++;
			}
		}
		if (Next.equalsIgnoreCase("l")) {
			for (int i = 0; i < 4; i++) {
				if (i == 3) {
					counterx = 1;
					counter = 2;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 381, counter * 30 + 312, UnitSize - 2, UnitSize - 2);
				counter++;
			}
		}
		if (Next.equalsIgnoreCase("s")) {
			for (int i = 0; i < 4; i++) {
				if (i == 2) {
					counterx = 1;
					counter = -1;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 368, counter * 30 + 356, UnitSize - 2, UnitSize - 2);
				counterx++;
			}
		}
		if (Next.equalsIgnoreCase("z")) {
			for (int i = 0; i < 4; i++) {
				if (i == 2) {
					counterx = 1;
					counter = 1;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 368, counter * 30 + 326, UnitSize - 2, UnitSize - 2);
				counterx++;
			}
		}
		if (Next.equalsIgnoreCase("t")) {
			for (int i = 0; i < 4; i++) {
				if (i == 3) {
					counterx = 1;
					counter = -1;
				}
				g.setColor(Color.CYAN);
				g.fillRect(counterx * 30 + 368, counter * 30 + 356, UnitSize - 2, UnitSize - 2);
				counterx++;
			}
		}
		counter = 0;
		counterx = 0;
	}

	public void clear(int Row) {
		for (int i = 0; i < width; i++) {
			grid[i][Row] = false;
		}
		for (int i = Row - 1; i >= 0; i--) {
			for (int o = 0; o < width; o++) {
				grid[o][i + 1] = grid[o][i];
			}
		}
	}

	public boolean checkRow(int Row) {
		for (int i = 0; i < width; i++) {
			if (grid[i][Row] == false) {
				full = false;
				break;
			} else if (i + 1 == width) {
				full = true;
			}
		}
		return full;
	}
}
