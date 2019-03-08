package default_package;

import java.awt.Color;
import java.awt.Graphics;

public class Grid {
	int xposition = 0;
	int yposition = 0;

	public void drawGrid(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 1000);
		g.setColor(Color.BLUE);
		for(int z = 0; z < 11; z++) {
			g.fillRect(xposition, 0, 1, 750);
			xposition+=30;
		}
		xposition = 0;
		g.setColor(Color.BLUE);
		for (int i = 0; i < 26; i++) {
			g.fillRect(0, yposition, 300, 1);
			yposition += 30;

		}
		yposition = 0;
	}
}
