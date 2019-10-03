import java.awt.Point;


public class Triangle extends Shape{

	public Triangle(Point[] points)
	{
		super("Triangle");
		Point[] corners = new Point[3];
		for(int i = 0; i < 3; i++)
		{
			corners[i] = points[i];
		}
		setPoints(corners);
	}
	
	public double getPerimeter(){
		double result = 0.0;
		double totalDistance = 0.0;
		Point[] points = getPoints();
		// get distance of all 3 sides and sum
		for(int i = 0; i< points.length -1; i++)
		{
			totalDistance += getDistance(points[i], points[i + 1]);
		}
		totalDistance += getDistance(points[points.length - 1], points[0]);		
		return totalDistance;
	}
}
