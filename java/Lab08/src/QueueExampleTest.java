import static org.junit.Assert.*;

import org.junit.Test;

public class QueueExampleTest {
	private static final Candy BLUE_RASPBERRY = new Candy( "Blue Raspberry" );
	private static final Candy CHOCOLATE      = new Candy( "Chocolate" );
	private static final Candy COLA           = new Candy( "Cola" );
	private static final Candy GRAPE          = new Candy( "Grape" );
	private static final Candy GREEN_APPLE    = new Candy( "Green Apple" );
	private static final Candy LEMON          = new Candy( "Lemon" );
	private static final Candy ORANGE         = new Candy( "Orange" );
	private static final Candy PEPPERMINT     = new Candy( "Peppermint" );
	private static final Candy RASPBERRY      = new Candy( "Raspberry" );
	private static final Candy WATERMELON     = new Candy( "Sour Watermelon" );
	
	private static final int   MONDAY    = 0;
	private static final int   TUESDAY   = 1;
	private static final int   WEDNESDAY = 2;
	private static final int   THURSDAY  = 3;
	private static final int   FRIDAY    = 4;
	private static final int   SATURDAY  = 5;
	private static final int   SUNDAY    = 6;

	private class QueueTest extends Queue<Candy> {
		public QueueTest(Candy... candy) {
			for (Candy c : candy) {
				enqueue( c );
			}
		}
	}
	@Test
	public void testNoCandy() {
		Queue<Candy> dispenser = new QueueTest();
		Queue<Candy> actual    = QueueExample.getCandy( dispenser, FRIDAY );
		assertNotNull( "\"getCandy\" returned a null queue", actual );
		assertTrue( "Incorrect result", actual.isEmpty() );
	}
	@Test
	public void testMonday() {
		Queue<Candy> dispenser = new QueueTest( LEMON, GREEN_APPLE, BLUE_RASPBERRY, ORANGE );
		Queue<Candy> actual    = QueueExample.getCandy( dispenser, MONDAY );
		Candy[]  expected  =  { LEMON, GREEN_APPLE, BLUE_RASPBERRY, ORANGE };
		assertNotNull( "\"getCandy\" returned a null queue", actual );
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail( "expected " + exp + "but results ended prematurely" );
			}
			Candy act = actual.dequeue();
			assertEquals( "Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail( "result had unexpected additional data" );
		}
	}
	@Test
	public void testTuesday() {
		Queue<Candy> dispenser = new QueueTest( CHOCOLATE, COLA, PEPPERMINT, BLUE_RASPBERRY );
		Queue<Candy> actual    = QueueExample.getCandy( dispenser, TUESDAY );
		Candy[]  expected  =  { CHOCOLATE, PEPPERMINT, COLA, BLUE_RASPBERRY };
		assertNotNull( "\"getCandy\" returned a null queue", actual );
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail( "expected " + exp + "but results ended prematurely" );
			}
			Candy act = actual.dequeue();
			assertEquals( "Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail( "result had unexpected additional data" );
		}
	}
	@Test
	public void testWednesday() {
		Queue<Candy> dispenser = new QueueTest( GRAPE, ORANGE, WATERMELON, RASPBERRY );
		Queue<Candy> actual    = QueueExample.getCandy( dispenser, WEDNESDAY );
		Candy[]  expected  =  { GRAPE, RASPBERRY, ORANGE, WATERMELON };
		assertNotNull( "\"getCandy\" returned a null queue", actual );
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail( "expected " + exp + "but results ended prematurely" );
			}
			Candy act = actual.dequeue();
			assertEquals( "Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail( "result had unexpected additional data" );
		}
	}
	@Test
	public void testThursday() {
		Queue<Candy> dispenser = new QueueTest( COLA, RASPBERRY, WATERMELON, ORANGE, GREEN_APPLE );
		Queue<Candy> actual    = QueueExample.getCandy( dispenser, THURSDAY );
		Candy[]  expected  =  { COLA, GREEN_APPLE, RASPBERRY, ORANGE, WATERMELON };
		assertNotNull( "\"getCandy\" returned a null queue", actual );
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail( "expected " + exp + "but results ended prematurely" );
			}
			Candy act = actual.dequeue();
			assertEquals( "Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail( "result had unexpected additional data" );
		}
	}
	@Test
	public void testFriday() {
		Queue<Candy> dispenser = new QueueTest( BLUE_RASPBERRY, GREEN_APPLE, COLA, BLUE_RASPBERRY );
		Queue<Candy> actual    = QueueExample.getCandy( dispenser, FRIDAY );
		Candy[]  expected  =  { BLUE_RASPBERRY, COLA, BLUE_RASPBERRY, GREEN_APPLE };
		assertNotNull( "\"getCandy\" returned a null queue", actual );
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail( "expected " + exp + "but results ended prematurely" );
			}
			Candy act = actual.dequeue();
			assertEquals( "Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail( "result had unexpected additional data" );
		}
	}
	@Test
	public void testSaturday() {
		Queue<Candy> dispenser = new QueueTest( LEMON, GRAPE, PEPPERMINT, CHOCOLATE );
		Queue<Candy> actual    = QueueExample.getCandy( dispenser, SATURDAY );
		Candy[]  expected  =  { LEMON, CHOCOLATE, PEPPERMINT, GRAPE };
		assertNotNull( "\"getCandy\" returned a null queue", actual );
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail( "expected " + exp + "but results ended prematurely" );
			}
			Candy act = actual.dequeue();
			assertEquals( "Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail( "result had unexpected additional data" );
		}
	}
	@Test
	public void testSunday() {
		Queue<Candy> dispenser = new QueueTest( WATERMELON, ORANGE, GREEN_APPLE, BLUE_RASPBERRY, COLA );
		Queue<Candy> actual    = QueueExample.getCandy( dispenser, SUNDAY );
		Candy[]  expected  =  { WATERMELON, BLUE_RASPBERRY, COLA, ORANGE, GREEN_APPLE };
		assertNotNull( "\"getCandy\" returned a null queue", actual );
		for (Candy exp : expected) {
			if (actual.isEmpty()) {
				fail( "expected " + exp + "but results ended prematurely" );
			}
			Candy act = actual.dequeue();
			assertEquals( "Incorrect result", exp, act);
		}
		if (!actual.isEmpty()) {
			fail( "result had unexpected additional data" );
		}
	}
}