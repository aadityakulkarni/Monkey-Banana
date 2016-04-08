import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Banana {

	private int bananaX, bananaY;
	CJPanel panel;
	Image bananaImage;
	URL urlForBanana;
	ImageIcon bananaIcon;
	
	private Random r = new Random();;
	Banana(int bananaX, int bananaY, CJPanel cjp){
		
		this.bananaX = bananaX;
		this.bananaY = bananaY;
		this.panel = cjp;
		
	}
	public void showBanana(Graphics g){
		urlForBanana = getClass().getResource("/banana.png");
		bananaIcon = new ImageIcon(urlForBanana);
		bananaImage = bananaIcon.getImage();
		g.drawImage(bananaImage, bananaX, bananaY, null);
		
	}
	
	public void createNewBanana(){
		setBananaX(r.nextInt(19) * 32);
		setBananaY(r.nextInt(19) * 32);
		
	}
	public int getBananaY() {
		return bananaY;
	}
	public void setBananaY(int bananaY) {
		this.bananaY = bananaY;
	}
	public int getBananaX() {
		return bananaX;
	}
	public void setBananaX(int bananaX) {
		this.bananaX = bananaX;
	}
}
