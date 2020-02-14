package default_package;

public class SBlock extends GameObject{
	public SBlock(Grid grid) {
		super(grid);
		xPos[0] = 3;
		yPos[0] = 1;
		xPos[1] = 4;
		yPos[1] = 0;
		xPos[2] = 4;
		yPos[2] = 1;
		xPos[3] = 5;
		yPos[3] = 0;
			/*
			 	1  3
			 0  2
			 */
		//GREEN
		//still working on S Block
		for(int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = true;
		}
	}
}
