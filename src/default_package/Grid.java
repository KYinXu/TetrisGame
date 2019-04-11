package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Grid {
	int xposition;
	int yposition;
	GridSquare[][] FilledBlock = new GridSquare[26][11];

	public void createGrid(Graphics g) {
		for (int i = 0; i < FilledBlock.length; i++) {
			for (int j = 0; j < FilledBlock[i].length; j++) {
				FilledBlock[i][j] = new GridSquare();
				FilledBlock[i][j].xposition=j+1;
				FilledBlock[i][j].yposition=i+1;
			}
		}

	}

	public void drawGrid(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 1000);
		g.setColor(Color.BLUE);

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

	public void update(Graphics g, GameObject object) {	
		DrawFilled(g);
		for (int i = 0; i < FilledBlock.length; i++) {
			for (int j = 0; j < FilledBlock[i].length; j++) {
				if (FilledBlock[i][j].xposition == object.x && FilledBlock[i][j].yposition == object.y) {
					System.out.println("work");
					FilledBlock[i][j].isFilled = true;
					break;
				}
			}
		}
	}

	public void DrawFilled(Graphics g) {
		for (int i = 0; i < FilledBlock.length; i++) {
			for (int j = 0; j < FilledBlock[i].length; j++) {
				if (FilledBlock[i][j].isFilled == true) {
					for(int d = 1; d<5;d++) {
						g.drawRect((FilledBlock[i][j].xposition+d) * 30, FilledBlock[i][j].yposition * 30, 30, 30);
					}
				}
			}
		}
	}
}
