package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class Object {
	int x = 2;
	int y;
	int fallspeed = 1;
	LineBlock line;
	boolean isActive = true;
	Object currentObject;
	ObjectManager manager = new ObjectManager();
	public Object(int GridX, int GridY) {
	}

	void isLine() {
		line = new LineBlock(x, y);

	}
	void resetBlock() {
		x=3;
		y=0;
		x=line.x;
		y=line.y;
	}
	void update() {
			if(y==23) {
				isActive=false;
		}	

	
		x = line.x;
		y = line.y;
		if(isActive==true) {
		line.update();
		}
	}
}
