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
	ArrayList<Integer> recordX = new ArrayList<Integer>();
	ArrayList<Integer> recordY = new ArrayList<Integer>();
	ObjectManager manager = new ObjectManager();
	public Object(int GridX, int GridY) {
	}

	void isLine() {
		line = new LineBlock(x, y);

	}
	void resetBlock() {
		line.x=2;
		line.y=0;
	}
	void update() {
		if(y>=22) {
			isActive=false;
		}
		
		x = line.x;
		y = line.y;
		line.update();
	}
}
