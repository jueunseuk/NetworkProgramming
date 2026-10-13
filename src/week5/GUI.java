package week5;

import javax.swing.JFrame;

public class GUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Frame");
		frame.setTitle("Title Test");
		frame.setSize(400, 300);
		frame.setLocation(100, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class CustomFrame