import java.util.Scanner;

public class CircleArea {
	public static void main(String[] args) 
		{
		Scanner myScanner = new Scanner(System.in);
		double radius;
		double area;
		
		System.out.print("Circle's radius: ");
		radius = myScanner.nextDouble();
		area = radius * radius * 3.14159;
		System.out.println("The area of a circle of radius " +radius+ " is " +area);
		}
	}
