import java.io.*;
import java.util.Scanner;

public class CookieJar {
	public static void cashingIn(File input, File output){
		try{
			//input string:“2 quarters 4 dimes 1 penny 3 nickels 3 pennies”
			Scanner scan= new Scanner(input);
			PrintWriter writer = new PrintWriter(output);		
			
			int quarters =0;
			
			int dimes=0;
			int pennies=0;
			int nickels=0;
			
			while(scan.hasNext()){
				int x= scan.nextInt();
				String next = scan.next();
				
				if(next.equals("quarters")||next.equals("quarter")){
					quarters += x;
				}
				if(next.equals("dimes")||next.equals("dime")){
					dimes += x;
				}
				if(next.equals("nickels")||next.equals("nickel")){
					nickels += x;
				}
				if(next.equals("pennies")||next.equals("penny")){
					pennies += x;
				}
			}
			
			//parse string
			//recognize the plural and singular form of names
			//print to output file
			double sum = quarters*.25 + dimes*.10 + nickels*.05 + pennies*.01;
			if(sum == 0){
				writer.print("You have no money in the jar");
			}
			else{
				writer.printf("You have $%,.2f" + " in the jar", sum);
			}
			writer.close();
			scan.close();
		}
		catch(IOException e){
			
		}
	}
}
