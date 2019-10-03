import java.util.Scanner;



public class MyLoanTest{

	public static void main(String[] args){
		//Kyle Myren
		//Worked for 5 hours on 2014-02-27
		//Worked for 4 hours on 2014-02-28		
		//This program accepts a user conditions and then outputs a sentence as a problem it will solve
		//then solves the problem in a second sentence. there are 10 examples that do this.
		
		//declare scanner
		Scanner in = new Scanner(System.in);
		
		//variables
		
		double amount;
		double interestRate;
		int WhichPeriod;
		double Payment;
		int lengthOfLoan;
		double finalAmount;
		int periods;
		int timeYears;
		double deductionAmount;
		double closingCosts;
		double downPayment;		
		double method1out;
		double method2out;
		double method3out;
		double method4out;
		double method5out;
		double method6out;		
		
		
		
		//Example 1
			//inputs: Loan Amount, Annual Interest Rate (as a percentage), Length of Loan (in months), Payment Number, Monthly Payment Amount 
			//method 1
			System.out.println();
			System.out.println("Example 1");
			System.out.print("Loan Amount: ");			
			amount = in.nextDouble();
			System.out.print("Annual Interest Rate (as a percentage): ");
			interestRate = in.nextDouble();
			System.out.print("Length of Loan (in months): ");
			lengthOfLoan = in.nextInt();
			System.out.print("Payment Number:");
			WhichPeriod =in.nextInt();
			System.out.print("Monthly Payment Amount:");
			Payment = in.nextDouble();
			
			//Example 1 Output				
			
			System.out.printf("%s $%.2f %s %.2f%s %d %s %s %d%s $%.2f %s ", 
			"You have a", amount, "car loan at", interestRate, "% for", lengthOfLoan, 
			"months.", "You have just made your", WhichPeriod, "th payment of", Payment, "and would like to know the payoff amount.");
			
			//divide interest rate by 12 and 100. 
			method1out = SimpleTest.method1(amount, interestRate/1200, WhichPeriod, Payment);
			
			System.out.println();
			
			System.out.printf("%s $%.2f %s %.2f%s %d %s %d %s $%.2f",
			"Example 1: The balance on an", amount, "loan at", interestRate, "% for", lengthOfLoan, "months after", WhichPeriod, "payments is", method1out);
		
			
			
			
		//Example 2
			//inputs: Loan Amount, Down Payment (as a percentage), Length of Mortgage (in years), Annual Interest Rate
			//method 2
			System.out.println();
			System.out.println("Example 2");
			System.out.print("Loan Amount:");			
			amount = in.nextDouble();
			System.out.print("Down Payment (as a percentage):");
			downPayment = in.nextDouble();
			System.out.print("Length of Mortgage (in years):");
			periods = in.nextInt();
			System.out.print("Annual Interest Rate (as a percentage):");
			interestRate = in.nextDouble();
			
			
			System.out.printf("%s $%.0f %s %.0f%s %d%s %.1f%s",
			"You are buying a", amount, "house, with", downPayment, "% down, on a", periods, "-year mortage at a fixed rate of",
			interestRate, "%. What is the monthly payment?");			
			
			//Calculate monthly payment
				// interestRate = interestRate/1200; 			set to monthly and percentage
				// periods = periods*12; 						set to monthly
				// amount = amount - amount*downPayment/100; 	decrease amount by downpayment
			method2out = SimpleTest.method2(amount - amount*downPayment/100,
											interestRate/1200,
											periods*12);
			System.out.println();
			System.out.printf("%s $%.0f %s %.0f%s %d %s %.1f%s $%.2f",
			"Example 2: The monthly payment on a", amount, "house, with a", downPayment, "% down payment, on a",
			periods, "year mortgage at", interestRate, "% is", method2out);
			
			
		//Example 3
		// amount=3500;
		// interestRate=6;
		// Payment=100;
			//inputs: Loan Amount, Annual Interest Rate (as a percentage), Monthly Payment Amount. 
			//method 3
			System.out.println();
			System.out.println("Example 3");
			System.out.print("Loan Amount:");			
			amount = in.nextDouble();
			System.out.print("Annual Interest Rate (as a percentage):");
			interestRate = in.nextDouble();
			System.out.print("Monthly Payment Amount:");
			Payment = in.nextDouble();
			
			System.out.printf("%s $%.0f %s %.1f%s %s $%.1f %s",
			"Aunt sally offers to lend you", amount, "at", interestRate, "% for that new home theater system you want.",
			"If you pay her back", Payment, "a month, how long will it take?");
			
			//change interest rate into percent and month
			method3out = SimpleTest.method3(amount, 
											interestRate/1200, 
											Payment);
			
			System.out.println();
			System.out.printf("%s %.2f %s $%.2f %s %.2f%s $%.2f %s",
			"Example 3: It will take", method3out, "months to pay off a", amount, "loan at ", interestRate, 
			"% interest, if you pay back", Payment, "a month.");
			
		
		
		//Example 4
		// amount=15000;
		// interestRate=5;
		// Payment=100;
			//inputs: Account balance, Annual Interest Rate (as a percentage), Monthly Withdrawal Amount.	
			//method 3
			System.out.println();
			System.out.println("Example 4");
			System.out.print("Account balance:");
			amount = in.nextDouble();
			System.out.print("Annual Interest Rate (as a percentage):");
			interestRate = in.nextDouble();
			System.out.print("Monthly Withdrawal Amount:");
			Payment = in.nextDouble();
			
			System.out.printf("%s $%.2f %s %.2f%s %s $%.2f %s",
			"You have", amount, "in a", interestRate, "% savings account, which is compounded monthly.",
			"How long will it take to run down the account if you withdrew", Payment, "a month.");
			
			//turn interest rate into monthly and percentage
			method3out =  SimpleTest.method3(amount, 
											interestRate/1200, 
											Payment);
			System.out.println();							
			System.out.printf("%s $%.2f %s $%.2f %s %.2f%s $%.2f %s",
			"Example 4: It will take", method3out, "months to empty a savings account with",
			amount, "that accrues interest at", interestRate, "% if you withdraw", Payment, "a month.");
		
				
		//Example 5
		// Payment=60;
		// timeYears=3;
		// interestRate=16.9;
			//inputs: Monthly Payment Amount, Number of Years, Annual Interest Rate (as a percentage). 
			//method 4
			System.out.println();
			System.out.println("Example 5");
			System.out.print("Monthly Payment Amount:");
			Payment = in.nextDouble();
			System.out.print("Number of years:");
			timeYears = in.nextInt();
			System.out.print("Annual Interest Rate (as a percentage):");
			interestRate = in.nextDouble();
			
			System.out.printf("%s $%.2f %s %.2f%s %s",
			"You're looking to buy furniture for your living room. You can afford to pay about", Payment,
			"a month over the next three years, and your credit card charges", interestRate, "% interest. How much",
			"furniture can you buy?");
			
			//change interest rate to decimal and monthly
			//change period from years to months
			method4out = SimpleTest.method4(interestRate/1200,
											Payment, 
											timeYears*12);
			
			
			
			System.out.println();
			System.out.printf("%s $%.2f %s $%.2f %s %d %s %.2f%s",
			"Example 5: You can afford a purchase total of", method4out, "if you pay", Payment, "a month for",
			timeYears, "years with a credit card at", interestRate, "% interest.");
			
		
		//Example 6
		// Payment=100;
		// interestRate=6;
		// lengthOfLoan=5;
		// amount=0;
			//inputs: Monthly Investment, Annual Interest Rate (as a percentage), Length of Loan (in years) 
			//method 1
			System.out.println();
			System.out.println("Example 6");
			System.out.print("Monthly Investment:");
			Payment = in.nextDouble();
			System.out.print("Annual Interest Rate (as a percentage):");
			interestRate = in.nextDouble();
			System.out.print("Length of Loan (in years):");
			lengthOfLoan = in.nextInt();
			amount = 0;
			
			System.out.printf("%s $%.2f %s %.2f%s %d %s",
			"At the end of every month, you put", Payment, "into a mutual fund that pays", interestRate, 
			"%, compounded monthly. How much will you have at the end of", lengthOfLoan, "years?");
			
			//change interest rate to percent/months 
			//change loan period to months
			method1out = SimpleTest.method1(amount,
											interestRate/1200,
											lengthOfLoan*12,
											-Payment);
			
			System.out.println();
			System.out.printf("%s $%.2f %s %.2f%s %d %s $%.2f",
			"Example 6: If you put",Payment, "into a mutual fund every month that pays", interestRate,
			"%, compounded monthly, at the end of", lengthOfLoan, "years, you will have", method1out);
			
		
		
		//Example 7
		// timeYears = 20;
		// Payment = 500;
		// interestRate= 4;
			//inputs: Length of Annuity (in years), Monthly Payment, Annual Interest Rate (as a percentage) 
			//method 4
			System.out.println();
			System.out.println("Example 7");
			System.out.print("Length of Annuity (in years):");
			timeYears = in.nextInt();
			System.out.print("Monthly Payment Amount:");
			Payment = in.nextDouble();
			System.out.print("Annual Interest Rate (as a percentage):");
			interestRate = in.nextDouble();
			
			System.out.printf("%s %d%s $%.2f %s %.2f%s",
			"You want to purchase a", timeYears, "-year annuity that will pay", Payment,
			"a month. If the guaranteed interest rate is", interestRate, "%, how much will the annuity cost?");
			
			//change interest rate to month and percent
			//change annuity to months
			method4out = SimpleTest.method4(interestRate/1200,
											Payment,
											timeYears*12);
			System.out.println();
			System.out.printf("%s %d%s $%.2f %s $%.2f %s %.2f%s",
			"Example 7: In order to fund a", timeYears, "-year annuity that pays", Payment, "a month, you will need a one-time payment of",
			method4out, "with a", interestRate, "% interest rate.");
		
		
		
		//Example 8
		// amount = 250000;
		// timeYears= 5;
		// closingCosts= 2500;
		// interestRate= 5.5;
		// downPayment = 10;
			//inputs: Number of Years to Save, Price of the House, Closing Costs, Down Payment(as a percentage), Annual percentage return 
			//method 5
			System.out.println();
			System.out.println("Example 8");
			System.out.print("Number of Years to Save:");
			timeYears = in.nextInt();
			System.out.print("Price of the House:");
			amount = in.nextDouble();
			System.out.print("Closing Costs:");
			closingCosts = in.nextDouble();
			System.out.print("Down Payment (as a percentage):");
			downPayment = in.nextDouble();
			System.out.print("Annual percentage return:");
			interestRate = in.nextDouble();
			
			System.out.printf("%s %d %s $%.2f %s %.2f%s %.2f %s %.2f%s",
			"You are saving up for a down payment on a house. You expect to buy in about", timeYears, "years, and you will be looking in the",
			amount, "range. You need to make at least a", downPayment, "% down payment, plus", closingCosts, "for closing costs. If you money funds pays",
			interestRate, "%, posted and compounded every month how much do you need to deposit?");
			
			
			//amount*downPayment/100 + closingCosts
			method5out = SimpleTest.method5(interestRate/1200,
											amount*downPayment/100+closingCosts,
											timeYears*12);
			
			System.out.println();
			System.out.printf("%s $%.2f %s %.2f%s $%.2f %s %d %s %.2f%s $%.2f %s",
			"Example 8: You will need to invest", method5out, "a month to a fund that pays", interestRate, "% in order to buy your house worth",
			amount, "in", timeYears, "years with a", downPayment, "% down payment and", closingCosts, "closing costs.");
			
		
		
		//Example 9				
			//inputs: Annual Investment Amount, Annual Rate of Increase (as a percentage), Target Savings Amount.	
			//method 6
			System.out.println();
			System.out.println("Example 9");
			System.out.print("Annual Investment Amount:");
			Payment = in.nextDouble();
			System.out.print("Annual Rate of Increase (as a percentage):");
			interestRate = in.nextDouble();
			System.out.print("Target Savings Amount:");
			amount = in.nextDouble();
			
			System.out.printf("%s $%.2f %s %.2f%s %s $%.2f %s",
			"On the same day every year, you put", Payment, "into stocks. If the market rises", interestRate, "% a year,",
			"how many years will it take you to accumulate", amount, "?");
			
			//change interest rate to decimal
			method6out = SimpleTest.method6(interestRate/100,
											amount,
											Payment);
			
			System.out.println();
			System.out.printf("%s $%.2f %s %.2f%s %.2f %s $%.2f %s",
			"Example 9: If you invest", Payment, "a year in stocks with a market rise of", interestRate, "% a year, it will take you",
			method6out, "years to accumulate", amount, ".");
			
			
		
		//Example 10
			//inputs: Investment Amount, Annual Interest Rate (as a percentage), First Year Deduction Amount, Number of Payment Installations.	
			//method 2
			System.out.println();
			System.out.println("Example 10");
			System.out.print("Investment Amount:");
			amount = in.nextDouble();
			System.out.print("Annual Interest Rate (as a percentage):");
			interestRate = in.nextDouble();
			System.out.print("First Year Deduction Amount:");
			deductionAmount = in.nextDouble();
			System.out.print("Number of Payment Installations:");
			timeYears = in.nextInt();
			
			
			System.out.printf("Suppose you invest the $%.2f at %.2f%% over %d years." + 
			" How much could you get every year if you take $%.2f at the start of the first year?", amount, interestRate, timeYears, deductionAmount); 
			
			
			method2out = SimpleTest.method2(amount-deductionAmount,
											interestRate/100,
											timeYears-1);
			System.out.println();
			System.out.printf("Example 10: If you invest $%.2f at %.2f%% over %d years" +
			"and take %.2f in the first year, you will receive %.2f every year afterward.",  amount, interestRate, timeYears, deductionAmount, method2out);

			
	}
}