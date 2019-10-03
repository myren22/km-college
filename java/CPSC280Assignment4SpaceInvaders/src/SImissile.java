import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;

public class SImissile extends SIthing {
	// active represents whether or not there is a missile on the screen,
	// isUpwards is for the direction it is traveling, current X/Y is to store
	// the values at which the missile was launched from
//	private boolean active;
	private boolean isUpwards;
	// three separate invader missiles to keep track of the limit
	private int currentX;
	private int currentY;
	private Integer[][] example = new Integer[3][2];

	protected SImissile(int x, int y, boolean direction) {
		super(x, -y, 2, 10);
		setActive(false);
		currentX = x;
		currentY = y;
		isUpwards = direction;
		}
		
	public void launch(int x, int y, boolean isUpwards){
		setActive(true);
		this.isUpwards = isUpwards;
		currentX= x;
		setX(currentX);
		currentY = y;
		setY(currentY);
	}
	public void reset() { 
		currentX = 600;
		setX(600);
		currentY = 600;
		setY(600);
		setActive(false);
		System.out.println("missile removed");
	}

	public void update() {
		// if active is not true then no update is necessary for the base
		// missile
		if (isActive()) {
			// Check to see the direction and adjust numbers accordingly, then
			// check if the
			if (isUpwards == true) {
				currentY = currentY - 5;
				setY(currentY);
				if (currentY <= -10) {
					setActive(false);
				}
			} else {
				currentY = currentY + 5;
				setY(currentY);
				if (currentY >= 510) {
					setActive(false);
				}
			}
		}

	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(currentX, currentY, 2, 10);
	}

//	public boolean isActive() {
//		return active;
//	}
//
//	public void setActive(boolean active) {
//		this.active = active;
//	}

}
