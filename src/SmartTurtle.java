import java.awt.Color;

/*
 * SmartTurtle.java
 * Created by Michael Floerchinger
 * Assignment Week 02
 */


public class SmartTurtle extends Turtle
{
	

	
	// Constructors -------------------------
	public SmartTurtle(int x, int y, World pond)		
	{
		super(x,y,pond);
	}

	public SmartTurtle(World pond) 
	{
		super(pond);
	}
		
		
	// END Constructors-------------------------
		
	public void draw(Color color)	
	{
		this.penUp();
		this.moveTo(40, 420);
		this.penDown();
		this.setPenColor(color);
	}
	
	
	public void draw()
	{

		int length = 100;
		
		for ( int i = 0; i < 20; i++)
		{
			this.forward(length);
			this.turnRight();
			this.forward(length);
			this.turnRight();
			this.forward(length);
			this.turnRight();
			length = length - 10;
			this.forward(length);
			this.turnRight();

		}
	}
}