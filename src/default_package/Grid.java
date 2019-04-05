package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Grid {
	int xposition;
	int yposition;
	GridSquare[][] FilledBlock = new GridSquare[26][11];
	public void drawGrid(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 1000);
		g.setColor(Color.BLUE);
		for(int i = 0;i<FilledBlock.length;i++) {
			for(int j = 0;j<FilledBlock.length;j++) {
				GridSquare g2 = FilledBlock[i][j];
				if(g2.isFilled==true) {
					DrawFilled(g);
				}
				else {
					break;
				}
			
			}
		}
		for (int z = 0; z < 11; z++) {
			g.fillRect(xposition, 0, 1, 750);
			xposition += 30;
		}

		xposition = 0;
		g.setColor(Color.BLUE);
		for (int i = 0; i < 26; i++) {
			g.fillRect(0, yposition, 300, 1);
			yposition += 30;

		}
		yposition = 0;
	}

	public void update(Graphics g, Object object) {
		DrawFilled(g);
		if (object.isActive == false) {
			for (int i = 0; i < FilledBlock.size(); i++) {
				if (FilledBlock.get(i).isFilled == false) {
					FilledBlock.get(i).xposition = object.x * 30;
					for (int o = 0; o < FilledY.size(); o++) {
						if (FilledY.get(o).isFilled == false) {
							FilledY.get(o).yposition = object.y * 30;
							g.setColor(Color.CYAN);
							for (int m = 0; m < 4; m++) {
								g.drawRect(FilledBlock.get(i).xposition + 30, FilledY.get(o).yposition, 30, 30);
								FilledBlock.get(i).xposition = FilledBlock.get(i).xposition + 30;
							}
							FilledBlock.get(i).xposition -= 120;
							FilledBlock.get(i).isFilled = true;
							FilledY.get(o).isFilled = true;
							break;
						}
					}
				}
			}
		}
	}
	public void DrawFilled(Graphics g) {
		for (int i = 0; i < FilledBlock.size(); i++) {
			if (FilledBlock.get(i).isFilled == true) {
				for (int o = 0; o < FilledY.size(); o++) {
					if (FilledY.get(o).isFilled = true) {
						g.setColor(Color.CYAN);
						for (int m = 0; m < 4; m++) {
							g.drawRect(FilledBlock.get(i).xposition + 30, FilledY.get(o).yposition, 30, 30);
							FilledBlock.get(i).xposition+=30;
						}
						FilledBlock.get(i).xposition-=120;
					}
				}
			}
		}
	}
}
