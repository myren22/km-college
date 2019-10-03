import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest extends Polynomial {

	@Test
	public void testNewDefaultPolynomial() {
		Polynomial p = new Polynomial();

		int actual = p.order();
		int expected = 0;
		assertEquals("Default order should be 0.", expected, actual);

		actual = p.get(0);
		assertEquals("Default coefficient should be 0.", expected, actual);
	}

	@Test
	public void testNewOrderedPolynomial() {
		Polynomial p = new Polynomial(5);

		int actual = p.order();
		int expected = 5;
		assertEquals("Order should be 5.", expected, actual);

		// Test default coefficients
		expected = 0;
		for (int i = 0; i < p.order(); i++) {
			actual = p.get(i);
			assertEquals("Default coefficient should be 0.", expected, actual);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetNegativeOrder() {
		Polynomial p = new Polynomial(-1);
		p.order();
		fail("Does not throw IllegalArgumentException with negative order.");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetNonExistantPositiveTerm() {
		Polynomial p = new Polynomial();
		p.get(1000);
		fail("Does not throw IllegalArgumentException when accessing non-existant term.");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetNegativeTerm() {
		Polynomial p = new Polynomial();
		p.get(-1);
		fail("Does not throw IllegalArgumentException when accessing negative term.");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNonExistantPositiveTerm(){
		Polynomial p = new Polynomial();
		p.set(1,1);
		fail("Does not throw IllegalArgumentException when setting non-existant term.");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNegativeTerm() {
		Polynomial p = new Polynomial();
		p.set(-1,1);
		fail("Does not throw IllegalArgumentException when setting negative term.");
	}
	
	@Test
	public void testGetAndSet() {
		Polynomial p = new Polynomial(4);

		p.set(0, 1);
		p.set(1, 2);
		p.set(2, 3);
		p.set(3, 4);

		int actual = p.get(0);
		int expected = 1;
		assertEquals("Set does not change value.", expected, actual);

		actual = p.get(1);
		expected = 2;
		assertEquals("Set does not change value.", expected, actual);

		actual = p.get(2);
		expected = 3;
		assertEquals("Set does not change value.", expected, actual);

		actual = p.get(3);
		expected = 4;
		assertEquals("Set does not change value.", expected, actual);
	}

	@Test
	public void testAdd() {
		Polynomial p = new Polynomial(3);
		Polynomial q = new Polynomial(3);

		for (int i = 0; i < 3; i++) {
			p.set(i, 1);
			q.set(i, 1);
		}
		
		Polynomial sum = p.add(q);
		
		int   actual = sum.get(0);
		int expected = 2;
		assertEquals( "0: Does not add numbers.", expected, actual );
		
		actual = sum.get(1);
		expected = 2;
		assertEquals( "1: Does not add numbers.", expected, actual );
		
		actual = sum.get(2);
		expected = 2;
		assertEquals( "2: Does not add numbers.", expected, actual );
	}
	
	@Test
	public void testSubtract() {
		Polynomial p = new Polynomial(3);
		Polynomial q = new Polynomial(3);

		for (int i = 0; i < 3; i++) {
			p.set(i, i);
			q.set(i, -1);
		}
		
		Polynomial sum = p.add(q);
		
		int   actual = sum.get(0);
		int expected = -1;
		assertEquals( "0: Does not add negative numbers.", expected, actual );
		
		actual = sum.get(1);
		expected = 0;
		assertEquals( "1: Does not add negative numbers.", expected, actual );
		
		actual = sum.get(2);
		expected = 1;
		assertEquals( "2: Does not add negative numbers.", expected, actual );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNull(){
		Polynomial p = new Polynomial();
		Polynomial q = null;
		p.add(q);
		fail("Does not throw IllegalArgumentException when adding null value.");
	}

	@Test
	public void testZeroToString(){
		Polynomial p = new Polynomial(3);
		String actual = p.toString();
		String expected = "0";
		
		assertEquals("toString does not return zero for a zero-polynomial.", expected, actual);
	}
	
	//
	@Test
	public void testQuadraticString(){
		Polynomial p = new Polynomial(3);
		
		
		for (int i = 0; i < 3; i++) {
			p.set(i, 5);			
		}
		
		String actual = p.toString();
		String expected = "5x2+5x+5";
		
		assertEquals("toString does...", expected, actual);
				
	}
	@Test
	public void testConstantString(){
		Polynomial p = new Polynomial(0);
		p.set(0, 5);
		
		String actual = p.toString();
		String expected = "5";
		
		assertEquals("toString does...", expected, actual);
				
	}
	@Test
	public void testVariedSignString(){
		Polynomial p = new Polynomial(5);
		p.set(5, 10);
		p.set(4, 1);
		p.set(3, 0);
		p.set(2, -1);
		p.set(1, -10);
		
		String actual = p.toString();
		String expected = "10x5+x4-x2-10x";
		
		assertEquals("toString does...", expected, actual);
				
	}
	
	//constructor is creating an extra
	
	
	/*
	 * Tests needed:
	 * 
	 * new Polynomial(): test get( 0 ) test order = 0
	 * 
	 * add(Polynomial): adding null adding zeros adding positive values adding
	 * negative values
	 * 
	 * set(int, int): setting up polynomial
	 * 
	 * toString(): value: 0 coefficients: 0 coefficients: 1, -1 coefficients:
	 * 10, -10 exponent: 0 exponent: 1 exponent: 2
	 */

}