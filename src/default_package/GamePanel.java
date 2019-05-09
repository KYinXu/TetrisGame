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
	GameObject object;
	LineBlock line;
	Grid grid;
	ObjectManager manager = new ObjectManager();
	Timer t = new Timer(1000 / 60, this);

	public GamePanel() {
		
		if (manager.BlockType == 0) {
			line = new LineBlock(4, 0, grid);
			line.isActive=true;
			
		}

		grid = new Grid();
		grid.createGrid(getGraphics());
		
		t.start();
	}

	public void paintComponent(Graphics g) {

		grid.drawGrid(g);
		CreateObject(g);
		CheckObjects(g);
	}

	public void CheckObjects(Graphics g) {
		grid.DrawFilled(g);
		if(line.isActive==false && line.y<=0) {
//game over
		}
		if (line.isActive == false) {
			grid.update(g, line);
			line.resetBlock();

		}
	}

	public void CreateObject(Graphics g) {
		if (manager.BlockType == 0) {
			line.createblock(line, g);
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if (System.currentTimeMillis() - updateTimer > TimeToUpdate) {
			if (line.isActive == true) {
				line.update(grid);
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
			line.left=true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			line.right=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			line.left=false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			line.right=false;
		}
	}
}
