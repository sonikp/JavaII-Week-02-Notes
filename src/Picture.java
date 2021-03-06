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
   * program 5: Decrease the Amount of Red in a Picture by 50%
   * 
   * A method to decrease the red by half in the current picture
   */
  public void decreaseRed()
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  int value = 0;
	  int index = 0;
	  /*
	  // Show all pixels
	  for (Pixel showValue : pixelArray) 
	  {
		    System.out.println(showValue);
	  }
	  */
	  
	  // loop through all pixels
	  while ( index < pixelArray.length)
	  {
		  // get the current pixel
		 pixel = pixelArray[index];
		 
		 // get the value
		 value = pixel.getRed();
		 
		 // decrease value by 50%
		 value = value * (int)0.5;
		 
		 // set pixel value
		 pixel.setRed(value);
		 
		 // increment counter by 1
		 index++;
	  }
  }
  
  /*
   * Problem 5.7 reduce redness by a parameter
   */
  public void decreaseRed(int parameter)
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  int index = 0;
	  int valueRed = 0;
	  System.out.println(parameter);
	  
	  while ( index < pixelArray.length)
	  {
		  // get pixels
		  pixel = pixelArray[index];
		  
		  // get red color value
		  valueRed = pixel.getRed();
		  
		  // reduce value by a specified parameter amount
		  pixel.setRed(valueRed - parameter);
		  
		  index++;
		  
	  }
	  
  }
  
  
  /*
   * Problem 4.5 reduce the redness by 10% and again by 20%
   */
  public void reduceRedness(int inputNum)
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  int value = 0;
	  int index = 0;
	  double reductionAmount = 1 - ((double)inputNum / 100);
	  System.out.println(reductionAmount);
	  
	  // loop through all the pixels using a while loop
	  while (index < pixelArray.length)
	  {
		  // get the current pixel
		  pixel = pixelArray[index];
		  
		  // get color value
		  value = pixel.getRed();

		  //reduce redness by selected % amount
		  pixel.setRed((int)(value * reductionAmount));

		  index++;
	  }
  }
  
  /*
   * program 6: Increase the Amount of Red in a Picture by 30%
   * 
   * A method to increase the red by half in the current picture
   */
  public void increaseRed()
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  int value = 0;
	  int index = 0;
	  /*
	  // Show all pixels
	  for (Pixel showValue : pixelArray) 
	  {
		    System.out.println(showValue);
	  }
	  */
	  
	  // loop through all pixels
	  while ( index < pixelArray.length)
	  {
		  // get the current pixel
		 pixel = pixelArray[index];
		 
		 // get the value
		 value = pixel.getRed();
		 
		 // decrease value by 50%
		 value = (int)(value * 1.3);
		 
		 // set pixel value
		 pixel.setRed(value);
		 
		 // increment counter by 1
		 index++;
	  }
  }
  // Chapter 04 - Problem 4.6
  public void increaseRed2()
  {
	  Pixel[] pixelArray = this.getPixels();
	  int value = 0;
	
	  // loop through the pixels
	  for ( int i = 0; i < pixelArray.length; i++)
	  {
		  // get the current pixel
		 value = pixelArray[i].getRed();
		 
		 // set red 1.3 * what it was
		 pixelArray[i].setRed((int)(value * 1.3));

	  }
  }
  
//Chapter 04 - Problem 4.6
 public void increaseRed3()
 {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  int red = 0;
	  int green = 0;
	  int blue = 0;
	  int newRed = 0;

	  // loop through all pixels
	  for ( int i = 0; i < pixelArray.length; i++)
	  {
		  // get the current pixel
		 pixel = pixelArray[i];
		 
		 // get the color values
		 red = pixel.getRed();
		 green = pixel.getGreen();
		 blue = pixel.getBlue();

		 // calculate new red
		 newRed = (int)(red * 1.3);
		 
		 // set pixel value
		 pixel.setColor(new Color(newRed, green, blue));

	  }
 }
  
  /*
   * Program 7: Clear the blue component from the picture (set the blue to 0)
   */
  public void clearBlue()
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  int index = 0;
	  
	  // loop through pixels
	  while ( index < pixelArray.length )
	  {
		  // get current pixel
		  pixel = pixelArray[index];
		  
		  //set blue
		  pixel.setBlue(0);
			
		  // increment counter
		  index++;
				  
	  }
  }
  
