import java.util.Scanner;

public class Change {
	public static void main(String[] args) 
		{
		Scanner myScanner = new Scanner(System.in);
		double payment;
		double price;
		int dollar;
		int quarter;
		int dime;
		int cent;
		
		System.out.print("Purchase: ");
		price = myScanner.nextDouble();
		System.out.print("Payment ");
		payment = myScanner.nextDouble();
		
		double change = payment - price;

		int change2 = (int)(change * 100);
		dollar = change2 /100;
		change2 = change2 - dollar *100;
		quarter = change2 /25;
		change2 = change2 -quarter*25;
		dime = change2 / 10;
		change2 = change2 - dime*10;
		//change = Math.round(change*100)/100;
		cent = change2;
		

		

		System.out.println("Given $" +payment+ " for a purchase of $" +price+ " we need");
		System.out.println(dollar + " dollars " + quarter + " quarters " + dime + " dimes " + cent + " cents");
		}
	}