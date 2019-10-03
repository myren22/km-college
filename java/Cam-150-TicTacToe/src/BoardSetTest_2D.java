import static org.junit.Assert.*;

import org.junit.Test;

public class BoardSetTest_2D {
    char BLANK = 'N';


    @Test
    public void testNewBoard() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX0() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        b.setX(0);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX1() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[0][0] = 'X';
        b.setX(1);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX2() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[0][1] = 'X';
        b.setX(2);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX3() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[0][2] = 'X';
        b.setX(3);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX4() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[1][0] = 'X';
        b.setX(4);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX5() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[1][1] = 'X';
        b.setX(5);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX6() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[1][2] = 'X';
        b.setX(6);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX7() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[2][0] = 'X';
        b.setX(7);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX8() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[2][1] = 'X';
        b.setX(8);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX9() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[2][2] = 'X';
        b.setX(9);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetX10() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        b.setX(10);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO0() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        b.setO(0);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO1() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[0][0] = 'O';
        b.setO(1);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO2() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[0][1] = 'O';
        b.setO(2);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO3() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[0][2] = 'O';
        b.setO(3);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO4() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[1][0] = 'O';
        b.setO(4);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO5() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[1][1] = 'O';
        b.setO(5);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO6() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[1][2] = 'O';
        b.setO(6);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO7() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[2][0] = 'O';
        b.setO(7);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO8() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[2][1] = 'O';
        b.setO(8);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO9() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[2][2] = 'O';
        b.setO(9);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testSetO10() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        b.setO(10);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testTrySetX3OccupiedX() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[0][2] = 'X';
        expected[1][1] = 'O';
        b.setX(3);
        b.setO(5);
        b.setX(3);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testTrySetO2OccupiedO() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[0][1] = 'O';
        expected[1][0] = 'X';
        expected[1][2] = 'X';
        b.setX(4);
        b.setO(2);
        b.setX(6);
        b.setO(2);        
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testTrySetO5OccupiedX() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[1][1] = 'X';
        b.setX(5);
        b.setO(5);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }

    @Test
    public void testTrySetX8OccupiedO() {
        Board b = new Board();
        char [][] expected   = {{BLANK,BLANK,BLANK}, {BLANK,BLANK,BLANK},{BLANK,BLANK,BLANK}};
        expected[1][0] = 'X';
        expected[2][1] = 'O';
        b.setX(4);
        b.setO(8);
        b.setX(8);
        char [][] actual   = b.getBoard();
        
        assertArrayEquals( "The result is incorrect", expected, actual );
    }
}