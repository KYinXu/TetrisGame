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
Grid(int w, int h) {
	grid = new boolean[w][h];
	this.width = w;
	this.height = h;
}
	public void end(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, MainClass.framewidth, MainClass.frameheight);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", MainClass.framewidth/2-20, MainClass.frameheight/2);
	}
	public void update(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, MainClass.framewidth, MainClass.frameheight);
		for(int i=0;i<width;i++) {
			for(int z=0;z<height;z++) {
			g.setColor(Color.BLUE);
			g.drawRect(i*30, z*30, UnitSize, UnitSize);
			}
		}
		for(int i=0;i<width;i++) {
			for(int z=0;z<height;z++) {
				if(grid[i][z]) {
					g.setColor(Color.CYAN);
					g.fillRect(i*30+2, z*30+2, UnitSize-2, UnitSize-2);
				}
			}
		}
	}
	public void clear(int Row) {
		for(int i = 0; i < width; i++) {
			grid[i][Row] = false;
		}
		for(int i = Row-1; i >= 0; i--) {
			for(int o = 0; o < width; o++) {
				grid[o][i+1] = grid[o][i];
			}
		}
	}
	public boolean checkRow(int Row) {
		for(int i = 0; i < width; i++) {
			if(grid[i][Row] == false) {
				full = false;
				break;
			}
			else if(i + 1 == width) {
				full = true;
			}
		}
		return full;
	}
}
