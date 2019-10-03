import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class ShiftTest {
	@Test
	public void testReflection() {
		Class<?> cClass  = Shift.class;
		Field[]  cFields = cClass.getDeclaredFields();

		for (Field f : cFields) {
			if (!f.isSynthetic()) {
				assertTrue ( "Field \""+f.getName()+"\" should be private", Modifier.isPrivate( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
			}
		}
		new Shift();
	}

	@Test
	public void testWithNone() {
		int[] actual   = { };
		int[] expected = { };
		Shift.shiftRight( actual );
		assertArrayEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void testWithOne() {
		int[] actual   = { 10 };
		int[] expected = { 10 };
		Shift.shiftRight( actual );
		assertArrayEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void testWithTwo() {
		int[] actual   = { 42, 40 };
		int[] expected = { 40, 42 };
		Shift.shiftRight( actual );
		assertArrayEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void testWithThree() {
		int[] actual   = { 1, 2, 3 };
		int[] expected = { 3, 1, 2 };
		Shift.shiftRight( actual );
		assertArrayEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void testSeveralTimes() {
		int[] actual   = { 1, 2, -2, -1, 0 };
		int[] expected = { 0, 1, 2, -2, -1 };
		Shift.shiftRight( actual );
		assertArrayEquals( "Incorrect result", expected, actual );

		Shift.shiftRight( actual );
		expected = new int[]{ -1, 0, 1, 2, -2 };
		assertArrayEquals( "Incorrect result", expected, actual );

		Shift.shiftRight( actual );
		expected = new int[]{ -2, -1, 0, 1, 2 };
		assertArrayEquals( "Incorrect result", expected, actual );
	}
}