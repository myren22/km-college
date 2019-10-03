import java.awt.Graphics;
import java.awt.Image;

public class SIinvader extends SIship{	
//	The abstract class SIinvader is the super-class of all invaders, 
//	either mystery ships or any of the three different types of invaders in the wave. 
//	Invaders share several characteristics, among which are that they are worth points,
//	and that they have the same image when hit. Figure 10 shows an example of an invader 
//	(fourth column, fourth row from left to right, top to bottom) exploding after being hit by a missile from the base. 
//	This explosion image is found in the file �SIinvaderBlast.gif�, and should Figure 10: Space Invader explosion. 
//	be loaded in the SIinvader constructor, stored in the image field defined in SIship, and drawn when the invader is shot.
//	Also, the SIinvader class defines a field indicating how many points an invader is worth. 
//	Note though that this field should be initialized by individual subclasses, as each invader is worth different number of points. 
//	The points of a mystery ship should be randomly chosen among 4 equally distributed values.
	
	private int points, pulseSinceLast;
	private double pace;
	private boolean isFrame0, rightWards;
	private String frame0, frame1;
	private Image image;	
	
	//same image when hit		SIinvaderBlast.gif	
	public SIinvader(int x, int y, int width, int height, int worth, String frame0, String frame1){
		super(x, y,  "SIinvaderBlast.gif", width, height);
		points = worth;
		this.frame0 = frame0;
		this.frame1 = frame1;
		rightWards = true;
		isFrame0 = true;
		pace = 40;
		pulseSinceLast = 0;
		image = getImage(frame0);
	}
	public int getPoints(){
		return points;
	}
	public boolean contains(int x, int y) {
		// Get width and height, then add those respectively to the current X and Y position.
		// Then check if the x and y that are parameters
		boolean hit = false;
		int width = getWidth();
		int height = getHeight();
		int currentX = getX();
		int currentY = getY();
		
		
		
		if(x <= currentX+width && x  >= currentX && y <= currentY+height && y >= currentY) {
			hit = true;
		} else if(x+2 <= currentX+width && x+2  >= currentX && y <= currentY+height && y >= currentY) {
			hit = true;
		} else if(x <= currentX+width && x  >= currentX && y+10 <= currentY+height && y+10 >= currentY) {
			hit = true;
 		} else if(x+2 <= currentX+width && x+2  >= currentX && y+10 <= currentY+height && y+10 >= currentY) {
 			hit = true; 			
 		}
		return hit;
	}
	
	public void updatePosition(){
		pulseSinceLast++;
		
		
		if(pulseSinceLast==(int)pace){
			if(isFrame0 == true){
				image = getImage(frame0);
				isFrame0 = false;
			}
			else{
				image = getImage(frame1);
				isFrame0 = true;
			}
			pulseSinceLast=0;
			//if hit
			//this.drawDestroyed(g);
			
			//need a way to check neighboring spots
			//if(zone left or zone right contain an invader, wall reached){
					//or landon's way, have a leftmost and rightmost invader, then update who when they die
			//flip rightwards
			//decrease pace
			//go down
			//}
			if(rightWards){
				this.setX(this.getX()+5);
			}
			else{
				this.setX(this.getX()-5);
			}
		}	
	}
	public void edgeCollision(){
		//should this be floored? 40*.8=32, 32*.8=25.6
		pace = pace * 0.8;
		Math.floor(pace);
//		System.out.print(pace);
		rightWards = !rightWards;
		this.setY(this.getY()+12);
		
	}
	public void draw(Graphics g) {
		g.drawImage(image, getX(), getY(), null);
	}
	
}
