import java.util.Scanner;

public class MathMethods{
	public static double absoluteValue(double a)
		{
		// Scanner in = new Scanner(System.in);		
		
		// System.out.print("Enter a Value: ");		
		// a = in.nextDouble();
		if(a>=0)
		{
		}
		else
		{
		a = a * -1;
		}	
		return a;
		// System.out.println("Absolute Value: " + a);		
		}
	public static double minOf3Numbers(double valueOne, double valueTwo, double valueThree)
		{
		if (valueOne <= valueTwo && valueOne <= valueThree)
		{
		return valueOne;
		}
		else if (valueTwo < valueOne && valueTwo < valueThree) 
		{
		return valueTwo;
		}
		else 
		{
		return valueThree;
		}
		}
	public static boolean leapYear(int value)
		{
		if(value % 400 == 0){
		return true;	
		}
		else if(value % 100 == 0){
		return false;
		}
		else if(value % 4 == 0){
		return true;
		}
		else{
		return false;
		}
		}
	public static int factorial(int number)
		{
		int sum = 1;
		
		while	(number >= 1)	{		
		sum = sum * number;
		number--;		
		}	
		return sum;
		}
	public static int GCD(int X, int Y)
	{
    	  int A = X;
	   	  int Z = Y;
	
    	if (X < 0 || Y < 0) 
		{
			return -1;
		}
	
		if (Y > X) 
		{	
			Y = A;			
			X = Z;
		}
		
		else if (Y == X) 
		{		
			int B = X;
		}		
		while (Y != 0) 
		{		
			int C = X % Y;
			X = Y;
			Y = C;
		}		
		return X;
	}
	public static int combinations(int n, int r)
	{
	return MathMethods.factorial(n)/(MathMethods.factorial(r)*MathMethods.factorial(n-r));
	}
	public static void main(String[] args)
		{
		Scanner in = new Scanner(System.in);		
		double a;
		double b;
		double c;
		//System.out.print("Enter a Value: ");
		
		a = in.nextDouble();
		a = MathMethods.absoluteValue(a);
		//System.out.println("Absolute Value: " + a);
		
		 // System.out.print("Enter Value 1: "); 
		 double valueOne = in.nextDouble(); 		 
		 // System.out.print("Enter Value 2: "); 
		 double valueTwo = in.nextDouble(); 		 
		 // System.out.print("Enter Value 3: "); 
		 double valueThree = in.nextDouble(); 
		 
		 MathMethods.minOf3Numbers(valueOne, valueTwo, valueThree);
		 
		 int value = in.nextInt();
		 MathMethods.leapYear(value);
		 
		 int number = in.nextInt();
		 MathMethods.factorial(number);
		 
		 int X = in.nextInt();
		 int Y = in.nextInt();
		 MathMethods.GCD(X, Y);
		 
		 int n = in.nextInt();
		 int r = in.nextInt();
		 MathMethods.combinations(n, r);
		}
	}