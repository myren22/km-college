
import static org.junit.Assert.*;

import org.junit.Test;

public class MoverTest {

	@Test
	public void test0_MoverImplementsComparableAndDefinesGetForce() {
		Mover mover = new Mover() {
			@Override
			public int compareTo(Mover o) {
				return 0;
			}
			@Override
			public int getForce() {
				return 0;
			}
		};
		assertTrue( "Incorrect result", mover instanceof Comparable );
	}
	@Test
	public void test1_AbstractMoverIsAnMover() {
		Mover mover = new AbstractMover( 2 ) { };
		assertTrue( "Incorrect result", mover instanceof Mover );
	}
	@Test
	public void test2_AbstractMoverHasGetForce() {
		Mover mover   = new AbstractMover( 24 ) { };
		int    actual   = mover.getForce();
		int    expected = 24;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test3_AbstractMoverHasEquals() {
		Mover  a, b;
		boolean actual;
		// equal to itself
		a      = new AbstractMover( 42 ) { };
		actual = a.equals( a );
		assertTrue ( "Incorrect result", actual );
		// equal to another mover with the same force
		a      = new AbstractMover( 19 ) { };
		b      = new AbstractMover( 19 ) { };
		actual = a.equals( b );
		assertTrue ( "Incorrect result", actual );
		// not equal to another mover with a different force 
		a      = new AbstractMover( 22 ) { };
		b      = new AbstractMover( 24 ) { };
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to null
		actual = a.equals( null );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals( "22" );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals(  22  );
		assertFalse( "Incorrect result", actual );
	}
	@Test
	public void test3_AbstractMoverHasCompareTo() {
		Mover a, b;
		int    actual;
		// equal to itself
		a      = new AbstractMover( 42 ) { };
		actual = a.compareTo( a );
		assertTrue( "Incorrect result", actual == 0 );
		// equal to another mover with the same force
		a      = new AbstractMover( 9000 ) { };
		b      = new AbstractMover( 9000 ) { };
		actual = a.compareTo( b );
		assertTrue( "Incorrect result", actual == 0 );
		// goes before a more powerful mover 
		a      = new AbstractMover( 23 ) { };
		b      = new AbstractMover( 24 ) { };
		actual = a.compareTo( b );
		assertTrue( "Incorrect result", actual < 0 );
		// goes after a less powerful mover 
		actual = b.compareTo( a );
		assertTrue( "Incorrect result", actual > 0 );
	}
	@Test
	public void test4_DonkeyIsAnMover() {
		Donkey donkey = new Donkey( 3 );
		assertTrue( "Incorrect result", donkey instanceof AbstractMover );
	}
	@Test
	public void test5_DonkeyHasGetForce() {
		Mover mover   = new Donkey( 4 );
		int    actual   = mover.getForce();
		int    expected = 4;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test5_DonkeyHasEquals() {
		Mover  a, b;
		boolean actual;
		// equal to itself
		a      = new Donkey( 42 );
		actual = a.equals( a );
		assertTrue ( "Incorrect result", actual );
		// equal to another mover with the same force
		a      = new Donkey( 19 );
		b      = new Donkey( 19 );
		actual = a.equals( b );
		assertTrue ( "Incorrect result", actual );
		// not equal to another mover with a different force 
		a      = new Donkey( 22 );
		b      = new Donkey( 24 );
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to another mover of equal force 
		a      = new Donkey            ( 21 );
		b      = new AbstractMover( 21 ) { };
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to null
		actual = a.equals( null );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals( "blah" );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals(  111  );
		assertFalse( "Incorrect result", actual );
	}
}