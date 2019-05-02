package default_package;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	long updateTimer = 0;
	int TimeToUpdate = 50;
	ArrayList<GameObject> InactiveObjects = new ArrayList<GameObject>();
	GameObject object;
	Grid grid;
	ObjectManager manager = new ObjectManager();
	Timer t = new Timer(1000 / 60, this);

	public GamePanel() {
		t.start();
		if (manager.BlockType == 0) {
			object = new GameObject(5, 0);
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
		if(object.isActive==false && object.y<=0) {
//game over
		}
		if (object.isActive == false) {
			grid.update(g, object);
			object.resetBlock();

		}
	}

	public void StartBlock(Graphics g) {
		if (manager.BlockType == 0) {

			for (int i = 0; i < 4; i++) {
				object.line.x++;
				object.line.addBlock(object.line.l);

			}
			object.line.generatePiece(g);

		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if (System.currentTimeMillis() - updateTimer > TimeToUpdate) {
			if (object.isActive == true) {
				object.update(grid);
				updateTimer = System.currentTimeMillis();
				repaint();
			}


		}
	}

	// TODO Auto-generated method stub
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			object.left=true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			object.right=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			object.left=false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			object.right=false;
		}
	}
}
