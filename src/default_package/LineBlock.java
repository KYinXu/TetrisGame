package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class LineBlock extends GameObject {
	int x;
	int y;
	LineBlock l;

	public LineBlock(int GridX, int GridY) {
		super(GridX, GridY);
		fallspeed = 1;
		x=GridX;
		y=GridY;
	}
	ArrayList<LineBlock> Line = new ArrayList<LineBlock>();
	


	void addBlock(LineBlock l) {
		
		l = new LineBlock(x, y);
		Line.add(l);
	}

	void generatePiece(Graphics g) {
		for (int i = 0; i < 4; i++) {
			Line.get(i).draw(g);

			
		}
		x-=4;
	}

	void update() {
		y=y+1;
		removeLine();
	}

	void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.drawRect((x*30), (y*30), 30, 30);
	}
void removeLine() {
Line.clear();
}

}
