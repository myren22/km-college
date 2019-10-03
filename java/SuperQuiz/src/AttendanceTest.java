import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class AttendanceTest {
	@Rule
    public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void testReflection() {
		Class<?> cClass  = Attendance.class;
		Field[]  cFields = cClass.getDeclaredFields();

		for (Field f : cFields) {
			if (!f.isSynthetic()) {
				assertTrue ( "Field \""+f.getName()+"\" should be private", Modifier.isPrivate( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
			}
		}
		new Attendance();
	}
	@Test
	public void test0() {
		try {
			// create file
			File        input  = folder.newFile();
			File        output = folder.newFile();

			// invoke program
			Attendance.foo(input, output);

			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			if (scan.hasNext()) {
				fail( String.format( "File contains more data than expected: found \"%s\"", scan.nextLine() ));
			}
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test1() {
		try {
			// create file
			File        input = folder.newFile();
			PrintWriter write = new PrintWriter( input );
			write.println( "Alexandra=2" );
			write.println( "Charles=2" );
			write.println( "Bob=2" );
			write.close();

			File        output = folder.newFile();

			// invoke program
			Attendance.foo(input, output);

			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"Alexandra", "Bob", "Charles"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			if (scan.hasNext()) {
				fail( String.format( "File contains more data than expected: found \"%s\"", scan.nextLine() ));
			}
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test2() {
		try {
			// create file
			File        input = folder.newFile();
			PrintWriter write = new PrintWriter( input );
			write.println( "Chris=3" );
			write.println( "Nico=3" );
			write.println( "Daniel=3" );
			write.println( "Colin=3" );
			write.println( "David=3" );
			write.println( "Alexandra=3" );
			write.close();

			File        output = folder.newFile();

			// invoke program
			Attendance.foo(input, output);

			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"Alexandra","Chris","Colin","Daniel","David","Nico"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			if (scan.hasNext()) {
				fail( String.format( "File contains more data than expected: found \"%s\"", scan.nextLine() ));
			}
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test3() {
		try {
			// create file
			File        input = folder.newFile();
			PrintWriter write = new PrintWriter( input );
			write.println( "Charles=4" );
			write.println( "Kent=5" );
			write.println( "Dieubenit=6" );
			write.println( "Jackson=4" );

			write.close();

			File        output = folder.newFile();

			// invoke program
			Attendance.foo(input, output);

			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"Dieubenit"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			if (scan.hasNext()) {
				fail( String.format( "File contains more data than expected: found \"%s\"", scan.nextLine() ));
			}
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test4() {
		try {
			// create file
			File        input = folder.newFile();
			PrintWriter write = new PrintWriter( input );
			write.println( "Daniel=3" );
			write.println( "Nico=2" );
			write.println( "Bob=3" );
			write.println( "Chris=3" );
			write.close();

			File        output = folder.newFile();

			// invoke program
			Attendance.foo(input, output);

			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"Bob", "Chris","Daniel"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			if (scan.hasNext()) {
				fail( String.format( "File contains more data than expected: found \"%s\"", scan.nextLine() ));
			}
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test5() {
		try {
			// create file
			File        input = folder.newFile();
			PrintWriter write = new PrintWriter( input );
			write.println( "Michael=4" );
			write.println( "Alexander=3" );
			write.println( "Joshua=3" );
			write.println( "Dylan=5" );
			write.println( "Cameron=3" );
			write.println( "Paul=4" );
			write.println( "Camren=5" );
			
			write.close();

			File        output = folder.newFile();

			// invoke program
			Attendance.foo(input, output);

			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"Camren","Dylan"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			if (scan.hasNext()) {
				fail( String.format( "File contains more data than expected: found \"%s\"", scan.nextLine() ));
			}
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test6() {
		try {
			// create file
			File        input = folder.newFile();
			PrintWriter write = new PrintWriter( input );
			write.println( "Michael=4" );
			write.println( "Alexander=3" );
			write.println( "Joshua=3" );
			write.println( "Cameron=3" );
			write.println( "Paul=4" );
			write.println( "Lilly Ann=4" );
			write.println( "Camren=3" );
			write.close();

			File        output = folder.newFile();

			// invoke program
			Attendance.foo(input, output);

			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] {
					"Lilly Ann","Michael","Paul"
			};
			for (String expected : result) {
				if (scan.hasNext()) {
					String actual = scan.nextLine();
					assertEquals( "Incorrect result", expected, actual );
				}
				else {
					fail( String.format( "Unexpected end of file: expected \"%s\"", expected ));
					break;
				}
			}
			if (scan.hasNext()) {
				fail( String.format( "File contains more data than expected: found \"%s\"", scan.nextLine() ));
			}
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}	
}