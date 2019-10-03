
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test0_VehicleHasDriver() {
		Driver  actual;
		Driver  aDriver = new Driver() { };
		Vehicle vehicle = new Vehicle( aDriver, null ) { };

		actual = vehicle.getDriver();
		assertEquals( "Incorrect result", aDriver, actual );

		Driver  another = new Driver() { };
		vehicle.setDriver( another );
		actual = vehicle.getDriver();
		assertEquals( "Incorrect result", another, actual );
	}
	private class AMoverSubClass implements Mover {
		private int force;
		public AMoverSubClass() { this( -1 ); }
		public AMoverSubClass(int theForce) { force = theForce; }
		@Override public int compareTo(Mover o) { return 0; }
		@Override public int getForce() { return force; }
		@Override public boolean equals(Object o) { return (o instanceof Mover) && (((Mover)o).getForce()==force); }
	}
	@Test
	public void test1_VehicleHasMover() {
		Mover  actual;
		Mover  anMover = new AMoverSubClass();
		Vehicle vehicle  = new Vehicle( null, anMover ) { };

		actual = vehicle.getMover();
		assertEquals( "Incorrect result", anMover, actual );

		Mover another   = new AMoverSubClass();
		vehicle.setMover( another );
		actual = vehicle.getMover();
		assertEquals( "Incorrect result", another, actual );
	}
	@Test
	public void test3_VehicleHasEquals() {
		Vehicle a, b;
		boolean actual;
		// equal to itself
		a      = new Vehicle( new Driver() {}, new AMoverSubClass() ) { };
		actual = a.equals( a );
		assertTrue ( "Incorrect result", actual );
		// equal to another vehicle with the same mover
		Mover anMover = new AMoverSubClass( 99 );
		a      = new Vehicle( new Driver() {}, anMover ) { };
		b      = new Vehicle( new Driver() {}, anMover ) { };
		actual = a.equals( b );
		assertTrue ( "Incorrect result", actual );
		// equal to another vehicle with a mover of the same force
		a      = new Vehicle( new Driver() {}, new AMoverSubClass( 37 ) ) { };
		b      = new Vehicle( new Driver() {}, new AMoverSubClass( 37 ) ) { };
		actual = a.equals( b );
		assertTrue ( "Incorrect result", actual );
		// not equal to another vehicle with a different mover 
		a      = new Vehicle( new Driver() {}, new AMoverSubClass( 23 ) ) { };
		b      = new Vehicle( new Driver() {}, new AMoverSubClass( 32 ) ) { };
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to null
		actual = a.equals( null );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals( "77" );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals(  91  );
		assertFalse( "Incorrect result", actual );
	}
	@Test
	public void test4_CartIsAVehicle() {
		Cart cart = new Cart( new Person( 65 ), new Donkey( 132 ) );
		assertTrue( "Incorrect result", cart instanceof Vehicle );
	}
	@Test
	public void test5_CartHasEquals() {
		Vehicle a, b;
		boolean actual;
		// equal to itself
		a      = new Cart( new Person( 31 ) {}, new Donkey( 345 ) ) { };
		actual = a.equals( a );
		assertTrue ( "Incorrect result", actual );
		// equal to another cart with the same mover
		a      = new Cart( new Person( 42 ) {}, new Donkey( 345 ) ) { };
		b      = new Cart( new Person( 15 ) {}, new Donkey( 345 ) ) { };
		actual = a.equals( b );
		assertTrue ( "Incorrect result", actual );
		// not equal to another vehicle with an mover of the same force
		a      = new Cart ( new Person( 56 ) {}, new Donkey( 33 ) ) { };
		b      = new Vehicle( new Person( 56 ) {}, new Donkey( 33 ) ) { };
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to another cart with a different mover 
		a      = new Cart ( new Person( 42 ) {}, new Donkey( 20 ) ) { };
		b      = new Cart ( new Person( 42 ) {}, new Donkey( 21 ) ) { };
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to null
		actual = a.equals( null );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals( "blah" );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals(  42  );
		assertFalse( "Incorrect result", actual );
	}
	@Test
	public void test6_ChariotIsAVehicle() {
		Chariot chariot = new Chariot( new Donkey( 32 ) {}, new Donkey( 500 ) );
		assertTrue( "Incorrect result", chariot instanceof Vehicle );
	}
	@Test
	public void test7_ChariotHasEquals() {
		Vehicle a, b;
		boolean actual;
		// equal to itself
		a      = new Chariot( new Donkey( 21 ), new Person( 35 )) { };
		actual = a.equals( a );
		assertTrue ( "Incorrect result", actual );
		// equal to another chariot with the same mover
		a      = new Chariot( new Donkey   ( 42 ), new Donkey( 345 ) ) { };
		b      = new Chariot( new Person( 42 ), new Donkey( 345 ) ) { };
		actual = a.equals( b );
		assertTrue ( "Incorrect result", actual );
		// not equal to another chariot with a mover of the same force
		a      = new Chariot( new Person( 42 ) {}, new Donkey( 31 ) ) { };
		b      = new Cart  ( new Person( 42 ) {}, new Donkey( 31 ) ) { };
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to another chariot with a different mover 
		a      = new Chariot( new Person( 39 ) {}, new Donkey( 90 ) ) { };
		b      = new Chariot( new Person( 39 ) {}, new Donkey( 21 ) ) { };
		actual = a.equals( b );
		assertFalse( "Incorrect result", actual );
		// not equal to null
		actual = a.equals( null );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals( "foo" );
		assertFalse( "Incorrect result", actual );
		// not equal to some other object
		actual = a.equals(   2  );
		assertFalse( "Incorrect result", actual );
	}
}