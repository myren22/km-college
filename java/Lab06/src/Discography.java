import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Discography {
	public static void writeReport(File input, File output){
		try{
			Scanner scan= new Scanner(input);
			scan.useDelimiter(",");
			PrintWriter writer = new PrintWriter(output);
			String sep = System.getProperty("line.separator");
			
			ArrayList<String> albumNameList = new ArrayList<String>();
			ArrayList<String> artistList = new ArrayList<String>();
			ArrayList<String> albumLengthList = new ArrayList<String>();
			
			//parse and store all album info into arrays
			while(scan.hasNextLine()){
				String albumInfo = scan.nextLine();
				Scanner ascan = new Scanner(albumInfo);
				ascan.useDelimiter(",");
				
				//stores artist and album names
				String albumName1 = ascan.next();
				String artist1 = ascan.next();
				albumNameList.add(albumName1);
				artistList.add(artist1);				 
				
				//parse for time
				int hours = 0;
				int minutes = 0;
				int seconds = 0;
				ascan.useDelimiter(",|:");
				while(ascan.hasNextInt()){
					minutes += ascan.nextInt();
					seconds += ascan.nextInt();
					
					if(seconds >= 60){
						seconds -= 60;
						minutes++;
					}
					if(minutes>=60){
						minutes -= 60;
						hours++;
					}					
				}
				//stores time
				albumLengthList.add(String.format("%d:%02d:%02d",hours,minutes,seconds));				
			}
			
			//find longest artist and album name(length)
			int longestAlbumName =0;
			int longestArtistName =0;
			for(int i=0; i<albumNameList.size(); i++){
				if(albumNameList.get(i).length() > longestAlbumName){
					longestAlbumName = albumNameList.get(i).length();
				}
			}
			for(int i=0; i<artistList.size(); i++){
				if(artistList.get(i).length() > longestArtistName){
					longestArtistName = artistList.get(i).length();
				}
			}
			
			//format every album's info into their own string, and store in an array
			ArrayList<String> albumInfoList = new ArrayList<String>();
			for(int i=0; i<artistList.size(); i++){
				albumInfoList.add( String.format("%-"+longestArtistName+"s | %-"+longestAlbumName+"s | %s",
						artistList.get(i), albumNameList.get(i), albumLengthList.get(i)));
				
			}
			
			//alphabatize strings
			Collections.sort(albumInfoList);
			
			//output all info			
			for(int i=0; i<albumInfoList.size(); i++){
				writer.printf("%s"+sep,albumInfoList.get(i));
				
			}
			
			writer.close();
			scan.close();
		}
		catch(IOException e){
			
		}
	}
}
//
//A Song for You,Carpenters,4:42,2:56,2:46,2:55,3:50,0:22,3:07,1:45,1:59,3:47,3:58,3:50
//Entre el Cielo y el Suelo,Mecano,4:02,4:37,4:22,4:04,2:57,3:05,3:14,4:42,5:04,3:58
//Doo-Wops & Hooligans,Bruno Mars,3:42,3:40,4:03,2:28,3:15,3:50,3:37,3:49,3:17,3:47

//
//s.useDelimiter(",");
//String albumName = s.next();
//String albumArtist = s.next();
//int hours = 0;
//int minutes = 0;
//int seconds = 0;
//s.useDelimiter(",|:");
//while(s.hasNextInt()){
//	minutes += s.nextInt();
//	seconds += s.nextInt();
//	
//	if(seconds >= 60){
//		seconds -= 60;
//		minutes++;
//	}
//	if(minutes>=60){
//		minutes -= 60;
//		hours++;
//	}
//}
//
//timeList.add(String.format("%d:%02d:%02d",hours,minutes,seconds));
