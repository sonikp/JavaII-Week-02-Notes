import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
	/*
	 * Program 18: Lighten the Picture Using Nested Loops
	 * Method to lighten the colors in the picture
	 * 
	 */
	public void lighten2()
	{
		Color color = null;
		Pixel pixel = null;
		
		// loop through the columns ( x direction)
		for ( int x = 0; x < getWidth(); x++)
		{
			// loop through the rows ( y direction)
			for ( int y = 0; y < getHeight(); y++)
			{
				// get pixel at the x and y location
				pixel = getPixel(x,y);
				
				// get the current color
				color = pixel.getColor();
				
				// get a lighter 
				color = color.brighter();
				
				// set the pixel color the the lighter color
				pixel.setColor(color);
				
			}
		}
		
	}
  
  /*
   * Program 19: Mirror Pixels in a Picture along a Vertical Line
   * Method to mirror around a vertical line in the middle of the
   * picture based on width
   */
  public void mirrorVertical()
  {
	  int width = this.getWidth();
	  int mirrorPoint = width / 2;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  
	  // loop through all the rows
	  for (int y = 0; y < getHeight(); y++)
	  {
		  // loop through all the columns
		  for (int x = 0; x < mirrorPoint; x++)
		  {
			  leftPixel = getPixel(x,y);
			  rightPixel = getPixel(width - 1 - x, y);
			  rightPixel.setColor(leftPixel.getColor());
		  }
		  
		  
	  }
  }
  
  /*
   * Program 20: Mirror around a horizontal line. Copies top mirrored 
   * to bottom
   */
  public void mirrorHorizontal()
  {
	  int height = this.getHeight();
	  int mirrorPoint = height / 2;
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  
	  // loop through columns
	  for (int x = 0; x < getWidth(); x++)
	  {
		  // loop from 0 to just before mirror point
		  for (int y = 0; y < mirrorPoint; y++)
		  {
			  topPixel = getPixel(x,y);
			  bottomPixel = getPixel(x, height - 1 - y);
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
	  
  }
  
  /*
   * Program 21: Mirror Pixels Horizontally, Bottom to Top
   * Mirror around a horizontal line. Copies bottom mirrored 
   * to top
   */
  public void mirrorHorizontalBottomToTop()
  {
	  int height = this.getHeight();
	  int mirrorPoint = height / 2;
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  
	  // loop through columns
	  for (int x = 0; x < getWidth(); x++)
	  {
		  // loop from 0 to just before mirror point
		  for (int y = 0; y < mirrorPoint; y++)
		  {
			  topPixel = getPixel(x,y);
			  bottomPixel = getPixel(x, height - 1 - y);
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
	  
  }
  
  /*
   * move only a section
   * 
   */
  
  public void mirrorTemple()
  {
	  /*
	   * startTop x, y = 13, 27
	   * endtop   x, y = 276,27
	   * startBottom x, y = 13, 97
	   * endBottom x, y = 276, 97
	   * 
	   */
	  
	  int mirrorPoint = 276;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  
	  // loop through row
	  for (int y = 27; y < 28; y++)	// to 97
	  {
		  // loop through column
		  for (int x = 13; x < 17; x++)	// to 276
		  {
			  System.out.println("Copying clor from " + x + " to " + (mirrorPoint + (mirrorPoint - x)));
			  leftPixel = getPixel(x, y);
			  rightPixel = getPixel(mirrorPoint + (mirrorPoint - x), y);
			  rightPixel.setColor(leftPixel.getColor());
			  count = count + 1;
		  }
	  }
  }
  
  
  
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
 
  public static void main(String[] args) 
  {
     //String fileName = FileChooser.pickAFile();
	 //String fileName = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/caterpillar.jpg";
     String fileName = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/temple.jpg";
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
     //pictObj.mirrorHorizontalBottomToTop();		// program 20
     //pictObj.repaint();
     
     /*
     pictObj.lighten2();			// program 18
     pictObj.mirrorVertical();		// program 19
     pictObj.mirrorHorizontal();	// program 20
     pictObj.explore();
     */
  }
  
} // this } is the end of class Picture, put all new methods before this
 