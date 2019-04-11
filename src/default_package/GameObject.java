package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameObject {
	int x = 2;
	int x2 = 3;
	int x3 = 4;
	int x4 = 5;
	int y;
	int fallspeed = 1;
	LineBlock line;
	
	boolean isActive = true;
	GameObject currentObject;
	ObjectManager manager = new ObjectManager();

	public GameObject(int GridX, int GridY) {
	}

	void isLine() {
		line = new LineBlock(x, y);

	}

	void resetBlock() {
		line.x = 2;
		x2 = 3;
		x3 = 4;
		x4 = 5;
		line.y = 0;
		isActive = true;
	}

	void update(Grid grid) {
		if (y+1 == 24|| grid.FilledBlock[x][y+1].isFilled==true) {
			isActive = false;
		}
		line.x=x;
		line.y=y;
		x=line.x;
		y=line.y;

		if (isActive == true) {
			line.update();
		}
	}
}
