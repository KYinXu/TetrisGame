package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class LineBlock extends Object {
	int x;
	int y;
	LineBlock l;

	public LineBlock(int GridX, int GridY) {
		super(GridX, GridY);
		fallspeed = 1;
	}

	ArrayList<LineBlock> Line = new ArrayList();

	void addBlock(LineBlock l) {
		l = new LineBlock(0, 0);
		Line.add(l);
	}

	void generatePiece(Graphics g) {
		for (int i = 0; i < 4; i++) {
			Line.get(i).draw(g);
			addBlock(l);
		}
	}

	void update() {

	}

	void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.drawRect(x, y, 30, 30);
	}

}
