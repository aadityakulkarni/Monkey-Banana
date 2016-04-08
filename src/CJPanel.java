import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CJPanel extends JPanel implements Runnable {
	public static final int WIDTH = 640, HEIGHT = 640;
	// Chain key;

	Monkey monkey;
	Banana banana;
	Random rMonkey = new Random();
	Random rBanana = new Random();
	Image grassImage; // ????? (64*64 pixels)
	URL urlForGrass;
	ImageIcon grassIcon;
	ArrowKey a;
	Timer gameTimer;
	int gameCounter = 40;
	int bananaCounter = 6;
	int bananaTime = 10;
	boolean running = false;
	int score =0;
	Thread thread;

	public CJPanel() {
		start();
		a = new ArrowKey();
		setFocusable(true);
		addKeyListener(a);
		setPreferredSize(new Dimension(WIDTH, HEIGHT + 50));

	}

	public void start() {
		running = true;
		thread = new Thread(this, "Game Loop");
		thread.start();
		gameTimer = new Timer(1000, new GameTimer());

		// start the timer
		gameTimer.start();
		// System.out.print( "Press 'Enter'" );
		monkey = new Monkey(rMonkey.nextInt(19) * 32, rMonkey.nextInt(19) * 32, this);
		banana = new Banana(rBanana.nextInt(19) * 32, rBanana.nextInt(19) * 32, this);

	}

	public void paint(Graphics g) {
		super.paint(g);
		// TODO
		Font myFont = new Font ("Courier New", 1, 15);
		g.setFont (myFont);
		if (bananaCounter > 0 && gameCounter > 0) {
			urlForGrass = getClass().getResource("/grass.jpg");
			grassIcon = new ImageIcon(urlForGrass);
			grassImage = grassIcon.getImage();
			g.drawImage(grassImage, 0, 0, null);
			monkey.showMonkey(g);
			banana.showBanana(g);
			g.drawString("Time - :" + gameCounter, 12, 655);
			g.drawString("Remaining Banana's - :" + bananaCounter, 12, 670);
			g.drawString("Banana Time - :" + bananaTime, 300, 655);
			g.drawString("Score - :" + score, 12, 685);
			
			
		} else {
			Font myFont1 = new Font ("Courier New", 1, 36);
			
			g.setFont (myFont1);
			
			if (gameCounter == 0 && bananaCounter > 0) {
				g.setColor(Color.red);
				g.drawString("You Loose !!!", 220, 320);
			} else if (bananaCounter == 0 && gameCounter > 0) {
				g.setColor(Color.green);
				g.drawString("You Win !!!", 220, 320);
			}
			
		}

	}

	public class ArrowKey implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_RIGHT ) {
				
				monkey.moveRight();
				// System.out.println("right");

			}
			if (key == KeyEvent.VK_LEFT ) {
				
				monkey.moveLeft();
				// System.out.println("left");

			}
			if (key == KeyEvent.VK_UP ) {
				

				monkey.moveUp();
				// System.out.println("up");
			}
			if (key == KeyEvent.VK_DOWN ) {
				monkey.moveDown();
				// System.out.println("down");
			}
			bananaChecker();
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}

		public void bananaChecker() {
			if ((monkey.getMonkeyX() == banana.getBananaX() && monkey.getMonkeyY() == banana.getBananaY())) {
			//	System.out.println("Hello");
				//bananaTime = 10;
				banana.createNewBanana();
				bananaTime = 10;
				bananaCounter--;
				score = ((6 - bananaCounter));
				repaint();

			}
			else if (bananaTime == 0){
				banana.createNewBanana();
				bananaTime = 10;
				
				
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	class GameTimer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (gameCounter > 0) {
				gameCounter--;
				bananaTime--;
				if (bananaTime == 0){
					banana.createNewBanana();
					bananaTime = 10;
					
				}
			} 
		}
	}
	


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (running) {
			try {
				thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}

}
