//package lecture.assignments.spring2013.assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Program2Test {
	@Test
	public void test1() {
		int[][] array = { };
		int actual   = Program2.getMostRepeatedNumber( array );
		int expected = -1;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test2() {
		int[][] array = {
				{ 1 },
		};
		int actual   = Program2.getMostRepeatedNumber( array );
		int expected = 1;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test3() {
		int[][] array = {
				{ 3, 2, 3 },
		};
		int actual   = Program2.getMostRepeatedNumber( array );
		int expected = 3;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test4() {
		int[][] array = {
				{ 1, 2, 1 },
				{ 2, 4, 2 }
		};
		int actual   = Program2.getMostRepeatedNumber( array );
		int expected = 2;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test5() {
		int[][] array = {
				{ 7 },
				{ 9 },
				{ 9 },
				{ 7 },
				{ 9 },
		};
		int actual   = Program2.getMostRepeatedNumber( array );
		int expected = 9;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test6() {
		int[][] array = {
				{ 4, 2 },
				{ 3, 8 },
				{ 8, 2 }
		};
		int actual   = Program2.getMostRepeatedNumber( array );
		int expected = 2;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test7() {
		int[][] array = {
				{ 1, 2, 3, 4, 5, 6, 7, 8 },
				{ 0, 1, 2, 3, 4, 5, 6, 7 },
				{ 9, 0, 1, 2, 3, 4, 5, 6 },
				{ 8, 9, 0, 9, 8, 7, 6, 5 }
		};
		int actual   = Program2.getMostRepeatedNumber( array );
		int expected = 5;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test8() {
		int[][] array = {
				{ 0, 1, 0, 5 }, 
				{ 2, 3, 1, 6 }, 
				{ 4, 5, 2, 7 }, 
				{ 6, 7, 3, 8 }, 
				{ 8, 9, 4, 9 }
		};
		int actual   = Program2.getMostRepeatedNumber( array );
		int expected = 0;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test9() {
		int[][] array = {
				{ 0, 1, 0 }, 
				{ 2, 3, 9 }, 
				{ 4, 5, 0 }, 
				{ 6, 7, 9 }, 
				{ 8, 9, 1 }
		};
		int actual   = Program2.getMostRepeatedNumber( array );
		int expected = 0;
		assertEquals( "Incorrect result", expected, actual );
	}
}