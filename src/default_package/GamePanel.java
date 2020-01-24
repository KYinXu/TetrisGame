package default_package;

import java.awt.Color;
import java.awt.Font;
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
	boolean canHold;
	int endy;
	Timer t = new Timer(1000 / 3, this);
	int Level;
	int clears = 0;
	public GamePanel() {
		t.start();
		Level = 1;
		grid = new Grid(10, 26);
		object = new LineBlock(grid);
		object.currentState = "line";
		canHold = true;
		Next = NewBlock();
		endy = MainClass.frameheight;
	}

	public void paintComponent(Graphics g) {
		System.out.println(Level);
		if (GameState.equalsIgnoreCase("Lose")) {
			if(endy > 0) {
			end(g);
			}
			else {
				g.setColor(Color.RED);
				g.fillRect(0,  0,  MainClass.framewidth, MainClass.frameheight);
			}
		} else {
			if(clears >= 5) {
				Level++;
				clears-=10;
				t.stop();
				t = new Timer(1000/(3+(2*Level/5)), this);
				t.start();
			}
			grid.update(g, Hold, Next);
		}
	}
	public void end(Graphics g) {
		grid.update(g, Hold, Next);
		g.setColor(Color.RED);
			g.fillRect(0, endy, MainClass.framewidth, MainClass.frameheight);
		}

	public String NewBlock() {
		String block;
		int r = new Random().nextInt(7);
		object.rotation = 0;
		for(int i = 0; i < grid.height; i++) {
			if(grid.checkRow(i) == true) {
				grid.clear(i);
				clears++;
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
		if(object.currentState.equalsIgnoreCase("t")) {
			object = new TBlock(grid);
			object.currentState = "t";
		}
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

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (GameState.equalsIgnoreCase("Lose")) {
			endy-=1;
			repaint();
		}
		if (GameState.equalsIgnoreCase("Game")) {

			object.update("check");

			if (object.isActive == true) {
				object.update("down");
				object.update("check");

			} else {

				for (int i = 0; i < 4; i++) {
					if (object.yPos[i] <= 1 && grid.grid[object.xPos[i]][object.yPos[i]]) {
						GameState = "Lose";
					}
				}
				for (int i = 0; i < 4; i++) {
					grid.grid[object.xPos[i]][object.yPos[i]] = true;
				}
				System.out.println(Next);
				if(Next.equalsIgnoreCase(null)) {
				}
				if(Next.equalsIgnoreCase("blank")) {
					Next = NewBlock();
				}
				object.currentState = Next;
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
			for(int i = 0;i < 4; i++) {
					object.checkLeft();
					object.checkRight();
					if(object.canRotate == true) {
					object.update("r");
					}
					break;
			}
				
			

		}
		else if(e.getKeyCode() == KeyEvent.VK_C) {
			if(canHold == true) {
			for(int i = 0; i < 4; i++)
			object.grid.grid[object.xPos[i]][object.yPos[i]] = false;
			if(Next.equalsIgnoreCase("blank")) {
				Next = NewBlock();
			}
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
