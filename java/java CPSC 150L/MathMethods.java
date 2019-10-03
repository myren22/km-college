import java.util.Scanner;

public class MathMethods{
	public static void absouluteValue(double)
		{
		Scanner in = new Scanner(System.in);
		double a;
		
		System.out.print("Enter a Value: ");		
		a = in.nextDouble();
		if(a>=0)
		{
		}
		else
		{
		a = a * -1;
		}
		System.out.println("Absolute Value: " + a);		
		}
	public static void main(String.args[])
		{
		MathMethods.absoluteValue(-3);
		}
	}