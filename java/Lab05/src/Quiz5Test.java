import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class Quiz5Test {
	public final class HotPotato {
		private int value;
		public HotPotato(int _value) {
			value = _value;
		}
		public void blah() {
			if      (value == 0) throw new RuntimeException();
			else if (value == 1) throw new ArrayIndexOutOfBoundsException();
			else if (value == 2) throw new NoSuchElementException();
		}
	}
	@Test
	public void testRuntimeException() {
		String actual   = Quiz5.foo( new HotPotato( 0 ));
		String expected = "runtime";
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void testArrayIndexOutOfBoundsException() {
		String actual   = Quiz5.foo( new HotPotato( 1 ));
		String expected = "index";
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void testNoSuchElementException() {
		String actual   = Quiz5.foo( new HotPotato( 2 ));
		String expected = "element";
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void testNoException() {
		String actual   = Quiz5.foo( new HotPotato( 3 ));
		String expected = "none";
		assertEquals( "Incorrect result", expected, actual );
	}
}