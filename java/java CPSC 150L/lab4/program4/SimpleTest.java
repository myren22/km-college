import java.util.Scanner;

public class  SimpleTest {
		//Kyle Myren
		//3-18-2013
		//this program provides methods to calculate loan and investment changes
		
	//(1)  Loan balance after n payments have been made	
	public static double method1(double amount, double interestRate, int WhichPeriod, double Payment) 
		{
		double balance;
		
		balance = amount * Math.pow((1 + interestRate), WhichPeriod) - Payment/interestRate * (Math.pow((1 + interestRate), WhichPeriod) - 1);
		
		return balance;
		}
	
	//(2)  Payment amount on a loan	
	public static double method2(double amount, double interestRate, int periods) 
		{
		double payment;
		
		payment = (interestRate * amount)/(1 - Math.pow((1 + interestRate), (-1* periods)));
		
		return payment;		
		}
	
	//(3)  Number of payments on a loan
	public static double method3(double amount, double interestRate, double Payment) 
        {
		double numberOfPayments;
		
		numberOfPayments = (-1 * Math.log(1 - interestRate * amount / Payment))/(Math.log(1 + interestRate));
		
		return numberOfPayments;		
		} 
	
	//(4)  Original loan amount
	public static double method4(double interestRate, double Payment, int periods) 
 		{
		double amount;
		
		amount = Payment / interestRate * (1 - Math.pow((1 + interestRate), (-1 * periods)));
		
		return amount;
		}      

	//(5)  Payment amount to reach an investment goal
	public static double method5(double interestRate, double finalAmount, int periods) 
		{
		double paymentAmount;
		
		paymentAmount = (interestRate * finalAmount)/(Math.pow((1 + interestRate), periods) - 1);
		
		return paymentAmount;
		}   

	//(6)  Number of payments to reach an investment goal
	public static double method6(double interestRate, double finalAmount, double Payment)
		{
		double numberOfPayments;
		
		numberOfPayments = Math.log(1 + interestRate * finalAmount / Payment)/Math.log(1 + interestRate);
		
		return numberOfPayments;
		
		}	
	public static void main(String[] args) 
		{		
		}
	}
