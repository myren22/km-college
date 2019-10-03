import java.awt.Point;

public abstract class Shape {
	private String  name;
	private Point[] points;
	
	protected Shape(String aName) {		
		name = aName;
	}
	
	public final String getName() {		
		return name;
	}

	protected final void setPoints(Point[] thePoints) {
		points = new Point[thePoints.length];		
		for(int i =0; i<points.length; i++)
		{
			points[i] = thePoints[i];
		}						
	}
	
	public final Point[] getPoints() {		
		return points;			
	}
	
	public abstract double getPerimeter();
	
	public static double getDistance(Point one, Point two) {
		double absDiffX = 0;
		double absDiffY = 0;
		double squareX = 0;
		double squareY = 0;
		double result = 0;
			//get difference in distance of x1,x2 and y1,y2
		absDiffX = one.getX() - two.getX();
		absDiffY = one.getY() - two.getY();
			//square each difference
		squareX = Math.pow(absDiffX, 2);
		squareY = Math.pow(absDiffY, 2);			
			//sum and squareroot
		result = Math.sqrt(squareY + squareX);		
		return result;
	}
}