
import static org.junit.Assert.*;

import org.junit.Test;

public class DriverTest {

	@Test
	public void test0_PersonIsADriverAndMover() {
		Person person = new Person( 32 );
		assertTrue( "Incorrect result", person instanceof Driver );
		assertTrue( "Incorrect result", person instanceof AbstractMover );
	}
	public void test1_PersonHasGetForce() {
		Mover mover   = new Person( 42 );
		int    actual   = mover.getForce();
		int    expected = 42;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test3_PersonHasEquals() {
		Mover  a, b;
		boolean actual;
		// equal to itself
		a      = new Person( 42 );
		actual = a.equals( a );
		assertTrue ( "Incorrect result", actual );
		// equal to another mover with the same force
		a      = new Person( 2 );
		b      = new Person( 2 );
		actual = a.equals( b );
		assertTrue ( "Incorrect result", actual );
		// not equal to another person with a different force 
		a      = new Person( 21 );
		b      = new Person( 20 );
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to another mover with the same force 
		a      = new Person        ( 2 );
		b      = new AbstractMover( 2 ) { };
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to null
		actual = a.equals( null );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals( "bar" );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals(  -5  );
		assertFalse( "Incorrect result", actual );
	}
	@Test
	public void test4_PersonHasCompareTo() {
		Person a, b;
		int    actual;
		// equal to itself
		a      = new Person( 42 );
		actual = a.compareTo( a );
		assertTrue( "Incorrect result", actual == 0 );
		// equal to another mover with the same force
		a      = new Person( 90 );
		b      = new Person( 90 );
		actual = a.compareTo( b );
		assertTrue( "Incorrect result", actual == 0 );
		// goes before a more powerful mover 
		a      = new Person( 23 );
		b      = new Person( 24 );
		actual = a.compareTo( b );
		assertTrue( "Incorrect result", actual < 0 );
		// goes after a less powerful mover 
		actual = b.compareTo( a );
		assertTrue( "Incorrect result", actual > 0 );
	}
	@Test
	public void test1_DonkeyIsADriverAndMover() {
		Donkey donkey = new Donkey( 32 );
		assertTrue( "Incorrect result", donkey instanceof Driver );
		assertTrue( "Incorrect result", donkey instanceof AbstractMover );
	}
	public void test2_DonkeyHasGetForce() {
		Mover mover   = new Donkey( 42 );
		int    actual   = mover.getForce();
		int    expected = 42;
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void test3_DonkeyHasEquals() {
		Mover  a, b;
		boolean actual;
		// equal to itself
		a      = new Donkey( 42 );
		actual = a.equals( a );
		assertTrue ( "Incorrect result", actual );
		// equal to another mover with the same force
		a      = new Donkey( 2 );
		b      = new Donkey( 2 );
		actual = a.equals( b );
		assertTrue ( "Incorrect result", actual );
		// not equal to another donkey with a different force 
		a      = new Donkey( 21 );
		b      = new Donkey( 20 );
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to another mover with the same force 
		a      = new Donkey           ( 5 );
		b      = new AbstractMover( 5 ) { };
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to null
		actual = a.equals( null );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals( "donkey" );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals(  5  );
		assertFalse( "Incorrect result", actual );
	}
	@Test
	public void test4_DonkeyHasCompareTo() {
		Donkey a, b;
		int actual;
		// equal to itself
		a      = new Donkey( 42 );
		actual = a.compareTo( a );
		assertTrue( "Incorrect result", actual == 0 );
		// equal to another mover with the same force
		a      = new Donkey( 910 );
		b      = new Donkey( 910 );
		actual = a.compareTo( b );
		assertTrue( "Incorrect result", actual == 0 );
		// goes before a more powerful mover 
		a      = new Donkey( 23 );
		b      = new Donkey( 24 );
		actual = a.compareTo( b );
		assertTrue( "Incorrect result", actual < 0 );
		// goes after a less powerful mover 
		actual = b.compareTo( a );
		assertTrue( "Incorrect result", actual > 0 );
	}
}