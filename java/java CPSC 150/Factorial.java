import java.util.Scanner; 
public class Factorial 
{
	public static void main (String[] args) 
		 { 
		int number;
		

		 
		Scanner scannerIn = new Scanner(System.in); 

		System.out.print("Enter Number: "); 
		number = scannerIn.nextInt(); 

		int sum = 1;

		while	(number >= 1)	{		
		sum = sum * number;
		number--;		
		}	
		System.out.println("Factorial is: " + sum);
				
 } 
} 
