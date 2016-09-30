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
	   * Program 22: copy a section of the temple roof
	   * startTop x, y = 13, 27
	   * endtop   x, y = 276,27
	   * startBottom x, y = 13, 97
	   * endBottom x, y = 276, 97
	   * 
	   */
	  
	  int mirrorPoint = 276;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int count = 0;
	  
	  // loop through row
	  for (int y = 27; y < 97; y++)	// to 97
	  {
		  // loop through column
		  for (int x = 13; x < mirrorPoint; x++)	// to 276
		  {
			  //System.out.println("Copying color from " + x + " to " + (mirrorPoint + (mirrorPoint - x)));
			  leftPixel = getPixel(x, y);
			  rightPixel = getPixel(mirrorPoint + (mirrorPoint - x), y);
			  rightPixel.setColor(leftPixel.getColor());
			  count = count + 1;
		  }
	  }
	  System.out.println("Copied " + count + " pixels");
  }
  
  /*
   * Program 23: Copying a Picture to the Current Picture
   * 
   * Method to copy the picture of Katie to the upper left 
   * corner of the current picture
   * 
   */
  
  public void copyKatie()
  {
	String sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/KatieFancy.jpg";
	Picture sourcePicture = new Picture(sourceFile);
	Pixel sourcePixel = null;
	Pixel targetPixel = null;
	
	// loop through the columns
	for ( int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX++, targetX++)		
	{
		// loop through the rows
		for ( int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++)		
		{
			// set target pixel color to the source pixel color
			
			sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
			targetPixel = this.getPixel(targetX, targetY);
			targetPixel.setColor(sourcePixel.getColor());
			
		}
	}
		
  }
  
  
  /*
   * Program 25: Copying a Picture to the Current Picture
   * 
   * Method to copy the picture of Katie to the upper left 
   * corner of the current picture
   * 
   */
  
  public void copyKatiesFace()
  {
	String sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/KatieFancy.jpg";
	Picture sourcePicture = new Picture(sourceFile);
	Pixel sourcePixel = null;
	Pixel targetPixel = null;
	
	// loop through the columns
	for ( int sourceX = 70, targetX = 100; sourceX < 135; sourceX++, targetX++)		// sourcePicture.getWidth()
	{
		// loop through the rows
		for ( int sourceY = 3, targetY = 100; sourceY < 80; sourceY++, targetY++)		// sourcePicture.getHeight()
		{
			// set target pixel color to the source pixel color
			
			sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
			targetPixel = this.getPixel(targetX, targetY);
			targetPixel.setColor(sourcePixel.getColor());
			
		}
	}
		
  }
  
  /*
   * Program 30: Scaling down a picture (Smaller)
   * 
   */
  public void copyJakitaSmaller()
  {
	  String filePic = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/katie.jpg";
	  Picture jakitaPicture = new Picture(filePic);
	  System.out.println(jakitaPicture);
	  Pixel sourcePixel = null;
	  Pixel targetPixel = null;
	  
	  // loop through columns
	  for ( int sourceX = 0, targetX = 0; sourceX < jakitaPicture.getWidth(); sourceX+=2, targetX++ )
	  {
		  //loop through rows
		  for ( int sourceY = 0, targetY = 0; sourceY < jakitaPicture.getHeight(); sourceY+=2, targetY++ )
		  {
			  sourcePixel = jakitaPicture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(sourcePixel.getColor());
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

	 
     
	 //String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/temple.jpg";
	 //String fileName = FileChooser.getMediaPath("7inX95in.jpg");
     //String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/7inX95in.jpg";
	 
	  String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/katie.jpg";
	  System.out.println(fileName);
	  Picture picFile = new Picture(fileName);
	  System.out.println(picFile);
	  picFile.copyJakitaSmaller();	// program 30
	  picFile.show();
	  
	  
	  
	  /*
	  String filePic = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/katie.jpg";
	  Picture jakitaPicture = new Picture(filePic);
	  jakitaPicture.show();
	  */
	  
	/*
	 String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/7inX95in.jpg";
	 Picture pictObj = new Picture(fileName);
     pictObj.show();
     */
	  
     /*
     pictObj.copyJakitaSmaller();		// program 22
     pictObj.repaint();
     */

     
     /*
     pictObj.lighten2();			// program 18
     pictObj.mirrorVertical();		// program 19
     pictObj.mirrorHorizontal();	// program 20
     pictObj.mirrorHorizontalBottomToTop();		// program 21
     pictObj.mirrorTemple();		// program 22
     pictObj.copyKatie();		// program 23
     pictObj.copyKatiesFace();		// program 25
     picFile.copyJakitaSmaller();	// program 30

     pictObj.explore();
     */
     
     /*
     // random crazy notes"
          //String fileName = FileChooser.pickAFile();
	 //String fileName = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/caterpillar.jpg";
     //String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/caterpillar.jpg";
     // String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/caterpillar.jpg";
	  
	  
	  //String fileName = FileChooser.pickAFile();
	  //System.out.println(fileName);
	  
	  //System.out.println(FileChooser.pickAFile());
	  //"//Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/Assignments/wk02/"

	  // gets media path for a filename
	  //System.out.println(FileChooser.getMediaPath("temple.jpg"));
      
	  // sets media path, I guess for saving
	  //FileChooser.setMediaPath("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/Assignments/wk02/");
     */
  }
  
} // this } is the end of class Picture, put all new methods before this
 