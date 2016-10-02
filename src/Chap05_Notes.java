import java.awt.Color;

public class Chap05_Notes extends Picture
{
	
	/*
	 * program 30: scaling the picture down(making smaller)
	 * 
	 */
	
		public void copyPictureSmaller(Picture pic)
		{
			Picture origPicture = new Picture(FileChooser.getMediaPath("rose.jpg"));
			Pixel sourcePixel = null;
			Pixel targetPixel = null;
			  
			  // loop through columns
			  for ( int sourceX = 0, targetX = 0; sourceX < origPicture.getWidth(); sourceX+=2, targetX++ )
			  {
				  //loop through rows
				  for ( int sourceY = 0, targetY = 0; sourceY < origPicture.getHeight(); sourceY+=2, targetY++ )
				  {
					  sourcePixel = origPicture.getPixel(sourceX, sourceY);
					  targetPixel = origPicture.getPixel(targetX, targetY);
					  targetPixel.setColor(sourcePixel.getColor());
				  }
			  }
			  origPicture.show();
		  }
	
	
	
	
	/*
	 * Program 31: Scaling the picture up(making larger)
	 */
	
	
	public void copyPictureLarger(Picture pic)
	{
		Picture origPicture = new Picture(FileChooser.getMediaPath("rose.jpg"));
		Pixel sourcePixel = null;
		Pixel targetPixel = null;
		
		// loop through columns
		for ( double sourceX = 0, targetX = 0; sourceX < origPicture.getWidth(); sourceX = sourceX + 0.5, targetX++)
		{
			for ( double sourceY = 0, targetY = 0; sourceY < origPicture.getWidth(); sourceY = sourceY + 0.5, targetY++)
			{
				sourcePixel = origPicture.getPixel((int) sourceX, (int) sourceY);
				targetPixel = origPicture.getPixel((int) targetX, (int) targetY);
				targetPixel.setColor(sourcePixel.getColor());
						
			}
		}
		origPicture.show();
	}
	
	
	public static void main(String[] args)
	{
		
		Chap05_Notes notes = new Chap05_Notes();
		String sourceFile = FileChooser.getMediaPath("rose.jpg");
		System.out.println(sourceFile);
		Picture picObject =  new Picture(sourceFile);
		picObject.show();
		notes.copyPictureSmaller(picObject);
		
		
	}
}