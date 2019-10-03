import java.util.Scanner;

public class LeapYear {
public static void main (String args [])
	{
	Scanner in = new Scanner(System.in);
	System.out.println("Enter Year : ");
	int value = in.nextInt();
	
if(value % 400 == 0){
System.out.println("IT IS A LEAP YEAR");	
}
else if(value % 100 == 0){
System.out.println("IT IS NOT A LEAP YEAR");
}
else if(value % 4 == 0){
System.out.println("IT IS A LEAP YEAR");
}
else{
System.out.println("IT IS NOT A LEAP YEAR");
}
	}
}
