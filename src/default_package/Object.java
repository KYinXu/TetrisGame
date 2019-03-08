package default_package;

import java.awt.Graphics;

public class Object {
	int x = 2;
	int y;
	int fallspeed = 1;
	LineBlock line;
	boolean isActive = true;
	Object currentObject;

	public Object(int GridX, int GridY) {
	}

	void isLine() {
		line = new LineBlock(x, y);

	}

	void update() {
		if(y>=22) {
			isActive=false;
		}
		x = line.x;
		y = line.y;
		line.update();
		System.out.println("test");
	}
}
