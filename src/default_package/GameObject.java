package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameObject {
	String currentState = "line";
	boolean canMoveRight = true;
	boolean canMoveLeft = true;
	boolean canRotate = true;
	int[] xPos = new int[4];
	int[] yPos = new int[4];
	int leftwallcheck;
	int rightwallcheck;
	int rotation = 0;
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
		if(canMoveLeft == true) {
		for(int i = 0; i < 4; i++) {
		grid.grid[xPos[i]][yPos[i]] = false;
		}
		for(int i = 0; i < 4; i++) {
			xPos[i]--;	
			grid.grid[xPos[i]][yPos[i]] = true;
		}

	}
		
	}

	//
	//
	public void moveRight() {
		update("check");
		if(canMoveRight == true) {
		for(int i = 0; i < 4; i++) {
		grid.grid[xPos[i]][yPos[i]] = false;
		}
		for(int i = 0; i < 4; i++) {
		xPos[i]++;	
		grid.grid[xPos[i]][yPos[i]] = true;
		}


		}
/*
 * 			if (rotation == 0) {
				if (currentState.equalsIgnoreCase("t")) {
					if (canMoveRight == true && grid.grid[xPos[3] + 1][yPos[3]] == false
							&& grid.grid[xPos[2] + 1][yPos[2]] == false) {
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
				if (currentState.equalsIgnoreCase("line") || currentState.equalsIgnoreCase("square")) {
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
				if (currentState.equalsIgnoreCase("s") || currentState.equalsIgnoreCase("z")) {
					if (canMoveRight == true && grid.grid[xPos[3] + 1][yPos[3]] == false
							&& grid.grid[xPos[2] + 1][yPos[2]] == false) {
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
				if (currentState.equalsIgnoreCase("j") || currentState.equalsIgnoreCase("l")) {
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
			}

			if (rotation == 1) {
				if (currentState.equalsIgnoreCase("l")) {
					if (canMoveRight == true && grid.grid[xPos[1] + 1][yPos[1]] == false
							&& grid.grid[xPos[3] + 1][yPos[3]] == false) {
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
				if (currentState.equalsIgnoreCase("j"))
					if (canMoveRight == true && grid.grid[xPos[1] + 1][yPos[1]] == false
							&& grid.grid[xPos[0] + 1][yPos[0]] == false) {
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
				if (currentState.equalsIgnoreCase("line") || currentState.equalsIgnoreCase("square")) {
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
			}
			if (rotation == 2) {
				if (currentState.equalsIgnoreCase("j") || currentState.equalsIgnoreCase("l")) {
					if (canMoveRight == true && grid.grid[xPos[2] + 1][yPos[2]] == false
							&& grid.grid[xPos[0] + 1][yPos[0]] == false && grid.grid[xPos[1] + 1][yPos[1]] == false) {
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
				if (currentState.equalsIgnoreCase("line") || currentState.equalsIgnoreCase("square")) {
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
			}
			if (rotation == 3) {
				if (currentState.equalsIgnoreCase("j") || currentState.equalsIgnoreCase("l")) {
					if (canMoveRight == true && grid.grid[xPos[3] + 1][yPos[3]] == false
							&& grid.grid[xPos[0] + 1][yPos[0]] == false) {
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
				if (currentState.equalsIgnoreCase("line") || currentState.equalsIgnoreCase("square")) {
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
			}

 */
		
	}
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
	public boolean checkLeft() {
		canMoveLeft = true;
		for(int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = false;
		}
		for(int i = 0; i < 4; i++) {
			if(xPos[i] - 1< 0) {
				canMoveLeft = false;
				break;
			}
			else if(grid.grid[xPos[i] - 1][yPos[i]]) {
				canMoveLeft = false;
				break;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = true;
		}
			if (currentState == "j") {

				if(rotation == 0) {
					if(xPos[3] - 1 < 0) {
						canRotate = false;
					}
					else {
						canRotate = true;
					}
				}
				else if(rotation == 1) {
					if(xPos[1] - 2 < 0 || xPos[2] - 1 < 0) {
						canRotate = false;
					}
					else {
						canRotate = true;
					}
				}
				else if(rotation == 2) {
						canRotate = true;
				}
				else if(rotation == 3) {
					if(xPos[0] - 2 < 0 || xPos[3] - 1 < 0) {
						canRotate = false;
					}
					else {
						canRotate = true;
					}
				}
			}
		if(currentState == "l") {
			if(rotation == 0) {
				if(xPos[3] - 1 < 0) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 1) {
				if(xPos[1] - 1 < 0) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 2) {
				if(xPos[1] - 1 < 0) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 3) {
				if(xPos[0] - 2 < 0 ||xPos[2] - 1 < 0 || xPos[3] - 1 < 0) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
		}
		if(currentState == "line") {
			if(rotation == 0) {
				if(xPos[3] - 1 < 0) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 1) {
				if(xPos[0] -2 < 0 || xPos[1] - 1 < 0) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 2) {
				if(xPos[2] - 1 < 0 || xPos[3] - 2 < 0) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 3) {
				if(xPos[0] - 1 < 0) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
		}
		return canRotate;
	}

	public boolean checkRight() {
		canMoveRight = true;
		for(int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = false;
		}
		for(int i = 0; i < 4; i++) {
			if(xPos[i] + 1 > 9) {
				canMoveRight = false;
				break;
			}
			else if(grid.grid[xPos[i] + 1][yPos[i]]) {
				canMoveRight = false;
				break;
			}
		}
		for(int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = true;
		}
		if (currentState == "j") {
			if(rotation == 0) {
				if(xPos[1] + 1 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 1) {
				if(xPos[0] + 1 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 2) {
				if(xPos[0] + 1 > 9 || xPos[2] + 1 > 9 || xPos[3] + 2 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 3) {
				if(xPos[1] + 1 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
		}
		if(currentState.equalsIgnoreCase("l")) {
			if(rotation == 0) {
				if(xPos[1] + 2 > 9 || xPos[2] + 1 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 1) {
				if(xPos[0] + 1 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 2) {
				if(xPos[0] + 1 > 9 || xPos[3] + 2 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 3) {
				canRotate = true;
			}
		}
		if(currentState == "line") {
			if(rotation == 0) {
				if(xPos[0]+2 > 9 || xPos[1] + 1 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 1) {
				if(xPos[3] + 1 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 2) {
				if(xPos[0] + 1 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
			else if(rotation == 3) {
				if(xPos[2] + 1 > 9 || xPos[3] + 2 > 9) {
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
		}
		return canRotate;
	}

	void update(String direction) {
		for (int i = 0; i < grid.height; i++) {
			if (grid.grid[0][i]) {

			}

		}
		if (direction.equalsIgnoreCase("check")) {
			checkLeft();
			checkRight();
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
				/*
				for (int i = 0; i < 4; i++) {
					for(int i2 = 0;i2<4;i2++) {
						grid.grid[xPos[i2]][yPos[i2]] = false;
					}
					if (xPos[3] <= 8 && xPos[0] >= 1) {
						if (canMoveLeft == true && grid.grid[xPos[i] - 1][yPos[i]]) {
							canMoveLeft = false;
						}
					}
					if (xPos[3] <= 8 && xPos[0] >= 1) {
						if (canMoveRight == true && grid.grid[xPos[i] + 1][yPos[i]]) {
							canMoveRight = false;
						}
					}
					for(int i2 = 0;i2<4;i2++) {
						grid.grid[xPos[i2]][yPos[i2]] = true;
					}
				}
				*/

			} else {
				isActive = false;
			}
		}
		if (direction.equalsIgnoreCase("space")) {
			if (canMoveDown == true) {
				for (int i = 0; i < grid.height; i++) {
					if (currentState.equalsIgnoreCase("t") && yPos[0] + 1 < grid.height && yPos[1] + 1 < grid.height
							&& yPos[2] + 1 < grid.height && yPos[3] + 1 < grid.height) {

						if (grid.grid[xPos[0]][yPos[0] + 1] == false || grid.grid[xPos[1]][yPos[1] + 1] == false
								|| grid.grid[xPos[3]][yPos[3] + 1] == false) {
							update("down");
						} else {
							canMoveDown = false;
							break;
						}
					}
					if (currentState.equalsIgnoreCase("line") && yPos[0] + 1 < grid.height && yPos[1] + 1 < grid.height
							&& yPos[2] + 1 < grid.height && yPos[3] + 1 < grid.height) {
						if (grid.grid[xPos[0]][yPos[0] + 1] == false || grid.grid[xPos[1]][yPos[1] + 1] == false
								|| grid.grid[xPos[2]][yPos[2] + 1] == false
								|| grid.grid[xPos[3]][yPos[3] + 1] == false) {
							update("down");
						} else {
							canMoveDown = false;
							break;
						}
					}
					if (currentState.equalsIgnoreCase("square") && yPos[0] + 1 < grid.height
							&& yPos[1] + 1 < grid.height && yPos[2] + 1 < grid.height && yPos[3] + 1 < grid.height) {
						if (grid.grid[xPos[2]][yPos[2] + 1] == false || grid.grid[xPos[3]][yPos[3] + 1] == false) {
							update("down");
						} else {
							canMoveDown = false;
							break;
						}
					}
					if (currentState.equalsIgnoreCase("s") && yPos[0] + 1 < grid.height && yPos[1] + 1 < grid.height
							&& yPos[2] + 1 < grid.height && yPos[3] + 1 < grid.height) {
						if (grid.grid[xPos[0]][yPos[0] + 1] == false || grid.grid[xPos[2]][yPos[2] + 1] == false) {
							update("down");
						} else {
							canMoveDown = false;
							break;
						}
					}
					if (currentState.equalsIgnoreCase("z") && yPos[0] + 1 < grid.height && yPos[1] + 1 < grid.height
							&& yPos[2] + 1 < grid.height && yPos[3] + 1 < grid.height) {
						if (grid.grid[xPos[1]][yPos[1] + 1] == false || grid.grid[xPos[3]][yPos[3] + 1] == false) {
							update("down");
						} else {
							canMoveDown = false;
							break;
						}
					}
					if (currentState.equalsIgnoreCase("j") || currentState.equalsIgnoreCase("l")) {
						if (yPos[0] + 1 < grid.height && yPos[1] + 1 < grid.height && yPos[2] + 1 < grid.height
								&& yPos[3] + 1 < grid.height) {
							if (grid.grid[xPos[0]][yPos[0] + 1] == false || grid.grid[xPos[3]][yPos[3] + 1] == false) {
								update("down");
							} else {
								canMoveDown = false;
								break;
							}
						}
					}
				}
			}
		}
		if (direction.equalsIgnoreCase("r")) {
			update("check");
			if (currentState.equalsIgnoreCase("l")) {
				if (rotation == 0) {

					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if (rotation == 1) {
								break;
							}
							if (grid.grid[xPos[1] + i][yPos[1] + j]) {
								break;
							} else if (checkLeft() == true && checkRight() == true) {
								for (int i2 = 0; i2 < 4; i2++)
									grid.grid[xPos[i2]][yPos[i2]] = false;
								yPos[0]--;
								xPos[1] += 2;
								yPos[1]++;
								xPos[2]++;
								xPos[3]--;
								for (int j1 = 0; j1 < 4; j1++) {
									System.out.println(xPos[j1]);
									System.out.println(yPos[j1]);
								}
								rotation++;
								for (int z = 0; z < 4; z++) {
									if (grid.grid[xPos[z]][yPos[z]]) {
										yPos[0]++;
										xPos[1] -= 2;
										yPos[1]--;
										xPos[2]--;
										xPos[3]++;
										rotation--;
									}

									
								}
								for (int i3 = 0; i3 < 4; i3++)
									grid.grid[xPos[i3]][yPos[i3]] = true;
								break;
							} else {
								break;
							}
						}
					}

//end
				} else if (rotation == 1) {

					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {

							if (rotation == 2) {
								break;
							}
							if (xPos[0] + i > 8) {
								break;
							}
							if (grid.grid[xPos[0] + i][yPos[0] - 1 + j]) {
								break;
							} else if (checkLeft() == true && checkRight() == true) {
								for (int i2 = 0; i2 < 4; i2++)
									grid.grid[xPos[i2]][yPos[i2]] = false;
								xPos[0]++;
								yPos[0]--;
								xPos[1]--;
								yPos[1]++;
								yPos[3] -= 2;
								rotation++;
								for (int z = 0; z < 4; z++) {
									if (grid.grid[xPos[z]][yPos[z]]) {
										xPos[0]--;
										yPos[0]++;
										xPos[1]++;
										yPos[1]--;
										yPos[3] += 2;
										rotation--;
									} 
								}
								for (int i3 = 0; i3 < 4; i3++)
								grid.grid[xPos[i3]][yPos[i3]] = true;
								break;
							}
						}
					}

				} else if (rotation == 2) {

					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {

							if (rotation == 3) {
								break;
							}
							if (xPos[3] + i > 9) {
								break;
							}
							if (grid.grid[xPos[3] + i][yPos[3] + j]) {
								break;
							} else if (checkLeft() == true && checkRight() == true) {
								for (int i2 = 0; i2 < 4; i2++)
									grid.grid[xPos[i2]][yPos[i2]] = false;
								xPos[0]++;
								yPos[0] += 2;
								xPos[1]--;
								yPos[2]++;
								xPos[3] += 2;
								yPos[3]++;
								rotation++;
								for (int z = 0; z < 4; z++) {
									if (grid.grid[xPos[z]][yPos[z]]) {
										xPos[0]--;
										yPos[0] -= 2;
										xPos[1]++;
										yPos[2]--;
										xPos[3] -= 2;
										yPos[3]--;
										rotation--;
									} 
								}
								for (int i3 = 0; i3 < 4; i3++)
								grid.grid[xPos[i3]][yPos[i3]] = true;
							} else {
								break;
							}
						}
					}
				} else if (rotation == 3) {

					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {

							if (rotation == 0) {
								break;
							}
							if (xPos[1] + i > 9) {
								break;
							}
							if (grid.grid[xPos[1] + i][yPos[1] - 2 + j]) {
								break;
							} else if (checkLeft() == true && checkRight() == true) {
								for (int i2 = 0; i2 < 4; i2++)
									grid.grid[xPos[i2]][yPos[i2]] = false;
								xPos[0] -= 2;
								yPos[1] -= 2;
								xPos[2]--;
								yPos[2]--;
								xPos[3]--;
								yPos[3]++;
								rotation = 0;
								for (int z = 0; z < 4; z++) {
									if (grid.grid[xPos[z]][yPos[z]]) {
										xPos[0] += 2;
										yPos[1] += 2;
										xPos[2]++;
										yPos[2]++;
										xPos[3]++;
										yPos[3]--;
										rotation = 3;
									} 
								}
								for (int i3 = 0; i3 < 4; i3++)
								grid.grid[xPos[i3]][yPos[i3]] = true;
								break;
							} else {
								break;
							}
						}
					}

				}
			}
			/*
			 * 1 2 0 3
			 * 
			 * 0 2 1 3
			 * 
			 * 3 0 2 1
			 * 
			 * 3 1 2 0
			 * 
			 * 
			 * 1 2 0 3
			 * 
			 * 0 3 2 1
			 * 
			 * 3 0 2 1
			 * 
			 * 1 2 3 0
			 */
			if (currentState.equalsIgnoreCase("j") && canRotate == true) {
				if (rotation == 0) {


					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {

							if (rotation == 1) {
								break;
							}
							if (xPos[1] + i > 8) {
								break;
							}
							if (grid.grid[xPos[0] + i][yPos[1] + j]) {
								break;
							} else if (checkLeft() == true && checkRight() == true) {
								for (int i2 = 0; i2 < 4; i2++)
									grid.grid[xPos[i2]][yPos[i2]] = false;
								yPos[0]--;
								xPos[1]++;
								yPos[1] += 2;
								yPos[2]++;
								xPos[3]--;
								rotation++;
								for (int z = 0; z < 4; z++) {
									if (grid.grid[xPos[z]][yPos[z]]) {
										yPos[0]++;
										xPos[1]--;
										yPos[1] -= 2;
										yPos[2]--;
										xPos[3]++;
									} 
								}
								for (int i3 = 0; i3 < 4; i3++)
								grid.grid[xPos[i3]][yPos[i3]] = true;
							}
						}
					}


				}

				else if (rotation == 1) {


					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {

							if (rotation == 2) {
								break;
							}
							if (xPos[1] + i > 9) {
								break;
							}
							if (grid.grid[xPos[1] + i][yPos[1] - 2 + j]) {
								break;
							}
							if (checkLeft() == true && checkRight() == true) {
								for (int i2 = 0; i2 < 4; i2++)
									grid.grid[xPos[i2]][yPos[i2]] = false;
								xPos[0]++;
								yPos[0]--;
								xPos[1] -= 2;
								xPos[2]--;
								yPos[2]--;
								yPos[3] -= 2;
								rotation++;
								for (int z = 0; z < 4; z++) {
									if (grid.grid[xPos[z]][yPos[z]]) {
										if (xPos[0] <= 0) {
											break;
										}
										System.out.println(xPos[0]);
										xPos[0]--;
										yPos[0]++;
										xPos[1] += 2;
										xPos[2]++;
										yPos[2]++;
										yPos[3] += 2;
										rotation--;
									} 
								}
								for (int i3 = 0; i3 < 4; i3++)
								grid.grid[xPos[i3]][yPos[i3]] = true;
							}
						}
					}


				}

				else if (rotation == 2) {


					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0]++;
						yPos[0] += 2;
						yPos[1]--;
						xPos[2]++;
						xPos[3] += 2;
						yPos[3]++;
						rotation++;
						for (int z = 0; z < 4; z++) {
							if (grid.grid[xPos[z]][yPos[z]]) {
								xPos[0]--;
								yPos[0] -= 2;
								yPos[1]++;
								xPos[2]--;
								xPos[3] -= 2;
								yPos[3]--;
								rotation--;
							} 
						}
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				} else if (rotation == 3) {


					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0] -= 2;
						xPos[1]++;
						yPos[1]--;
						xPos[3]--;
						yPos[3]++;
						rotation = 0;
						for (int z = 0; z < 4; z++) {
							if (grid.grid[xPos[z]][yPos[z]]) {
								xPos[0] += 2;
								xPos[1]--;
								yPos[1]++;
								xPos[3]++;
								yPos[3]--;
								rotation = 3;
							} 
						}
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				}
			}
			if(currentState.equalsIgnoreCase("line") && canRotate == true && yPos[0] >= 2) {
				if(rotation == 0) {


					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0]+=2;
						yPos[0]-=2;
						xPos[1]++;
						yPos[1]--;
						xPos[3]--;
						yPos[3]++;
						rotation++;
						for (int z = 0; z < 4; z++) {
							if (grid.grid[xPos[z]][yPos[z]]) {
								xPos[0]-=2;
								yPos[0]+=2;
								xPos[1]--;
								yPos[1]++;
								xPos[3]++;
								yPos[3]--;
								rotation--;
							} 
						}
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				}
				else if(rotation == 1) {

					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0]-=2;
						yPos[0]+=2;
						xPos[1]--;
						yPos[1]++;
						xPos[3]++;
						yPos[3]--;
						rotation++;
						for (int z = 0; z < 4; z++) {
							if (grid.grid[xPos[z]][yPos[z]]) {
								xPos[0]-=2;
								yPos[0]+=2;
								xPos[1]--;
								yPos[1]++;
								xPos[3]++;
								yPos[3]--;
								rotation--;
							}
						}
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				}
				else if(rotation == 2) {

					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0]+=1;
						yPos[0]-=2;
						xPos[2]--;
						yPos[1]--;
						xPos[3]-=2;
						yPos[3]++;
						rotation++;
						for (int z = 0; z < 4; z++) {
							if (grid.grid[xPos[z]][yPos[z]]) {
								xPos[0]-=1;
								yPos[0]+=2;
								xPos[2]++;
								yPos[1]++;
								xPos[3]+=2;
								yPos[3]--;
								rotation--;
							} 
						}
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				}
				else if(rotation == 3) {

					if (checkLeft() == true && checkRight() == true && xPos[3] + 2 <= 9) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0]-=1;
						yPos[0]+=2;
						xPos[2]++;
						yPos[1]++;
						xPos[3]+=2;
						yPos[3]--;
						rotation=0;
						for (int z = 0; z < 4; z++) {
							if (grid.grid[xPos[z]][yPos[z]]) {
								xPos[0]+=1;
								yPos[0]-=2;
								xPos[2]--;
								yPos[1]--;
								xPos[3]-=2;
								yPos[3]++;
								rotation=3;
							}
						}
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				}
			}
			if(currentState.equalsIgnoreCase("t") && canRotate == true && yPos[0] >= 1) {
				/*
				   2
				 0 1 3
				 
				 0
				 1 2
				 3
				 
				 0 1 3
				   2
				   
				     3
				   2 1
				     0
				 */
				if(rotation == 0) {
					if(checkLeft() == true && checkRight() == true) {
						for(int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
					}
				}
				else if(rotation == 1) {
					if(checkLeft() == true && checkRight() == true) {
						for(int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
					}
				}
				else if(rotation == 2) {
					if(checkLeft() == true && checkRight() == true) {
						for(int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
					}
				}
				else if(rotation == 3) {
					if(checkLeft() == true && checkRight() == true) {
						for(int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
					}
				}
			}
		}
	}

}