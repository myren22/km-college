import java.util.Scanner;

public class TriangleArea {
	public static void main(String[] args) 
		{
		Scanner myScanner = new Scanner(System.in);
		int base;
		int height;
		double area;
		
		System.out.print("Triangle's Base: ");
		base = myScanner.nextInt();
		System.out.print("Triangle's Height: ");
		height = myScanner.nextInt();
		area = base * height * 0.5;
		System.out.println("The area of a triangle of base " +base+ " and height " + height + " is " +area);
		}
	}
