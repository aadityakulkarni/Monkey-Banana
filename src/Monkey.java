import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Monkey {

	private int monkeyX, monkeyY;
	CJPanel panel;
	private Image monkeyImage; 
	private URL urlForMonkey;
	private ImageIcon monkeyIcon;
	State s;
	Monkey(int monkeyX, int monkeyY, CJPanel cjp){
		
		this.monkeyX = monkeyX;
		this.monkeyY = monkeyY;
		this.panel = cjp;
		
		 s = new Idle();
		
	}
	
	public void showMonkey(Graphics g){
		urlForMonkey = getClass().getResource("/monkey1.png");
		monkeyIcon = new ImageIcon(urlForMonkey);
		monkeyImage = monkeyIcon.getImage();
		g.drawImage(monkeyImage, monkeyX, monkeyY, null);
		
	}
	
	
	public void moveRight() {
		// TODO Auto-generated method stub
		s = s.monkeyRight(this);
		atDestination();
	}
	
	public void moveLeft() {
		// TODO Auto-generated method stub
		s = s.monkeyLeft(this);
		atDestination();
	}
	public void moveUp() {
		// TODO Auto-generated method stub
		s = s.monkeyUp(this);
		atDestination();
	}
	public void moveDown() {
		// TODO Auto-generated method stub
		s = s.monkeyDown(this);
		atDestination();
	}
	
	public void atDestination() {
		// TODO Auto-generated method stub
		
		s = s.monkeyAtDestination(this);
		panel.repaint();
	}
	public int getMonkeyX() {
		return monkeyX;
	}
	public void setMonkeyX(int x) {
		this.monkeyX = x;
	}
	public int getMonkeyY() {
		return monkeyY;
	}
	public void setMonkeyY(int y) {
		this.monkeyY = y;
	}
	

}
