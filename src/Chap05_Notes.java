import java.awt.Color;

public class Chap05_Notes
{
	public static void main(String[] args)
	{
		// Chapter 05 Modifying Pixels in a Matrix
		
		// -----------5.1------------------
		
		// Nested loops
		
		
		// String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/caterpillar.jpg";
		String fileName = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/caterpillar.jpg";
		Picture picture = new Picture(fileName);
		//picture.getPixel();	// from SimplePicture class
		
		/*
		// loop through the columns (x direction)
		for (int x = 0; x < getWidth(); x++)
		{
			// loop through the rows (y direction)
			for ( int y = 0; y < getHeight(); y++)
			{
				// get the current pixet at this x and y position
				pixel = getPixel(x,y);
				
				// do something
				
				// set the new color
				pixel.setColor(aColor);
				
			}
		}
		
		*/
		//System.out.println("seers");
	}
}