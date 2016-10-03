import java.security.SecureRandom;

/*
 * ConfusedTurtle.java
 * Created by Michael Floerchinger
 * Assignment Week 02
 */


public class ConfusedTurtle extends Turtle				
{
	
	// Constructors -------------------------
	public ConfusedTurtle(int x, int y, World pond)		
	{
		super(x,y,pond);
	}

	public ConfusedTurtle(World pond) 
	{
		super(pond);
	}
	
	
	// END Constructors-------------------------
	
	
	
	public void confusedDoStuff()
	{
		System.out.println("ConfusedTurtle.confusedDoStuff");
		this.forward(40);
	}
	
	public static int[] randomLocation()		
	{
		/*
		 * create random locations using max width & 
		 * height methods
		 */
		
		SecureRandom randomNumbers = new SecureRandom();
		int xAxis = randomNumbers.nextInt(640) - 1;
		int yAxis = randomNumbers.nextInt(480) - 1;
		return new int[] {xAxis, yAxis};
		
	}
	

	
	public void draw()
	{
		SecureRandom randomLength = new SecureRandom();
		int length = randomLength.nextInt(17);
		
		SecureRandom randomAngle = new SecureRandom();
		int angle = randomAngle.nextInt(180);
		
		int randomLoc[] = randomLocation();
		int xAxis = randomLoc[0];
		int yAxis = randomLoc[1];
		this.penUp();
		this.moveTo(xAxis, yAxis);
		this.penDown();
		this.forward(10);
		
		for ( int i = 0; i < angle / 2; i++)
		{
			if ( angle / 2 == 0 )
			{
				this.forward(angle / length);
			}
			else if ( angle / 3 == 0)
			{
				this.turn(angle / length);
			}
			else
			{
				this.backward(i);
				this.turn(i * Math.PI);
				this.forward(i / 30);
			}
	
		}
		
	}


	
}