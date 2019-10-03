import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;


public class SIbase extends SIship{
//	 Basic creation with images for alive and dead for the base
	
	private AudioClip shoot;
	private Image image;
	//base image size: 26wx20h
	
	protected SIbase() {
		super(242,380, "SIbaseBlast.gif", 26, 20);
		image = getImage("SIbase.gif");
		shoot = getSound("SIbaseShoot.wav");
		
	}
	
//	protected AudioClip getSound(String filename) {
//		URL url = getClass().getResource(filename);
//		return Applet.newAudioClip(url);
//	}
//	
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
	public void reset(){
		setX(242);
		setY(380);
		setActive(true);
		setHit(false);
	}
	public void draw(Graphics g) {
		g.drawImage(image, getX(), getY(), null);
	}
	
	public void missileShot(){
		shoot.play();
	}
}
