import java.awt.Graphics;
import java.awt.Image;


public class SItop extends SIinvader{
	//update the model to cycle between the 2 SItop gifs.
	//have a method to update position
	
	//SItop image size 30wx24h
	public SItop(int x, int y){
		super(	x,
				y,
				30,		//width
				24,		//height
				30,		//worth
				"SItop0.gif",
				"SItop1.gif");
	}
}
