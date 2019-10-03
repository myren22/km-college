import static org.junit.Assert.*;

import org.junit.Test;

public class BoardDoneTest {



    @Test
    public void testNewBoard() {
        Board b = new Board();
        boolean expected = false;
        boolean actual = b.done();
        
       assertEquals( "The result is incorrect ", expected, actual );
        
    }

    @Test
    public void testDone1XPopulated() {
        Board b = new Board();
        boolean expected = false;
        b.setX(2);
        
        boolean actual = b.done();
        
       assertEquals( "The result is incorrect ", expected, actual );
        
    }

    @Test
    public void testDone1OPopulated() {
        Board b = new Board();
        boolean expected = false;
        b.setO(7);
        
        boolean actual = b.done();
        
       assertEquals( "The result is incorrect ", expected, actual );
        
    }

    @Test
    public void testDoneMultiPop() {
        Board b = new Board();
        boolean expected = false;
        b.setO(7);
        b.setX(4);
        b.setO(9);
        b.setX(3);
        
        boolean actual = b.done();
        
       assertEquals( "The result is incorrect ", expected, actual );
        
    }

    @Test
    public void testDoneAllFull() {
        Board b = new Board();
        boolean expected = true;
        b.setX(1);
        b.setO(2);
        b.setX(3);
        b.setX(4);
        b.setO(5);
        b.setX(6);
        b.setX(7);
        b.setO(8);
        b.setX(9);
        boolean actual = b.done();
        
       assertEquals( "The result is incorrect ", expected, actual );
        }
    }
