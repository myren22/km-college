import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public abstract class SIship extends SIthing {
	private Image image;
	private Image destroyed;
//	private AudioClip shoot;
	private AudioClip boom;
	private boolean hit;

	// Images for alive and dead, audio for it firing and when it is hit, and
	// boolean to check the status of whether or not it has been hit
	//Kyle -- alive constructor removed
	protected SIship(int x, int y, String filenameDead, int width, int height) {
		super(x, y, width, height);
		// Fields that all ships will share
		hit = false;
		boom = getSound("SIshipHit.wav");
		// Specific parameters that change per ship
//		image = getImage(filenameAlive);
		destroyed = getImage(filenameDead);
//		shoot = getSound(filenameAudioShoot);
	}

	// method to check to see if the ship has been hit
	protected boolean isHit() {
		return this.hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	protected AudioClip getSound(String filename) {
		URL url = getClass().getResource(filename);
		return Applet.newAudioClip(url);
	}

	protected Image getImage(String filename) {
		URL url = getClass().getResource(filename);
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}

//	public void draw(Graphics g) {
//		g.drawImage(image, getX(), getY(), null);
//	}

	public void drawDestroyed(Graphics g) {
		g.drawImage(destroyed, getX(), getY(), null);
		System.out.print("should be dead");
	}
	public void playDestroyed(){
		boom.play();
	}
}
