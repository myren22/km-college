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

public class LineNumbersTest {
	@Rule
    public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void testReflection() {
		Class<?>   cClass  = LineNumbers.class;
		Field[]    cFields = cClass.getDeclaredFields();

		for (Field f : cFields) {
			if (!f.isSynthetic()) {
				assertTrue ( "Field \""+f.getName()+"\" should be private", Modifier.isPrivate( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
			}
		}
	}
	@Test
	public void testEmptyFile() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			// invoke program
			LineNumbers.process( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			assertFalse ( "Incorrect result", scan.hasNext() );
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void testOneLine() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "Lorem ipsum dolor sit amet, consectetur adipiscing elit." );
			write.close();

			// invoke program
			LineNumbers.process( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String[] result = new String[] { 
					"  1 | Lorem ipsum dolor sit amet, consectetur adipiscing elit."
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
			assertFalse ( "File contains more data than expected", scan.hasNext() );
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void testLinesWithEmpty() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "                                     " );
			write.println( "            In sed scelerisque dolor," );
			write.println( "               in scelerisque lectus." );
			write.println( "                                     " );
			write.println( "Nam euismod mattis elit ac convallis." );
			write.println( "                                     " );
			write.println( "               Aliquam erat volutpat." );
			write.println( "                                     " );
			write.println( "                  Mauris velit magna," );
			write.println( "                  convallis a mi vel," );
			write.println( "    mattis     elementum      sapien." );
			write.close();

			// invoke program
			LineNumbers.process( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner scan     = new Scanner( output );
			String[] result = new String[] { 
					"  1 |                                      ",
					"  2 |             In sed scelerisque dolor,",
					"  3 |                in scelerisque lectus.",
					"  4 |                                      ",
					"  5 | Nam euismod mattis elit ac convallis.",
					"  6 |                                      ",
					"  7 |                Aliquam erat volutpat.",
					"  8 |                                      ",
					"  9 |                   Mauris velit magna,",
					" 10 |                   convallis a mi vel,",
					" 11 |     mattis     elementum      sapien.",
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
			assertFalse ( "File contains more data than expected", scan.hasNext() );
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void testSeveralLines() {
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "Nulla accumsan leo augue, eget mattis eros dictum sed." );
			write.println( "Donec sodales nibh sapien, non lacinia enim convallis eget." );
			write.println( "Duis at malesuada nisl." );
			write.println( "Proin risus diam, tristique bibendum euismod nec, fermentum adipiscing tortor." );
			write.println( "Sed porta semper risus, vitae tempor neque interdum vitae." );
			write.println( "Ut ullamcorper mollis elit, ut pellentesque tellus hendrerit nec." );
			write.println( "Nunc malesuada ac ipsum sit amet cursus." );
			write.println( "Donec ut tellus a lacus imperdiet elementum vitae consectetur sapien." );
			write.println( "Vestibulum eget consequat mauris." );
			write.println( "Aenean posuere placerat arcu, eu bibendum magna iaculis nec." );
			write.println( "Integer pretium, quam in venenatis cursus, dolor lacus feugiat turpis, nec ultrices dui diam sed odio." );
			write.println( "Suspendisse sed placerat lectus." );
			write.println( "Curabitur euismod eros a blandit pulvinar." );
			write.println( "Mauris est ante, rutrum in enim a, ultrices pellentesque odio." );
			write.println( "Ut congue neque quis dapibus facilisis." );
			write.close();

			// invoke program
			LineNumbers.process( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );
			Scanner  scan   = new Scanner( output );
			String[] result = new String[] { 
					"  1 | Nulla accumsan leo augue, eget mattis eros dictum sed.",
					"  2 | Donec sodales nibh sapien, non lacinia enim convallis eget.",
					"  3 | Duis at malesuada nisl.",
					"  4 | Proin risus diam, tristique bibendum euismod nec, fermentum adipiscing tortor.",
					"  5 | Sed porta semper risus, vitae tempor neque interdum vitae.",
					"  6 | Ut ullamcorper mollis elit, ut pellentesque tellus hendrerit nec.",
					"  7 | Nunc malesuada ac ipsum sit amet cursus.",
					"  8 | Donec ut tellus a lacus imperdiet elementum vitae consectetur sapien.",
					"  9 | Vestibulum eget consequat mauris.",
					" 10 | Aenean posuere placerat arcu, eu bibendum magna iaculis nec.",
					" 11 | Integer pretium, quam in venenatis cursus, dolor lacus feugiat turpis, nec ultrices dui diam sed odio.",
					" 12 | Suspendisse sed placerat lectus.",
					" 13 | Curabitur euismod eros a blandit pulvinar.",
					" 14 | Mauris est ante, rutrum in enim a, ultrices pellentesque odio.",
					" 15 | Ut congue neque quis dapibus facilisis."
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
			assertFalse ( "File contains more data than expected", scan.hasNext() );
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
}
