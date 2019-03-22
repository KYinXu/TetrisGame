package default_package;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	long updateTimer=0;
	int TimeToUpdate = 100;
	ArrayList<Object> InactiveObjects = new ArrayList<Object>();
	Object object = new Object(2, 0);
	Object old;
	Grid grid;
	ObjectManager manager = new ObjectManager();
	Timer t = new Timer(1000/60, this);
public GamePanel() {
	t.start();
	object.isLine();
	grid = new Grid();
	object.oldlist.add(100);
}
public void paintComponent(Graphics g) {

	grid.drawGrid(g);
	if(manager.BlockType==0) {
		for(int i=0;i<4;i++) {
			object.line.x++;
			object.line.addBlock(object.line.l);
		}

		object.line.generatePiece(g);
		object.line.x-=4;
	}

	CheckObjects(g);
	if(object.isActive==false) {
		old = new Object(object.line.x, object.y);
		old.x=object.line.x+1;
		old.y=object.line.y;
		old.isLine();
		InactiveObjects.add(old);
		object.resetBlock();
		object.isActive=true;
		object.oldlist.add(old.y-1);
		System.out.println("added");
	}
}
public void CheckObjects(Graphics g) {
	for(int i=0;i<InactiveObjects.size();i++) {
		for(int z=0;z<4;z++){
		InactiveObjects.get(i).line.addBlock(InactiveObjects.get(i).line.l);
		InactiveObjects.get(i).line.x++;
		}
		InactiveObjects.get(i).line.generatePiece(g);
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	if(object.isActive==true) {
		if(System.currentTimeMillis()-updateTimer>TimeToUpdate) {
			object.update();
			updateTimer=System.currentTimeMillis();
			repaint();

		}
	}
	// TODO Auto-generated method stub
}
}
