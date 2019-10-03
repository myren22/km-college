//My name is...
//This program adds 1 to whatever value user inputs
// I received help from X on how to do X

import java.util.Scanner;

public class
	{
	public static void main (String[] args)
		{
		//declare variables
		int userNumber;
		int resultNumber;
		
		//declare scanner
		Scanner myScanner = new Scanner(System.in);
		
		//prombt user
		System.out.println("Enter an integer");
		userNumber = myScanner.nextInt();
		
		//calculate result
		resultNumber = userNumber + 1;
		
		//print
		System.out.println("The next number is " + resultNumber);
		
		}
	}