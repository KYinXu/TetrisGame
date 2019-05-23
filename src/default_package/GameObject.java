package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameObject {
	boolean canMoveRight = true;
	boolean canMoveLeft = true;
	int[] xPos = new int[4];
	int[] yPos = new int[4];
	Grid grid;
	boolean isActive;

	public GameObject(Grid grid) {
		this.grid = grid;
		isActive = true;
	}

	//
	//
	public void moveLeft() {
		update("left");
		if (canMoveLeft == true) {
			for (int i = 0; i < 4; i++) {
				if (xPos[i] <= 0) {
					return;
				}
			}
			for (int i = 0; i < 4; i++) {
				grid.grid[xPos[i]][yPos[i]] = false;
				xPos[i]--;
				grid.grid[xPos[i]][yPos[i]] = true;
			}
		}
	}

	//
	//
	public void moveRight() {
		update("right");
		if (canMoveRight == true) {
			for (int i = 0; i < 4; i++) {
				if (xPos[i] == grid.width - 1) {
					return;
				}
			}
			for (int i = 3; i >= 0; i--) {
				grid.grid[xPos[i]][yPos[i]] = false;
				xPos[i]++;
				grid.grid[xPos[i]][yPos[i]] = true;
			}
		}
	}

	//
	//
	public void moveDown() {
		for (int i = 0; i < 4; i++) {
			if (yPos[i] + 1 >= grid.height) {
				isActive = false;
				return;
			}
		}
		for (int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = false;
			yPos[i]++;
		}

		for (int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = true;
		}
	}

	//
	//
	//
	void update(String direction) {

		boolean canMoveDown = true;

		for (int i = 0; i < 4; i++) {
			int x = xPos[i];
			int y = yPos[i];
			int ny = yPos[i] + 1;
			if (direction.equalsIgnoreCase("down")) {
				if (ny >= grid.height) {
					canMoveDown = false;
					break;
				}
				boolean sameBlock = false;
				if (grid.grid[x][ny]) {
					// check if grid square is part of the same block
					for (int j = 0; j < 4; j++) {
						if (i != j) {
							if (x == xPos[j] && ny == yPos[j]) {
								sameBlock = true;
								break;
							}
						}
					}
					if (!sameBlock) {
						canMoveDown = false;
					}
				}

			}

		}
		for (int i = 0; i < 4; i++) {
			if (direction.equalsIgnoreCase("right")) {
				if (xPos[3] <= 8 && xPos[0] >= 2) {
					if (grid.grid[xPos[3] + 1][yPos[i]]) {
						canMoveRight = false;
					}
					// start here, checking left and right movement

				}

			}
			if (direction.equalsIgnoreCase("left")) {
				if (xPos[3] <= 8 && xPos[0] >= 2) {
					if (grid.grid[xPos[0] - 1][yPos[i]]) {
						canMoveLeft = false;
					}
					// start here, checking left and right movement

				}

			}
		}
		if (direction.equalsIgnoreCase("down")) {
			if (canMoveDown) {
				moveDown();
			} else {
				isActive = false;
			}
		}

	}

}
