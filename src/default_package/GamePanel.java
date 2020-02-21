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
	// https://ia800504.us.archive.org/33/items/TetrisThemeMusic/Tetris.mp3
	// https://github.com/dencee/Level2GameTemplate/blob/master/src/Audio.java
	String GameState = "Title";
	long updateTimer = 0;
	int TimeToUpdate = 1;
	int streak = 0;
	int audiotest = 0;
	boolean tetrisstreak;
	boolean blocker = false;
	GameObject object;
	Grid grid;
	String Next = "blank";
	String Hold = "blank";
	String Hold2 = "blank";
	Audio Audio = new Audio("Tetris.mp3");
	Font font;
	Font titleFont;
	Font backTitleFont;
	int streakcolor;
	int Score = 0;
	boolean canHold;
	int endy;
	Timer t = new Timer(1000 / 3, this);
	Timer z = new Timer(84000, this);
	int Level;
	int clears = 0;

	public GamePanel() {
		font = new Font("Arial", Font.BOLD, 24);
		titleFont = new Font("Arial", Font.BOLD, 64);
		backTitleFont = new Font("Arial", Font.BOLD, 68);
		t.start();
		Level = 1;
		grid = new Grid(10, 26);
		object = new LineBlock(grid);
		object.currentState = "line";
		canHold = true;
		Next = NewBlock();

	}

	public void paintComponent(Graphics g) {
		g.drawString("", 100, 100);
		if (GameState.equalsIgnoreCase("Title")) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, MainClass.framewidth, MainClass.frameheight);
			g.setColor(Color.BLUE);
			g.fillRect(MainClass.framewidth / 2 - 85, 195, 170, 60);
			g.fillRect(MainClass.framewidth / 2 - 30, 250, 60, 60);
			g.setColor(Color.CYAN);
			g.fillRect(MainClass.framewidth / 2 - 80, 200, 50, 50);
			g.fillRect(MainClass.framewidth / 2 - 25, 200, 50, 50);
			g.fillRect(MainClass.framewidth / 2 + 30, 200, 50, 50);
			g.fillRect(MainClass.framewidth / 2 - 25, 255, 50, 50);
			g.setColor(Color.BLUE);
			g.fillRoundRect(MainClass.framewidth / 2 - 105, 320, 210, 110, 500, 200);
			g.setColor(Color.CYAN);
			g.fillRoundRect(MainClass.framewidth / 2 - 100, 325, 200, 100, 500, 200);
			g.setColor(Color.BLUE);
			g.setFont(titleFont);
			g.drawString("Tetris", MainClass.framewidth / 2 - 85, 400);
			g.fillRect(0, 0, MainClass.framewidth, 10);
			g.fillRect(0, 0, 10, MainClass.frameheight);
			g.fillRect(MainClass.framewidth - 10, 0, 10, MainClass.frameheight);
			g.fillRect(0, MainClass.frameheight - 10, MainClass.framewidth, 10);
			g.setFont(font);
			g.drawString("Press Space to Play", MainClass.framewidth / 2 - 115, 500);
			g.drawString("Press Enter for Instructions", MainClass.framewidth/2 - 155, 550);
		} else if(GameState.equalsIgnoreCase("paused")){
			grid.update(g, null, Hold, Next, font, Score, Level, 5 - clears, tetrisstreak, streakcolor);
			g.setFont(titleFont);
			g.setColor(Color.BLUE);
			g.fillRect(MainClass.framewidth/2 - 155, MainClass.frameheight/2 - 45, 310, 90);
			g.setColor(Color.BLACK);
			g.fillRect(MainClass.framewidth/2 - 150, MainClass.frameheight/2 - 40, 300, 80);
			g.setColor(Color.BLUE);
			g.drawString("PAUSED", MainClass.framewidth/2 - 135, MainClass.frameheight/2+24);
		}
		else if(GameState.equalsIgnoreCase("Controls")) {
			g.setColor(Color.BLACK);
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, MainClass.framewidth, 10);
			g.fillRect(0, 0, 10, MainClass.frameheight);
			g.fillRect(MainClass.framewidth - 10, 0, 10, MainClass.frameheight);
			g.fillRect(0, MainClass.frameheight - 10, MainClass.framewidth, 10);
			g.drawString("Move Left", 20, 50);
			g.drawString("Move Right", 20, 150);
			g.drawString("Move Down", 20, 250);
			g.drawString("Rotate", 20, 350);
			g.drawString("Hold Piece", 20, 450);
			g.drawString("Place Piece", 20, 550);
			g.drawString("Pause", 20, 650);
		}
		else {
		
			if (GameState.equalsIgnoreCase("Lose")) {
				Audio.stop(); 
				grid.end(g, titleFont, font, Score);
				/*
				 * g.setColor(Color.RED); g.fillRect(0, 0, MainClass.framewidth,
				 * MainClass.frameheight); if (endy > 0) { end(g); } else {
				 * g.setColor(Color.RED); g.fillRect(0, 0, MainClass.framewidth,
				 * MainClass.frameheight); }
				 */
			} else {
				if (clears >= 5) {
					Level++;
					clears = 0;
					t.stop();
					t = new Timer(1000 / (3 + (3 * Level / 5)), this);
					t.start();
				}

				grid.update(g, object, Hold, Next, font, Score, Level, 5 - clears, tetrisstreak, streakcolor);

			}
		}
	}

	public String NewBlock() {
		String block;
		int r = new Random().nextInt(7);
		object.rotation = 0;
		for (int i = 0; i < grid.height; i++) {
			if (grid.checkRow(i) == true) {
				grid.clear(i);
				clears++;
				streak++;
				System.out.println(streak);
			}
		}
		if (streak > 0) {
			if (streak == 4) {
				if (tetrisstreak == false) {
					Score += 800;
				} else if (tetrisstreak == true) {
					Score += 1200;
				}
				streak = 0;
				tetrisstreak = true;
			} else {
				for (int i = 0; i < streak; i++) {
					Score += 100;
					streak--;
					if (streak == 0) {
						break;
					}
				}
				tetrisstreak = false;
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
		if (object.currentState.equalsIgnoreCase("t")) {
			object = new TBlock(grid);
			object.currentState = "t";
		}
		if (object.currentState.equalsIgnoreCase("line")) {
			object = new LineBlock(grid);
			object.currentState = "line";
		}
		if (object.currentState.equalsIgnoreCase("l")) {
			object = new LBlock(grid);
			object.currentState = "l";
		}
		if (object.currentState.equalsIgnoreCase("j")) {
			object = new JBlock(grid);
			object.currentState = "j";
		}
		if (object.currentState.equalsIgnoreCase("z")) {
			object = new ZBlock(grid);
			object.currentState = "z";
		}
		if (object.currentState.equalsIgnoreCase("s")) {
			object = new SBlock(grid);
			object.currentState = "s";
		}
		if (object.currentState.equalsIgnoreCase("square")) {
			object = new SquareBlock(grid);
			object.currentState = "square";
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == t) {
		if (GameState.equalsIgnoreCase("Lose")) {
		}
		if (GameState.equalsIgnoreCase("Game")) {

			object.update("check");

			if (object.isActive == true) {
				object.update("down");
				object.update("check");

			} else {

				for (int i1 = 0; i1 < 9; i1++) {
					if (grid.grid[i1][0]) {
						for (int i = 0; i < 4; i++) {
							if (object.xPos[i] == i1 && object.isActive == false) {
								GameState = "Lose";
								break;
							} else {

							}
						}
					}
				}
				/*
				 * for (int i = 0; i < 4; i++) { if (object.yPos[i] <= 1 &&
				 * grid.grid[object.xPos[i]][object.yPos[i]]) { GameState = "Lose"; } }
				 */
				for (int i = 0; i < 4; i++) {
					grid.grid[object.xPos[i]][object.yPos[i]] = true;
				}
				if (Next.equalsIgnoreCase(null)) {
				}
				if (Next.equalsIgnoreCase("blank")) {
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
		else if(e.getSource() == z) {
			Audio.play(84);
			System.out.println("loop Audio");
		}
	}

	// TODO Auto-generated method stub
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (GameState.equalsIgnoreCase("Game")) {
			object.update("check");
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				t.stop();
				z.stop();
				Audio.stop();
				GameState = "paused";
			}
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
					if (object.canRotate == true && blocker == false) {
						object.update("r");
						blocker = true;
					}
					break;
				}

			} else if (e.getKeyCode() == KeyEvent.VK_C) {
				if (canHold == true) {
					for (int i = 0; i < 4; i++)
						object.grid.grid[object.xPos[i]][object.yPos[i]] = false;
					if (Next.equalsIgnoreCase("blank")) {
						Next = NewBlock();
					}
					if (Hold.equalsIgnoreCase("blank")) {
						Hold = object.currentState;
						Hold2 = object.currentState;
						Next = NewBlock();
						SetBlock();
					} else {
						Hold2 = Hold;
						Hold = object.currentState;
						object.currentState = Hold2;
						Hold2 = Hold;
						SetBlock();
					}
					canHold = false;
					for (int i = 0; i < 4; i++)
						object.grid.grid[object.xPos[i]][object.yPos[i]] = true;
				}
			}
			repaint();
		}
		else if(GameState.equalsIgnoreCase("paused")) {
			System.out.println("testtest");
				z.restart();
				t.start();
				Audio.play(84);
				GameState = "Game";
		}
		else {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				GameState = "Game";
				grid.reset();
				z.start();
				Audio.play(84);
			}
			if(GameState.equalsIgnoreCase("Title") && e.getKeyCode() == KeyEvent.VK_ENTER) {
				GameState.equalsIgnoreCase("Controls");
				System.out.println("controls");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		blocker = false;
	}
}
