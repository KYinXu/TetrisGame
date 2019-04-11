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
	ArrayList<GameObject> InactiveObjects = new ArrayList<GameObject>();
	GameObject object = new GameObject(2, 0);
	GameObject old;
	Grid grid;
	ObjectManager manager = new ObjectManager();
	Timer t = new Timer(1000/60, this);
public GamePanel() {
	t.start();
	if(manager.BlockType==0) {
		object.isLine();	
	}

	grid = new Grid();
	grid.createGrid(getGraphics());
}
public void paintComponent(Graphics g) {

	grid.drawGrid(g);
		StartBlock(g);
	CheckObjects(g);
}
public void CheckObjects(Graphics g) {
	grid.DrawFilled(g);
		if(object.isActive==false) {
			grid.update(g, object);
			object.resetBlock();
		
	}
}
public void StartBlock(Graphics g) {
	if(manager.BlockType==0) {

		for(int i=0;i<4;i++) {
			object.line.x++;
			object.line.addBlock(object.line.l);
		}
		ShowBlock(g);

	}
}
public void ShowBlock(Graphics g) {
	object.line.generatePiece(g);
	object.line.x-=4;
}
@Override
public void actionPerformed(ActionEvent e) {
		if(System.currentTimeMillis()-updateTimer>TimeToUpdate) {
			if(object.isActive==true) {
				object.update(grid);
				updateTimer=System.currentTimeMillis();
				repaint();	
			}


		}
	}
	// TODO Auto-generated method stub
}

