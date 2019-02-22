package default_package;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainClass implements ActionListener {
	JFrame frame;
	GamePanel panel;
	Timer t = new Timer(1000 / 60, this);
	Grid grid = new Grid();
	final int framewidth = 500;
	final int frameheight = 1000;
	void setup() {
		frame = new JFrame();
		panel = new GamePanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tetris");
		frame.add(panel);
		frame.setSize(framewidth, frameheight);
		t.start();
	}
public static void main(String[] args) {
	MainClass m = new MainClass();
	m.setup();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}


}
