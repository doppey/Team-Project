package game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	private boolean[] keys = new boolean[256];
	public boolean jump, attack, pause;
	
	public void update(){
		jump = keys[KeyEvent.VK_Z];
		attack = keys[KeyEvent.VK_X];
		pause = keys[KeyEvent.VK_SPACE];
		
		//For testing
		//System.out.println("jump: " + jump + "\nattack: " + attack + "\n" + "pause: " + pause);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = true;
		//System.out.println("true");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}
