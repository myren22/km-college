
import static org.junit.Assert.*;

import org.junit.Test;

public class CamelTest {

	@Test
	public void test0_CamelIsAVehicleAndAMover() {
		Camel camel = new Camel( new Person( 55 ) { } );
		assertTrue( "Incorrect result", camel instanceof Vehicle );
		assertTrue( "Incorrect result", camel instanceof Mover  );
	}
	@Test(expected=IllegalArgumentException.class)
	public void test1_CamelsCannotBeRiddenByAnyDriverOtherThanPeople_NEW() {
		new Camel( new Driver() { } );
	}
	@Test(expected=IllegalArgumentException.class)
	public void test2_CamelsCannotBeRiddenByAnyDriverOtherThanPeople_SET() {
		Camel camel = new Camel( new Person( 42 ) { } );
		camel.setDriver( new Driver() { } );
	}
	@Test
	public void test3_ACamelIsItsOwnMover() {
		Camel  camel  = new Camel( new Person( 99 ) { } );
		Mover mover = camel.getMover();
		assertTrue( "Incorrect result", camel == mover );
	}
	@Test(expected=IllegalArgumentException.class)
	public void test4_CamelsCannotHaveAMoverThatIsNotItself() {
		Mover anMover = new Mover() {
			@Override
			public int compareTo(Mover o) {
				return 0;
			}
			@Override
			public int getForce() {
				return 0;
			}
		};
		Camel camel = new Camel( new Person( 24 ) { } );
		camel.setMover( anMover );
	}
	@Test
	public void test5_ACamelReceivingNullOrItselfAsMoverSetMoverToItself() {
		Mover mover;
		Camel  camel  = new Camel( new Person( 99 ) { } );
		
		camel.setMover( null );
		mover = camel.getMover();
		assertTrue( "Incorrect result", camel == mover );
		
		camel.setMover( camel );
		mover = camel.getMover();
		assertTrue( "Incorrect result", camel == mover );
	}
	@Test
	public void test6_CamelHasEquals() {
		Mover  a, b;
		boolean actual;
		// equal to itself
		a      = new Camel( new Person( 21 ));
		actual = a.equals( a );
		assertTrue ( "Incorrect result", actual );
		// equal to another camel (regardless of driver)
		a      = new Camel( new Person( 42 ));
		b      = new Camel( new Person( 24 ));
		actual = a.equals( b );
		assertTrue ( "Incorrect result", actual );
		// not equal to null
		actual = a.equals( null );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals( "84" );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals(  48  );
		assertFalse( "Incorrect result", actual );
	}
	@Test
	public void test7_CamelHasCompareTo() {
		Camel a, b;
		int   actual;
		// equal to itself
		a      = new Camel( new Person( 52 ));
		actual = a.compareTo( a );
		assertTrue( "Incorrect result", actual == 0 );
		// equal to another camel (regardless of driver)
		a      = new Camel( new Person( 9 ));
		b      = new Camel( new Person( 8 ));
		actual = a.compareTo( b );
		assertTrue( "Incorrect result", actual == 0 );
	}
}