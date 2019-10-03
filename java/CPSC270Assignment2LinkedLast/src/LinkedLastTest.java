//Kyle Myren 100%, alex noak worked independently 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;




public class LinkedLastTest {
	/*	Methods to test
	 * 
	 * add		- at index
	 * add		- at last
	 * 		insert	-	alternative method name used in later 270 classes
	 * clear
	 * contains
	 * equals
	 * get
	 * getSize
	 * 		length	-	alternative method name used in later 270 classes
	 * indexOf
	 * isEmpty
	 * iterator
	 * remove	- 	at index
	 * remove	- 	first occurrence of value
	 * set
	 */
	//
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void basicListBuilderTest() throws IndexOutOfBoundsException{		
		//tests addAtLast, and get
		
		LinkedLast<String> B = new LinkedLast<String>();
		B.add("first");
		B.add("second");
		B.add("third");
		
		String expected;
		String actual;
		
		//current indexing is... 0=second , 1=third, 2=first
		
		expected = "first";
		actual = B.get(0);
		assertEquals( "Incorrect result at index 0", expected, actual );	
		
		expected = "second";
		actual = B.get(1);
		assertEquals( "Incorrect result at index 1", expected, actual );
		
		expected = "third";
		actual = B.get(2);
		assertEquals( "Incorrect result at index 2", expected, actual );
		
		//index out of bounds
		B.get(5);
		
		fail("index was out of bounds in the above");
	}
	
	@Test
	public void sizeTest(){
		LinkedLast<String> B = new LinkedLast<String>();
		
		assertEquals("Size wrong", 0, B.getSize());
		

		B.add("first");
		assertEquals("Size wrong", 1, B.getSize());
		
		B.add("second");
		assertEquals("Size wrong", 2, B.getSize());
		
		B.add("third");
		assertEquals("Size wrong", 3, B.getSize());		
	}
	
	@Test
	public void isEmptyTest(){
		LinkedLast<String> B = new LinkedLast<String>();
		
		assertTrue("List is empty", B.isEmpty());
		

		B.add("first");
		assertFalse("List should have 1 item", B.isEmpty());
		
		B.add("second");
		assertFalse("List should have 2 items", B.isEmpty());
		
		B.add("third");
		assertFalse("List should have 3 items", B.isEmpty());		
	}
	
	@Test
	public void clearTest(){
		LinkedLast<String> B = new LinkedLast<String>();
		
		B.add("first");
		
		B.clear();
		
		assertTrue("List is empty", B.isEmpty());
	}
	
	@Test
	public void indexOfandContainsTest(){
		LinkedLast<String> B = new LinkedLast<String>();
		B.add("first");
		B.add("second");		
		B.add("third");
		B.add("fourth");
		B.add("fifth");
		
		
		int actual = B.indexOf("third");
		assertEquals("index of third", 2, actual);
		
		actual = B.indexOf("nein");
		assertEquals("requested index of element not in list", -1, actual);
		
		assertTrue(B.contains("fourth"));
		assertFalse(B.contains("nein"));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void outOfBoundsTest() throws IndexOutOfBoundsException{
		LinkedLast<String> B = new LinkedLast<String>();
		B.add("first");
		B.add("second");		
		B.add("third");
		B.add("fourth");
		B.add("fifth");
		
		B.add(7, "oh no!");
		
		fail("index was out of bounds in the above");
		
	}
	
	@Test
	public void removeAddIndex(){
		LinkedLast<String> B = new LinkedLast<String>();
		B.add("first");
		B.add("second");		
		B.add("third");
		B.add("fourth");
		B.add("fifth");
		
		B.remove(2);
		
		assertEquals("size match", 4, B.getSize());
		assertEquals("index 2", "fourth", B.get(2));
		assertEquals("index 3", "fifth", B.get(3));
		
		B.add(2, "third");
		
		assertEquals("size match", 5, B.getSize());
		assertEquals("index 2", "third", B.get(2));
		assertEquals("index 3", "fourth", B.get(3));
	}
	
	@Test
	public void equalsTest(){
		LinkedLast<String> B = new LinkedLast<String>();
		B.add("first");
		B.add("second");		
		B.add("third");
		
		
		LinkedLast<String> A = new LinkedLast<String>();
		A.add("first");
		A.add("second");		
		A.add("third");
		
		LinkedLast<String> C = new LinkedLast<String>();
		C.add("first");
		C.add("second");		
		C.add("thirty");
		
		assertFalse(A.equals(C));
		
	}
	
	@Test
	public void removeTest(){
		LinkedLast<String> B = new LinkedLast<String>();
		B.add("first");
		B.add("second");		
		B.add("third");
		
		B.remove("second");
		
		assertEquals("size match", 2, B.getSize());
		assertEquals("index 1", "first", B.get(0));
		assertEquals("index 1", "third", B.get(1));
	}
	
	@Test
	public void setTest(){
		LinkedLast<String> B = new LinkedLast<String>();
		B.add("first");
		B.add("second");		
		B.add("third");
		
		B.set(2, "five");
		
		assertEquals("size match", 3, B.getSize());
		assertEquals("index 2", "five", B.get(2));
	}
	
	

	
}

