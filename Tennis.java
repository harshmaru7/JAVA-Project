 package PongV2;
 import java.awt.Color;
 import java.awt.Image;

 //import java.awt.*;
 
 import java.applet.Applet;
 import java.awt.event.*;
 import java.awt.Graphics;
 public class Tennis extends Applet implements Runnable, KeyListener {
 	final int WIDTH=700,HEIGHT=500;
 	Thread thread;
 	int k=1,a=0,b=0;
 	
 	HumanPaddle p1,p2;
 	Ball b1;
 	boolean gameStarted;
 	Graphics gfx;
 	Image img;
 	public void init()
 	{
 		this.resize(WIDTH,HEIGHT);
 		gameStarted=false;
 		this.addKeyListener(this);
 		p1=new HumanPaddle(1);
 		p2=new HumanPaddle(2);
 		b1=new Ball();;
 		
 		img=createImage(WIDTH,HEIGHT);
 		gfx=img.getGraphics();
 		thread=new Thread(this);
 		thread.start();

 	}
 	public void paint(Graphics g)
 	{	
 		gfx.setColor(Color.black);
		gfx.fillRect(0,0,WIDTH,HEIGHT);

 		if (k==2)
 		{
 			
 		
 				try{

 		 			g.setColor(Color.red);
 		 			
 					if (a<b)
 	 					g.drawString("Player 1 Wins",310,250);
 	 				else if(a==b)
 	 					g.drawString("DRAW",310,250);
 	 				else
 	 					g.drawString("Player 2 Wins",310,250);
 	 				 
 	 				Thread.sleep(2000);
 	 			}
 	 			catch(InterruptedException e)
 	 			{
 	 				e.printStackTrace();
 	 			}	
 		 					
 			
 		p1.setY(210);
 		p2.setY(210);
 		b1.setX(350);
 		b1.setY(250);
 		k=1;
 		a=0;
 		b=0;
 		}
 		
 		else
 	
 		{
 			if(b1.getX()<=0)
 	 		{	
 	 			a+=1;
 	 		}
 	 		if(b1.getX()>=700)
 	 		{
 	 			b+=1;
 	 		}
 	 		
 		p1.draw(gfx);
 		p2.draw(gfx);
 		b1.draw(gfx);
 		gfx.setColor(Color.white);
 		gfx.drawString("Player1:"+a,10,490);
		gfx.drawString("Player2:"+b,630,490);
			
 		}
 		if(!gameStarted) {
 			gfx.setColor(Color.white);
 			gfx.drawString("PONG",350,100);
 			gfx.drawString("Press ENTER to START", 310, 130);
 			
 		}
 	g.drawImage(img,0,0,this);
 	}
 	
 	public void update(Graphics g)
 	{
 		paint(g);
 	}
 	public void run()
 	{
 		for(;;)
 		{
 			if(gameStarted)
 			{	
 			p1.move();
 			p2.move();
 			b1.move();
 			b1.checkPaddleCollision(p1,p2);
 			}
 			repaint();
 			try{
 				Thread.sleep(10);
 			}
 			catch(InterruptedException e)
 			{
 				e.printStackTrace();
 			}
 		}
 		
 	}
 
 	public void keyPressed(KeyEvent e){
 		if(e.getKeyCode()==KeyEvent.VK_UP){
 			p2.setUpAccel(true);

 		}
 		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
 			p2.setDownAccel(true);
 		}
 		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
 			gameStarted=true;
 		}

 		if (e.getKeyCode()==KeyEvent.VK_P) {
 			gameStarted=false;
 		}
 		if (e.getKeyCode()==KeyEvent.VK_X) {
 			gameStarted=false;
 			k=2;
 			
 			repaint();
 		}
 	
 		if(e.getKeyCode()==KeyEvent.VK_W){
 			p1.setUpAccel(true);

 		}
 		else if(e.getKeyCode()==KeyEvent.VK_S){
 			p1.setDownAccel(true);
 		}

 	}
 	public void keyReleased(KeyEvent e){
 		if(e.getKeyCode()==KeyEvent.VK_UP){
 			p2.setUpAccel(false);

 		}
 		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
 			p2.setDownAccel(false);			
 		}
 		if(e.getKeyCode()==KeyEvent.VK_W){
 			p1.setUpAccel(false);

 		}
 		else if(e.getKeyCode()==KeyEvent.VK_S){
 			p1.setDownAccel(false);			
 		}


 	}
 	public void keyTyped(KeyEvent e){

 	}
 }