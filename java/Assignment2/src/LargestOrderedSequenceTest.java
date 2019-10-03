
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class LargestOrderedSequenceTest {

	@Test
	public void test0() {
		Integer[]          array    = { };
		ArrayList<Integer> list     = new ArrayList<Integer>(Arrays.asList( array ));
		int                actual   = LargestOrderedSequence.getLargestOrderedSequence( list );
		int                expected = 0;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test1() {
		Integer[]          array    = { 19 };
		ArrayList<Integer> list     = new ArrayList<Integer>(Arrays.asList( array ));
		int                actual   = LargestOrderedSequence.getLargestOrderedSequence( list );
		int                expected = 1;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test2() {
		Integer[]          array    = { 42, 21 };
		ArrayList<Integer> list     = new ArrayList<Integer>(Arrays.asList( array ));
		int                actual   = LargestOrderedSequence.getLargestOrderedSequence( list );
		int                expected = 1;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test3() {
		Integer[]          array    = { -3, 0, 1, -4 };
		ArrayList<Integer> list     = new ArrayList<Integer>(Arrays.asList( array ));
		int                actual   = LargestOrderedSequence.getLargestOrderedSequence( list );
		int                expected = 3;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test4() {
		Integer[]          array    = { 1, 2, 3, 4, 0, 19, 1, 1, 2, 2, 3, 3, 2 };
		ArrayList<Integer> list     = new ArrayList<Integer>(Arrays.asList( array ));
		int                actual   = LargestOrderedSequence.getLargestOrderedSequence( list );
		int                expected = 6;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test5() {
		Integer[]          array    = { 1, 3, 5, 4, 21, 37, 42, 1, 3, 6, 5 };
		ArrayList<Integer> list     = new ArrayList<Integer>(Arrays.asList( array ));
		int                actual   = LargestOrderedSequence.getLargestOrderedSequence( list );
		int                expected = 4;
		assertEquals( "Incorrect result", expected, actual );
	}
}

