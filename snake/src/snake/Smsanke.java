package snake;

import javax.swing.JFrame;

public class Smsanke { 
	public static void main(String[] args) {
		
		 
		JFrame f= new JFrame();
		f.setBounds(10, 10, 900, 720);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MPanel());
		f.setVisible(true);
				
	}

}
