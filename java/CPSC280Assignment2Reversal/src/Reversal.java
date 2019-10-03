import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Reversal {
	public static void reverseFile(File input, File output) throws FileNotFoundException{	
		StringBuilder sb = new StringBuilder();
		String EOL = System.getProperty("line.separator");
		if(!input.exists()){
			throw new FileNotFoundException("Input file not found");
		}
		if(!output.exists()){
			throw new FileNotFoundException("Output file not found");
		}
		try{
			ArrayList<String> lines= new ArrayList<String>();		
			//take in all lines of text
			//store them
			Scanner scan= new Scanner(input);
			while(scan.hasNext()){
				lines.add(scan.nextLine());
			}
			scan.close();
			
			ArrayList<String> outputArray= new ArrayList<String>();
			
			//take last line, reverse word order "Lorem	ipsum	dolor	sit	amet" -> "amet,	sit	dolor	ipsum	Lorem"
			for(int i=lines.size()-1; i>=0; i--){
				Scanner lineScan= new Scanner(lines.get(i));
				lineScan.useDelimiter(" ");
				ArrayList<String> words= new ArrayList<String>();
				while(lineScan.hasNext()){
					words.add(lineScan.next());
				}
				lineScan.close();
				for(int g=words.size()-1; g>=0; g--){
//					if(g != words.size()-1){
//						sb.append(" ");
//					}
					sb.append(words.get(g));
					if(g > 0)
						sb.append(" ");
					else
						sb.append(EOL);
				}
//				sb.setLength(0);
			}
		
			
		}
		catch(IOException e){
			System.out.println("Error with Scanner");
		}		
		
		try{
			PrintWriter writer = new PrintWriter(output);	
			writer.write(sb.toString());
			writer.close();
		}catch(IOException e){
			System.out.println("Error with PrintWriter");
		}
	}
}


//PrintWriter writer = new PrintWriter(output);	
//writer.


