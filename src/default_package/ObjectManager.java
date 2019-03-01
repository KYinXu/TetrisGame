package default_package;

import java.awt.Graphics;
import java.util.Random;

public class ObjectManager {
LineBlock l;
int BlockType;
public ObjectManager() {
	BlockType = new Random().nextInt(6);
	if(BlockType == 0) {
		l = new LineBlock(4, 0);
	}
}
void drawObject(Graphics g) {
	l.generatePiece(g);
}
}
