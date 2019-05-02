package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class LineBlock extends GameObject {
	int x;
	int y;
	LineBlock l;
	Grid grid;
	public LineBlock(int GridX, int GridY, Grid grid) {
		super(GridX, GridY);
		fallspeed = 1;
		x=GridX;
		y=GridY;
		this.grid=grid;
	}
	ArrayList<LineBlock> Line = new ArrayList<LineBlock>();
	


	void addBlock(LineBlock l) {
		
		l = new LineBlock(x, y, grid);
		l.x--;
		Line.add(l);
	}
	void generatePiece(Graphics g) {
		for (int i = 0; i < 4; i++) {
			Line.get(i).draw(g);

			
		}
		x-=4;
	}

	void update() {
		for(int i=0;i<4;i++) {
		if(grid.FilledBlock[y+1][x+i].isFilled==true) {
			isActive=false;
		}
		}
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
