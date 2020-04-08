package bobina.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import bobina.main.Main;
import bobina.objects.Player;

public class key implements KeyListener{
	private Player p;
	private Main ma;
	public key(Player p, Main ma) {
		this.p=p;
		this.ma=ma;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_SPACE) p.jump();
		if(p.lost) {
			p.lost=false;
			String args[]=new String[] {"o","a"};
			
			Main m = new Main();
			ma.window.frame.dispose();
			ma.pause();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
