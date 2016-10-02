import java.awt.Color;

public class BaleOfTurtles // extends Turtle // appears not to be needed
{
	/*
	// constructor: 
	public BaleOfTurtles()
	{
		
	}
	*/
	
	public static void main(String[] args)
	{
		World pond = new World();
		Turtle turtle = new Turtle(pond);
		turtle.draw();
		Color specificColor = new Color(Color.RED);
		//turtle.draw(Color.red);
		
		// need to do something with a turtle array
		
		/*
		// Section 1: create local methods draw() & spiral()
	    turtle.setColor(Color.red);
	    turtle.setPenColor(Color.green);
	    turtle.spiral();
	    */
	    
	    /*
	    // Create 3 subclasses
	    SpiralTurtle newSpiral = new SpiralTurtle();
	    newSpiral.spiralDoStuff();
	    newSpiral.draw();
	    
	    ConfusedTurtle newConfused = new ConfusedTurtle();
	    newConfused.confusedDoStuff();
	    newConfused.draw();
	    
	    SmartTurtle newSmart =new SmartTurtle();
	    newSmart.smartDoStuff();
	    newSmart.draw();
	    */
	}
}