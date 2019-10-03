package poop;
//Alex Hoak
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;


public class LinkedLastTest {
	
	@Test
	public <T> void testequalsEmptyLists(){
		LinkedLast<T> a = new LinkedLast<T>();
		LinkedLast<T> b = new LinkedLast<T>();
		boolean expected = true;
		boolean actual   = a.equals(b);
		assertEquals(expected, actual);
	}
    @Test
    public<T> void testDefaultLLisEmpty() {
    	LinkedLast<T> a = new LinkedLast<T>();
        boolean expected = true;
        boolean actual   = a.isEmpty();
        assertEquals(expected, actual);
    }
    @Test
    public<T> void testAdd(){
    	LinkedLast <Character> a = new LinkedLast<Character>();
        a.add('A');
        a.add('B');
        int expected = 2;
        int actual   = a.position();
   
       int actual2 = a.indexOf('B');
        assertEquals(expected, actual);
        assertEquals(expected, actual2);
    }
    @Test
    public<T> void AddIndex(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        
        a.add('A');
        a.add('B');
        a.add('C');
        
        a.add(2, 'D');
        
        char expected = 'D';
        int actual   = a.get(2);
        char expected2 = 'B';
        int actual2 = a.get(3);
        assertEquals(expected2, actual2);
        assertEquals(expected, actual);
    }
    @Test
    public<T> void Set(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        
        a.add('A');
        a.add('B');
        a.add('C');
        
        a.set(2, 'D');
        
        char expected = 'D';
        int actual   = a.get(2);
        assertEquals(expected, actual);
        char expected2 = 'D';
        char actual2 = a.set(2, 'D');
        assertEquals(expected2, actual2);

            }
    @Test
    public<T> void testDefaultLLisNotEmpty() {
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add('A');
        boolean expected = false;
        boolean actual   = a.isEmpty();
        assertEquals(expected, actual);
    }
    @Test
    public<T> void testSize(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        
        a.add('A');
        a.add('B');
        int expected = 2;
        int actual   = a.getSize();
        assertEquals(expected, actual);
       
    }
    @Test
    public<T> void testIndexOF(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
         
        a.add('A');
        a.add('B');
        a.add('C');    
        int expected = 2;
        int actual   = a.indexOf('B');
        assertEquals(expected, actual);
        
    }
    @Test(expected = IllegalArgumentException.class)
    public<T> void testgetEmptyList(){
    	LinkedLast<T> a = new LinkedLast<T>();
        a.get(2);
    }
   
    @Test
    public<T> void testgoFirst(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add('B');
        a.add('C');
        a.goFirst();
        int expected = 1;
        int actual   = a.position();
        assertEquals(expected, actual);
    }
    
    @Test
    public<T> void testgoNext(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add( 'A');
        a.add( 'B');
        a.add('C');
        a.goFirst();
        a.goNext();
        int expected = 2;
        int actual   = a.position();
        assertEquals(expected, actual);
    }
    
   
   
    @Test
    public<T> void testget(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add('A');
        char expected = 'A';
        char actual   = a.get(1);
        assertEquals(expected, actual);
    }
    @Test
    public<T> void testRemoveIndex(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add('A');
        a.add('B');
        a.add('C');
        a.remove(1);
        char expected = 'B';
        char actual = a.get(1);

        assertEquals(expected, actual);
    }
    @Test
    public<T> void testRemoveObject(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add('A');
        a.add('B');
        a.add('C');
        a.remove('A');
        char expected = 'B';
        char actual = a.get(1);

        assertEquals(expected, actual);
        expected = 'C';
        actual = a.get(2);
        assertEquals(expected, actual);
    }
    @Test
    public<T> void testequalsIfFalse(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add('A');
        LinkedLast<T> b = new LinkedLast<T>();
        boolean expected = false;
        boolean actual   = a.equals(b);
        boolean ac2      = b.equals(a);
        assertEquals(expected, actual);
        assertEquals(expected, ac2);

    }
    @Test
    public<T> void testequalsIfEqual(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add('A');
        LinkedLast<Character> b = new LinkedLast<Character>();
        b.add('A');
        boolean expected = true;
        boolean actual   = a.equals(b);
        boolean ac2      = b.equals(a);
        assertEquals(expected, actual);
        assertEquals(expected, ac2);
    }
    @Test
    public<T> void testContains(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add('A');
        boolean expected = true;
        boolean actual = a.contains('A');
        assertEquals(expected, actual);
        }
    @Test
    public<T> void testDoesNotContains(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add('A');
        boolean expected = false;
        boolean actual = a.contains('B');
        assertEquals(expected, actual);
        }
    @Test(expected =  IllegalArgumentException.class)
    public<T> void testClear(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
        a.add('A');
        a.clear();
        a.get(1);
    }
    @Test(expected =  NoSuchElementException.class)
    public<T> void testIteratorHasNext(){
    	LinkedLast<Character> a = new LinkedLast<Character>();
    	a.goNext();
    }
}
