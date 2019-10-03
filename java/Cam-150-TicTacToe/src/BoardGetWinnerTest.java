import static org.junit.Assert.*;

import org.junit.Test;

public class BoardGetWinnerTest {
    char BLANK = 'N';

    @Test
    public void testNewBoard() {
        Board b = new Board();
        char expected = BLANK;
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testXWinTopRow() {
        Board b = new Board();
        char expected = 'X';
        b.setX(1);
        b.setO(7);
        b.setX(9);
        b.setO(5);
        b.setX(3);
        b.setO(6);
        b.setX(2);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testXWinMidRow() {
        Board b = new Board();
        char expected = 'X';
        b.setX(5);
        b.setO(2);
        b.setX(1);
        b.setO(9);
        b.setX(4);
        b.setO(7);
        b.setX(6);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testXWinBotRow() {
        Board b = new Board();
        char expected = 'X';
        b.setX(7);
        b.setO(4);
        b.setX(5);
        b.setO(3);
        b.setX(8);
        b.setO(2);
        b.setX(9);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testXWinLeftCol() {
        Board b = new Board();
        char expected = 'X';
        b.setX(5);
        b.setO(2);
        b.setX(1);
        b.setO(9);
        b.setX(4);
        b.setO(6);
        b.setX(7);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testXWinMidCol() {
        Board b = new Board();
        char expected = 'X';
        b.setX(7);
        b.setO(4);
        b.setX(5);
        b.setO(3);
        b.setX(8);
        b.setO(9);
        b.setX(2);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testXWinRightCol() {
        Board b = new Board();
        char expected = 'X';
        b.setX(1);
        b.setO(7);
        b.setX(9);
        b.setO(5);
        b.setX(3);
        b.setO(2);
        b.setX(6);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testXWinMainDiag() {
        Board b = new Board();
        char expected = 'X';
        b.setX(5);
        b.setO(6);
        b.setX(3);
        b.setO(7);
        b.setX(1);
        b.setO(2);
        b.setX(9);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testXWinSecondDiag() {
        Board b = new Board();
        char expected = 'X';
        b.setX(5);
        b.setO(6);
        b.setX(1);
        b.setO(9);
        b.setX(3);
        b.setO(2);
        b.setX(7);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testOWinTopRow() {
        Board b = new Board();
        char expected = 'O';
        b.setO(1);
        b.setX(7);
        b.setO(9);
        b.setX(5);
        b.setO(3);
        b.setX(6);
        b.setO(2);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testOWinMidRow() {
        Board b = new Board();
        char expected = 'O';
        b.setO(5);
        b.setX(2);
        b.setO(1);
        b.setX(9);
        b.setO(4);
        b.setX(7);
        b.setO(6);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testOWinBotRow() {
        Board b = new Board();
        char expected = 'O';
        b.setO(7);
        b.setX(4);
        b.setO(5);
        b.setX(3);
        b.setO(8);
        b.setX(2);
        b.setO(9);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testOWinLeftCol() {
        Board b = new Board();
        char expected = 'O';
        b.setO(5);
        b.setX(2);
        b.setO(1);
        b.setX(9);
        b.setO(4);
        b.setX(6);
        b.setO(7);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testOWinMidCol() {
        Board b = new Board();
        char expected = 'O';
        b.setO(7);
        b.setX(4);
        b.setO(5);
        b.setX(3);
        b.setO(8);
        b.setX(9);
        b.setO(2);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testOWinRightCol() {
        Board b = new Board();
        char expected = 'O';
        b.setO(1);
        b.setX(7);
        b.setO(9);
        b.setX(5);
        b.setO(3);
        b.setX(2);
        b.setO(6);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testOWinMainDiag() {
        Board b = new Board();
        char expected = 'O';
        b.setO(5);
        b.setX(6);
        b.setO(3);
        b.setX(7);
        b.setO(1);
        b.setX(2);
        b.setO(9);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testOWinSecondDiag() {
        Board b = new Board();
        char expected = 'O';
        b.setO(5);
        b.setX(6);
        b.setO(1);
        b.setX(9);
        b.setO(3);
        b.setX(2);
        b.setO(7);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
        }
    

    @Test
    public void testNoWinAllFull() {
        Board b = new Board();
        char expected = BLANK;
        b.setX(5);
        b.setO(1);
        b.setX(9);
        b.setO(3);
        b.setX(2);
        b.setO(8);
        b.setX(4);
        b.setO(6);
        b.setX(7);
        char actual = b.getWinner();
        
        assertEquals( "The result is incorrect ", expected, actual );
    }
}