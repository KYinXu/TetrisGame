package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Grid {
	int xposition = 0;
	int yposition = 0;
	boolean isFilled = false;
	ArrayList<Grid> FilledX = new ArrayList<Grid>();
	ArrayList<Grid> FilledY = new ArrayList<Grid>();

	public void drawGrid(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 1000);
		g.setColor(Color.BLUE);
		for (int z = 0; z < 11; z++) {
			Grid g3 = new Grid();
			FilledX.add(g3);
			g.fillRect(xposition, 0, 1, 750);
			xposition += 30;
		}

		xposition = 0;
		g.setColor(Color.BLUE);
		for (int i = 0; i < 26; i++) {
			Grid g2 = new Grid();
			FilledY.add(g2);
			g.fillRect(0, yposition, 300, 1);
			yposition += 30;

		}
		yposition = 0;
	}

	public void update(Graphics g, Object object) {
		int RecordedX = object.x;
		int RecordedY = object.y;
		if(object.isActive==false) {
		for (int i = 0; i < FilledX.size(); i++) {
			if (FilledX.get(i).isFilled == true) {
				FilledX.get(i).xposition = RecordedX * 30;
				System.out.println(FilledX.get(i).xposition);
			
			for (int o = 0; o < FilledY.size(); o++) {
				if (FilledY.get(o).isFilled == true) {
					FilledY.get(o).yposition = RecordedY * 30;
					g.setColor(Color.CYAN);
					g.fillRect(FilledX.get(i).xposition, FilledY.get(o).yposition, 30, 30);
				}
			}
			}
		}
		}
	}
}
