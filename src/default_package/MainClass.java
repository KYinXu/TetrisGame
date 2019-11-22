package default_package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainClass {
	JFrame frame;
	GamePanel panel;

	public final static int framewidth = 505;
	public final static int frameheight = 775;
	void setup() {
		frame = new JFrame();

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tetris");
		frame.setBackground(Color.BLACK);
		panel = new GamePanel();
		panel.setPreferredSize(new Dimension(framewidth, frameheight));
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.pack();
		panel.t.start();
	}

	public static void main(String[] args) {
		MainClass m = new MainClass();
		m.setup();
	}

}
