import java.awt.Graphics;



//Supplies coordinates for each ship that will be created, allows retrieval and setting of x,y

//setup restrictions on movement here or leave free?
public abstract class SIthing {
	private int x,y,width,height;
	private boolean isActive;
	
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	protected SIthing(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isActive = true;
	}
//	public void draw(Graphics g){
//		
//	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	
	
}
