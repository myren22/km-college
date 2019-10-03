import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Attendance {
	public static void foo(File input, File output){
		try{
			//setup print and read
			Scanner scan= new Scanner(input);
			PrintWriter writer = new PrintWriter(output);
			
			
			//create arrays for name and days
			ArrayList<String> namesArray = new ArrayList<String>();
			ArrayList<Integer> daysArray = new ArrayList<Integer>();
			
			
			
			//populate
			
			while(scan.hasNextLine()){
				String lineOfText = scan.nextLine();
				Scanner line= new Scanner(lineOfText);
				line.useDelimiter("=");				
				namesArray.add(line.next());
				daysArray.add(line.nextInt());
			}
			
			
			//find highest number of days
			int mostDays=0;
			for(int i=0; i<daysArray.size(); i++){
				if(daysArray.get(i)>mostDays){
					mostDays = daysArray.get(i);
				}
			}
			//match to students with that amount
			ArrayList<String> mostAttendedNames = new ArrayList<String>();
			for(int i=0; i<daysArray.size(); i++){
				if(mostDays ==daysArray.get(i)){
					mostAttendedNames.add(namesArray.get(i));
				}
			}
			
			Collections.sort(mostAttendedNames);
			
			//print each name alphabetically
			for(int i=0; i<mostAttendedNames.size(); i++){
				writer.println(mostAttendedNames.get(i));
			}
			
		}
		catch(IOException e){
			
		}
		
	}
}
