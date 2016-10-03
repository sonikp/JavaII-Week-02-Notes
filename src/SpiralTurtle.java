public class SpiralTurtle extends Turtle

/*
 * SpiralTurtle.java
 * Created by Michael Floerchinger
 * Assignment Week 02
 * Sorry, due to limited time, spiral turtle, became a square spiral
 */


{
	
	// Constructors -------------------------
	public SpiralTurtle(int x, int y, World pond)		
	{
		super(x,y,pond);
	}

	public SpiralTurtle(World pond) 
	{
		super(pond);
	}
		
		
	// END Constructors-------------------------
	

	
	public void spiralDoStuff()
	{
		System.out.println("SpiralTurtle.spiralDoStuff");
	}
	
	public void draw()
	{
		System.out.println("SpiralTurtle.draw()");
		
		int length = 10;
		for ( int i = 0; i < 35; i++)
		{
			this.forward(length);
			this.turnRight();
			length = length + 5;
		}
		
	}

}