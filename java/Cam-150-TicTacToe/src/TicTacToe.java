import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class tictac here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicTacToe
{



    // instance variables
    Random r;
    Board board;
    Scanner scnr;
    
    public TicTacToe(){
        //constructor
        r= new Random();
        board = new Board(); 
        scnr = new Scanner(System.in);
        //a constructor that initializes all of the instance variables
        //board and r may be initialized with calls to their default constructor.
        // scanner's constructor should have System.in as a parameter 
        //(just like we always initialize Scanner objects to tie them to the keyboard).
    }
    
    public void start( )
    {
        System.out.println("This program plays tic-tac-toe");
        char yourMark =  getPlayerChar();
        char myMark;
        if (yourMark == 'X') // make sure yourMark returns capital X or O
              myMark = 'O';
        else
               myMark = 'X';
        while (!board.win( ) && !board.done( ))
        {
            int index;
            if (myMark == 'X') // if computer is X, computer goes first
              {
                  index = getComputerSpot( );
                  board.setX(index);
                  if (board.done( ) || board.win( ))
                      break; // is game over before player turn?
                  index = getPlayerSpot( );
                  board.setO(index);
              }
             else  // player is X, so goes first
                 {
                  index = getPlayerSpot( );
                  board.setX(index);
                   if (board.done( ) || board.win( ))
                      break;  // stop the loop if player has made last move
                  index = getComputerSpot( );
                  board.setO(index);
                }
        }
        board.display( );
       // if (board.win( ))
        //    System.out.println(board.getWinner( ) + " wins.");
        //else
          //  System.out.println("Nobody wins.");
    }

    public static void main(String[ ] args)
    {
        TicTacToe t = new TicTacToe( );
        t.start( );
    }
    public char getPlayerChar (){
    	//----------METHOD NEEDS WORK----------------------------
    	
        //This method asks the user to enter an X or an O. 
        System.out.println("Would you like to be X or O-> ");
        String input = scnr.next();
        input.toUpperCase();
        
        while(input.charAt(0)!='X'){
        	System.out.println("Your marker must be an X or an O");
        	String input2 = scnr.next();
        	input2.toUpperCase();
        	input = input2;
        }
        
        return input.charAt(0);
        //reader
        //cast
        
        //You will need to read this in as a String. 
        //Convert it to uppercase. 
        //If the user enters anything other than X or an O,
               //the method should ask the user to enter characters until either an X or an O is entered.
        //The uppercase X or O should be returned as a character (you will need charAt for this)

        
        
       

    }
    public int getComputerSpot(){
        int nbr = r.nextInt(Board.SIZE)+1;      // choose a random number between
                                                // 0 and 9 (not including 9).
                                                // spots are 1-9, so add 1 to nbr
       while (!board.isAvailable(nbr))
       {
         nbr = r.nextInt(Board.SIZE)+1;
        }
       return nbr;

    }
    public int getPlayerSpot(){
    	//----------METHOD NEEDS WORK----------------------------
    	
    	
       //println asking to choose an unoccupied number
       System.out.println("Choose the number where you want to play-> ");
       String input = scnr.next();
       //scanner
       //check the value of the number
       while(!board.isAvailable(input.charAt(0))){
           System.out.println("That number is not available. Choose another -> ");
           String input2 = scnr.next();
           input = input2;
        }
       //if the user chooses a number outside the range
            //or a number that is already occupied
       //the method asks the user to enter a number until the player chooses an unoccupied slot
       
        return input.charAt(0);
    }
}