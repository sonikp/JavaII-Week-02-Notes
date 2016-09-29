import java.awt.Color;

public class Chap04_Notes
{
	public void decreaseRed(Picture pic)	// page 93
	{
		Pixel[] pixelArray = pic.getPixels();	// appears line 95: 
		/*
		 * Debug: when you execute pictureObject.decreaseRed() the runtime checks the "Picture class"
		 */
		int value = 0;
		
		// loop through all pixels in the array
		
		for ( Pixel pixelObj : pixelArray )
		{
			// get the red value
			value = pixelObj.getRed();
			
			// decrease red value 
			value = (int) (value * 0.5);
			
			// set the red value of the current pixel to the new value
			pixelObj.setRed(value);
			
		}

	}
	
	public static void main(String[] args)
	{
		
		/*
		
		4.3 =======Changing Color Values===================================
		
		*/
		
		
		// 
		
		// String fileName = FileChooser.pickAFile();
		Chap04_Notes notes = new Chap04_Notes();
		

		// String fileName = "/Users/mfloerchinger/Documents/z.JavaProgramming/UCSD/Java II/CourseCD/mediasources/caterpillar.jpg";
		String fileName = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/caterpillar.jpg";
		 
		Picture pictureObject = new Picture(fileName);
		pictureObject.show();
		
		// call new method
		pictureObject.explore();
		notes.decreaseRed(pictureObject);	// error
		pictureObject.explore();
		
		
		/*
		// create array
		Pixel[] pixelArray = pictureObject.getPixels();
		Pixel pixelObject = pixelArray[0];
		System.out.println(pixelObject);
		
		// change color values on first pixel in array
		int red = pixelObject.getRed();
		System.out.println(red);
		red = (int) (red * 0.5);
		System.out.println(red);
		
		// change color values on second pixel in array
		pixelObject = pixelArray[1];
		red = pixelObject.getRed();
		System.out.println(red);
		red = (int) (red * 0.5);
		System.out.println(red);
		
		// change color values on 3rd pixel in array
		pixelObject = pixelArray[2];
		red = pixelObject.getRed();
		System.out.println(red);
		red = (int) (red * 0.5);
		System.out.println(red);
		
		
		
		pixelObject.getPixels();
		Pixel[] pixelArray = picObject.getPixels();
		*/
		
		
		/*
		
		 For loop example
		 
		 for ( Type variableName : array )
		 
		 Which reads; first declare a variable that wll be used in the body of the loop, then, for each element in the array execute the body
		 of the loop.
		 
		*/
		
		
		
		
		
		/*
		
		4.2 =======Manipulating Pictures===================================
		
		
		*/
		
		/*
		// String myPicture = FileChooser.pickAFile();
		String myPicture = "/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/arch.jpg";
		
		// create picture object
		Picture picObject = new Picture(myPicture);
		
		// use explore method to view RGB of picture
		picObject.explore();		// .explore(); is the RGB color explorer for a picture file
		System.out.println(picObject);
		
		// show dimensions
		System.out.println(picObject.getHeight());
		System.out.println(picObject.getWidth());
		
		// get particular pixel
		System.out.println(picObject.getPixel(240, 180));
		
		// get picture array page 86
		System.out.println("\nget picture array");
		Pixel[] pixelArray = picObject.getPixels();
		System.out.println(pixelArray[0]);
		*/
		
		/*
		// prints out the color array for the entire picture file
		System.out.println("\nprint entire array");
		for (int i = 0; i <= pixelArray.length; i++)
			System.out.println(pixelArray[i]);
		*/
		
		// System.out.println((picObject.getWidth().getHeight()));  // need to figure out stacking
		
		/*
		// where pixels come from, set pixelObject
		System.out.println("\nwhere pixels come from");
		Pixel pixelObject = picObject.getPixel(0, 0);
		System.out.println(pixelObject);
		
		// Pixel array
		Pixel[] pixel2Array = picObject.getPixels();
		System.out.println(pixel2Array[0]);
		
		System.out.println(pixelObject.getRed());
		
		// set red
		pixelObject.setRed(255);
		System.out.println(pixelObject.getRed());
		
		// get color
		System.out.println(pixelObject.getColor());
		//System.out.println(pixelObject.setColor(Color.black));		// my experiment doesn't work
		
		// get X Y coordinates
		System.out.println(pixelObject.getX());
		System.out.println(pixelObject.getY());
		
		
		// set colour
		Color colorObject = pixelObject.getColor();
		System.out.println(colorObject);
		
		Color newColorObject = new Color(0,100,0);
		System.out.println(newColorObject);
		
		// change color of pixel object
		pixelObject.setColor(newColorObject);
		
		// redraw picture to see changes to color pixel
		System.out.println(picObject.getPixel(0, 0));
		
		// redraw image
		//System.out.println(picObject.repaint());	<= why doesn't this work when every other time I have to call the object.method it has to be from inside the screen display method. How do I know when I can call a display method directly, and when it has to be from within the System.out.println method
		picObject.repaint();
		
		//picObject.show();
		System.out.println("----------------------------\n");
		
		// make object darker / lighter
		Color testColorObj = new Color(168,131,105);
		System.out.println(testColorObj);
		
		testColorObj = testColorObj.darker();
		System.out.println(testColorObj);
		
		testColorObj = testColorObj.brighter();
		System.out.println(testColorObj);
		
		// Color chooser <= I'm creating a new object, but why can I call a method directly without first creating the object
		//Color pickedColorObj = new Color()
		Color pickedColorObj = ColorChooser.pickAColor();
		System.out.println(pickedColorObj);
		picObject.repaint();
		
		// write picture to a file
		picObject.write("modifiedPicture.jpg");
		
		//=============END 4.2 =======Manipulating Pictures===================================
		*/
		
		
		
		
		
		
		
		/*
		
		4.1 =======How pictures are encoded===================================
		
		arrayName[index]
		
		arrayName[0]	= first element in the array
		arrayName[1]	= 2nd element in the array
		arrayName.length = number items in an array
		arrayName.length-1	= access last element in the array.
		
		*/
		
		/*
		// examples
		double[] gradeArray = {80, 90.5, 88, 92, 94.5};
		System.out.println(gradeArray);
		System.out.println(gradeArray[0] + "\n\n");
		System.out.println(gradeArray.length);
		
		for (int i = 0; i <= 4; i ++)
			System.out.println(gradeArray[i]);
		// end of examples
		 
		*/
		
		
		
		/*
		Two dimensional arrays = matrix
		
		For one dimensional array, an element is at index i : array[i];
		
		For two dimensional array, an element is at row r column c : array[r][c];	AKA row-major order
		
		column-major order = matrix[c][r] = specifies column first, then row. Usually for picture files, x = horizontal, y = vertical
		i.e: matrix[x][y] - column = x axis, vertical, row = y axis, horizontal
		

		*/
		
	}
}