package PongV2;
import java.math.*;
import java.awt.Graphics;
import java.awt.Color;
public class Ball{
	double xVel, yVel, x, y;

	public Ball(){
		x = 350;
		y = 250;
		xVel = getRandomSpeed()* getRandomDirection();
		yVel = getRandomSpeed()* getRandomDirection();
	}
	public double getRandomSpeed() {
		return(Math.random()*3+2);
	}
	public int getRandomDirection() {
	int rand=(int)(Math.random()*2);
	if(rand==1)
		return 1;
	return -1;
	}
//To draw the ball of radius 10 and white color	
	public void draw(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval((int)x-10,(int)y-10, 20, 20); //subtracting 10 to make x,y center of the circle
	}

	public void checkPaddleCollision(Paddle p1,Paddle p2){
		 if( x <= 15){
		 	if(y>= p1.getY() && y <= p1.getY()+80){
		 		
		 		xVel = -xVel;
		 	}
		 }
		 else if(x >= 685){
		 	if(y >= p2.getY() && y <= p2.getY() + 80)
		 		xVel = -xVel;
		 }
		 else
		 {
			 if(x<10 || x>690)
				 xVel=-xVel;
			 
		 }
		 
	}
	public void move(){
		x += xVel;
		y += yVel;
		if(x<0)
			//if ball goes vertically outside the top of the screen,we reverse it
			xVel = -xVel;
		if(x>700)
			xVel = -xVel; //if ball leaves the screen by dropping (500-radius) is limiting
		
		if(y < 10) //if ball goes vertically outside the top of the screen,we reverse it
			yVel = -yVel;
		if(y > 490)
			yVel = -yVel; //if ball leaves the screen by dropping (500-radius) is limiting
						  //y co-ordinate	
		
	}
	public int getX(){
		return (int)x;
	}	
	public int getY(){
		return (int)y;
	}
	public void setX(int a){
		x=a;
	}	
	public void setY(int b){
		y=b;
	}

}