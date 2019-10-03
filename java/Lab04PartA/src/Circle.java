import java.awt.Point;

public class Circle extends Shape {
	private double radius;
	//constructor
	public Circle(Point center, double theRadius){
		super("Circle");
		if(theRadius > 0)
		{	
			radius = theRadius;
		}
		else
		{
			radius = 0;
		}
		Point[] centerArray = new Point[1];
		centerArray[0] = center;
		setPoints(centerArray);
	}
	
	
	//getRadius
	public double getRadius(){
		return radius;
	}
	
	//getPerimeter
	public double getPerimeter(){
		double perimeter = 1;
		perimeter = 2 * Math.PI * radius;
		return perimeter;
	}
}
