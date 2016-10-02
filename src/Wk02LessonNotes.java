public class Wk02LessonNotes
{
	public static void main(String[] args)
	{
		System.out.println("Module 2 \n");
		
		/*
		Module 2: Arrays
		
		*/
		int[] number = {8, 42, 31, 6, -7, 2, 58, 256, 0, -400};
		System.out.println(number[0]);
		
		
		
		int x;
		int y;
		x = number[0];
		y = number[1];
		
		int[] pair = new int[2];	// creates an empty array of size two ints
		// keyword new is a way of instantiating objects
		pair[0] = x;	// assigns value of x to 1st location of pair array
		pair[1] = y;	// assigns value of y to 2nd location of pair array
		
		// one dimensional array
		
		// two dimensional array
		int[][] sudoku = new int[9][9];
		
		// array length
		System.out.println("\nArray Lengths");
		System.out.println(number.length);	// prints length 
		
		double[][] grade = new double[30][5];
		System.out.println(grade.length);
		System.out.println(grade[0].length);	// length of the second dimension of the array
		
		/*
		
		Hierarchical Decomposition
			- method should be as cohesive as possible
			- method should do one thing and only one thing really well
			- Cohesive methods foster clarity and reusability
			- Cohesive methods facilitate the establishment of a hierarchy of goals
			
		Scope = best practice, only grantas much visibility as is necessary to a variable
			- principle of least privilege
			
		
		
		 */
		
		/*
		 
		 For loop: (enhanced)
		 for (Pixel pixel:pixelArray)
		 
		 For-each look:
		 for (int i = 0, i < pixelArray.length(), i++
		 
		 using the number array
		 
		 */
		/*
		// enhanced for look
		for (int num : number)
		{
			System.out.print(num + ", ");
		}
		
		System.out.println();
		*/
		/*
		// for-each loop
		for (int i = 0; i < number.length; i++)
		{
			System.out.print(number[i] + ", ");
		}
		*/
		/*
		// while loop
		boolean done = false;	// initialize a control condition
		int index = 0;			// initialize counter
		System.out.println();	// new line for presentation
		while (!done)
		{
			
			int value = number[index];
			System.out.print(value + ", ");
			index++;
			if ( index == number.length)	// test for condition
			{
				done = true;
			}
		}
		
		System.out.println();
		*/
		// nested loops
		/*
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				System.out.print(i + j);
			}
		}
		*/
		
		/*
		
		Constructor initializes values of the class, and must be the same 
		name as the class. A constuctor has no return type.
		
		 Method Return Values
		 
		 if a method does return a value, the it's return type should be
		 declared to be of the appropriate type
		 
		 public int foo()	// int in this line is the return type
		 
		 Method Overloading
		 
		 Methods are said to be overloaded if they have the same
		 name, but differ in the number of arguments, the type of
		 arguments, or a combination of number/type of arguments
		 
		 NB: Overloaded Methods are never differentiated by return type.
		 
		 int fooFee(int num){..}  //and
		 float fooFee(int num){..} // differs from above in return type
		 
		 Conditional Execution	=> Chapter 6
		 if (boolean expression)
		 {
		 	do stuff
		 }
		 
		 
		 if (boolean expression)
		 {
		 	do stuff
		 }
		 else
		 {
		 	do different stuff
		 }
		 
		 // nested if/else statements
		  
		 if (boolean expression)
		 {
		 	do stuff
		 }
		 else if
		 {
		 	do different stuff
		 }  
		 else if
		 {
		 	do different stuff
		 } 
		 else if
		 {
		 	do different stuff
		 } 
		 else 
		 {
		 	do completely different stuff
		 }   
		   
		   Inheritance
		   
		   public class Picture extends SimplePicture
		   		- establishes an inheritance relationship between Picture and 
		   		SimplePicture
		   		- this means that Picture "IS A" SimplePicture
		   		- all fields (instance variables) and methods defined by SimplePicture
		   		become the basis of Picture
		   		- Additional fields and methods can then be added by Picture
		 
		 Encapsulation - 
		 
		*/
		// slide 25 from lesson content
		//SimplePicture simplePicture = new SimplePicture("/home/notroot/Java/JavaII/AdditionalSoftware/mediasources/gorge.jpg");
		//simplePicture.setVisible(true);
		
		
		
	}
}