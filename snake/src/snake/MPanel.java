package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MPanel  extends JPanel implements KeyListener,ActionListener  {
	ImageIcon title=new ImageIcon("src/title.png");
	ImageIcon body=new  ImageIcon("src/body.png");
	ImageIcon right=new ImageIcon("src/right.png");
	ImageIcon food=new  ImageIcon("src/food.png");
	ImageIcon up=new  ImageIcon("src/up.png");
	ImageIcon left=new  ImageIcon("src/left.png");
	ImageIcon down=new  ImageIcon("src/down.png");
	
	
	int len=3;
	int[]snakex=new int[750];
	int[]snakey=new int[750];
	String fx ="R";//∑ΩœÚR£¨L,U,D
	boolean isStarted=false;
	boolean isFailed=false;
	Timer timer=new Timer(150,this);
	int foodx;
	int foody;
	Random rand =new Random();
	
	
	
	public MPanel() {
		initSnake();
		this.setFocusable(true);
		this.addKeyListener(this);
		timer.start();
		
	}
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		this.setBackground(Color.RED);
		title.paintIcon(this, g, 25, 11);
		g.fillRect(25, 75, 850, 600);
		
		if(fx=="R") {
			right.paintIcon(this, g, snakex[0],snakey[0]);
		}else if(fx=="L") {
			left.paintIcon(this, g, snakex[0], snakey[0]);
		}else if(fx=="U") {
			up.paintIcon(this, g, snakex[0], snakey[0]);
		}else if(fx=="D") {
			down.paintIcon(this, g, snakex[0], snakey[0]);
		}
		
		food.paintIcon(this, g, foodx, foody);
		
		for(int i=1;i<len;i++) {
			body.paintIcon(this, g, snakex[i],snakey[i]);
		}
		
		if(isStarted==false) {
		g.setFont(new Font("arial",Font.BOLD,40));
		g.setColor(Color.WHITE);
		g.drawString("Press Space to Start",300,300);
		}
		if(isFailed) {
			g.setFont(new Font("arial",Font.BOLD,40));
			g.setColor(Color.RED);
			g.drawString("Press Space to Restart",200,300);
			}
		
	}
	public void initSnake() {
		len =3;
		snakex[0]=100;
		snakey[0]=100;
		snakex[1]=75;
		snakey[1]=100;
		snakex[2]=50;
		snakey[2]=100;
		foodx=25+25*rand.nextInt(34);
		foody=75+25*rand.nextInt(24);
		fx="R";
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode=e.getKeyCode();
		if(keyCode==KeyEvent.VK_SPACE) {
			if(isFailed) {
				isFailed=false;
				initSnake();
			}else 
			
			isStarted= !isStarted;
			repaint();
		}else if (keyCode== KeyEvent.VK_LEFT) {
			fx="L";
		}else if (keyCode==KeyEvent.VK_RIGHT) {
			fx="R";
		}else if(keyCode== KeyEvent.VK_UP) {
			fx="U";
			
		}else if(keyCode==KeyEvent.VK_DOWN) {
			fx="D";
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isStarted&&!isFailed) {
			
		
	  for(int i=len-1;i>0;i--) { 
		  snakex[i]=snakex[i-1];
		  snakey[i]=snakey[i-1];
	  }
	    if(fx=="R") {
	    	
	    
		snakex[0]=snakex[0]+25;
		if(snakex[0]>850)snakex[0]=25;
	    }else if(fx=="L") {
	    	snakex[0]=snakex[0]-25;
	    	if(snakex[0]<25)snakex[0]=850 ;
	    } else if(fx=="U") {
	    	snakey[0]=snakey[0]-25;
	    	if(snakey[0]<75)snakey[0]=650;
	    } else if(fx=="D") {
	    	snakey[0]=snakey[0]+25;
	    	if(snakey[0]>650)snakey[0]=75; }
		 
	    if(snakex[0]==foodx&&snakey[0]==foody) {
	    	len++;
	    	foodx=25+25*rand.nextInt(34);
	    	foody=75+25*rand.nextInt(24);
	    }
		
	    for(int i=1;i<len;i++) {
	    	if(snakex[i]==snakex[0]&&snakey[i]==snakey[0]) {
	    		isFailed=true;
	    	}
	    }
		repaint();
		
		}
		timer.start(); 
		
	}

	}
