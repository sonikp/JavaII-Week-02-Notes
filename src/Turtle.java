import java.util.*;
import java.awt.*;

/*
 * Turtle.java
 * Michael Floerchinger
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
	  this.forward(100);
	  this.turnRight();
	  this.forward(100);
	  this.turnRight();
	  this.forward(100);
	  this.turnRight();
	  this.forward(100);
	  this.turnLeft();
  }
  
  public void draw(Color color)	// overloaded method, same method name different inputs
  {
	  this.penUp();
	  this.moveTo(60, 80);
	  this.penDown();
	  this.setPenColor(color);
	  this.forward(200);
	  
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

  /*
  Week 02 Assignment notes:
  
  Need methods:
  draw()				- draw shape of my choosing, created in turtle.java, but overwritten in subclasses
  draw(Color color) 	- draw shape of my choosing, must remain in the turtle.java class
  
  Create subclasses:
  SpiralTurtle	-	overwrite draw() method, draw a spiral
  ConfusedTurtle	-	overwrite draw() method, draw a erratic pattern of random sized segments drawn in chaotic directions
  SmartTurtle		- overwrite draw() method, draw a "design" of your own choosing
  
  Create:
  BaleOfTurtles.java class, with the main method. Will perform:
  Create world
  Initialize array of three turtles, with reference to Spiral, Confused, Smart, all turtles must be in current world
  Create a color object, choose color
  Iterate through TurtleArray, call draw(Color color) using each Turtle reference within the Array
  */
  

  public static void main(String[] args)
  {
    /*
	World pond = new World();
    Turtle turtle = new Turtle(pond);
    System.out.println("New Turtle Assignment \n");
    */
	  
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
    
    /*
    turtle.forward();
    turtle.draw();					// task 1 complete
    turtle.draw(Color.blue);		// task 2 complete
    */
  }

} // this } is the end of class Turtle, put all new methods before this