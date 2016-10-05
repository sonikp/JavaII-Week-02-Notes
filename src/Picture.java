import java.awt.*;
import java.awt.color.*;
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
	 * Adjust red method to try as a example from
	 * the class lesson text
	 */
  public void adjustRedForLoop(int deltaFactor)
  {
	  Pixel[] pixelArray = this.getPixels();
	  int value = 0;
	  for (Pixel pixel:pixelArray)
	  {
		  value = pixel.getRed();
		  value = (int) (value * deltaFactor);	// adjust red by deltaFactor
		  pixel.setRed(value);
	  }
  }
  
  		/*
  		 * exercise while loop
  		 * adjust red using a while loop
  		 */
  public void adjustRedWhileLoop(int deltaFactor)
  {
	  Pixel[] pixelArray = this.getPixels();
	  int value = 0;
	  int pixIndex = 0;
	  boolean done = false;
	  
	  while(!done)
	  {
		  value = pixelArray[pixIndex].getRed();
		  value = (int)(value * deltaFactor);	// adjust red by deltaFactor
		  pixelArray[pixIndex].setRed(value);
		  pixIndex++;
		  
		  if (pixIndex == pixelArray.length)
		  {
			  done = true;
		  }
	  }
  }
  
  /*
   * Program 16: grayscale 
   *  incidental method that did not appear in the book
   * for some reason
   * found here: http://slideplayer.com/slide/8381573/
   */
  
  public void grayscale()
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixelObj = null;
	  int intensity = 0;
	  
	  // loop through all the pixels
	  for ( int i = 0; i < pixelArray.length; i++)
	  {
		  // get the current pixel
		  pixelObj = pixelArray[i];
		  
		  // compute the average intensity
		  intensity = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
		  
		  // set the pixel color
		  pixelObj.setColor(new Color(intensity,intensity,intensity));
	  }
  }
  
  
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
   * Program 26: Creating a Collage by copying Flowers
   * 
   * Method to copy flower pictures to create a collage. All the flower pictures will be lined up near
   * the bottom of the current picture (5 pixels from the bottom)
   */
  
  public void copyFlowers()
  {
	  // create the flower pictures
	  Picture flower1Picture = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/flower1.jpg");
	  System.out.println(flower1Picture);
	  Picture flower2Picture = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/flower2.jpg");
	  
	  // declare the source and target pixel variables
	  Pixel sourcePixel = null;
	  Pixel targetPixel = null;
	  
	  // save the height of the two pictures
	  int flower1Height = flower1Picture.getHeight();
	  int flower2Height = flower2Picture.getHeight();
	  flower1Picture.show();
	  flower2Picture.show();
	  
	  // copy the first flower picture to 5 pixels from the bottom left corner of the current picture
	  for ( int sourceX = 0, targetX = 0; sourceX < flower1Picture.getWidth(); sourceX++, targetX++)
	  {
		  for ( int sourceY = 0, targetY = 0; sourceY < flower1Picture.getHeight(); sourceY++, targetY++)
		  {
			  sourcePixel = flower1Picture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
	  //flower1Picture.explore();
	  //flower2Picture.explore();
	  
	  // copy the clower2 picture starting with x = 100;
  }
  
  
  /*
   * Program 30: Scaling down a picture (Smaller)
   * 
   */
  public void copyPictureSmaller()
  {
	  String filePic = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/katie.jpg";
	  Picture thePicture = new Picture(filePic);
	  System.out.println(thePicture);
	  Pixel sourcePixel = null;
	  Pixel targetPixel = null;
	  
	  // loop through columns
	  for ( int sourceX = 0, targetX = 0; sourceX < thePicture.getWidth(); sourceX+=2, targetX++ )
	  {
		  //loop through rows
		  for ( int sourceY = 0, targetY = 0; sourceY < thePicture.getHeight(); sourceY+=2, targetY++ )
		  {
			  sourcePixel = thePicture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
  }
  
  /*
   * Program: 31 Scaling the Picture Up (Larger)
   * Method to copy a flower but scaled to a 2x 
   * normal size onto the current picture
   */
  
  public void copyPictureLarger()
  {
	  Picture thePicture = new Picture(FileChooser.getMediaPath("rose.jpg"));
	  Pixel sourcePixel = null;
	  Pixel targetPixel = null;
	  
	  // loop through columns
	  for ( double sourceX = 0, targetX = 0; sourceX < thePicture.getWidth(); sourceX = sourceX + 0.5, targetX++)
	  {
		  // loop through the rows
		  for ( double sourceY = 0, targetY = 0; sourceY < thePicture.getHeight(); sourceY = sourceY + 0.5, targetY++)
		  {
			  sourcePixel = thePicture.getPixel((int) sourceX, (int) sourceY);
			  targetPixel = this.getPixel((int) targetX, (int) targetY);
			  targetPixel.setColor(sourcePixel.getColor());
					  
		  }
	  }
	  
  }
  
  /*
   * Program 33: Color Replacement: Turns Brown to Red
   * 
   * 
   */
  
  public void turnBrownIntoRed()
  {
	  Color brown = new Color(42,25,15);
	  Pixel[] pixels = this.getPixels();
	  Pixel pixel = null;
	  
	  // loop through the pixels
	  for ( int i = 0; i < pixels.length; i++)
	  {
		  // get the current pixels
		  pixel = pixels[i];
		  
		  // check if distance to brown and if so double the red
		  if (pixel.colorDistance(brown) < 50.0)
		  {
			  pixel.setColor(new Color((int) (pixel.getRed() * 2.0), pixel.getGreen(), pixel.getBlue()));
			  
		  }
	  }
	  
  }
  
  /*
   * Program 34: Color Replacements in a Rectangular Area
   * 
   */
  public void turnBrownToRedInRectangle()
  {
	  Color brown = new Color(42,25,15);
	  Pixel pixel = null;
	  
	  // head top x = 63 y = 10, bottom x = 140 y = 72
	  
	  // loop through the x values
	  for ( int x = 63; x < 140; x++)
	  {
		  for ( int y = 10; y < 72; y++)
		  {
			  // get current pixel
			  pixel = this.getPixel(x, y);
			  
			  // check if distance to brown and if so double red
			  if (pixel.colorDistance(brown) < 50.0)
			  {
				  pixel.setColor(new Color((int)(pixel.getRed() * 2.0), pixel.getGreen(), pixel.getBlue()));
				  
			  }
		  }
	  }
  }
  
  /*
   * program 35; Color replacements with passing in a range
   * 
   * specifying startX, endX-1, startY, endY-1
   * 
   */
  
  public void turnBrowntoRedInRectangleDimensions(int startX, int endX, int startY, int endY, double distance)
  {
	  Color brown = new Color(42,25,15);
	  Pixel pixel = null;
	  
	  // loop through the x values
	  for (int x = startX; x < endX; x++)
	  {
		  // loop through the Y values
		  for (int y = startY; y < endY; y++)
		  {
			  // get the current pixel
			  pixel = this.getPixel(x, y);
			  
			  // check if distance to brown is less than the passed distance, and if so double red
			  if (pixel.colorDistance(brown) < distance)
			  {
				  pixel.setColor(new Color((int)(pixel.getRed() * 2.0), pixel.getGreen(), pixel.getBlue()));
				  
			  }
			  
		  }
	  }
  }
  
  /*
   * program 36: remove red-eye
   * Method to remove red-eye from the current picture object
   * The red will be replaced with the passed newColor
   * @param startX top LH corner x value of a rectangle
   * @param startY top LH corner y value of a rectangle
   * @param endX bottom RH corner x value of a rectangle
   * @param endY bottom RH corner y value of a rectangle
   */
  
  public void removeRedEye(int startX, int startY, int endX, int endY, Color newColor)
  {
	  Pixel pixel = null;
	  
	  // loop through the (column) pixels in the rectangle defined by input values
	  for ( int x = startX; x < endX; x++)
	  {
		  // loop through the rows
		  for ( int y = startY; y < endY; y++)
		  {
			  // get current pixel
			  pixel = this.getPixel(x, y);
			  
			  // conditional, if pixel color is near red, the change it
			  if (pixel.colorDistance(Color.red) < 167 )
			  {
				  pixel.setColor(newColor);
				  
			  }
		  }
	  }
  }
  
  /*
   * program: 37 Edge Detection
   * Method to do simple edge detection
   * comparing the absolute value of the difference between the color intensities.
   * 
   * If the absolute value of the difference between the color intensities is less that a passed amount
   * the top pixel color will be set to white. Otherwise it will be set to black
   * @param amount of the absolute value of the differences in the color average is less that this set the color to white
   * 
   */
  public void edgeDetection(double amount)
  {
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  double topAverage = 0.0;
	  double bottomAverage = 0.0;
	  int endY = this.getHeight() - 1;
	  
	  // loop through y values from 0 to height - 1, (since compare to below pixel)
	  for ( int y = 0; y < endY; y++)
	  {
		  // loop through the x values from 0 to width
		  for ( int x = 0; x < this.getWidth(); x++)
		  {
			  // get the top and bottom pixels
			  topPixel = this.getPixel(x, y);
			  bottomPixel = this.getPixel(x, y + 1);
			  
			  // get the color average for the two pixels
			  topAverage = topPixel.getAverage();
			  bottomAverage = bottomPixel.getAverage();
			  
			  // check if absolute value of the difference is less than the amount
			  if ( Math.abs(topAverage - bottomAverage) < amount)
			  {
				  topPixel.setColor(Color.WHITE);
			  }
			  else
			  {
				  topPixel.setColor(Color.BLACK);
			  }
		  }
	  }
  }
  
  
  public void edgeDetectionRange(double amount)
  {
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  double topAverage = 0.0;
	  double bottomAverage = 0.0;
	  int endY = this.getHeight() - 1;	// now unused
	  // problem 6.3, limit edge detection
	  int yStart = (this.getWidth() / 4);
	  int yEnd = ((this.getWidth() / 4) * 3);
	  int xStart = (this.getHeight() / 4);
	  int xEnd = ((this.getHeight() / 4) * 3);
	  
	  // loop through y values from 0 to height - 1, (since compare to below pixel)
	  for ( int y = yStart; y < yEnd; y++)	// int y = (0 + ((int)0.25 * endY)); y < (endY * (int) 0.75); y++
	  {
		  // loop through the x values from 0 to width
		  for ( int x = xStart; x < xEnd; x++)
		  {
			  // get the top and bottom pixels
			  topPixel = this.getPixel(x, y);
			  bottomPixel = this.getPixel(x, y + 1);
			  
			  // get the color average for the two pixels
			  topAverage = topPixel.getAverage();
			  bottomAverage = bottomPixel.getAverage();
			  
			  // check if absolute value of the difference is less than the amount
			  if ( Math.abs(topAverage - bottomAverage) < amount)
			  {
				  topPixel.setColor(Color.WHITE);
			  }
			  else
			  {
				  topPixel.setColor(Color.BLACK);
			  }
		  }
	  }
  }
  
  
  
  /*
   * program 38:
   * Method to change the current picture to a sepia tint, (modify middle colors to a light brown
   * and the light colors to a light yellow and make the shadows darker)
   */
  
  public void sepiaTint()
  {
	  Pixel pixel = null;
	  double redValue = 0;
	  double greenValue = 0;
	  double blueValue = 0;
	  
	  // first change the current picture to grayscale, create grayscale method
	  this.grayscale();
	  
	  // loop through pixels
	  for ( int x = 0; x < this.getWidth(); x++)
	  {
		  for ( int y = 0; y < this.getHeight(); y++)
		  {
			  // get the current pixel and color value
			  pixel = this.getPixel(x, y);
			  redValue = pixel.getRed();
			  greenValue = pixel.getGreen();
			  blueValue = pixel.getBlue();
			  
			  // tint the shadows darker
			  if (redValue < 60)
			  {
				  redValue = redValue * 0.9;
				  greenValue = greenValue * 0.9;
				  blueValue = blueValue * 0.9;
			  }
			  
			  // tint mid-tones a light brown by reducing the blue
			  else if (redValue < 190)
			  {
				  blueValue = blueValue * 0.8;
			  }
			  
			  // tint highlights a light yellow by reducing blue
			  else 
			  {
				  blueValue = blueValue * 0.9;
			  }
			  
			  // set the colors
			  pixel.setRed((int)(redValue));
			  pixel.setGreen((int)(greenValue));
			  pixel.setBlue((int)(blueValue));
					  
		  }
	  }
  }
  
  /*
   * Problem 6.4 within a range
   */
  
  public void sepiaTintRange()
  {
	  Pixel pixel = null;
	  double redValue = 0;
	  double greenValue = 0;
	  double blueValue = 0;
	  // problem 6.3, limit edge detection
	  int yStart = (this.getWidth() / 4);
	  int yEnd = ((this.getWidth() / 4) * 3);
	  int xStart = (this.getHeight() / 4);
	  int xEnd = ((this.getHeight() / 4) * 3);
	  
	  // first change the current picture to grayscale, create grayscale method
	  this.grayscale();
	  
	  // loop through pixels
	  for ( int x = xStart; x < xEnd; x++)
	  {
		  for ( int y = yStart; y < yEnd; y++)
		  {
			  // get the current pixel and color value
			  pixel = this.getPixel(x, y);
			  redValue = pixel.getRed();
			  greenValue = pixel.getGreen();
			  blueValue = pixel.getBlue();
			  
			  // tint the shadows darker
			  if (redValue < 60)
			  {
				  redValue = redValue * 0.9;
				  greenValue = greenValue * 0.9;
				  blueValue = blueValue * 0.9;
			  }
			  
			  // tint mid-tones a light brown by reducing the blue
			  else if (redValue < 190)
			  {
				  blueValue = blueValue * 0.8;
			  }
			  
			  // tint highlights a light yellow by reducing blue
			  else 
			  {
				  blueValue = blueValue * 0.9;
			  }
			  
			  // set the colors
			  pixel.setRed((int)(redValue));
			  pixel.setGreen((int)(greenValue));
			  pixel.setBlue((int)(blueValue));
					  
		  }
	  }
  }
  
  
  
  /*
   * program 39: posterizing a picture
   * method to posterize (reduce the number of colors) in
   * the picture. the number of reds, greens and blues
   * will be 4
   */
  public void posterize()
  {
	  Pixel pixel = null;
	  int redValue = 0;
	  int greenValue = 0;
	  int blueValue = 0;
	  
	  // loop through the rows of pixels
	  for ( int x = 0; x < this.getWidth(); x++)
	  {
		  // loop through the columns of pixels
		  for ( int y = 0; y < this.getHeight(); y++)
		  {
			  // get current pixel and color
			  pixel = this.getPixel(x, y);
			  redValue = pixel.getRed();
			  greenValue = pixel.getGreen();
			  blueValue = pixel.getBlue();
			  
			  
			  // check for red color range and change red color
			  if (redValue < 64)
			  {
				  redValue = 31;
			  }
			  else if (redValue < 128)
			  {
				  redValue = 95;
			  }
			  else 
			  {
				  redValue = 223;
			  }
			  
			// check for green color range and change green color
			  if (greenValue < 64)
			  {
				  greenValue = 31;
			  }
			  else if (greenValue < 128)
			  {
				  greenValue = 95;
			  }
			  else 
			  {
				  greenValue = 223;
			  }
			  
				// check for blue color range and change blue color
			  if (blueValue < 64)
			  {
				  blueValue = 31;
			  }
			  else if (blueValue < 128)
			  {
				  blueValue = 95;
			  }
			  else 
			  {
				  blueValue = 223;
			  }
			  
			  // set the colors
			  pixel.setRed(redValue);
			  pixel.setGreen(greenValue);
			  pixel.setBlue(blueValue);
		  }
	  }
  }
  
  /*
   * program 40: posterizing by level
   * Method to posterize (reduce the number of colors) in the picture
   * @param numLevels the number of color levels to use
   * 
   */
  
  public void posterizeLevel(int numLevels)
  {
	  Pixel pixel =  null;
	  int redValue = 0;
	  int greenValue = 0;
	  int blueValue = 0;
	  int increment = (int) (256.0 / numLevels);
	  int bottomValue, topValue, middleValue = 0;
	  
	  // loop through the columns of the pixels
	  for ( int x = 0; x < this.getWidth(); x++)
	  {
		  for ( int y = 0; y < this.getHeight(); y++)
		  {
			  // get current pixel and color
			  pixel = this.getPixel(x, y);
			  redValue = pixel.getRed();
			  greenValue = pixel.getGreen();
			  blueValue = pixel.getBlue();
			  
			  // loop through number levels
			  for ( int i = 0; i < numLevels; i++)
			  {
				  // compute the bottom, top, middle values
				  bottomValue = i * increment;
				  topValue = (i + 1) * increment;
				  middleValue = (int) ((bottomValue + topValue - 1) / 2.0);
				  
				  // check if current values are in current range and if
				  // so set them to the middle value
				  
				  if ( bottomValue <= redValue && redValue < topValue)
				  {
					  pixel.setRed(middleValue);
				  }
				  if ( bottomValue <= greenValue && greenValue < topValue)
				  {
					  pixel.setGreen(middleValue);
				  }
				  if ( bottomValue <= blueValue && greenValue < topValue)
				  {
					  pixel.setBlue(middleValue);
				  }
			  }
		  }
	  }
  }
  
  /*
   * program 41: highlight extremes
   * Method to replace the pixel colors in the current picture
   * object that have a color distance with the passed replacement color
   * @param replacementColor the new color to use
   */
  public void highlightLightAndDark(double amount, Color replacementColor)
  {
	  Pixel pixel = null;
	  
	  
	  // loop through all the pixels in the x direction
	  for ( int x = 0; x < getWidth(); x++)
	  {
		  // loop through all the pixels in the y direction
		  for ( int y = 0; y < getHeight(); y++)
		  {
			  // get current pixel
			  pixel = this.getPixel(x, y);
			  
			  // if the distance from white to black is less that the 
			  //passed amount use the replacement color instead
			  if ( pixel.colorDistance(Color.white) < amount || 
					  pixel.colorDistance(Color.black) < amount)
			  {
				  pixel.setColor(replacementColor);
				  
			  }
		  }
	  }
  }
  
  /*
   * program 42: A Simple Blur
   * Method to blur pixels
   * @param numPixels the number of pixels to average in all directions
   * If the numPixel is 2 then we will average all pixels in the rectangle
   * defined by 2 before the current pixel to 2 after the current pixel
   */
  
  public void blur(int numPixels)
  {
	  Pixel pixel = null;
	  Pixel samplePixel = null;
	  int redValue = 0;
	  int greenValue = 0;
	  int blueValue = 0;
	  int count = 0;
	  
	  // loop through the columns of the pixels
	  for ( int x = 0; x < this.getWidth(); x++)
	  {
		  //loop through the rows of the pixels
		  for ( int y = 0; y < this.getHeight(); y++)
		  {
			  // get the current pixel
			  pixel = this.getPixel(x, y);
			  
			  // reset the count and red, green, blue values
			  count = 0;
			  redValue = greenValue = blueValue = 0;
			  
			  // loop through pixel numPixel before x to numPixel after x
			  for ( int xSample = x - numPixels; xSample <= x + numPixels; xSample++)
			  {
				  for ( int ySample = y - numPixels; ySample <= y + numPixels; ySample++)
				  {
					  // check if we are in range of acceptable pixels
					  if (xSample >= 0 && xSample < this.getWidth() && ySample >= 0 && ySample < this.getHeight())
					  {
						  samplePixel = this.getPixel(xSample, ySample);
						  redValue = redValue + samplePixel.getRed();
						  greenValue = greenValue + samplePixel.getGreen();
						  blueValue = blueValue + samplePixel.getBlue();
						  count = count + 1;
					  }
				  }
			  }
			  
			  // use average color of surrounding pixels
			  Color newColor = new Color(redValue / count, greenValue / count, blueValue / count);
			  pixel.setColor(newColor);
			  
		  }
	  }
	  
  }
  
  /*
   * Program 43: subtract the background and replace itwith a new one
   * 
   * Method to replce the background from the current picture
   * with the background from another picture
   * @param oldBackground a picture with the old background
   * @param newBackground a picture with the new background
   */
  public void swapBackground(Picture oldBackground, Picture newBackground)
  {
	  Pixel currPixel = null;
	  Pixel oldPixel = null;
	  Pixel newPixel = null;
	  
	  // loop through the columns
	  for ( int x = 0; x < this.getWidth(); x++)
	  {
		  for ( int y = 0; y < this.getHeight(); y++)
		  {
			  // get the current pixel
			  currPixel = this.getPixel(x, y);
			  oldPixel = oldBackground.getPixel(x, y);
			  
			  // if the distance between the current pixel color and the old background
			  // pixel color is less than 15 then swap in the new background
			  
			  if ( currPixel.colorDistance(oldPixel.getColor()) < 15.0 )
			  {
				  newPixel = newBackground.getPixel(x, y);
				  currPixel.setColor(newPixel.getColor());
			  }
			  
		  }
	  }
  }
  
  /*
   * program 45: Chromakey: replace all blue with the new background
   */
  
  public void chromakey(Picture newBg)
  {
	  Pixel currPixel = null;
	  Pixel newPixel = null;
	  int x,y;
	  
	  // loop through columns
	  for (  x = 0; x < this.getWidth() - 1; x++ );
	  {
		  // loop through rows
		  for (  y = 0; y < this.getHeight() - 1; y++ );
		  {
			// get current pixel
			  currPixel = this.getPixel(x,y);
			  
			  /*
			   * If the color at the current pixel is mostly blue (blue value is greater than red & green
			   * value combined), then use new background color
			   */
			  if ( currPixel.getRed() + currPixel.getGreen() < currPixel.getBlue())
			  {
				  newPixel = newBg.getPixel(x, y);
				  currPixel.setColor(newPixel.getColor());
			  }
		  }
	  }
  }
  
  /*
   * program 45: edited for problem 6.2
   * 
   */
  
  public void chromakeyProblemExercise(Picture newBg)
  {
	  Pixel currentPixel = null;
	  Pixel newPixel =  null;
	  
	  // loop through current columns
	  for ( int x = 0; x < this.getWidth() - 1; x++)
	  {
		  // loop through current rows
		  for ( int y = 0; y < this.getHeight() - 1; y++)
		  {
			  // get current pixel
			  currentPixel = this.getPixel(x, y);
			  //if ( currentPixel.getRed() + currentPixel.getGreen() < currentPixel.getBlue())	// r = 155 - 190 
			  
			  if ( currentPixel.getRed() + currentPixel.getGreen() < currentPixel.getBlue() )				// (currentPixel.getRed() >= 155 && currentPixel.getRed() >= 190) && (currentPixel.getBlue() >= 200 && currentPixel.getBlue() >= 230)
			  {
				  newPixel = newBg.getPixel(x, y);
				  currentPixel.setColor(newPixel.getColor());
			  }
			  
		  }
	  }
	 
  }
  
  
  /***********************************************************************
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
	  
	  System.out.println("blank");
	  
	  // @Lnx
	  //String sourceFile = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/KatieFancy.jpg";
	  // @MAC
	  //String sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/blue-mark.jpg";
	
	  
	  Picture p = new Picture();
	  p.copyFlowers();
	  
	  /*
	  String fileName =  "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/butterfly1.jpg";
	  Picture p = new Picture(fileName);
	  System.out.println(p);
	  p.explore();
	  p.sepiaTintRange();
	  p.explore();
	  */
	  
	  // homework for 6.2 didn't work
	  /*
	  // get the clock face
	  String sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/clock-tower.jpg";
	  Picture mark = new Picture(sourceFile);
	  //mark.explore();
	  
	  // replace with Marks face
	  sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/blue-mark.jpg";
	  Picture newBg = new Picture(sourceFile);
	  //newBg.explore();
	  mark.chromakey(newBg);
	  newBg.explore();
	  */
	  
	  

	  
	  
	  
	  
	  /*
	  // program 43:
	  
	  String fileName = FileChooser.getMediaPath("kid-in-frame.jpg");
	  Picture p = new Picture(fileName);
	  
	  fileName = FileChooser.getMediaPath("bgframe.jpg");
	  Picture oldBg = new Picture(fileName);
	  
	  fileName = FileChooser.getMediaPath("moon-surface.jpg");
	  Picture newBg = new Picture(fileName);
	  p.swapBackground(oldBg, newBg);		// program 43
	  p.show();
	  
	  */
	  
	  /*
	  String sourceFile = FileChooser.getMediaPath("kid-in-frame.jpg");
	  System.out.println(sourceFile);
	  Picture picObject =  new Picture(sourceFile);

	  //picObject.show();
	  picObject.blur(20);	// program 42 : this takes a while, be patience
	  picObject.explore();
	  */
	  //picObject.turnBrowntoRedInRectangleDimensions(109,91,190,107,20); // program: 35
	  //picObject.explore();
	  
	  
	  
	  
	  // ----------------------scribble notes below here------------------------
	  //picObject.copyPictureLarger();
	  
	  
	  
	 
     /*
	 //String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/temple.jpg";
	 //String fileName = FileChooser.getMediaPath("7inX95in.jpg");
     //String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/7inX95in.jpg";
	 
	 // String fileName = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/caterpillar.jpg"; //FileChooser.getMediaPath("rose.jpg");
	  															
	 // System.out.println(fileName);
	  Picture picFile = new Picture();
	 // System.out.println(picFile);
	  picFile.copyPictureSmaller();	// program 30
	  picFile.show();
	  */
	  
	  
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
     picFile.copyPictureSmaller();	// program 30
     picObject.copyPictureLarger();	// program 31
     picObject.adjustRedWhileLoop(10);
     picObject.turnBrownIntoRed();	// program 33
	 picObject.turnBrownToRedInRectangle();	// program 34
	 picObject.turnBrowntoRedInRectangleDimensions(109,91,190,107,20); // program: 35
	 picObject.removeRedEye(109, 91, 202, 107, java.awt.Color.black);	// program: 36
	 picObject.edgeDetection(10);	// program: 37
	 picObject.posterize();	// program 39
	 picObject.posterizeLevel(3);	// program 40
	 picObject.highlightLightAndDark(50.0, java.awt.Color.yellow);	// program 41
	 picObject.blur(20);	// program 42 : this takes a while, be patience
	   p.swapBackground(oldBg, newBg);		// program 43
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
 