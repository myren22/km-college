import static org.junit.Assert.*;

import org.junit.Test;

public class LockTest {
	@Test
	public void testNewLockIsOpenAndHasDialLimit() {
		Combination comb = new Combination( 8, 8, 1 ); 
		Lock        lock = new Lock( 9, comb );
		
		assertTrue( lock.isOpen() );
		
		int expected = 9;
		int actual   = lock.getDialLimit();
		
		assertEquals( "Incorrect result", expected, actual );
	}

	@Test(expected=InvalidLockCombinationException.class)
	public void testNewLockThrowsExceptionWhenCombinationNotWithinLimits() {
		Combination  comb = new Combination( 1, 5, 10 ); 
		new Lock( 5, comb ); // invalid combination. should throw exception.
	}

	@Test
	public void testLockIsOpenWhenNew() {
		Combination comb = new Combination( 0, 0, 7 ); 
		Lock        lock = new Lock( 7, comb );
		assertTrue( "Incorrect result", lock.isOpen() );
	}
	
	@Test
	public void testLockIsNotOpenWhenClosed() {
		Combination comb = new Combination( 3, 0, 6 );
		Lock        lock = new Lock( 7, comb );
		
		lock.close();
		assertFalse( "Incorrect result", lock.isOpen() );
	}

	@Test
	public void testClosedLockIsNotOpenedWithIncorrectCombination() {
		Combination comb = new Combination( 0, 0, 7 ); 
		Lock        lock = new Lock( 7, comb );
		Combination now  = new Combination( 1, 2, 3 ); 
		
		lock.close();
		lock.open( now );
		assertFalse( "Incorrect result", lock.isOpen() );
	}

	@Test
	public void testClosedLockIsOpenedWithCorrectCombination() {
		Combination comb = new Combination( 0, 0, 7 ); 
		Lock        lock = new Lock( 9, comb );
		Combination now  = new Combination( 0, 0, 7 ); 

		lock.close();
		lock.open( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}

	@Test
	public void testOpenedLockRemainsOpenedWithIncorrectCombination() {
		Combination comb = new Combination( 4, 4, 4 );
		Lock        lock = new Lock( 5, comb );
		Combination now  = new Combination( 8, 8, 8 ); 
		
		lock.open( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}
}
