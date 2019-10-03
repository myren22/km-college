import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;


public class ReversalTest {
	@Rule
    public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void test0() {
		
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );

			PrintWriter write  = new PrintWriter( input );
			write.println( "Lorem ipsum dolor sit amet," );
			write.println( "consectetur adipiscing elit." );
			write.close();

			// invoke program
			Reversal.reverseFile( input, output );
			
			// verify file results
			assertTrue  ( "Output file does not exist", output.exists() );			
			
			Scanner scan     = new Scanner( output );

			assertTrue  ( "Unexpected end of file: expected \"%s\"", scan.hasNext() );
			
			String  actual   = scan.nextLine();
			assertEquals( "Incorrect result", "elit. adipiscing consectetur", actual );
			
			actual = scan.nextLine();
			assertEquals( "Incorrect result", "amet, sit dolor ipsum Lorem", actual );
			
			
			assertFalse ( "File contains more data than expected", scan.hasNext() );
			scan.close();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	@Test
	public void reflectionTest(){
		
	}
	
	@Test
	public void fileExistsTest(){
		
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testEmptyFileException(){
		try {
			// create file
			File        input  = folder.newFile( "input.txt" );
			File        output = folder.newFile( "output.txt" );
			
			PrintWriter write  = new PrintWriter( input );
			write.println( "Lorem ipsum dolor sit amet," );
			write.println( "consectetur adipiscing elit." );
			write.close();
			
			// invoke program
			Reversal.reverseFile( input, output );

		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
}
