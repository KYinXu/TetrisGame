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
	
	boolean isActive = true;
	GameObject currentObject;
	ObjectManager manager = new ObjectManager();

	public GameObject(int GridX, int GridY) {
		x=GridX-1;
		y=GridY;

	}

	void isLine() {
		line = new LineBlock(x,y);
		line.x-=1;
		line.y-=1;

	}

	void resetBlock() {
		line.x = 2;
		line.y = 0;
		isActive = true;
	}

	void update(Grid grid) {
		if(left == true && x>=0) {
			line.x-=1;
		}
		if(right == true && x4<=9) {
			line.x+=1;
		}
		x=line.x;
		y=line.y;
		x2 = x+1;
		x3 = x+2;
		x4 = x+3;
		for(int i=0;i<line.Line.size();i++) {
		if (y == 24 || grid.FilledBlock[line.Line.get(i).y+1][x].isFilled==true) {
			isActive = false;
			break;
		}
		

		}
		if (isActive == true) {
			line.update();
		}

	}
}