//-------------Chapter 04 Problem 4.9------------- 
  public void clearRed()
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  
	  // loop through the pixels
	  for ( int i = 0; i < pixelArray.length; i++)
	  {
		  // get color array
		  pixel = pixelArray[i];		
		  
		  // clear red
		  pixel.setRed(0);
		 
	  }
  }
  
//-------------Chapter 04 Problem 4.9------------- 
  public void clearGreen()
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  
	  // loop through the pixels
	  for ( int i = 0; i < pixelArray.length; i++)
	  {
		  // get color array
		  pixel = pixelArray[i];		
		  
		  // clear red
		  pixel.setGreen(0);
		 
	  }
  }
  
//-------------Chapter 04 Problem 4.10------------- 
  public void keepGreen()
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  int red = 0;
	  int green = 0;
	  int blue = 0;
	  
	  // loop through the pixels
	  for ( int i = 0; i < pixelArray.length; i++)
	  {
		  // get pixels & values
		  pixel = pixelArray[i];
		  System.out.print(pixel + "  \t");
		  
		  // get green color
		  green = pixel.getGreen();
		  
		  // reset all colors & keep green
		  pixel.setColor(new Color(red, green, blue));
		  System.out.print(pixel + "  \n");
		  
	  }
  }
  
//-------------Chapter 04 Problem 4.10------------- 
  public void keepBlue()
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  int value =  0;
	  int red = 0;
	  int green = 0;
	  
	  // loop through pixels
	  for ( int i = 0; i < pixelArray.length; i++)
	  {
		  // get colors
		  pixel = pixelArray[i];
		  
		  // get blue
		  value = pixel.getBlue();
		  
		  // set colors
		  pixel.setColor(new Color(red, green, value));
		  
	  }
  }
  
