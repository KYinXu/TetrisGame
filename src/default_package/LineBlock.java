package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LineBlock extends GameObject {
	int x;
	int y;
	int[] xPos = new int[4];
	int[] yPos = new int[4];
	Grid grid;
	Unit unit;
	public LineBlock(int x, int y, Grid grid) {
		super(x, y);
		this.grid=grid;
		xPos[0]=0;
		xPos[0]=0;
		for(int i=0;i<4;i++) {
			xPos[i]= x+i;
			yPos[i]=y;
		}
	}
	ArrayList<Unit> Line = new ArrayList<Unit>();
	

void createblock(LineBlock l, Graphics g) {

	for(int i=0;i<4;i++) {
		unit = new Unit();
		unit.x=xPos[i];
		unit.y=yPos[i];
		Line.add(unit);
		
	}	 

	for (int i = 0; i < 4; i++) {
		draw(g, unit.x, unit.y);
		unit.x++;
		
	}
	unit.x-=4;

}

	void resetBlock() {
		x = 4;
		y = 0;
		isActive = true;
	}
	public void update(Grid grid) {
		if(left == true && x>=1) {
			x-=1;
		}
		if(right == true && xPos[4]<=8) {
			x+=1;
		}

		for(int i=0;i<Line.size();i++) {
			
		if (y == 24 || grid.FilledBlock[yPos[i]+1][xPos[i]].isFilled==true) {
			isActive = false;
			break;
		}
		}
		if (isActive == true) {
			y++;
			removeLine();
		}
	}

	void draw(Graphics g, int x, int y) {
		g.setColor(Color.CYAN);
		g.drawRect((x*30), (y*30), 30, 30);
	}
void removeLine() {
Line.clear();
}

}
