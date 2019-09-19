package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameObject {
	String currentState = "line";
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
		update("check");
		update("left");
		if(xPos[0] >= 1) {
		if(currentState.equalsIgnoreCase("line") || currentState.equalsIgnoreCase("square")) {

		if (canMoveLeft == true && grid.grid[xPos[0] - 1][yPos[0]] == false && grid.grid[xPos[0] - 1][yPos[1]] == false
				&& grid.grid[xPos[0] - 1][yPos[2]] == false && grid.grid[xPos[0] - 1][yPos[3]] == false) {
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
		if(currentState.equalsIgnoreCase("s") || currentState.equalsIgnoreCase("z")) {
			if(canMoveLeft == true && grid.grid[xPos[0] - 1][yPos[0]] == false && grid.grid[xPos[1] - 1][yPos[1]] == false) {
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
		if(currentState.equalsIgnoreCase("j") || currentState.equalsIgnoreCase("l")) {
			if(canMoveLeft == true && grid.grid[xPos[0] - 1][yPos[0]] == false && grid.grid[xPos[2] - 1][yPos[2]] == false && grid.grid[xPos[1] - 1][yPos[1]] == false) {
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
		}
	}

	//
	//
	public void moveRight() {
		update("check");
		update("right");
		if(xPos[3] <= 8) {
		if(currentState.equalsIgnoreCase("line") || currentState.equalsIgnoreCase("square")) {
		if (canMoveRight == true && grid.grid[xPos[3] + 1][yPos[0]] == false && grid.grid[xPos[3] + 1][yPos[1]] == false
				&& grid.grid[xPos[3] + 1][yPos[2]] == false && grid.grid[xPos[3] + 1][yPos[3]] == false) {
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
		if(currentState.equalsIgnoreCase("s") || currentState.equalsIgnoreCase("z")) {
			if(canMoveRight == true && grid.grid[xPos[3] + 1][yPos[3]] == false && grid.grid[xPos[2] + 1][yPos[2]] == false) {
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
		if(currentState.equalsIgnoreCase("j") || currentState.equalsIgnoreCase("l")) {
			if(canMoveRight == true && grid.grid[xPos[3] + 1][yPos[3]] == false && grid.grid[xPos[2] + 1][yPos[2]] == false && grid.grid[xPos[1] + 1][yPos[1]] == false) {
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
		if (direction.equalsIgnoreCase("check")) {
			for (int i = 0; i < 4; i++) {
				if (xPos[3] <= 8 && xPos[0] >= 1) {
					if (currentState.equalsIgnoreCase("line") || currentState.equalsIgnoreCase("square")) {
						if (canMoveLeft == true && grid.grid[xPos[0] - 1][yPos[i]]) {
							canMoveLeft = false;
						} else {
							canMoveLeft = true;
						}
					
					if (xPos[3] <= 8 && xPos[0] >= 2) {
						if (canMoveRight == true && grid.grid[xPos[3] + 1][yPos[i]]) {
							canMoveRight = false;
						} else {
							canMoveRight = true;
						}
					}
						
				}
					if(currentState.equalsIgnoreCase("s") || currentState.equalsIgnoreCase("z")) {
						if (canMoveLeft == true && grid.grid[xPos[0] - 1][yPos[0]] && grid.grid[xPos[1] - 1][yPos[1]]) {
							canMoveLeft = false;
						} else {
							canMoveLeft = true;
						}
					
					if (xPos[3] <= 8 && xPos[0] >= 2) {
						if (canMoveRight == true && grid.grid[xPos[3] + 1][yPos[3]] && grid.grid[xPos[2] + 1][yPos[2]]) {
							canMoveRight = false;
						} else {
							canMoveRight = true;
						}
					}
					}
					if(currentState.equalsIgnoreCase("j") || currentState.equalsIgnoreCase("l")) {
						if (canMoveLeft == true && grid.grid[xPos[0] - 1][yPos[0]] && grid.grid[xPos[1] - 1][yPos[1]] && grid.grid[xPos[2] - 1][yPos[2]]) {
							canMoveLeft = false;
						} else {
							canMoveLeft = true;
						}
					
					if (xPos[3] <= 8 && xPos[0] >= 2) {
						if (canMoveRight == true && grid.grid[xPos[3] + 1][yPos[3]] && grid.grid[xPos[2] + 1][yPos[2]] && grid.grid[xPos[1] + 1][yPos[1]]) {
							canMoveRight = false;
						} else {
							canMoveRight = true;
						}
					}
					}
			}

		}
		}
		for (int i = 0; i < 4; i++) {
			if (direction.equalsIgnoreCase("right")) {
				if (xPos[3] <= 8 && xPos[0] >= 2) {
					if(currentState.equalsIgnoreCase("line") || currentState.equalsIgnoreCase("square")) {
					if (grid.grid[xPos[3] + 1][yPos[i]]) {
						canMoveRight = false;
						break;
					}
					}
					if(currentState.equalsIgnoreCase("s") || currentState.equalsIgnoreCase("z")) {
						if(grid.grid[xPos[3] + 1][yPos[3]] && grid.grid[xPos[2] + 1][yPos[2]]) {
							canMoveRight = false;
						}
					}
					// start here, checking left and right movement
					if(currentState.equalsIgnoreCase("j") || currentState.equalsIgnoreCase("l")) {
						if(grid.grid[xPos[3] + 1][yPos[3]] && grid.grid[xPos[2] + 1][yPos[2]] && grid.grid[xPos[1] + 1][yPos[1]]) {
						canMoveRight = false;
						}
					}
				}

			}
			if (direction.equalsIgnoreCase("left")) {
				if (xPos[3] <= 8 && xPos[0] >= 2) {
					if(currentState.equalsIgnoreCase("line") || currentState.equalsIgnoreCase("square")) {
					if (grid.grid[xPos[0] - 1][yPos[i]]) {
						canMoveLeft = false;
						break;
					}
					}
					if(currentState.equalsIgnoreCase("s") || currentState.equalsIgnoreCase("z")) {
						if(grid.grid[xPos[0] - 1][yPos[0]] && grid.grid[xPos[1] - 1][yPos[0]]) {
							canMoveLeft = false;
						}
					}
					if(currentState.equalsIgnoreCase("j") || currentState.equalsIgnoreCase("l")) {
						if(grid.grid[xPos[0] - 1][yPos[0]] && grid.grid[xPos[2] - 1][yPos[2]] && grid.grid[xPos[1] - 1][yPos[1]]) {
						canMoveLeft = false;
						}
					}
					// start here, checking left and right movement

				}

			}
		}
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

		if (direction.equalsIgnoreCase("down")) {
			if (canMoveDown) {
				moveDown();
				for (int i = 0; i < 4; i++) {
					if (xPos[3] <= 8 && xPos[0] >= 2) {
						if (canMoveLeft == true && grid.grid[xPos[0] - 1][yPos[i]]) {
							canMoveLeft = false;
						}
					}
					if (xPos[3] <= 8 && xPos[0] >= 2) {
						if (canMoveRight == true && grid.grid[xPos[3] + 1][yPos[i]]) {
							canMoveRight = false;
						}
					}
				}

			} else {
				isActive = false;
			}
		}

	}
	

}
