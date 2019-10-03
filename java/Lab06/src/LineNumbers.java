
import java.io.*;
import java.util.Scanner;

public class LineNumbers {
	public static void process(File input, File output)
	{
		try{
			Scanner scan= new Scanner(input);
			PrintWriter writer = new PrintWriter(output);
			String sep = System.getProperty("line.separator");
			
			int x = 1;
			while(scan.hasNextLine()){
				writer.printf("%3d" + " | " + "%s"+sep, x, scan.nextLine());
				x++;
			}			
			
			//line number is right aligned in a 3 space wide area
			//followed by " | " + text, new line
			
			writer.close();
			scan.close();
		}
		catch(IOException e){
			
		}
	}
}
