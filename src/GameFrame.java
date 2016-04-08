import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	public GameFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Monkey Banana Game");
		setResizable(false);
		init();
	}
	public void init(){

		setLayout(new GridLayout(1,1,0,0));
		CJPanel c = new CJPanel();
		add(c);
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		
		new GameFrame();
		}
}