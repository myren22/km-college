import java.util.Scanner;
public class EuclidGCD {

    public static void main(String[] args) {
    	    	
    	  int X;
	
    	  int Y;
	
    	  int Z;
	
    	  int A;
	
    	  int B;
	
    	  Scanner Scan = new Scanner(System.in);
	
    	  System.out.print("Enter First Number: ");
	
    	  X = Scan.nextInt();
	
    	  A = X;
	
    	  System.out.print("Enter Second Number: ");
	
    	  Y = Scan.nextInt();
	
    	  Z = Y;
	
    	  if (X < 0 || Y < 0) {
	
    	  	  System.out.print("POSITIVE NUMBERS ONLY");
			}
	
			if (Y > X) {
			
				Y = A;
			
				X = Z;
		}
		
		else if (Y == X) {
		
			B = X;
		
		}
		
		while (Y != 0) {
		
			int C = X % Y;
			X = Y;
			Y = C;
		}
	System.out.println("The GCD of " + A + " and " + Z + " is: " + X);
    }

}


