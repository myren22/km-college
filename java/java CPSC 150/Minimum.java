import java.util.Scanner; 
public class Minimum 
{ public static void main (String[] args) 
 { 
 double valueOne; 
 double valueTwo;
 double valueThree; 
 
 Scanner scannerIn = new Scanner(System.in); 

 System.out.print("Enter Value 1: "); 
 valueOne = scannerIn.nextDouble(); 
 
 System.out.print("Enter Value 2: "); 
 valueTwo = scannerIn.nextDouble(); 
 
 System.out.print("Enter Value 3: "); 
 valueThree = scannerIn.nextDouble(); 

if (valueOne <= valueTwo && valueOne <= valueThree){
System.out.print("Minimum value: " + valueOne);}
  else if (valueTwo < valueOne && valueTwo < valueThree) {
  System.out.print("Minimum value: " + valueTwo);}
  else {
  System.out.print("Minimum value: " + valueThree);}
  	  
	
 } 
} 
