package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class Object {
	int x = 2;
	int y;
	int fallspeed = 1;
	ArrayList<Integer> oldlist = new ArrayList<Integer>();
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
		line.y=0;
	}
	void update() {
		for(int i=0;i<oldlist.size();i++) {
			System.out.println(oldlist.get(i));
			if(y==22 || y==oldlist.get(i)) {

				isActive=false;
				break;
		}	

		}
	
		x = line.x;
		y = line.y;
		line.update();
	}
}
