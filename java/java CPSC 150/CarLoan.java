//Kyle Myren
	//Worked for 2 hours on 2014-02-12
	//Worked for 4 hours on 2014-02-20
			//Received help from Landon Reams on using printf command
	//This program takes the price of a car, its depreciation
	//the interest rate and time span of loan taken to show the change
	//in the car's value and when the loan payments will outweigh the worth of the car

import java.util.Scanner;

public class CarLoan{
	public static void main(String[] args){
		
			//Variables
		double carInitVal;
		double deprec;
		double interLoan;
		double carDeprVal;
		double payment;
		double amtPaid = 0;
		int month = 0;
		int loanLength;
				
			//Declare Scanner
		Scanner in = new Scanner(System.in);
		
			//Ask to enter price of car
		System.out.print("Enter the price of the care you wish to buy-> ");
			//Take price
		carInitVal = in.nextDouble();		
		
			//Ask for monthly rate of depreciation
		System.out.print("Enter the monthly rate of depreciation of your car-> ");
			//take rate
		deprec = in.nextDouble();
		
			//ask for interest rate of loan
		System.out.print("Enter the interest rate of your loan-> ");
			//take rate
		interLoan = in.nextDouble();
		
			//ask for number of monthly payments
		System.out.print("Enter the number of monthly payments of the loan-> ");
			//take total payments
		loanLength =in.nextInt();
		
		System.out.println();
		System.out.println();

			//setup table header. print :Month	Car Value	Amount Paid
		System.out.printf("%5s \t %9s \t %10s \n", "Month", "Car Value", "Amount Paid");
		
			//calculate amount per payment
		payment = ((interLoan/12)* carInitVal)/(1 - Math.pow((1 + interLoan/12), -loanLength));
			
			
		carDeprVal = carInitVal;
		
		// while (current car value is less than total amount paid
				// OR month paying is < loan length)
		while((carDeprVal > amtPaid)&&(month < loanLength))	
		{
			month++;
				// depreciate car			
			carDeprVal = carDeprVal - carDeprVal * deprec;
			
				// Loan payment
			amtPaid = payment * month;
			
				//print:  month of payment, car val, amount paid
			System.out.printf("%8d $%.2f \t $%.2f \n", month, carDeprVal, amtPaid);
		}
		System.out.println();
		if(month < loanLength)
		{
			System.out.println("You will have paid more than your car is worth in " + month + " months. ");
		}



		
		
	}
}