package default_package;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	long updateTimer=0;
	int TimeToUpdate = 50;
	ArrayList<Object> InactiveObjects = new ArrayList<Object>();
	Object object = new Object(0, 0);
	Object old = new Object(0, 0);
	Grid grid;
	ObjectManager manager = new ObjectManager();
	Timer t = new Timer(1000/60, this);
public GamePanel() {
	object.isLine();
	grid = new Grid();
	t.start();
}
public void paintComponent(Graphics g) {
	grid.drawGrid(g);
	if(manager.BlockType==0) {
		for(int i=0;i<4;i++) {
			object.line.x++;
			object.line.addBlock(object.line.l);
		}
	}
	object.line.x-=4;
	object.line.generatePiece(g);
	if(object.isActive==false) {
		old.isActive=false;
		old.isLine();
		old.y=22;
		old.x=object.x;
		InactiveObjects.add(old);
		for(int i=0;i<InactiveObjects.size();i++) {
			for(int z=0;z<4;z++){
			InactiveObjects.get(i).line.addBlock(InactiveObjects.get(i).line.l);
			InactiveObjects.get(i).line.x++;
			}
			InactiveObjects.get(i).line.generatePiece(getGraphics());
		}
		InactiveObjects.get(0).line.generatePiece(g);
		object.resetBlock();
		object.isActive=true;
		for(int i=0;i<4;i++) {
			object.line.addBlock(object.line.l);
			object.line.x++;
		}
		object.line.x-=4;
		object.line.generatePiece(g);
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
