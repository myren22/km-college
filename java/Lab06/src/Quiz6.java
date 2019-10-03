import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Quiz6 {
	public static ArrayList<String> getAnyOther(File file){
		try{
			Scanner scan= new Scanner(file);
			
			ArrayList<String> list = new ArrayList<String>();
			while(scan.hasNext()){
				
				list.add(scan.next());
				if(scan.hasNext())
				{
					scan.next();
				}
			}
			
			scan.close();
			return list;			
		}
		catch(IOException e){
			ArrayList<String> list = new ArrayList<String>();
			return list;
		}
	}
}
