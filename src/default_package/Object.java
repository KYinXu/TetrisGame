package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class Object {
	int x = 2;

	int y;
	int fallspeed = 1;
	LineBlock line;
	Grid grid = new Grid();
	boolean isActive = true;
	Object currentObject;
	ObjectManager manager = new ObjectManager();

	public Object(int GridX, int GridY) {
	}

	void isLine() {
		line = new LineBlock(x, y);

	}

	void resetBlock() {
		line.x = 2;
		line.y = 0;
		isActive = true;
	}

	void update() {
		for(int i=0;i<grid.FilledY.size();i++) {
			if(line.y*30>=grid.FilledY.get(i).yposition-30) {
				isActive=false;
				break;
			}
		}
		
		if (y == 23) {
			isActive = false;
		}
		
		x=line.x;
		y=line.y;

		if (isActive == true) {
			line.update();
		}
	}
}
