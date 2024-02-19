package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		System.setProperty("sun.java2d.opengl", "true"); // to force the system the use of openGL , otherwise it's really laggy
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Maritim");
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack(); // to make sure the windows takes the size of the components in it
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}

}