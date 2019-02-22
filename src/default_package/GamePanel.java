package default_package;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	Grid grid;
public GamePanel() {
	grid = new Grid();
	System.out.println("test");

}
public void paintComponent(Graphics g) {
	grid.drawGrid(g);
}
}
