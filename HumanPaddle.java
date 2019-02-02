package PongV2;
import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle{
	double y,yVel;
	boolean upAccel,downAccel;
	final double GRAVITY= 0.94;
	int player,x;
	public HumanPaddle(int player){
		upAccel=false; downAccel=false;
		y=210;yVel=0;
		if(player==1)
			x=0;
		else
			x=695;
	}
	public void draw(Graphics g)
	{	
		if(x==0)
		{
			g.setColor(Color.red);
		g.fillRect(x,(int)y,5,80);
		}
		else
		{
			g.setColor(Color.green);
		g.fillRect(x,(int)y,5,80);
		}
	
	}
	public void move(){
		if(upAccel){
			yVel-=1;
		}
		else if(downAccel){
			yVel+=1;
		}
		else if(!upAccel && !downAccel){
			yVel*=GRAVITY;
		}
		if (yVel>=5)
			yVel=5;
		else if(yVel<=-5)
			yVel=-5;
		y+=yVel;
		if (y<0)
			y=0;
		if (y>420)
			y=420;
	}
	public void setUpAccel(boolean input){
		upAccel=input;
	}
	public void setDownAccel(boolean input){
		downAccel=input;
	}

	
	public int getY()
	{
		return (int)y;
	}
	public void setY(int i)
	{
		y=i;
	}
	
}
