package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameObject {
	int[] xPos = new int[4];
	int[] yPos = new int[4];
	Grid grid;
	boolean isActive;

	public GameObject(Grid grid) {
		this.grid=grid;
		isActive=true;
	}
	public void moveLeft() {
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
	public void moveRight() {
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
	public void moveDown() {
		for(int i = 0; i < 4; i++) {
			if(yPos[i] + 1 >= grid.height) {
				isActive = false;
				return;
			}
		}
		for(int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = false;
			yPos[i]++;
		}
		
		for(int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = true;
		}
	}
void update(){

	boolean canMoveDown = true;

	for(int i = 0; i < 4; i++) {
		int x = xPos[i];
		int y = yPos[i];
		int ny = yPos[i] + 1;
		
		if(ny >= grid.height) {
			canMoveDown = false;
			break;
		}
		boolean sameBlock=false;
		if(grid.grid[x][ny]) {
			//check if grid square is part of the same block
			for(int j = 0; j < 4; j++) {
				if(i != j) {
					if(x == xPos[j] && ny == yPos[j]) {
						sameBlock = true;
						break;
					}
				}
			}
			if(!sameBlock) {
				canMoveDown = false;
			}
		}
		/*if(xPos[4]<10 && xPos[0]>0) {
			//start here, checking left and right movement
			if(grid.grid[x+1][y]) {
				for(int j = 0; j < 4; j++) {
					if(i != j) {
						if(x+1 == xPos[j] && y == yPos[j]) {
							sameBlock = true;
							break;
						}
						if(!sameBlock) {
						canMoveRight == true;
						}
					}
				}
			}
		}
		*/
	}
	
	if(canMoveDown) {
		moveDown();
	}else {
		isActive = false;
	}
}

}
