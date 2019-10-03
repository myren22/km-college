import java.util.Scanner;

public class RectangleArea {
	public static void main(String[] args) 
		{
		Scanner myScanner = new Scanner(System.in);
		int base;
		int height;
		int area;
		
		System.out.print("Rectangle's Base: ");
		base = myScanner.nextInt();

		System.out.print("Rectangle's Height: ");
		height = myScanner.nextInt();
		area = base * height;
		System.out.println("The area of a rectangle of base " +base+ " and height " + height + " is " +area);
		}
	}
