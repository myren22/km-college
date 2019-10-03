import java.util.Scanner;

public class PRSTester {
	public static void main(String[] args) 
		{
		//Kyle Myren
		//Worked for 2 hours on 2014-02-04
		//Worked for 4 hours on 2014-02-10
			//Received help from Landon Reams
		//This program asks the names of 2 users and calculates a 
		//winner of a game of rock paper scissors.
		
		
		//Declare Scanner
		Scanner in = new Scanner(System.in);

		//Declare Variables
		String user1;
		String user2;
		int choice1val;
		int choice2val;
		String choice1type;
		String choice2type;			
		
		//Prompt User1 for a name
		System.out.println("User1, please enter your name: ");
		//Take User1 name
		user1 = in.next();
		//Prompt User1 for choice
		System.out.println(user1 + ", please enter your choice " 
			+ "(0 for paper, 1 for rock or 2 for scissors): "); 
		//Take User1's choice of PRS
		choice1val = in.nextInt();
			//If an invalid value is given, alert user once.
		if (choice1val == 0 || choice1val == 1 || choice1val == 2 ){
			System.out.println();
			}
		else{
			System.out.println("Sorry " + user1 + ", " + choice1val + " is an invalid value." 
				+ " Please enter 0 for paper, 1 for rock, or 2 for scissors: ");
			choice1val = in.nextInt();
			}
		//The user will be kept entering values until the computer accepts a valid number
		while((choice1val != 0)&&(choice1val != 1)&&(choice1val != 2)){
			choice1val = in.nextInt();
			}
			
		//Prompt User2 for a name
		System.out.println("User2, please enter your name: ");
		//Take User2 name
		user2 = in.next();
		//Prompt User2 for choice
		System.out.println(user2 + ", please enter your choice " 
			+ "(0 for paper, 1 for rock or 2 for scissors): "); 
		//Take User2's choice of PRS
		choice2val = in.nextInt();
			//If an invalid value is given, alert user once. wait until valid value given.
		if (choice2val == 0 || choice2val == 1 || choice2val == 2 ){
			System.out.println();
			}
		else{
			System.out.println("Sorry " + user2 + ", " + choice2val + " is an invalid value." 
				+ " Please enter 0 for paper, 1 for rock, or 2 for scissors: ");
			choice2val = in.nextInt();
			}
			
		// The user will be kept entering values until the computer accepts a valid number
		while((choice2val != 0)&&(choice2val != 1)&&(choice2val != 2)){
			choice2val = in.nextInt();
			}
		
		//Reinterpret choice numbers as objects
		if (choice1val == 0)
			{
			choice1type = "paper";
			}
		else if (choice1val == 1)
			{
			choice1type = "rock";
			}
		else 
			{
			choice1type = "scissors";
			}
			
		if (choice2val == 0)
			{
			choice2type = "paper";
			}
		else if (choice2val == 1)
			{
			choice2type = "rock";
			}
		else 
			{
			choice2type = "scissors";
			}
		
		//Calculate Outcome
		if(choice1val==choice2val) //if both players had same choice
			{
			//Print outcome of a tie
			System.out.println("The game has ended in a tie. Both " +user1
				+ " and " +user2+ " chose " + choice1type+ ".");
			}
		//Check if user1 won by checking if he had any of the 3 winning match ups
		else if((choice1val==0 && choice2val==1)||(choice1val==1 && choice2val==2)||(choice1val==2 && choice2val==0))
			{
			//Print outcome for user1 winning
			System.out.println(choice1type+ " beats " +choice2type+ ". Sorry " +user2+ ", " +user1+ " wins.");
			}
		//Check if user2 won by checking if he had any of the 3 winning match ups	
		else if((choice1val==1 && choice2val==0)||(choice1val==2 && choice2val==1)||(choice1val==0 && choice2val==2))
			{
			//Print outcome for user2 winning
			System.out.println(choice2type+ " beats " +choice1type+ ". Sorry " +user1+ ", " +user2+ " wins.");
			}
		
		}
	}