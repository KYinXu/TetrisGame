package default_package;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	long updateTimer=0;
	int TimeToUpdate = 100;
	Object object = new Object(0, 0);
	Grid grid;
	Timer t = new Timer(1000/60, this);
public GamePanel() {
	grid = new Grid();
	object.isLine();
	t.start();
}
public void paintComponent(Graphics g) {
	grid.drawGrid(g);
	for(int i=0;i<4;i++) {
		object.line.x++;
		object.line.addBlock(object.line.l);
		System.out.println(object.line.y);
	}
	object.line.x-=4;
	object.line.generatePiece(g);
	System.out.println("repaint");
}
@Override
public void actionPerformed(ActionEvent e) {
	if(object.isActive==true) {
		if(System.currentTimeMillis()-updateTimer>TimeToUpdate) {
			object.update();
			repaint();
			updateTimer=System.currentTimeMillis();
		}
	}
	// TODO Auto-generated method stub
}
}
