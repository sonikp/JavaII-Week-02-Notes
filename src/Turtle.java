import java.util.*;
import java.awt.*;


/*
 * Turtle.java
 * Modified by Michael Floerchinger
 * Assignment Week 02
 */

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////
  
  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture) 
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }
  
  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y, 
                 ModelDisplay modelDisplayer) 
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }
  
  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay) 
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p)
  {
    // let the parent constructor handle it
    super(p);
  }  
  
  /////////////////// methods ///////////////////////
  
  public void draw()
  {
	  // class turtle method draw = square
	  this.forward(50);
	  this.turnRight();
	  this.forward(50);
	  this.turnRight();
	  this.forward(50);
	  this.turnRight();
	  this.forward(50);
	  this.turnRight();
  }
  
  public void draw(Color color)	// overloaded method, same method name different inputs
  {
	  this.penUp();
	  this.moveTo(40, 420);
	  this.penDown();
	  this.setPenColor(color);
	  

	  // draw pentagon
	  this.forward(70);
	  this.turn(72);
	  this.forward(70);
	  this.turn(72);
	  this.forward(70);
	  this.turn(72);
	  this.forward(70);
	  this.turn(72);
	  this.forward(70);
	  this.turn(72);
	
	  
  }
  
  public void spiral()
  {
	  // need to create body for this
	  int move = 100;
	  this.forward(move);
	  double corner = 1;
	  this.turn(corner);
	  this.forward(move);
	  this.turn(corner + corner);

  }

  public void createTurtlesWithArray()
  {
	  
	  /*
	   * Need to figure out how to call the world object pond from the
	   * main method
	   * 
	   * INCOMPLETE
	   */
	  
	  
	  /*
	  // secure random number generator
	  SecureRandom randomNumbers = new SecureRandom();

	  // relocate
	  this.moveTo(30,40);
	  this.forward(1);

	  Turtle[] turtleArray = new Turtle[10];
		// create many turtles
		for ( int i = 0; i < 10; i++)
		{
			turtleArray[i] = new Turtle(pond);
			// random locations
			for ( int j = 0; j < 10; j++)
			{
				turtleArray[i].turn((int) (360 * randomNumbers.nextInt(100)));
				turtleArray[i].forward(20);
			}
		}
		*/
  }
  

  public static void main(String[] args)
  {
    
    // not used left these notes for myself
	
	/*
	World pond = new World();
    
    Turtle turtle = new Turtle(pond);
    turtle.backward(100);
    System.out.println(turtle);
    
    ConfusedTurtle confused = new ConfusedTurtle(pond);
    confused.forward(10);
    System.out.println(confused);
	*/
	
  }

} // this } is the end of class Turtle, put all new methods before this