import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Quiz6Test {
	@Rule
	public TemporaryFolder folder   = new TemporaryFolder();

	@Test
	public void testReflection() {
		Class<?> iClass  = Quiz6.class;
		Field[]  iFields = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				fail( "Class shouldn't have any fields [found: \""+f.getName()+"\"]" );
			}
		}
	}

	@Test
	public void test0() {
		try {
			File              file   = folder.newFile( "foo.txt" );

			ArrayList<String> actual = Quiz6.getAnyOther( file );

			assertEquals( "Incorrect result", 0, actual.size() );
		} catch (IOException e) {
			e.printStackTrace();
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void test1() {
		try {
			File        file = folder.newFile( "bar.txt" );
			PrintWriter out  = new PrintWriter( file );
			out.println( "Lorem ipsum dolor sit amet, consectetur adipiscing elit." );
			out.close();

			ArrayList<String> actual = Quiz6.getAnyOther( file );

			assertEquals( "Incorrect result", 4, actual.size() );
			assertEquals( "Incorrect result", "Lorem",      actual.get( 0 ));
			assertEquals( "Incorrect result", "dolor",      actual.get( 1 ));
			assertEquals( "Incorrect result", "amet,",      actual.get( 2 ));
			assertEquals( "Incorrect result", "adipiscing", actual.get( 3 ));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		try {
			String[] array = { 
					"Curabitur suscipit pellentesque turpis, id gravida dolor ultrices ac.",
					"In placerat venenatis elementum.",
					"Praesent mollis, enim a tristique vulputate"	
			};
			File        file = folder.newFile( "blah.txt" );
			PrintWriter out  = new PrintWriter( file );
			for (String s : array) {
				out.println( s );
			}
			out.close();

			ArrayList<String> actual = Quiz6.getAnyOther( file );

			assertEquals( "Incorrect result", 10,             actual.size() );
			assertEquals( "Incorrect result", "Curabitur",    actual.get( 0 ));
			assertEquals( "Incorrect result", "pellentesque", actual.get( 1 ));
			assertEquals( "Incorrect result", "id",           actual.get( 2 ));
			assertEquals( "Incorrect result", "dolor",        actual.get( 3 ));
			assertEquals( "Incorrect result", "ac.",          actual.get( 4 ));
			assertEquals( "Incorrect result", "placerat",     actual.get( 5 ));
			assertEquals( "Incorrect result", "elementum.",   actual.get( 6 ));
			assertEquals( "Incorrect result", "mollis,",      actual.get( 7 ));
			assertEquals( "Incorrect result", "a",            actual.get( 8 ));
			assertEquals( "Incorrect result", "vulputate",    actual.get( 9 ));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test3() {
		File              nofile = new File( "blah.txt" );

		ArrayList<String> actual = Quiz6.getAnyOther( nofile );

		assertEquals( "Incorrect result", 0, actual.size() );
	}
}