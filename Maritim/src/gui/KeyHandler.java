package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	private boolean upPressed, downPressed, leftPressed, rightPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	public boolean isUpPressed() {
		return upPressed;
	}

	public boolean isDownPressed() {
		return downPressed;
	}

	public boolean isLeftPressed() {
		return leftPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_Z) {
			upPressed=true;
		}
			
		if (code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if (code == KeyEvent.VK_D) {
			leftPressed=true;
		}
		if (code == KeyEvent.VK_Q) {
			rightPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_Z) {
			upPressed=false;
		}
			
		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			leftPressed=false;
		}
		if (code == KeyEvent.VK_Q) {
			rightPressed = false;
		}
		
	}
		
	}


