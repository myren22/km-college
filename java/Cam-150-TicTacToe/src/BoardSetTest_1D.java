import static org.junit.Assert.*;

import org.junit.Test;

public class BoardSetTest_1D {
    char BLANK = 'N';


    @Test
    public void testNewBoard() {
        Board b = new Board();
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX0() {
        Board b = new Board();
        int pos = 0;
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX1() {
        Board b = new Board();
        int pos = 1;
        char val = 'X';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX2() {
        Board b = new Board();
        int pos = 2;
        char val = 'X';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX3() {
        Board b = new Board();
        int pos = 3;
        char val = 'X';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX4() {
        Board b = new Board();
        int pos = 4;
        char val = 'X';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX5() {
        Board b = new Board();
        int pos = 5;
        char val = 'X';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX6() {
        Board b = new Board();
        int pos = 6;
        char val = 'X';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
  }

    @Test
    public void testSetX7() {
        Board b = new Board();
        int pos = 7;
        char val = 'X';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX8() {
        Board b = new Board();
        int pos = 8;
        char val = 'X';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX9() {
        Board b = new Board();
        int pos = 9;
        char val = 'X';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
   }

    @Test
    public void testSetX10() {
        Board b = new Board();
        int pos = 10;
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        b.setX(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO0() {
        Board b = new Board();
        int pos = 0;
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }
    
    @Test
    public void testSetO1() {
        Board b = new Board();
        int pos = 1;
        char val = 'O';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO2() {
        Board b = new Board();
        int pos = 2;
        char val = 'O';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO3() {
        Board b = new Board();
        int pos = 3;
        char val = 'O';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO4() {
        Board b = new Board();
        int pos = 4;
        char val = 'O';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO5() {
        Board b = new Board();
        int pos = 5;
        char val = 'O';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO6() {
        Board b = new Board();
        int pos = 6;
        char val = 'O';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO7() {
        Board b = new Board();
        int pos = 7;
        char val = 'O';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO8() {
        Board b = new Board();
        int pos = 8;
        char val = 'O';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
   }

    @Test
    public void testSetO9() {
        Board b = new Board();
        int pos = 9;
        char val = 'O';
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[pos-1] = val;
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO10() {
        Board b = new Board();
        int pos = 10;
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        b.setO(pos);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testTrySetX3OccupiedX() {
        Board b = new Board();
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[2] = 'X';
        expected[4] = 'O';
        b.setX(3);
        b.setO(5);
        b.setX(3);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testTrySetO2OccupiedO() {
        Board b = new Board();
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[3] = 'X';
        expected[1] = 'O';
        expected[5] = 'X';
        b.setX(4);
        b.setO(2);
        b.setX(6);
        b.setO(2);        
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testTrySetO5OccupiedX() {
        Board b = new Board();
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[4] = 'X';
        b.setX(5);
        b.setO(5);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testTrySetX8OccupiedO() {
        Board b = new Board();
        char [] expected   = {BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK,BLANK};
        expected[3] = 'X';
        expected[7] = 'O';
        b.setX(4);
        b.setO(8);
        b.setX(8);
        char [] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }
}