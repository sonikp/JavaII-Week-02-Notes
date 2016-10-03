import java.awt.Color;
import java.security.SecureRandom;

/*
 * BaleOfTurtles.java
 * Created by Michael Floerchinger
 * Assignment Week 02
 */


public class BaleOfTurtles 
{
	/*
	  Week 02 Assignment notes:
	  
	  Task 1: 
	  Need methods:			[COMPLETED]
	  draw()				- draw shape of my choosing, created in turtle.java, but overwritten in subclasses
	  draw(Color color) 	- draw shape of my choosing, must remain in the turtle.java class
	  
	  Task 2:
	  Create subclasses:	[COMPLETED]
	  SpiralTurtle		-	overwrite draw() method, draw a spiral
	  ConfusedTurtle	-	overwrite draw() method, draw a erratic pattern of random sized segments drawn in chaotic directions
	  SmartTurtle		- 	overwrite draw() method, draw a "design" of your own choosing
	  
	  Create:				[COMPLETED]
	  BaleOfTurtles.java class, with the main method. 
	  
	  Will perform:
	  Create world			[COMPLETED]
	  Initialize array of three turtles, with reference to Spiral, Confused, Smart, all turtles must be in current world
	  
	  Create a color object, choose color	[COMPLETED]
	  
	  Iterate:				[COMPLETED]
	  Interate through TurtleArray, call draw(Color color) using each Turtle reference within the Array
	  */
	
	
	
	public static void main(String[] args)
	{
		// secure random number generator
		SecureRandom randomNumbers = new SecureRandom();
		
		// Create world object 
		World pond = new World();
		
		// Create turtle object
		Turtle turtle = new Turtle(pond);
		turtle.turn(45);
		turtle.forward(250);
		System.out.println(turtle);
		
		// Task 1: 
		turtle.draw();
		System.out.println(turtle);
		turtle.turn(-45);
		turtle.draw(Color.red);
		
		    
		// Create confused turtle object
		ConfusedTurtle confused = new ConfusedTurtle(pond);
		confused.forward(100);
		confused.draw();
		System.out.println(confused);
		 
		// Create smart turtle object
		SmartTurtle smart = new SmartTurtle(pond);
		smart.turnRight();
		smart.forward(100);
		smart.draw();
		 
		// Create spiral turtle object
		SpiralTurtle spiral = new SpiralTurtle(pond);
		spiral.turnLeft();
		spiral.forward(100);
		spiral.draw();
			  
		// Turtle Array (as method)
		// turtle.createTurtlesWithArray();		// Incomplete: attempted to call a 
												// method in turtle class, but could not 
												// figure out how to access the "pond" object
		// Turtle Array 
		turtle.moveTo(30, 300);	// move to a free area
		
		// Create a turtle array
		Turtle[] turtleArray = new Turtle[10];
		
		// Create a color array
		Color[] newColor = {Color.RED,Color.WHITE,Color.BLUE,Color.BLACK,Color.CYAN,
				Color.GREEN,Color.ORANGE,Color.YELLOW,Color.PINK,Color.GRAY};
		
		// create many turtles
		for ( int i = 0; i < 10; i++)
		{
			
			turtleArray[i] = new Turtle(pond);
			
			// random movements
			for ( int j = 0; j < 10; j++)
			{
				turtleArray[i].draw(newColor[randomNumbers.nextInt(10)]);
				turtleArray[i].turn((int) (randomNumbers.nextInt(360)));
				turtleArray[i].forward(5);
			}
		}
		
		
		
		
	}	// End of main method
}		// End of BaleOfTurtles class