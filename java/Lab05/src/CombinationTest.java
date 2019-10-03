import static org.junit.Assert.*;
import org.junit.Test;

public class CombinationTest {

	@Test
	public void testGetNumbers() {
		Combination a        = new Combination( 7, 6, 1 );
		int[]       expected = { 7, 6, 1 };
		int[]       actual   = a.getNumbers();
		
		assertArrayEquals( "Incorrect result", expected, actual );
	}

	@Test
	public void testNumbersAreWithinRange() {
		Combination a = new Combination( 0, 9, 1 );
		assertTrue( "Incorrect result", a.isWithinRange( 9 ));
	}
	@Test
	public void testNumbersAreNotWithinRange() {
		Combination a = new Combination( 0, 5, -9 );
		assertFalse( "Incorrect result", a.isWithinRange( 20 ));

		Combination b = new Combination( -1, 1, 2 );
		assertFalse( "Incorrect result", b.isWithinRange( 3 ));

		Combination c = new Combination( 2, 99, 3 );
		assertFalse( "Incorrect result", c.isWithinRange( 3 ));
	}

	@Test
	public void testEqualsIsTrueWithSelf() {
		Object a = new Combination( 1, 2, 3 );
		assertEquals( "Incorrect result", a, a );
	}
	@Test
	public void testEqualsIsTrueWithCopy() {
		Object a = new Combination( 4, 5, 6 ) { };
		Object b = new Combination( 4, 5, 6 ) { };
		assertEquals( "Incorrect result", a, b );
	}
	@Test
	public void testEqualsIsFalseWithDifferentCombination() {
		Object a = new Combination( 7, 8, 9 );
		Object b = new Combination( 7, 8, 0 );
		assertFalse( a.equals( b ));
	}
	@Test
	public void testEqualsIsFalseWithOtherObject() {
		Object a = new Combination( 4, 5, 6 );
		Object b = "4, 5, 6";
		assertFalse( "Incorrect result", a.equals( b ));
	}
}
