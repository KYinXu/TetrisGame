package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LineBlock extends GameObject {

	Grid grid;
	public LineBlock(Grid grid) {
		super(grid);
		this.grid=grid;
		for(int i = 0; i < 4; i++) {
			xPos[i] = 3 + i;
			yPos[i] = 0;

			grid.grid[xPos[i]][yPos[i]] = true;
		}
	}
}
