package default_package;

public class LBlock extends GameObject{

	public LBlock(Grid grid) {
		super(grid);
		xPos[0] = 3;
		yPos[0] = 2;
		xPos[1] = 3;
		yPos[1] = 0;
		xPos[2] = 3;
		yPos[2] = 1;
		xPos[3] = 4;
		yPos[3] = 2;
		/*
		 1
		 2
		 0 3
		*/
		//MAGENTA
		for(int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = true;
		}
	}

}
