//package lecture.assignments.spring2013.assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Program1Test {
	@Test
	public void testFirstLessSameLength() {
		int[]   one    = { 1, 2, 3, 4 };
		int[]   two    = { 2, 3, 4, 5 };
		boolean actual = Program1.allLess( one, two );
		assertTrue ( "Incorrect result",actual );
	}
	@Test
	public void testSecondLessSameLength() {
		int[]   one    = { 1, 2, 3, 4 };
		int[]   two    = { 4, 3, 3, 6 };
		boolean actual = Program1.allLess( one, two );
		assertFalse( "Incorrect result",actual );
	}
	@Test
	public void testFirstLessFirstLonger() {
		int[]   one    = { 8, 7, 8, 0, 2 };
		int[]   two    = { 9, 8, 9 };
		boolean actual = Program1.allLess( one, two );
		assertTrue ( "Incorrect result",actual );
	}
	@Test
	public void testFirstLessSecondLonger() {
		int[]   one    = { 4, 2 };
		int[]   two    = { 5, 4, 3, 2 };
		boolean actual = Program1.allLess( one, two );
		assertTrue ( "Incorrect result",actual );
	}
	@Test
	public void testSecondLessFirstLonger() {
		int[]   one    = { 5, 5, 5 };
		int[]   two    = { 4 };
		boolean actual = Program1.allLess( one, two );
		assertFalse( "Incorrect result",actual );
	}
	@Test
	public void testSecondLessSecondLonger() {
		int[]   one    = { 2 };
		int[]   two    = { 1, 0 };
		boolean actual = Program1.allLess( one, two );
		assertFalse( "Incorrect result",actual );
	}
	@Test
	public void testFirstSecondOverlap() {
		int[]   one    = { 3, 1, 3 };
		int[]   two    = { 2, 1, 2 };
		boolean actual = Program1.allLess( one, two );
		assertFalse( "Incorrect result",actual );
	}
	@Test
	public void testFirstEmpty() {
		int[]   one    = { };
		int[]   two    = { 2 };
		boolean actual = Program1.allLess( one, two );
		assertTrue ( "Incorrect result",actual );
	}
	@Test
	public void testSecondEmpty() {
		int[]   one    = { 1, -1 };
		int[]   two    = { };
		boolean actual = Program1.allLess( one, two );
		assertTrue ( "Incorrect result",actual );
	}
}