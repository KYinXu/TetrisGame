package default_package;

public class SquareBlock extends GameObject{
	public SquareBlock(Grid grid) {
		super(grid);
		xPos[0] = 3;
		yPos[0] = 0;
		xPos[1] = 4;
		yPos[1] = 0;
		xPos[2] = 3;
		yPos[2] = 1;
		xPos[3] = 4;
		yPos[3] = 1;
		
		for(int i = 0; i < 4; i++) {
			grid.grid[xPos[i]][yPos[i]] = true;
		}
	} // //
}    //   
