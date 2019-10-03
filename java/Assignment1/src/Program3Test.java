//	Kyle	100%, Michael 100%, both completed independently before contacting each other.

import static org.junit.Assert.*;

import org.junit.Test;

public class Program3Test {
	@Test
	public void testAmazingArray1x1() {
		int[][] array1    = { {-5} };
		assertTrue(Program3.isAmazingArray(array1));
	}
	
	@Test
	public void testAmazingArray2x2() {
		int[][] array1    = { {1,2},
				             {2,1}  };
		assertTrue(Program3.isAmazingArray(array1));
	}
	
	@Test
	public void testOrdinaryArray2x2() {
		// rows add to 11, columns don't
		int[][] array1    = { {0,11},
				             {5,6}  };
		assertFalse(Program3.isAmazingArray(array1));

		// columns add to 11, rows don't
		int[][] array2    = { {5,0},
	                          {6,11}  };
        assertFalse(Program3.isAmazingArray(array2));
	}
	
	@Test
	public void testAmazingArray3x3() {
		int[][] array1    = { {4,9,2},
				             {3,5,7},
			                 {8,1,6} };
		assertTrue(Program3.isAmazingArray(array1));
	}

	@Test
	public void testOrdinaryArray3x3() {
		// rows add to 15, columns don't
		int[][] array1    = { {9,3, 3},
				             {1, 1,13},
			                 {5, 5, 5} };
		assertFalse(Program3.isAmazingArray(array1));
		
		// columns add to 15, rows don't
		int[][] array2    = { {5,1,10},
				             {5, 1, 2},
			                 {5, 13, 3} };
		assertFalse(Program3.isAmazingArray(array2));
	}
	
	@Test
	public void testAmazingArray4x4() {
		int[][] array1    = { {1,2,3,0},
				             {3,0,1,2},
			                 {0,1,2,3},
			                 {2,3,0,1} };
		assertTrue(Program3.isAmazingArray(array1));
		
		int[][] array2    = { {  1, 0, 0, 0},
	                         {-99, 0, 1, 99},
                             {  0, 1, 0, 0},
                             { 99, 0, 0,-98} };
        assertTrue(Program3.isAmazingArray(array2));
        
		int[][] array3    = { { 1, 2,15,16},
                             { 6,11, 7,10},
                             {13,12, 4, 5},
                             {14, 9, 8, 3} };
        assertTrue(Program3.isAmazingArray(array3));
	}
	
	@Test
	public void testOrdinaryArray4x4() {
		// columns add to 6, rows don't
		int[][] array1    = { {1,2,1,2},
				             {3,1,3,0},
			                 {0,0,0,3},
			                 {2,3,2,1} };
		assertFalse(Program3.isAmazingArray(array1));
		
		// rows add to 6, columns don't
		int[][] array2    = { {2,0,3,1},
				             {1,2,1,2},
			                 {2,0,3,1},
			                 {1,3,0,2} };
		assertFalse(Program3.isAmazingArray(array2));
	}
	
	@Test
	public void testOrdinaryArray3x5() {
		int[][] array1    = { { 6, 7, 8, 9,10},
				             {13, 3, 1,11,12},
			                 { 5,14,15, 4, 2} };
		assertFalse(Program3.isAmazingArray(array1));
	}
	
	@Test
	public void testAmazingArray1x5() {
		int[][] array1    = { { 0, 0, 0, 0, 0} };
		assertTrue(Program3.isAmazingArray(array1));
	}
	
	@Test
	public void testAmazingArray2x4() {
		int[][] array1    = { {-1, 1,-1, 1},
				             { 1,-1, 1,-1} };
		assertTrue(Program3.isAmazingArray(array1));
	}
}