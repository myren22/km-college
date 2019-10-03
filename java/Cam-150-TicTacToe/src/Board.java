/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    public static int SIZE = 9;
    private char [] board;
    private char BLANK = 'N';
    
  public char [] getBoard(){
      return board;
  }
  public Board(){
      board = new char [SIZE];
      //Good coding practice is to do the below in a loop
      board[0] =BLANK;
      board[1] =BLANK;
      board[2] =BLANK;
      board[3] =BLANK;
      board[4] =BLANK;
      board[5] =BLANK;
      board[6] =BLANK;
      board[7] =BLANK;
      board[8] =BLANK;
      //---loop above^
    }
  public void display(){
      System.out.println(board[0] +"  " + board[1] +"  " + board[2] +"  ");
      System.out.println(board[3] +"  " + board[4] +"  " + board[5] +"  ");
      System.out.println(board[6] +"  " + board[7] +"  " + board[8] +"  ");
      
      
      
      //this is where the 3by3 grid goes
    }

  public void setX(int index){
        //check if index is equal to 0-8 and index location isAvailable
      
          if(isAvailable(index)){
              if(index==1){ board[0]='X';     }
              if(index==2){ board[1]='X';     }
              if(index==3){ board[2]='X';     }
              if(index==4){ board[3]='X';     }
              if(index==5){ board[4]='X';     }
              if(index==6){ board[5]='X';     }
              if(index==7){ board[6]='X';     }
              if(index==8){ board[7]='X';     }
              if(index==9){ board[8]='X';     }
    
          }
      
    }

  public void setO(int index){
      if(index>=0 && index<=9){
          if(isAvailable(index)){
              if(index==1){ board[0]='O';     }
              if(index==2){ board[1]='O';     }
              if(index==3){ board[2]='O';     }
              if(index==4){ board[3]='O';     }
              if(index==5){ board[4]='O';     }
              if(index==6){ board[5]='O';     }
              if(index==7){ board[6]='O';     }
              if(index==8){ board[7]='O';     }
              if(index==9){ board[8]='O';     }
    
          }
      }

    }

  public boolean isAvailable(int index){
      if(index==1){  
          if(board[0]==BLANK)
              return true;
          else{ 
              return false;
          }
      }
      if(index==2){ 
          if(board[1]==BLANK)
              return true;
          else{ 
              return false;
          }
      }
      if(index==3){
          if(board[2]==BLANK)
              return true;
          else{ 
              return false;
          }
      }
      if(index==4){ 
          if(board[3]==BLANK)
              return true;
          else{ 
              return false;
          }
      }
      if(index==5){ 
          if(board[4]==BLANK)
              return true;
          else{ 
              return false;
          }
      }
      if(index==6){ 
          if(board[5]==BLANK)
            return true;
          else{ 
              return false;
          }
      }
      if(index==7){ 
          if(board[6]==BLANK)
              return true;
          else{ 
              return false;
          }
      }
      if(index==8){ 
          if(board[7]==BLANK)
              return true;
          else{ 
              return false;
          }
      }
      if(index==9){
          if(board[8]==BLANK)
              return true;
          else{ 
              return false;
          }
      }

   return true; }

  public boolean win(){
      if(board[0]=='O' & board[1]=='O' & board[2]=='O'){
          return true;
      }
      if(board[3]=='O' & board[4]=='O' & board[5]=='O'){
          return true;
      }
      if(board[6]=='O' & board[7]=='O' & board[8]=='O'){
          return true;
      }
      if(board[0]=='O' & board[3]=='O' & board[6]=='O'){
          return true;
      }
      if(board[1]=='O' & board[4]=='O' & board[7]=='O'){
          return true;
      }
      if(board[2]=='O' & board[5]=='O' & board[8]=='O'){
          return true;
      }
      if(board[0]=='O' & board[4]=='O' & board[8]=='O'){
          return true;
      }
      if(board[2]=='O' & board[4]=='O' & board[6]=='O'){
          return true;
      }
      
      
      if(board[0]=='X' & board[1]=='X' & board[2]=='X'){
          return true;
      }
      if(board[3]=='X' & board[4]=='X' & board[5]=='X'){
          return true;
      }
      if(board[6]=='X' & board[7]=='X' & board[8]=='X'){
          return true;
      }
      if(board[0]=='X' & board[3]=='X' & board[6]=='X'){
          return true;
      }
      if(board[1]=='X' & board[4]=='X' & board[7]=='X'){
          return true;
      }
      if(board[2]=='X' & board[5]=='X' & board[8]=='X'){
          return true;
      }
      if(board[0]=='X' & board[4]=='X' & board[8]=='X'){
          return true;
      }
      if(board[2]=='X' & board[4]=='X' & board[6]=='X'){
          return true;
      }

    return false;}

  public char getWinner(){
        if(board[0]=='O' & board[1]=='O' & board[2]=='O'){
          return 'O';
      }
      if(board[3]=='O' & board[4]=='O' & board[5]=='O'){
          return 'O';
      }
      if(board[6]=='O' & board[7]=='O' & board[8]=='O'){
          return 'O';
      }
      if(board[0]=='O' & board[3]=='O' & board[6]=='O'){
          return 'O';
      }
      if(board[1]=='O' & board[4]=='O' & board[7]=='O'){
          return 'O';
      }
      if(board[2]=='O' & board[5]=='O' & board[8]=='O'){
          return 'O';
      }
      if(board[0]=='O' & board[4]=='O' & board[8]=='O'){
          return 'O';
      }
      if(board[2]=='O' & board[4]=='O' & board[6]=='O'){
          return 'O';
      }
      
      
      if(board[0]=='X' & board[1]=='X' & board[2]=='X'){
          return 'X';
      }
      if(board[3]=='X' & board[4]=='X' & board[5]=='X'){
          return 'X';
      }
      if(board[6]=='X' & board[7]=='X' & board[8]=='X'){
          return 'X';
      }
      if(board[0]=='X' & board[3]=='X' & board[6]=='X'){
          return 'X';
      }
      if(board[1]=='X' & board[4]=='X' & board[7]=='X'){
          return 'X';
      }
      if(board[2]=='X' & board[5]=='X' & board[8]=='X'){
          return 'X';
      }
      if(board[0]=='X' & board[4]=='X' & board[8]=='X'){
          return 'X';
      }
      if(board[2]=='X' & board[4]=='X' & board[6]=='X'){
          return 'X';
      }
      return BLANK;
    }


  public boolean done(){
      if(board[0]==BLANK)  return false;
      if(board[1]==BLANK)  return false;
      if(board[2]==BLANK)  return false;
      if(board[3]==BLANK)  return false;
      if(board[4]==BLANK)  return false;
      if(board[5]==BLANK)  return false;
      if(board[6]==BLANK)  return false;
      if(board[7]==BLANK)  return false;
      if(board[8]==BLANK)  return false;
      else return true;
      }




}