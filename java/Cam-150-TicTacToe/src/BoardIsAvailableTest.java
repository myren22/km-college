import static org.junit.Assert.*;

import org.junit.Test;

public class BoardIsAvailableTest {

    @Test
    public void testNewBoard() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
              
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX0() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 0;
        b.setX(pos);      
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX1() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 1;
        b.setX(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX2() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 2;
        b.setX(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX3() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 3;
        b.setX(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX4() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 4;
        b.setX(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX5() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 5;
        b.setX(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX6() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 6;
        b.setX(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX7() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 7;
        b.setX(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX8() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 8;
        b.setX(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX9() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 9;
        b.setX(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX10() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 10;
        b.setX(pos);      
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO0() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 0;
        b.setO(pos);      
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO1() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 1;
        b.setO(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO2() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 2;
        b.setO(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO3() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 3;
        b.setO(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO4() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 4;
        b.setO(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO5() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 5;
        b.setO(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO6() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 6;
        b.setO(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO7() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 7;
        b.setO(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO8() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 8;
        b.setO(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO9() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 9;
        b.setO(pos);      
        temp[pos-1] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO10() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        int pos = 10;
        b.setO(pos);      
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX3SetO5() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        b.setX(3);
        b.setO(5);
        b.setX(3);
        temp[2] = false;
        temp[4] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO2X4X6() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        b.setX(4);
        b.setO(2);
        b.setX(6);
        b.setO(2);        
        temp[1] = false;
        temp[3] = false;
        temp[5] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetO5OccupiedX() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        b.setX(5);
        b.setO(5);
        temp[4] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailSetX4O8() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = true;
        b.setX(4);
        b.setO(8);
        b.setX(8);
        temp[3] = false;
        temp[7] = false;
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }

    @Test
    public void testAvailAllFull() {
        Board b = new Board();
        boolean [] temp   = new boolean [9];
        boolean actual;
        boolean expected;
        for(int i=0;i<9;i++)
              temp[i] = false;
        b.setX(1);
        b.setO(2);
        b.setX(3);
        b.setX(4);
        b.setO(5);
        b.setX(6);
        b.setX(7);
        b.setO(8);
        b.setX(9);
        for (int k=0;k<9;k++){
            actual = b.isAvailable(k+1);
            expected = temp[k];
            assertEquals( "The result in position "+(k+1)+" is incorrect ", expected, actual );
        }
    }
}