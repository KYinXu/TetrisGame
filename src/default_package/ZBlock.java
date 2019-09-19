package default_package;

public class ZBlock extends GameObject{

	public ZBlock(Grid grid) {
		super(grid);
		// TODO Auto-generated constructor stub
		xPos[0] = 3;
		yPos[0] = 0;
		xPos[1] = 4;
		yPos[1] = 1;
		xPos[2] = 4;
		yPos[2] = 0;
		xPos[3] = 5;
		yPos[3] = 1;
			/*
			 0  2  
			    1  3
			 */

	for(int i = 0; i < 4; i++) {
		grid.grid[xPos[i]][yPos[i]] = true;
	}
}
}

