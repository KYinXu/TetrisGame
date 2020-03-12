package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameObject {
	String currentState;
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
	boolean canMoveDown = true;

	public GameObject(Grid grid) {
		this.grid = grid;
		isActive = true;
	}

	//
	//
	public void moveLeft() {
		update("check");
		if (canMoveLeft == true) {
			for (int i = 0; i < 4; i++) {
				grid.grid[xPos[i]][yPos[i]] = false;
			}
			for (int i = 0; i < 4; i++) {
				xPos[i]--;
				grid.grid[xPos[i]][yPos[i]] = true;
			}

		}

	}

	//
	//
	public void moveRight() {
		update("check");
		if (canMoveRight == true) {
			for (int i = 0; i < 4; i++) {
				grid.grid[xPos[i]][yPos[i]] = false;
			}
			for (int i = 0; i < 4; i++) {
				xPos[i]++;
				grid.grid[xPos[i]][yPos[i]] = true;
			}

		}

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
	public boolean checkDown() {
		for (int i = 0; i < 4; i++)
			grid.grid[xPos[i]][yPos[i]] = false;
		for (int i = 0; i < 4; i++) {
			if (yPos[i] + 1 >= grid.height) {
				canMoveDown = false;
				break;
			} else {
				if (grid.grid[xPos[i]][yPos[i] + 1]) {
					canMoveDown = false;
					break;
				}
			}
			if (i == 3) {
				canMoveDown = true;
				isActive = true;
			}
		}
		for (int i = 0; i < 4; i++)
			grid.grid[xPos[i]][yPos[i]] = true;
		return canMoveDown;
	}

	public boolean checkLeft() {
		canMoveLeft = true;
		for (int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = false;
		}
		for (int i = 0; i < 4; i++) {
			if (xPos[i] - 1 < 0) {
				canMoveLeft = false;
				break;
			} else if (grid.grid[xPos[i] - 1][yPos[i]]) {
				canMoveLeft = false;
				break;
			}
		}

		for (int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = true;
		}
		if(currentState == "t") {
			if(rotation == 3) {
				if(xPos[2] - 1 < 0){
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
		}
		if (currentState == "z") {

			if (rotation == 0) {
				if (xPos[1] - 1 < 0 || xPos[3] - 2 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 1) {
				if (xPos[0] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}

			}
		}
		if (currentState == "s") {
			if (rotation == 0) {
				if (xPos[2] - 1 < 0 || xPos[3] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 1) {

			}
		}
		if (currentState == "j") {

			if (rotation == 0) {
				if (xPos[3] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 1) {
				if (xPos[1] - 2 < 0 || xPos[2] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 2) {
				canRotate = true;
			} else if (rotation == 3) {
				if (xPos[0] - 2 < 0 || xPos[3] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			}
		}
		if (currentState == "l") {
			if (rotation == 0) {
				if (xPos[3] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 1) {
				if (xPos[1] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 2) {
				if (xPos[1] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 3) {
				if (xPos[0] - 2 < 0 || xPos[2] - 1 < 0 || xPos[3] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			}
		}
		if (currentState == "line") {
			if (rotation == 0) {
				if (xPos[3] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 1) {
				if (xPos[0] - 2 < 0 || xPos[1] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 2) {
				if (xPos[2] - 1 < 0 || xPos[3] - 2 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 3) {
				if (xPos[0] - 1 < 0) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			}
		}
		return canRotate;
	}

	public boolean checkRight() {
		canMoveRight = true;
		for (int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = false;
		}
		for (int i = 0; i < 4; i++) {
			if (xPos[i] + 1 > 9) {
				canMoveRight = false;
				break;
			} else if (grid.grid[xPos[i] + 1][yPos[i]]) {
				canMoveRight = false;
				break;
			}
		}
		for (int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = true;
		}
		if(currentState == "t") {
			if(rotation == 1) {
				if(xPos[2] + 1 > 9){
					canRotate = false;
				}
				else {
					canRotate = true;
				}
			}
		}
		if (currentState == "z") {
			if (rotation == 0) {
				if (xPos[0] + 1 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 1) {
				if (xPos[1] + 1 > 9 || xPos[3] + 2 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			}
		}
		if (currentState == "s") {
			if (rotation == 0) {
			} else if (rotation == 1) {
				if (xPos[2] + 1 > 9 || xPos[3] + 1 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			}
		}
		if (currentState == "j") {
			if (rotation == 0) {
				if (xPos[1] + 1 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 1) {
				if (xPos[0] + 1 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 2) {
				if (xPos[0] + 1 > 9 || xPos[2] + 1 > 9 || xPos[3] + 2 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 3) {
				if (xPos[1] + 1 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			}
		}
		if (currentState.equalsIgnoreCase("l")) {
			if (rotation == 0) {
				if (xPos[1] + 2 > 9 || xPos[2] + 1 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 1) {
				if (xPos[0] + 1 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 2) {
				if (xPos[0] + 1 > 9 || xPos[3] + 2 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 3) {
			}
		}
		if (currentState == "line") {
			if (rotation == 0) {
				if (xPos[0] + 2 > 9 || xPos[1] + 1 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 1) {
				if (xPos[3] + 1 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 2) {
				if (xPos[0] + 1 > 9) {
					canRotate = false;
				} else {
					canRotate = true;
				}
			} else if (rotation == 3) {
				if (xPos[2] + 1 > 9 || xPos[3] + 2 > 9) {
					canRotate = false;
				} else {
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
			checkDown();
		}

		if (direction.equalsIgnoreCase("down")) {
			update("check");
			if (canMoveDown) {
				moveDown();
			} else {
				update("check");
				isActive = false;
			}
		}
		if (direction.equalsIgnoreCase("space")) {
			if (canMoveDown == true) {
				for (int i1 = 0; i1 < grid.height; i1++) {
					for (int i = 0; i < 4; i++)
						grid.grid[xPos[i]][yPos[i]] = false;
					for (int i = 0; i < 4; i++) {
						if (yPos[i] + 1 < grid.height) {
							if (grid.grid[xPos[i]][yPos[i] + 1] == false) {
								if (i == 3) {
									update("down");
								}
							} else {
								canMoveDown = false;
								update("check");
								break;
							}
						}
					}
					for (int i = 0; i < 4; i++)
						grid.grid[xPos[i]][yPos[i]] = true;
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
								rotation++;
								for (int z = 0; z < 4; z++) {
									if (grid.grid[xPos[z]][yPos[z]]) {
										yPos[0]++;
										xPos[1] -= 2;
										yPos[1]--;
										xPos[2]--;
										xPos[3]++;
										rotation--;
										canRotate = false;
										break;
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
									if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
										if (grid.grid[xPos[z]][yPos[z]]) {
											xPos[0]--;
											yPos[0]++;
											xPos[1]++;
											yPos[1]--;
											yPos[3] += 2;
											rotation--;
											canRotate = false;
											break;
										}
									} else {
										xPos[0]--;
										yPos[0]++;
										xPos[1]++;
										yPos[1]--;
										yPos[3] += 2;
										rotation--;
										canRotate = false;
										break;
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
									if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
										if (grid.grid[xPos[z]][yPos[z]]) {
											xPos[0]--;
											yPos[0] -= 2;
											xPos[1]++;
											yPos[2]--;
											xPos[3] -= 2;
											yPos[3]--;
											rotation--;
											canRotate = false;
											break;
										}
									} else {
										xPos[0]--;
										yPos[0] -= 2;
										xPos[1]++;
										yPos[2]--;
										xPos[3] -= 2;
										yPos[3]--;
										rotation--;
										canRotate = false;
										break;
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
									if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
										if (grid.grid[xPos[z]][yPos[z]]) {
											xPos[0] += 2;
											yPos[1] += 2;
											xPos[2]++;
											yPos[2]++;
											xPos[3]++;
											yPos[3]--;
											rotation = 3;
											canRotate = false;
											break;
										}
									} else {
										xPos[0] += 2;
										yPos[1] += 2;
										xPos[2]++;
										yPos[2]++;
										xPos[3]++;
										yPos[3]--;
										rotation = 3;
										canRotate = false;
										break;
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
									if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
										if (grid.grid[xPos[z]][yPos[z]]) {
											yPos[0]++;
											xPos[1]--;
											yPos[1] -= 2;
											yPos[2]--;
											xPos[3]++;
											rotation--;
											canRotate = false;
											break;
										}
									} else {
										yPos[0]++;
										xPos[1]--;
										yPos[1] -= 2;
										yPos[2]--;
										xPos[3]++;
										rotation--;
										canRotate = false;
										break;
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
									if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
										if (grid.grid[xPos[z]][yPos[z]]) {
											System.out.println(xPos[0]);
											xPos[0]--;
											yPos[0]++;
											xPos[1] += 2;
											xPos[2]++;
											yPos[2]++;
											yPos[3] += 2;
											rotation--;
											canRotate = false;
											break;
										}
									} else {
										xPos[0]--;
										yPos[0]++;
										xPos[1] += 2;
										xPos[2]++;
										yPos[2]++;
										yPos[3] += 2;
										rotation--;
										canRotate = false;
										break;
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
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									xPos[0]--;
									yPos[0] -= 2;
									yPos[1]++;
									xPos[2]--;
									xPos[3] -= 2;
									yPos[3]--;
									rotation--;
									canRotate = false;
									break;
								}
							} else {
								xPos[0]--;
								yPos[0] -= 2;
								yPos[1]++;
								xPos[2]--;
								xPos[3] -= 2;
								yPos[3]--;
								rotation--;
								canRotate = false;
								break;
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
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									xPos[0] += 2;
									xPos[1]--;
									yPos[1]++;
									xPos[3]++;
									yPos[3]--;
									rotation = 3;
									canRotate = false;
									break;
								}
							} else {
								xPos[0] += 2;
								xPos[1]--;
								yPos[1]++;
								xPos[3]++;
								yPos[3]--;
								rotation = 3;
								canRotate = false;
								break;
							}

						}

						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				}
			}
			if (currentState.equalsIgnoreCase("line") && canRotate == true && yPos[0] >= 2) {
				if (rotation == 0) {

					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0] += 2;
						yPos[0] -= 2;
						xPos[1]++;
						yPos[1]--;
						xPos[3]--;
						yPos[3]++;
						rotation++;

						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									xPos[0] -= 2;
									yPos[0] += 2;
									xPos[1]--;
									yPos[1]++;
									xPos[3]++;
									yPos[3]--;
									rotation--;
									canRotate = false;
									break;
								}
							} else {
								xPos[0] -= 2;
								yPos[0] += 2;
								xPos[1]--;
								yPos[1]++;
								xPos[3]++;
								yPos[3]--;
								rotation--;
								canRotate = false;
							}

						}

						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				} else if (rotation == 1) {

					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0] -= 2;
						yPos[0] += 2;
						xPos[1]--;
						yPos[1]++;
						xPos[3]++;
						yPos[3]--;
						rotation++;

						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									xPos[0] -= 2;
									yPos[0] += 2;
									xPos[1]--;
									yPos[1]++;
									xPos[3]++;
									yPos[3]--;
									rotation--;
									canRotate = false;
									break;
								}
							} else {
								xPos[0] -= 2;
								yPos[0] += 2;
								xPos[1]--;
								yPos[1]++;
								xPos[3]++;
								yPos[3]--;
								rotation--;
								canRotate = false;
								break;
							}
						}

						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				} else if (rotation == 2) {

					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0] += 1;
						yPos[0] -= 2;
						xPos[2]--;
						yPos[1]--;
						xPos[3] -= 2;
						yPos[3]++;
						rotation++;

						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									xPos[0] -= 1;
									yPos[0] += 2;
									xPos[2]++;
									yPos[1]++;
									xPos[3] += 2;
									yPos[3]--;
									rotation--;
									canRotate = false;
									break;
								}
							} else {
								xPos[0] -= 1;
								yPos[0] += 2;
								xPos[2]++;
								yPos[1]++;
								xPos[3] += 2;
								yPos[3]--;
								rotation--;
								canRotate = false;
								break;
							}
						}

						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				} else if (rotation == 3) {

					if (checkLeft() == true && checkRight() == true && xPos[3] + 2 <= 9) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0] -= 1;
						yPos[0] += 2;
						xPos[2]++;
						yPos[1]++;
						xPos[3] += 2;
						yPos[3]--;
						rotation = 0;

						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									xPos[0] += 1;
									yPos[0] -= 2;
									xPos[2]--;
									yPos[1]--;
									xPos[3] -= 2;
									yPos[3]++;
									rotation = 3;
									canRotate = false;
									break;
								}
							} else {
								xPos[0] += 1;
								yPos[0] -= 2;
								xPos[2]--;
								yPos[1]--;
								xPos[3] -= 2;
								yPos[3]++;
								rotation = 3;
								canRotate = false;
								break;
							}
						}

						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				}
			}
			if (currentState.equalsIgnoreCase("t") && canRotate == true && yPos[2] >= 1) {
				if (rotation == 0) {
					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						yPos[0] -= 2;
						xPos[1]--;
						yPos[1]--;
						xPos[3] -= 2;
						rotation++;

						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									yPos[0] += 2;
									xPos[1]++;
									yPos[1]++;
									xPos[3] += 2;
									rotation--;
									canRotate = false;
									break;
								}
							} else {
								yPos[0] += 2;
								xPos[1]++;
								yPos[1]++;
								xPos[3] += 2;
								rotation--;
								canRotate = false;
								break;
							}
						}

						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				} else if (rotation == 1) {
					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[1]++;
						yPos[1]--;
						xPos[3] += 2;
						yPos[3] -= 2;
						rotation++;

						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									xPos[1]--;
									yPos[1]++;
									xPos[3] -= 2;
									yPos[3] += 2;
									rotation--;
									canRotate = false;
									break;
								}
							} else {
								xPos[1]--;
								yPos[1]++;
								xPos[3] -= 2;
								yPos[3] += 2;
								rotation--;
								canRotate = false;
								break;
							}
						}

						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				} else if (rotation == 2) {
					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						xPos[0] += 2;
						yPos[0] += 2;
						xPos[1]++;
						yPos[1]++;
						rotation++;

						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									xPos[0] -= 2;
									yPos[0] -= 2;
									xPos[1]--;
									yPos[1]--;
									rotation--;
									canRotate = false;
									break;
								}
							} else {
								xPos[0] -= 2;
								yPos[0] -= 2;
								xPos[1]--;
								yPos[1]--;
								rotation--;
								canRotate = false;
								break;
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
						yPos[1]++;
						xPos[1]--;
						yPos[3] += 2;
						rotation = 0;

						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									xPos[0] += 2;
									yPos[1]--;
									xPos[1]++;
									yPos[3] -= 2;
									rotation = 0;
									rotation = 3;
									canRotate = false;
									break;
								}
							} else {
								xPos[0] += 2;
								yPos[1]--;
								xPos[1]++;
								yPos[3] -= 2;
								rotation = 0;
								rotation = 3;
								canRotate = false;
								break;
							}
						}

						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				}
			}
			if (currentState == "s" && canRotate == true && yPos[0] >= 2) {
				if (rotation == 0) {
					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						yPos[0] -= 2;
						xPos[2]--;
						yPos[2]--;
						xPos[3]--;
						yPos[3]++;
						rotation = 1;
						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									yPos[0] += 2;
									xPos[2]++;
									yPos[2]++;
									xPos[3]++;
									yPos[3]--;
									rotation = 0;
									break;
								}
							} else {
								yPos[0] += 2;
								xPos[2]++;
								yPos[2]++;
								xPos[3]++;
								yPos[3]--;
								rotation = 0;
								break;
							}
						}
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				} else if (rotation == 1) {
					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						yPos[0] += 2;
						xPos[2]++;
						yPos[2]++;
						xPos[3]++;
						yPos[3]--;
						rotation = 0;
						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									yPos[0] -= 2;
									xPos[2]--;
									yPos[2]--;
									xPos[3]--;
									yPos[3]++;
									rotation = 1;
									break;
								}
							} else {
								yPos[0] -= 2;
								xPos[2]--;
								yPos[2]--;
								xPos[3]--;
								yPos[3]++;
								rotation = 1;
								break;
							}
						}
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				}

			}
			if (currentState == "z" && canRotate == true && yPos[0] >= 2) {
				if (rotation == 0) {
					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						yPos[0]--;
						xPos[0]++;
						xPos[1]--;
						yPos[1]--;
						xPos[3] -= 2;
						rotation = 1;
						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									yPos[0]++;
									xPos[0]--;
									xPos[1]++;
									yPos[1]++;
									xPos[3] += 2;
									rotation = 0;
									break;
								}
							} else {
								yPos[0]++;
								xPos[0]--;
								xPos[1]++;
								yPos[1]++;
								xPos[3] += 2;
								rotation = 0;
								break;
							}
						}
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				} else if (rotation == 1) {
					if (checkLeft() == true && checkRight() == true) {
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = false;
						yPos[0]++;
						xPos[0]--;
						xPos[1]++;
						yPos[1]++;
						xPos[3] += 2;
						rotation = 0;
						for (int z = 0; z < 4; z++) {
							if (xPos[z] > -1 && xPos[z] < 10 && yPos[z] < 26) {
								if (grid.grid[xPos[z]][yPos[z]]) {
									yPos[0]--;
									xPos[0]++;
									xPos[1]--;
									yPos[1]--;
									xPos[3] -= 2;
									rotation = 1;
									break;
								}
							} else {
								yPos[0]--;
								xPos[0]++;
								xPos[1]--;
								yPos[1]--;
								xPos[3] -= 2;
								rotation = 1;
								break;
							}
						}
						for (int i = 0; i < 4; i++)
							grid.grid[xPos[i]][yPos[i]] = true;
					}
				}

			}
			update("check");
		}
	}

}