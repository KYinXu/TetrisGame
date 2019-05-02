package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameObject {
	boolean left = false;
	boolean right = false;
	int x = 0;
	int x2 = x+1;
	int x3 = x+2;
	int x4 = x+3;
	int y;
	int fallspeed = 1;
	LineBlock line;
	Grid grid;
	boolean isActive = true;
	GameObject currentObject;
	ObjectManager manager = new ObjectManager();

	public GameObject(int GridX, int GridY) {
		x=GridX-1;
		y=GridY;

	}

	void isLine() {
		line = new LineBlock(x,y, grid);
		line.x-=1;
		line.y-=1;

	}

	void resetBlock() {
		line.x = 3;
		line.y = 0;
		isActive = true;
	}

	void update(Grid grid) {
		if(left == true && x>=1) {
			line.x-=1;
		}
		if(right == true && x4<=8) {
			line.x+=1;
		}
		x=line.x;
		y=line.y;
		x2 = x+1;
		x3 = x+2;
		x4 = x+3;
		System.out.println(line.Line.size());
		for(int i=0;i<line.Line.size();i++) {
			
		if (y == 24 || grid.FilledBlock[line.Line.get(i).y+1][line.Line.get(i).x].isFilled==true) {
			isActive = false;
			break;
		}
		}
		if (isActive == true) {
			line.update();
		}

	}
}
