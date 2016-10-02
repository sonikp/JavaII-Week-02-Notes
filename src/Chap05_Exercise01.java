import java.awt.Color;

public class Chap05_Exercise01 extends SimplePicture
{
	
	/*
	 * Program 18: Lighten the Picture Using Nested Loops
	 * Method to lighten the colors in the picture
	 * 
	 */
	public void lighten2(Picture pic)
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
	
	
	
	public static void main(String[] args)
	{
		
		Chap05_Exercise01 notes = new Chap05_Exercise01();
		// String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/caterpillar.jpg";
		String fileName = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/caterpillar.jpg";
		Picture pictureImage = new Picture(fileName);
		pictureImage.show();
		notes.lighten2(pictureImage);	// from SimplePicture class
		pictureImage.show();			// show picture after lightening
		
	}
}