//-------------Chapter 04 Problem 4.11------------- 
  public void maximizeBlue()
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  int red = 0;
	  int green = 0;
	  int blue = 255;
	  
	  // loop through the pixels
	  for ( int i = 0; i < pixelArray.length; i++)
	  {
		  // get pixels & values
		  pixel = pixelArray[i];
		  System.out.print(pixel + "  \t");
		  
		  // get green color
		  green = pixel.getGreen();
		  
		  // reset all colors & keep green
		  pixel.setColor(new Color(red, green, blue));
		  System.out.print(pixel + "  \n");
		  
	  }
  }
  
  
  
  /*
   * Program 15: Create the Negative of the Original Picture
   * method to negate the picture
   */
  
  public void negate()
  {
	  Pixel[] pixelArray = this.getPixels();
	  Pixel pixel = null;
	  int redValue, blueValue, greenValue = 0;
	  
	  // loop through all pixels
	  for ( int i = 0; i < pixelArray.length; i++)
	  {
		  // get the current pixel
		  pixel = pixelArray[i];
		  
		  // get the current red, green, blue values
		  redValue = pixel.getRed();
		  greenValue = pixel.getGreen();
		  blueValue = pixel.getBlue();
		  
		  // set the pixel;s color to the new value
		  pixel.setColor(new Color(255 - redValue, 255 - greenValue, 255 - blueValue));
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
		  System.out.println(intensity);
		  
		  // set the pixel color
		  pixelObj.setColor(new Color(intensity,intensity,intensity));
	  }
  }
  
  // Chapter 05.2 -  nested loops
  public void grayscaleNested()
  {
	  System.out.println("grayscaleNested");
	  Pixel pixel = null;
	  
	  // loop through the column pixels
	  for ( int x = 0; x < this.getWidth(); x++)
	  {
		  // loop through the rows for the pixels
		  for ( int y = 0; y< this.getHeight(); y++)
		  {
			  pixel = getPixel(x, y);
			  System.out.println(x + " " + y + " " + pixel);
			  
			  // grayscale
			  int grayness = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
			  System.out.println(grayness);
			  pixel.setColor(new Color(grayness,grayness,grayness));
		  }
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
  
  // Chapter 5.3 : mirror two heads
  public void mirrorTwoHeads()
  {
	  System.out.println("mirrorTwoHeads");
	  // head 1 : 198,32 to 300,152
	  // head 2 : 366,32 to 475,131
	  int top = 32;		// y-Axis
	  int bottom = 152;	// y-Axis
	  int left = 198;	//x-Axis
	  int right = 475;	//x-Axis
	  int height = (bottom - top) * 2 + 40; // bottom - top; // 152-32 = 120 
	  
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  
	  // loop through columns
	  for ( int x = left; x < right; x++) //
	  {
		  // loop through rows
		  for ( int y = top; y < bottom; y++) // 
		  {
			  // copy pixels to 
			  topPixel = getPixel(x,y); // 198, 32
			  bottomPixel = getPixel(x, height - 1 - y); 
			  bottomPixel.setColor(topPixel.getColor());
			  
		  }
	  }
  }
  
//Chapter 5.4 : mirror person so it looks conjoined
 public void mirrorConjoined()
 {
	 
	 int mirrorPoint = 278;
	 int startX = 109;
	 Pixel copyFromPixel = null;
	 Pixel copyToPixel = null;
	 
	 
	 // loop through column
	 for ( int x = startX; x < mirrorPoint; x++)
	 {
		 // loop through rows
		 for ( int y = 0; y < this.getHeight(); y++)
		 {
			 // copy pixels
			 copyFromPixel = getPixel(x, y);
			 copyToPixel = getPixel(mirrorPoint + (mirrorPoint - x), y);
			 copyToPixel.setColor(copyFromPixel.getColor());
			 
		 }
	 }
 }
  

 
 
//Chapter 5.5 : mirror person so it looks conjoined
public void blended()
{
	
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
   * Program22: move only a section
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
  
  // Problem 5.8:  needs start, stop, x, y points //97, 276, 13, 27
  public void mirrorSection(int start, int stop, int xAxis, int yAxis)
  {
	  int mirrorPoint = stop;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  
	  
	  // loop through the rows
	  for ( int y = yAxis; y < start; y++)			// int y = 27; y < 97; y++
	  {
		  // loop through the columns
		  for ( int x = xAxis; x < mirrorPoint; x++)	//  int x = 13; x < mirrorPoint; x++
		  {
			  leftPixel = getPixel(x, y);
			  rightPixel = getPixel(mirrorPoint + (mirrorPoint - x), y);
			  rightPixel.setColor(leftPixel.getColor());
			  
		  }
	  }
	  
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
	  //Picture flower1Picture = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/flower1.jpg");
	  //Picture flower2Picture = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/flower2.jpg");
	  Picture flower1Picture = new Picture(FileChooser.getMediaPath("flower1.jpg"));
	  Picture flower2Picture = new Picture(FileChooser.getMediaPath("flower2.jpg"));
	  
	  
	  //System.out.println(flower1Picture);
	  //System.out.println(flower2Picture);
	  
	  
	  // declare the source and target pixel variables
	  Pixel sourcePixel = null;
	  Pixel targetPixel = null;
	  
	  // save the height of the two pictures
	  int flower1Height = flower1Picture.getHeight();
	  int flower2Height = flower2Picture.getHeight();
	  
	  //flower1Picture.show();
	  //flower2Picture.show();
	  
	  
	  // copy the first flower picture to 5 pixels from the bottom left corner of the current picture
	  for ( int sourceX = 0, targetX = 0; sourceX < flower1Picture.getWidth(); sourceX++, targetX++)
	  {
		  for ( int sourceY = 0, targetY = 0; sourceY < flower1Picture.getHeight() - 5; sourceY++, targetY++)
		  {
			  sourcePixel = flower1Picture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
	  //flower1Picture.explore();
	  //flower2Picture.explore();
	  
	  // copy the flower2 picture starting with x = 100;
	  for ( int sourceX = 0, targetX = 100; sourceX < flower2Picture.getWidth(); sourceX++, targetX++)
	  {
		  for ( int sourceY = 0, targetY = this.getHeight() - flower2Height - 5; sourceY < flower2Picture.getHeight(); 
				  sourceY++, targetY++)
		  {
			  sourcePixel = flower2Picture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
		 
	  // copy the flower1 negated to x = 200;
	  flower1Picture.negate();
	  for ( int sourceX = 0, targetX = 200; sourceX < flower1Picture.getWidth(); sourceX++, targetX++)
	  {
		  for ( int sourceY = 0, targetY = this.getHeight() - flower1Height - 5; sourceY < flower1Picture.getHeight(); 
				  sourceY++, targetY++)
		  {
			  sourcePixel = flower1Picture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
	  
	  // clear blue in flower2 to x = 300;
	  flower2Picture.clearBlue();
	  for ( int sourceX = 0, targetX = 300; sourceX < flower2Picture.getWidth(); sourceX++, targetX++)
	  {
		  for ( int sourceY = 0, targetY = this.getHeight() - flower2Height - 5; sourceY < flower1Picture.getHeight(); 
				  sourceY++, targetY++)
		  {
			  sourcePixel = flower2Picture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
	  
	  
	// copy negated flower 1 to x=400;
	  
	  for ( int sourceX = 0, targetX = 400; sourceX < flower1Picture.getWidth(); sourceX++, targetX++)
	  {
		  for ( int sourceY = 0, targetY = this.getHeight() - flower2Height - 5; sourceY < flower1Picture.getHeight(); 
				  sourceY++, targetY++)
		  {
			  sourcePixel = flower1Picture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
	  
  }
  
  
  /*
   *Program 27: General Copy Method
   *
   * Method that will copy all of the passsed source picture into the current picture object starting with the
   * upper LH corner given by startX It will put the sourcePicture at 5 pixels from the bottom of this picture
   * @param sourcePicture: the picture object to copy
   * @param xStart: the x position to start the copy in the target
   */
  
  public void copyPictureTo(Picture sourcePicture, int xStart)
  {
	  Pixel sourcePixel = null;
	  Pixel targetPixel = null;
	  
	  // loop through the columns
	  for ( int sourceX = 0, targetX = xStart; sourceX < sourcePicture.getWidth(); sourceX++, targetX++)
	  {
		  // loop through the rows
		  for ( int sourceY = 0, targetY = this.getHeight() - sourcePicture.getHeight() - 5; 
				  sourceY < sourcePicture.getHeight(); sourceY++, targetY++)
		  {
			  sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX,  targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
  }
  
  /*
   * Method to copy two flowers in a pattern to the bottom (5 pixels from the bottom) of the current picture
   */
  public void copyFlowersBetter()
  {
	  // create the flower pictures
	  //Picture flower1Picture = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/flower1.jpg");
	  //Picture flower2Picture = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/flower2.jpg");
	  Picture flower1Picture = new Picture(FileChooser.getMediaPath("flower1.jpg"));
	  Picture flower2Picture = new Picture(FileChooser.getMediaPath("flower2.jpg"));
	  
	  // copy the first flower picture to near the bottom LH corner of the canvas
	  this.copyPictureTo(flower1Picture, 0); 
	  
	  /*
	   * copy the flower2 picture starting with x = 100 in the canvas
	   */
	 
	  // copy the flower1 negated to x=200 in the canvas
	  flower1Picture.negate();
	  this.copyPictureTo(flower1Picture,200);
	  
	  /*
	   * clear te blue in flower 2 picture and add at x = 300 in the canvas
	   */
	  flower2Picture.clearBlue();
	  this.copyPictureTo(flower2Picture, 300);
	  
	  // copy the negated flower 1 to x = 400
	  this.copyPictureTo(flower1Picture, 400);
  }
  
  /*
   * Program 28: Blending Two Pictures
   * 
   * method to blend two sisters together
   * onto the current picture
   * 
   */
   
  public void blendPictures()
  {
  	// create the sister picture
	  Picture katiePicture = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/KatieFancy.jpg"); //KatieFancy.jpg
	  System.out.println(katiePicture);
	  Picture horsePicture = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/horse.jpg");		//horse.jpg
	  System.out.println(horsePicture);
	
	  // declare the source and target pixel variables
	  Pixel katiePixel = null;
	  Pixel horsePixel = null;
	  Pixel targetPixel = null;
	
	   // declare the target x and source s since we will need the values after the for loop
	  int sourceX = 0;
	  int targetX = 0;
	  
	  // copy the first 150 pixels of Katie to the canvas
	  for (; sourceX < 50; sourceX++, targetX++)
	  {
		  for ( int sourceY = 0, targetY = 0; sourceY < katiePicture.getHeight(); sourceY++, targetY++)
		  {
			  katiePixel = katiePicture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(katiePixel.getColor());
		  }
	  }
	  
	  // copy 50% of katie and 50% of horse til the end of katie's width
	  for (; sourceX < katiePicture.getWidth(); sourceX++, targetX++)
	  {
		  for ( int sourceY = 0, targetY = 0; sourceY < katiePicture.getHeight(); sourceY++, targetY++)
		  {
			  katiePixel = katiePicture.getPixel(sourceX, sourceY);
			  horsePixel = horsePicture.getPixel(sourceX - 50, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(new Color((int)(katiePixel.getRed() * 0.5 + horsePixel.getRed() * 0.5), 
					  (int)(katiePixel.getGreen() * 0.5 + horsePixel.getGreen() * 0.5),
					  (int)(katiePixel.getBlue() * 0.5 + horsePixel.getBlue() * 0.5)));
		  }
	  }
	  
	  // copy the rest of horse
	  sourceX = sourceX - 20;
	  for (; sourceX < horsePicture.getWidth(); sourceX++, targetX++)
	  {
		  for ( int sourceY = 0, targetY = 0; sourceY < horsePicture.getHeight(); sourceY++, targetY++ )
		  {
			  horsePixel = horsePicture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(horsePixel.getColor());
		  }
	  }
	  
  }
  
  //Chapter 5.5 : blended two pictures
  public void blendTwoPictures()
  {
	// create the sister picture
	  Picture picture1 = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/jenny1-green-small.jpg"); 
	  System.out.println(picture1);
	  Picture picture2 = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/jenny2-green-small.jpg");	
	  System.out.println(picture2); 
	  
	  // declare source and target pixels
	  Pixel picture1Pixel = null;
	  Pixel picture2Pixel = null;
	  Pixel targetPixel = null;
	  
	  // declare sourceX & targetX since we need them after the loop
	  int sourceX = 0;
	  int targetX = 0;
	  
	  // copy the first 4 pixels in the column to the target
	  for (; sourceX < 4; sourceX++, targetX++ )
	  {
		// copy the first 4 pixels in the row to the target
		  for ( int sourceY = 0, targetY = 0; sourceY < picture1.getHeight(); sourceY++, targetY++)
		  {
			  picture1Pixel = picture1.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX,targetY);
			  targetPixel.setColor(picture1Pixel.getColor());	 
		  }
	  }
	  
	  // copy the columns for the middle section for the overlap
	  for (; sourceX < picture1.getWidth(); sourceX++, targetX++)
	  {
		  // copy the rows for the middle section for the overlap
		  for (int sourceY = 0, targetY = 0; sourceY < picture1.getHeight(); sourceY++, targetY++)
		  {
			  picture1Pixel = picture1.getPixel(sourceX, sourceY);
			  picture2Pixel = picture2.getPixel(sourceX - 4, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(new Color((int)(picture1Pixel.getRed() * 0.5 + picture2Pixel.getRed() * 0.5),
					  (int)(picture1Pixel.getGreen() * 0.5 + picture2Pixel.getGreen() * 0.5),
					  (int)(picture1Pixel.getBlue() * 0.5 + picture2Pixel.getBlue() * 0.5)));
			  
		  }
	  }
	  
	  // copy the last columns for the end section after the overlap
	  sourceX = sourceX - 4;
	  for (; sourceX < picture2.getWidth(); sourceX++, targetX++)
	  {
		  for (int sourceY = 0, targetY = 0; sourceY < picture2.getHeight(); sourceY++, targetY++)
		  {
			  picture2Pixel = picture2.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);			  
			  targetPixel.setColor(picture2Pixel.getColor());
		  }
	  }

  }
  
//Chapter 5.6 : blended two pictures, ratio 20% - 60% - 20%
  public void blendAnotherTwoPictures()
  {
	// create the sister picture
	  //Picture picture1 = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/flower1.jpg"); 
	  //FileChooser.getMediaPath(
	  Picture picture1 = new Picture(FileChooser.getMediaPath("flower1.jpg"));
	  System.out.println(picture1);
	  //Picture picture2 = new Picture("/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/flower2.jpg");	
	  Picture picture2 = new Picture(FileChooser.getMediaPath("flower2.jpg"));
	  System.out.println(picture2); 
	  
	  // declare source and target pixels
	  Pixel picture1Pixel = null;
	  Pixel picture2Pixel = null;
	  Pixel targetPixel = null;
	  
	  // declare sourceX and targetX, needed after the loops
	  int sourceX = 0;
	  int targetX = 0;
	  
	  // loop through the first columns
	  for (; sourceX < picture1.getWidth(); sourceX++, targetX++)
	  {
		  for ( int sourceY = 0, targetY = 0; sourceY < picture1.getHeight(); sourceY++, targetY++)
		  {
			  // get pixel colors
			  picture1Pixel = picture1.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(picture1Pixel.getColor());
		  }
	  }
	  
	  
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
	  
	  // ------------Chapter 05 Problem 5.9-------------
	  String fileName = FileChooser.getMediaPath("640x480.jpg");
	  Picture sourcePicture = new Picture(fileName);
	  System.out.println(sourcePicture);
	  sourcePicture.copyPictureLarger();
	  sourcePicture.explore();
	  
	  // ----END---------Chapter 05 Problem 5.9-------------
	  
	  /*
	  // ------------Chapter 05 Problem 5.8-------------
	  // Mirror by passing in start, stop, x, y points
	  String fileName = FileChooser.getMediaPath("oxford-cricketers.jpg");
	  //String fileName = FileChooser.getMediaPath("temple.jpg");
	  Picture sourcePhoto = new Picture(fileName);
	  System.out.println(sourcePhoto);
	  sourcePhoto.explore();
	  sourcePhoto.mirrorSection(382, 450, 383, 327);		// needs start, stop, x, y points 97, 276, 13, 27
	  sourcePhoto.explore();
	  // ----END---------Chapter 05 Problem 5.8-------------
	  */
	  
	  
	  /*
	  // ------------Chapter 05 Problem 5.7-------------
	  // decrease red by a specified parameter amount
	  String fileName = FileChooser.getMediaPath("grayMotorcycle.jpg");
	  Picture sourcePhoto = new Picture(fileName);
	  System.out.println(sourcePhoto);
	  sourcePhoto.explore();
	  sourcePhoto.decreaseRed(33);				// takes a parameter amount to reduce red by
	  sourcePhoto.explore();							
	  // ----END---------Chapter 05 Problem 5.7-------------
	  */
	  
	  
	  /*
	  // -------------Chapter 05 Problem 5.6-------------
	  // Create overlap, 20% to 60 % to 20 %
	  //String fileName = FileChooser.getMediaPath("wall-two-people.jpg");
	  //String sourceFile = FileChooser.getMediaPath("wall-two-people.JPG");
	  //String sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/7inX95in.jpg";
	  String sourceFile = FileChooser.getMediaPath("7inX95in.jpg");
	  Picture sourcePicture = new Picture(sourceFile);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.blendAnotherTwoPictures();	// blendAnotherTwoPictures(),  blendTwoPictures()
	  sourcePicture.explore(); 
	  // ----END---------Chapter 05 Problem 5.6-------------
	  */
	  
	  /*
	  // -------------Chapter 05 Problem 5.5-------------
	  // Create overlap, 10% to 80 % to 10 %
	  //String fileName = FileChooser.getMediaPath("wall-two-people.jpg");
	  //String sourceFile = FileChooser.getMediaPath("wall-two-people.JPG");
	  String sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/7inX95in.jpg";
	  Picture sourcePicture = new Picture(sourceFile);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.blendTwoPictures();	// blendPictures();; blendTwoPictures()
	  sourcePicture.explore(); 
	  // ----END---------Chapter 05 Problem 5.5-------------
	  */
	  
	  /*
	  // -------------Chapter 05 Problem 5.4-------------
	  // Mirror conjoined
	  //String fileName = FileChooser.getMediaPath("wall-two-people.jpg");
	  String sourceFile = FileChooser.getMediaPath("wall-two-people.JPG");
	  //String sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/wall-two-people.jpg";
	  Picture sourcePicture = new Picture(sourceFile);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.mirrorConjoined();	// mirrorTwoHeads(), mirrorConjoined()
	  sourcePicture.explore(); 
	  // ----END---------Chapter 05 Problem 5.4-------------
	  */
	  
	  /*
	  // -------------Chapter 05 Problem 5.3-------------
	  // Mirror Heads
	  //String fileName = FileChooser.getMediaPath("wall-two-people.jpg");
	  String sourceFile = FileChooser.getMediaPath("wall-two-people.JPG");
	  //String sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/wall-two-people.jpg";
	  Picture sourcePicture = new Picture(sourceFile);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.mirrorTwoHeads();	// mirrorTwoHeads(), mirrorHorizontal(), 
	  sourcePicture.explore(); 
	  // ----END---------Chapter 05 Problem 5.3-------------
	  */
	  
	  
	  /*
	  // -------------Chapter 05 Problem 5.2-------------
	  // Nested loops grayscale
	  String fileName = FileChooser.getMediaPath("caterpillar.jpg");
	  Picture sourcePicture = new Picture(fileName);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.grayscaleNested();	// keepRed(), keepGreen(), keepBlue()
	  sourcePicture.explore(); 
	  // ----END---------Chapter 05 Problem 5.2-------------
	  */
	  
	  /*
	  // -------------Chapter 04 Problem 4.20-------------
	  //String fileName = FileChooser.getMediaPath("caterpillar.jpg");
	  String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/caterpillar.jpg";
	  Picture sourcePicture = new Picture(fileName);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.grayscale();	// keepRed(), keepGreen(), keepBlue()
	  sourcePicture.explore(); 
	  // ----END---------Chapter 04 Problem 4.20-------------
	  */
	  
	  
	  /*
	  // -------------Chapter 04 Problem 4.13-------------
	  //How do you get the height of a picture object
	  String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/caterpillar.jpg";
	  Picture sourcePicture = new Picture(fileName);
	  System.out.println(sourcePicture);
	  System.out.println(sourcePicture.getHeight());
	  int height = sourcePicture.getHeight();
	  System.out.println(height);
	  // -------------Chapter 04 Problem 4.14-------------
	  System.out.println(sourcePicture.getWidth());
	  int width = sourcePicture.getWidth();
	  System.out.println(width);
	  // -------------Chapter 04 Problem 4.13-------------
	  Picture pictureSize = new Picture(200, 100);
	  System.out.print(pictureSize);
	  Pixel[] pictureSizeArray = pictureSize.getPixels();
	  System.out.println(" has " + pictureSizeArray.length + " pixels.");
	  Picture pictureSizeTwo = new Picture(640, 480);
	  System.out.print(pictureSizeTwo);
	  Pixel[] pictureSizeTwoArray = pictureSizeTwo.getPixels();
	  System.out.println(" has " + pictureSizeTwoArray.length + " pixels." );
	  
	  // -------------Chapter 04 Problem 4.17-------------
	  // print out the pixel array of a picture
	  String aFileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/caterpillar.jpg";
	  Picture aSourcePicture = new Picture(aFileName);
	  Pixel[] aPixelArray = aSourcePicture.getPixels();
	  int index = 0;
	  
	  while ( index < aPixelArray.length)
	  {
		  System.out.println(aPixelArray[index]);
		  index++;
	  }
	  Pixel pixel = aPixelArray[1];
	  //System.out.println(pixel.getRed(), pixel.getGreen(), pixel.getBlue());
	  System.out.println(pixel.getRed());
      System.out.println(pixel.getGreen());
	  System.out.println(pixel.getBlue());
	  pixel.setRed(237);
	  
	  //pixel.setColor(new Color(pixel.setRed(222), pixel.setGreen(222),pixel.setBlue(222));
	  
	  int red = 222;
	  int green = 222;
	  int blue = 222;
	  pixel.setColor(new Color(red, green, blue));
	  
	  
	  // ----END---------Chapter 04 Problem 4.13, 14-------------
	  */
	  
	  
	  
	  /*
	  // -------------Chapter 04 Problem 4.11-------------
	  //String fileName = FileChooser.getMediaPath("caterpillar.jpg");
	  String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/caterpillar.jpg";
	  Picture sourcePicture = new Picture(fileName);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.maximizeBlue();	// keepRed(), keepGreen(), keepBlue()
	  sourcePicture.explore();
	  // ----END---------Chapter 04 Problem 4.11-------------
	  */
	  
	  /*
	  // -------------Chapter 04 Problem 4.10-------------
	  //String fileName = FileChooser.getMediaPath("caterpillar.jpg");
	  String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/caterpillar.jpg";
	  Picture sourcePicture = new Picture(fileName);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.keepBlue();	// keepRed(), keepGreen(), keepBlue()
	  sourcePicture.explore();
	  // ----END---------Chapter 04 Problem 4.10-------------
	  */

	  
	  /*
	  // -------------Chapter 04 Problem 4.9-------------
	  String fileName = FileChooser.getMediaPath("caterpillar.jpg");
	  Picture sourcePicture = new Picture(fileName);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.clearBlue();	// clearRed(), clearGreen(), clearBlue()
	  sourcePicture.explore();
	  // ----END---------Chapter 04 Problem 4.9-------------
	  */
		  
	  /*
	  // -------------Chapter 04 Problem 4.7-------------
	  String fileName = FileChooser.getMediaPath("caterpillar.jpg");
	  Picture sourcePicture = new Picture(fileName);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.increaseRed();	// increaseRed2(), or increaseRed3()
	  sourcePicture.explore();
	  // ----END---------Chapter 04 Problem 4.7-------------
	  */
	  
	  
	  /*
	  // -------------Chapter 04 Problem 4.5-------------
	  String fileName = FileChooser.getMediaPath("caterpillar.jpg");
	  Picture sourcePicture = new Picture(fileName);
	  System.out.println(sourcePicture);
	  sourcePicture.explore();
	  sourcePicture.reduceRedness(15);	// insert the amount of reduction 10 or 20
	  sourcePicture.explore();
	  // ----END---------Chapter 04 Problem 4.5-------------
	  */
	  
	  // ------------------------------------Below this line is junk-------------------------
	  
	  
	  // @Lnx
	  //String sourceFile = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/KatieFancy.jpg";
	  // @MAC
	  //String sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/blue-mark.jpg";
	  /*
	  String fileName = FileChooser.getMediaPath("caterpillar.jpg");
	  Picture p = new Picture(fileName);
	  p.clearBlue();
	  p.explore();
	  p.increaseRed();
	  p.explore();
	  */
	  
	  /*
	  String fileName = FileChooser.getMediaPath("7inX95in.jpg");
	  //String fileName = FileChooser.getMediaPath("caterpillar.jpg");
	  Picture targetPicture = new Picture(fileName);
	  
	  targetPicture.copyFlowersBetter();// targetPicture.copyFlowers();
	  //targetPicture.negate();
	  targetPicture.show();
	  
	  //Picture p = new Picture();
	  //p.copyFlowers();
	  */
	  
	  /*
	  //String fileName =  "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/butterfly1.jpg";
	  String fileName = FileChooser.getMediaPath("butterfly1.jpg");
	  Picture p = new Picture(fileName);
	  System.out.println(p);
	  p.explore();
	  p.sepiaTintRange();
	  p.explore();
	  */
	  
	  
	  
	  /*
	  // homework for 6.2 didn't work
	  
	  // get the clock face
	  //String sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/clock-tower.jpg";
	  String fileName = FileChooser.getMediaPath("blue-mark.jpg");
	  Picture mark = new Picture(fileName);
	  //mark.explore();
	  
	  // replace with Marks face
	  //sourceFile = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/blue-mark.jpg";
	  fileName = FileChooser.getMediaPath("moon-surface.jpg");
	  Picture newBg = new Picture(fileName);
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
 