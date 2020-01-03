package default_package;

import java.awt.Color;
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
	String Next = "blank";
	String Hold = "blank";
	String Hold2 = "blank";
	boolean canHold = true;
	Timer t = new Timer(1000 / 3, this);

	public GamePanel() {
		t.start();
		grid = new Grid(10, 25);
		object = new LineBlock(grid);
		object.currentState = "line";

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
			object.currentState = "line";
		}
		if(object.currentState.equalsIgnoreCase("l")) {
			object = new LBlock(grid);
			object.currentState = "l";
		}
		if(object.currentState.equalsIgnoreCase("j")) {
			object = new JBlock(grid);
			object.currentState = "j";
		}
		if(object.currentState.equalsIgnoreCase("z")) {
			object = new ZBlock(grid);
			object.currentState = "z";
		}
		if(object.currentState.equalsIgnoreCase("s")) {
			object = new SBlock(grid);
			object.currentState = "s";
		}
		if(object.currentState.equalsIgnoreCase("square")) {
			object = new SquareBlock(grid);
			object.currentState = "square";
		}
		if(object.currentState.equalsIgnoreCase("t")) {
			object = new TBlock(grid);
			object.currentState = "t";
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
				System.out.println(Next);
				if(Next.equalsIgnoreCase(null)) {
					System.out.println("awetssdgrg broken");
				}
				if(Next.equalsIgnoreCase("blank")) {
					Next = NewBlock();
					System.out.println(Next + "efsduhhhhhhhxm,rrg vcxfthhhgn");
				}
				object.currentState = Next;
				System.out.println(object.currentState + "     eaffdrhhhhhhhtffgnyjnnntgd");
				Next = NewBlock();
				SetBlock();
				canHold = true;
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
			if(canHold = true) {
			for(int i = 0; i < 4; i++)
			object.grid.grid[object.xPos[i]][object.yPos[i]] = false;
			if(Hold.equalsIgnoreCase("blank")) {
				Hold = object.currentState;
				Hold2 = object.currentState;
				object.currentState = Next;
				Next = NewBlock();
				SetBlock();
			}
			else {
				Hold2 = Hold;
				Hold = object.currentState;
				object.currentState = Hold2;
				Hold2 = Hold;
				SetBlock();
			}
			canHold = false;
			for(int i = 0; i < 4; i++)
			object.grid.grid[object.xPos[i]][object.yPos[i]] = true;
		}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
