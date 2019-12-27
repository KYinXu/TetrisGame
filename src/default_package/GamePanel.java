package default_package;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	String GameState = "Game";
	long updateTimer = 0;
	int TimeToUpdate = 1;
	GameObject object;
	Grid grid;
	Timer t = new Timer(1000 / 3, this);

	public GamePanel() {
		t.start();
		grid = new Grid(10, 25);
		object = new LineBlock(grid);
	}

	public void paintComponent(Graphics g) {
		if (GameState.equalsIgnoreCase("Lose")) {
			System.out.println("lose");
			grid.end(g);
		} else {
			grid.update(g);
		}
	}
	public String NewBlock() {
		String block;
		int r = new Random().nextInt(7);
		object.rotation = 0;
		for(int i = 0; i < grid.height; i++) {
			if(grid.checkRow(i) == true) {
				grid.clear(i);
			}
		}
		if (r == 0) {


			block = "line";

		} else if (r == 1) {


			block = "square";

		} else if (r == 2) {


			block = "s";

		} else if (r == 3) {


			block = "z";

		} else if (r == 4) {


			block = "j";

		} else if (r == 5) {


			block = "l";

		} else {


			block = "t";

		}
		return block;
	}
	public void SetBlock() {
		if(object.currentState.equalsIgnoreCase("line")) {
			object = new LineBlock(grid);
		}
		if(object.currentState.equalsIgnoreCase("l")) {
			object = new LBlock(grid);
		}
		if(object.currentState.equalsIgnoreCase("j")) {
			object = new JBlock(grid);
		}
		if(object.currentState.equalsIgnoreCase("z")) {
			object = new ZBlock(grid);
		}
		if(object.currentState.equalsIgnoreCase("s")) {
			object = new SBlock(grid);
		}
		if(object.currentState.equalsIgnoreCase("square")) {
			object = new SquareBlock(grid);
		}
		if(object.currentState.equalsIgnoreCase("t")) {
			object = new TBlock(grid);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(grid.height);
		if (GameState.equalsIgnoreCase("Game")) {

			object.update("check");

			if (object.isActive == true) {
				object.update("down");
				object.update("check");

			} else {

				for (int i = 0; i < 4; i++) {
					if (object.yPos[i] <= 0 && grid.grid[object.xPos[i]][object.yPos[i]]) {
						GameState = "Lose";
					}
				}
				for (int i = 0; i < 4; i++) {
					grid.grid[object.xPos[i]][object.yPos[i]] = true;
				}
				object.currentState = NewBlock();
				SetBlock();
				object.Next = NewBlock();
			}
			repaint();
		}
	}

	// TODO Auto-generated method stub
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		object.update("check");
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT && object.canMoveLeft == true) {
			object.update("check");
			if (object.canMoveLeft == true) {
					object.moveLeft();

			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && object.canMoveRight == true) {
			object.update("check");
			if (object.canMoveRight == true) {
					object.moveRight();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			object.update("down");
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			object.update("space");
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			for (int i = 0; i < 4; i++) {
					object.checkLeft();
					object.checkRight();
					if(object.canRotate == true) {
					object.update("r");
					}
					break;
				
			}

		}
		else if(e.getKeyCode() == KeyEvent.VK_C) {
			for(int i = 0; i < 4; i++)
			object.grid.grid[object.xPos[i]][object.yPos[i]] = false;
			repaint();
			object.Hold = object.currentState;
			if(object.Hold.equalsIgnoreCase("blank")) {
				object.currentState = object.Next;
				object.Next = NewBlock();
			}
			else {
			object.currentState = object.Hold;
			}
			for(int i = 0; i < 4; i++)
			object.grid.grid[object.xPos[i]][object.yPos[i]] = true;
			SetBlock();
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
